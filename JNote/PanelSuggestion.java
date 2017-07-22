package JNote;

import com.inet.jortho.FileUserDictionary;
import com.inet.jortho.SpellChecker;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

public class PanelSuggestion extends JPanel implements MouseListener, KeyListener {
		
	private String lastSubWord;
	private String[] suggestions = new String[15];
	private static String[] dictionary = new String[2000];
	
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JList list;
	private Rectangle rectangle;
	
	public PanelSuggestion(JTextArea textArea) {
		this.textArea = textArea;
		
		initialize();
		loadDictionary();
	}
	
	private void initialize() {
             // Create user dictionary in the current working directory of application
        SpellChecker.setUserDictionaryProvider( new FileUserDictionary() );
        SpellChecker.registerDictionaries( null, null );
        // enable the spell checking on the text component with all features
                SpellChecker.register(textArea);
  
		setSize(180, 150);
		setLayout(new BorderLayout(0, 0));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setVisible(false);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		add(scrollPane, BorderLayout.CENTER);
		
		list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setVisibleRowCount(4);
		list.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		list.addMouseListener(this);
		scrollPane.setViewportView(list);
		
		textArea.addKeyListener(this);
	}
	
	private void loadDictionary() {
		try {
			int i = 0;
			
			Scanner scanner = new Scanner(PanelSuggestion.class.getResourceAsStream("/dictionary/dictionary.txt"));
			
			while (scanner.hasNextLine() && i<dictionary.length) {
				dictionary[i] = scanner.nextLine();
				
				if (i < suggestions.length) {
					suggestions[i] = dictionary[i];
				}
				
				i++;
			}
			
			scanner.close();
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	private String getTextAreaLastSubWord() {
		int endIndex = textArea.getCaretPosition(), beginIndex = Math.max(0, (endIndex - 1));
		String lastSubWord = textArea.getText();
		
        while (beginIndex > 0) {
            if (!Character.isWhitespace(lastSubWord.charAt(beginIndex))) {
            	beginIndex--;
            }
            else {
            	beginIndex++;
            	
            	break;
            }
        }
        
        if (beginIndex > endIndex) {
        	return null;
        }
        
        lastSubWord = lastSubWord.substring(beginIndex, endIndex);
        
        if (lastSubWord.length() < 1) {
        	return null;
        }
        
        return lastSubWord;
    }
	
	private void insertSelection() {
		try {
			textArea.select((textArea.getCaretPosition() - getTextAreaLastSubWord().length()), textArea.getCaretPosition());
			textArea.replaceSelection((String) list.getSelectedValue());
			setVisible(false);
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
    }
	
	/*
     * moves up the selection of suggestion list by one unit...
     */
    public void moveUp() {
        int index = Math.min(list.getSelectedIndex() - 1, list.getModel().getSize() + 1);
        
        list.setSelectedIndex(index);
        scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getValue() - 10);
    }
    
    /*
     * moves down the selection of suggestion list by one unit...
     */
    public void moveDown() {
        int index = Math.min(list.getSelectedIndex() + 1, list.getModel().getSize() - 1);
        
        list.setSelectedIndex(index);
        scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getValue() + 10);
    }
	
	@Override
	public void mouseClicked(MouseEvent event) {
		if (event.getClickCount() == 2) {
			insertSelection();
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
	public void keyPressed(KeyEvent event) {
		if (event.getSource().equals(textArea) && isVisible()) {
			if (event.getKeyCode() == KeyEvent.VK_ENTER) {
				insertSelection();
				event.consume();
			}
			else if ((!event.isControlDown() && event.getKeyCode() == KeyEvent.VK_SPACE) ||
					event.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
				setVisible(false);
			}
            else if (event.getKeyCode() == KeyEvent.VK_UP){
            	moveUp();
            	event.consume();
            }
            else if (event.getKeyCode() == KeyEvent.VK_DOWN){
            	moveDown();
            	event.consume();
            }
		}
	}

	@Override
	public void keyReleased(KeyEvent event) {
		if (isVisible() && Character.isLetter(event.getKeyCode())) {
			setVisible(true);
		}
		else if (isVisible() && (event.getKeyCode() == KeyEvent.VK_LEFT ||
        		event.getKeyCode() == KeyEvent.VK_RIGHT)) {
			setVisible(true);
        }
	}

	@Override
	public void keyTyped(KeyEvent event) {
		/*
		 * nothing to be implemented here...
		 */
	}
	
	@Override
	public void setVisible(boolean aFlag) {
		if (aFlag) {
			int x = 0, y = 0;
			
			try {
				lastSubWord = getTextAreaLastSubWord();
				
				if (lastSubWord != null) {
					int i = 0;
					
					for (int j=0; i < suggestions.length && j<dictionary.length; j++) {
						if (dictionary[j].startsWith(lastSubWord)) {
							suggestions[i] = dictionary[j];
							i++;
						}
					}
					
					list.setListData(suggestions);
					list.setSelectedIndex(0);
					scrollPane.getVerticalScrollBar().setValue(0);
				}
				else {
					return;
				}
				
				rectangle = textArea.modelToView(textArea.getCaretPosition());
				
				if ((rectangle.x + getWidth()) >= (textArea.getWidth() - 2)) {
					x = (textArea.getWidth() - 2) - getWidth();
				}
				else {
					x = rectangle.x;
				}
				
				if ((rectangle.y + getHeight()) >= (textArea.getHeight() - 2)) {
					y = textArea.getHeight() - (getHeight() + textArea.getFont().getSize() + 2);
				}
				else {
					y = rectangle.y + textArea.getFont().getSize() + 2;
				}
				
				setLocation(x, y);
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
		}
		
		super.setVisible(aFlag);
	}
	
}

	
