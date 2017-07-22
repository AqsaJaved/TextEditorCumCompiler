package JNote;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class Tab extends JPanel implements UndoableEditListener, ActionListener, CaretListener, KeyListener, ItemListener, MouseListener {
	
	private static final int[] sizes = {8, 9, 10, 11, 12, 13, 14, 16, 18, 20, 22, 24, 26, 28, 36, 48, 72};
	public String filePath = "", fileName = "";	// latest
	private static final String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	private static final Font font = new Font("Segoe UI", Font.PLAIN, 13);
	
	private FontSettings fontSettings = new FontSettings();
	
	private JPopupMenu popupMenu;
	private JMenuItem menuItemUndo, menuItemRedo, menuItemCut, menuItemCopy, menuItemPaste,
			menuItemSelectAll, menuItemFindOrReplace, menuItemFindNext, menuItemReplaceNext,
			menuItemGoTo, menuItemTimeAndDate;
	
	private JPanel panelControls;
	private JScrollPane scrollPane;
	private JLabel labelLineNumbers, labelLines, labelColumns;
	public JButton buttonFontColor,buttonBackgroundColor, buttonUndo, buttonRedo; 
	private JToggleButton buttonBold, buttonItalik;
	private JComboBox<Integer> comboBoxSize;
	private JComboBox<String> comboBoxName;
	
	public JTextArea textArea;
	public JPanel panelLineNumbers, statusBar;
	
	private PanelSuggestion panelSuggestion;
	public UndoManager undoManager = new UndoManager();
	private FindOrReplace findOrReplace;
	private GoTo goTo;
        static int key;
	
	public Tab() {
		initialize();
	}
	
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		panelControls = new JPanel();
		panelControls.setBackground(Color.LIGHT_GRAY);
		panelControls.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		add(panelControls, BorderLayout.NORTH);
		
		buttonUndo = new JButton("");
		buttonUndo.setIcon(new ImageIcon(Tab.class.getResource("/icons/undo.png")));
		buttonUndo.setEnabled(false);
		buttonUndo.addActionListener(this);
		panelControls.add(buttonUndo);
		
		buttonRedo = new JButton("");
		buttonRedo.setIcon(new ImageIcon(Tab.class.getResource("/icons/redo.png")));
		buttonRedo.setEnabled(false);
		buttonRedo.addActionListener(this);
		panelControls.add(buttonRedo);
		
		comboBoxName = new JComboBox<String>();
		comboBoxName.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		for (int i=0; i<fontNames.length; i++) {
			comboBoxName.addItem(fontNames[i]);
		}
		
		comboBoxName.setSelectedItem("Segoe UI");
		comboBoxName.addItemListener(this);
		panelControls.add(comboBoxName);
		
		comboBoxSize = new JComboBox<Integer>();
		comboBoxSize.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		
		for (int i=0; i<sizes.length; i++) {
			comboBoxSize.addItem(sizes[i]);
		}
		
		comboBoxSize.setSelectedIndex(5);
		comboBoxSize.addItemListener(this);
		panelControls.add(comboBoxSize);
		
		buttonBold = new JToggleButton("B");
		buttonBold.setFont(new Font("Segoe UI", Font.BOLD, 13));
		buttonBold.addActionListener(this);
		panelControls.add(buttonBold);
		
		buttonItalik = new JToggleButton("I");
		buttonItalik.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		buttonItalik.addActionListener(this);
		panelControls.add(buttonItalik);
		
		buttonFontColor = new JButton("Font Color");
		buttonFontColor.setFont(buttonBold.getFont());
                buttonFontColor.addMouseListener(this);
		panelControls.add(buttonFontColor);
                
                buttonBackgroundColor = new JButton("Background Color");
		buttonBackgroundColor.setFont(buttonBold.getFont());
                buttonBackgroundColor.addActionListener(this);
		panelControls.add(buttonBackgroundColor);
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		textArea.setTabSize(4);
		textArea.setFont(font);
		textArea.getDocument().addUndoableEditListener(this);
		textArea.addCaretListener(this);
		textArea.addKeyListener(this);
		scrollPane.setViewportView(textArea);
		
		popupMenu = new JPopupMenu();
		addPopup(textArea, popupMenu);
		
		menuItemCut = new JMenuItem("Cut");
		menuItemCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
                menuItemCut.setIcon(new ImageIcon(Frame.class.getResource("/icons/cut.png")));
		menuItemCut.addActionListener(this);
		popupMenu.add(menuItemCut);
		
		menuItemCopy = new JMenuItem("Copy");
		menuItemCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
                menuItemCopy.setIcon(new ImageIcon(Frame.class.getResource("/icons/copy.png")));
		menuItemCopy.addActionListener(this);
		popupMenu.add(menuItemCopy);
		
		menuItemPaste = new JMenuItem("Paste");
		menuItemPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
                menuItemPaste.setIcon(new ImageIcon(Frame.class.getResource("/icons/paste.png")));
		menuItemPaste.addActionListener(this);
		popupMenu.add(menuItemPaste);
		
		popupMenu.addSeparator();
		
		menuItemUndo = new JMenuItem("Undo");
		menuItemUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
                menuItemUndo.setIcon(new ImageIcon(Frame.class.getResource("/icons/undo.png")));
		menuItemUndo.addActionListener(this);
		popupMenu.add(menuItemUndo);
		
		menuItemRedo = new JMenuItem("Redo");
		menuItemRedo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
                menuItemRedo.setIcon(new ImageIcon(Frame.class.getResource("/icons/redo.png")));
		menuItemRedo.addActionListener(this);
		popupMenu.add(menuItemRedo);
		
		popupMenu.addSeparator();
		
		menuItemSelectAll = new JMenuItem("Select All");
		menuItemSelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
                menuItemSelectAll.setIcon(new ImageIcon(Frame.class.getResource("/icons/Select_All.png")));
		menuItemSelectAll.addActionListener(this);
		popupMenu.add(menuItemSelectAll);
		
		popupMenu.addSeparator();
		
		menuItemFindOrReplace = new JMenuItem("Find/Replace");
		menuItemFindOrReplace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
                menuItemFindOrReplace.setIcon(new ImageIcon(Frame.class.getResource("/icons/find-replace.png")));
		menuItemFindOrReplace.addActionListener(this);
		popupMenu.add(menuItemFindOrReplace);
		
		menuItemFindNext = new JMenuItem("Find Next");
		menuItemFindNext.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
                menuItemFindNext.setIcon(new ImageIcon(Frame.class.getResource("/icons/findnext.png")));
		menuItemFindNext.addActionListener(this);
		popupMenu.add(menuItemFindNext);
		
		menuItemReplaceNext = new JMenuItem("Replace Next");
		menuItemReplaceNext.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0));
                menuItemReplaceNext.setIcon(new ImageIcon(Frame.class.getResource("/icons/replace.png")));
		menuItemReplaceNext.addActionListener(this);
		popupMenu.add(menuItemReplaceNext);
		
		menuItemGoTo = new JMenuItem("Go To");
		menuItemGoTo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
                menuItemGoTo.setIcon(new ImageIcon(Frame.class.getResource("/icons/goto.png")));
		menuItemGoTo.addActionListener(this);
		popupMenu.add(menuItemGoTo);
		
		popupMenu.addSeparator();
		
		menuItemTimeAndDate = new JMenuItem("Time/Date");
		menuItemTimeAndDate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
                menuItemTimeAndDate.setIcon(new ImageIcon(Frame.class.getResource("/icons/timedate.jpg")));
		menuItemTimeAndDate.addActionListener(this);
		popupMenu.add(menuItemTimeAndDate);
		
		panelLineNumbers = new JPanel();
		panelLineNumbers.setLayout(new BorderLayout(0, 0));
		panelLineNumbers.setBorder(new EmptyBorder(0, 5, 0, 5));
		panelLineNumbers.setVisible(Frame.settings.lineNumbersVisible);
		scrollPane.setRowHeaderView(panelLineNumbers);
		
		labelLineNumbers = new JLabel("1");
		labelLineNumbers.setFont(font);
		labelLineNumbers.setVerticalAlignment(SwingConstants.TOP);
		labelLineNumbers.setHorizontalAlignment(SwingConstants.CENTER);
		panelLineNumbers.add(labelLineNumbers, BorderLayout.CENTER);
		
		statusBar = new JPanel();
		statusBar.setBackground(Color.LIGHT_GRAY);
		statusBar.setPreferredSize(new Dimension(0, 30));
		statusBar.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 5));
		statusBar.setVisible(Frame.settings.statusBarVisible);
		add(statusBar, BorderLayout.SOUTH);
		
		labelLines = new JLabel("Line(s) = 1");
		labelLines.setFont(font);
		statusBar.add(labelLines);
		
		labelColumns = new JLabel("Column(s) = 0");
		labelColumns.setFont(font);
		statusBar.add(labelColumns);
		
		panelSuggestion = new PanelSuggestion(textArea);
		textArea.add(panelSuggestion);
		findOrReplace = new FindOrReplace(textArea);
		goTo = new GoTo(textArea);
	}
	
	private void updateStatus(int flag) {
		if (flag == 0) {
			try {
				int lines = textArea.getLineOfOffset(textArea.getCaretPosition());
				
				labelLines.setText("Line(s) = " + (lines + 1));
				labelColumns.setText("Column(s) = " + (textArea.getCaretPosition() - textArea.getLineStartOffset(lines)));
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
		}
	}
	
	private void updateLineNumbers() {
		int lineCount = textArea.getLineCount();
		String text = "<html>";
		
		for (int i=1; i<=lineCount; i++) {
			text += i;
			
			if (i != lineCount) {
				text += "<br>";
			}
			else {
				text += "</html>";
			}
		}
		
		labelLineNumbers.setText(text);
	}
	
	@Override
	public void caretUpdate(CaretEvent event) {
		if (event.getSource().equals(textArea)) {
			updateStatus(0);
			updateLineNumbers();
		}
	}
	
	private void updateUndoRedoButtons() {
		menuItemUndo.setEnabled(undoManager.canUndo());
		buttonUndo.setEnabled(undoManager.canUndo());
		menuItemRedo.setEnabled(undoManager.canRedo());
		buttonRedo.setEnabled(undoManager.canRedo());
	}
	
	@Override
	public void undoableEditHappened(UndoableEditEvent event) {
		if (event.getSource().equals(textArea.getDocument())) {
			undoManager.addEdit(event.getEdit());
			updateUndoRedoButtons();
		}
	}
	
	private void updateFontStyle() {
		if (buttonBold.isSelected() && !buttonItalik.isSelected()) {
			fontSettings.isBold = true;
			fontSettings.isItalik = false;
		}
		else if (!buttonBold.isSelected() && buttonItalik.isSelected()) {
			fontSettings.isBold = false;
			fontSettings.isItalik = true;
		}
		else if (buttonBold.isSelected() && buttonItalik.isSelected()) {
			fontSettings.isBold = fontSettings.isItalik = true;
		}
		else {
			fontSettings.isBold = fontSettings.isItalik = false;
		}
		
		updateFont();
	}
	
	public void undo() {
		try {
			undoManager.undo();
		}
		catch (Exception exc) {
			/*
			 * don't need to know this exception...
			 */
		}
		
		updateUndoRedoButtons();
	}
	
	public void redo() {
		try {
			undoManager.redo();
		}
		catch (Exception exc) {
			/*
			 * don't need to know this exception...
			 */
		}
		
		updateUndoRedoButtons();
	}
	
	private void insertTimeAndDate() {
		textArea.insert(((DateFormat) new SimpleDateFormat("h:mm a dd/MM/yyyy")).format(new Date()), textArea.getCaretPosition());
	}
	
	private void findOrReplace() {
		findOrReplace.setLocationRelativeTo(this);
		findOrReplace.showDialog();
	}
	
	private void goTo() {
		goTo.setLocationRelativeTo(this);
		goTo.showDialog();
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource().equals(menuItemPaste)) {
			textArea.paste();
		}
		else if (event.getSource().equals(menuItemCopy)) {
			textArea.copy();
		}
		else if (event.getSource().equals(menuItemCut)) {
			textArea.cut();
		}
		else if (event.getSource().equals(menuItemUndo) ||
				event.getSource().equals(buttonUndo)) {
			undo();
		}
		else if (event.getSource().equals(buttonRedo) ||
				event.getSource().equals(menuItemRedo)) {
			redo();
		}
		else if (event.getSource().equals(menuItemSelectAll)) {
			textArea.selectAll();
		}
		else if (event.getSource().equals(menuItemFindOrReplace)) {
			findOrReplace();
		}
		else if (event.getSource().equals(menuItemFindNext)) {
			findOrReplace.findOrReplace(0);
		}
		else if (event.getSource().equals(menuItemReplaceNext)) {
			findOrReplace.findOrReplace(1);
		}
		else if (event.getSource().equals(menuItemGoTo)) {
			goTo();
		}
		else if (event.getSource().equals(menuItemTimeAndDate)) {
			insertTimeAndDate();
		}
		else if (event.getSource().equals(buttonBold) || event.getSource().equals(buttonItalik)) {
			updateFontStyle();
		}
		
                else if (event.getSource().equals(buttonBackgroundColor)) {
			Color color = JColorChooser.showDialog(null, "Pick a Color", Color.BLACK);
			
			if (color != null) {
					
					buttonBackgroundColor.setForeground(color);
					textArea.setBackground(color);
				}
		}
		textArea.requestFocusInWindow();
	}
	
	@Override
	public void keyPressed(KeyEvent event) {
            		if (event.getSource().equals(textArea)) {
			if ((event.getKeyCode() == KeyEvent.VK_BACK_SPACE) &&
					(textArea.getText().length() == 0)) {
				event.consume();
			}
			else if (event.isControlDown() && (event.getKeyCode() == KeyEvent.VK_SPACE)) {
				panelSuggestion.setVisible(true);
			}
			else if(event.isControlDown() && (event.getKeyCode() == KeyEvent.VK_Z)) {
				undo();
			}
			else if(event.isControlDown() && (event.getKeyCode() == KeyEvent.VK_Y)) {
				redo();
			}
			else if(event.isControlDown() && (event.getKeyCode() == KeyEvent.VK_F)) {
				findOrReplace();
			}
			else if(event.getKeyCode() == KeyEvent.VK_F3) {
				findOrReplace.findOrReplace(0);
			}
			else if(event.getKeyCode() == KeyEvent.VK_F4) {
				findOrReplace.findOrReplace(1);
			}
			else if(event.isControlDown() && (event.getKeyCode() == KeyEvent.VK_G)) {
				goTo();
			}
			else if(event.getKeyCode() == KeyEvent.VK_F5) {
				insertTimeAndDate();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent event) {
		/*
		 * nothing to be implemented here...
		 */
	}

	@Override
	public void keyTyped(KeyEvent event) {
		if (event.getSource().equals(textArea)) {
			if ((event.getKeyCode() == (KeyEvent.VK_CONTROL | KeyEvent.VK_Z))) {
				buttonUndo.doClick();
			}
		}
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	private void updateFont() {
		labelLineNumbers.setFont(fontSettings.getFont());
		textArea.setFont(fontSettings.getFont());
	}
	
	@Override
	public void itemStateChanged(ItemEvent event) {
		if (event.getSource().equals(comboBoxName)) {
			fontSettings.name = (String) comboBoxName.getSelectedItem();
		}
		else if (event.getSource().equals(comboBoxSize)) {
			fontSettings.size = (int) comboBoxSize.getSelectedItem();
		}
		
		updateFont();
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		if (event.getSource().equals(buttonFontColor)) {
			Color color = JColorChooser.showDialog(null, "Pick a Color", Color.BLACK);
			
			if (color != null) {
				if ((event.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK) {
					buttonFontColor.setForeground(color);
					textArea.setForeground(color);
				}
                                else
                                {
                                    
                                }
                        }
		}
	}

	@Override
	public void mouseEntered(MouseEvent event) {
		/*
		 * nothing to be implemented here...
		 */
	}

	@Override
	public void mouseExited(MouseEvent event) {
		/*
		 * nothing to be implemented here...
		 */
	}

	@Override
	public void mousePressed(MouseEvent event) {
		/*
		 * nothing to be implemented here...
		 */
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		/*
		 * nothing to be implemented here...
		 */
	}
         @Override
    public void processEvent(AWTEvent e) {
super.processEvent(e);
    }
	
}