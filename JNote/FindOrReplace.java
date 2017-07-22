package JNote;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class FindOrReplace extends JDialog implements ActionListener {
	
	
	private static int position;
	
	private JPanel contentPane;
	private JLabel labelFind, labelReplace;
	private JTextField textFieldFind, textFieldReplace;
	private JTextArea textArea;
	private JCheckBox checkBoxMatchCase;
	private JButton buttonFindNext, buttonReplace, buttonCancel;
	
	public FindOrReplace(JTextArea textArea) {
		this.textArea = textArea;
		
		initialize();
	}
	
	private void initialize() {
		setSize(330, 150);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FindOrReplace.class.getResource("/icons/logo1.png")));
		setTitle("Find/Replace");
		setModal(true);
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		labelFind = new JLabel("Find");
		labelFind.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		labelFind.setBounds(10, 13, 30, 14);
		contentPane.add(labelFind);
		
		textFieldFind = new JTextField();
		textFieldFind.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textFieldFind.setBounds(73, 9, 146, 22);
		contentPane.add(textFieldFind);
		textFieldFind.setColumns(10);
		
		labelReplace = new JLabel("Replace");
		labelReplace.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		labelReplace.setBounds(10, 42, 53, 14);
		contentPane.add(labelReplace);
		
		textFieldReplace = new JTextField();
		textFieldReplace.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textFieldReplace.setColumns(10);
		textFieldReplace.setBounds(73, 38, 146, 22);
		contentPane.add(textFieldReplace);
		
		checkBoxMatchCase = new JCheckBox("Match Case");
		checkBoxMatchCase.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		checkBoxMatchCase.setBounds(73, 67, 103, 23);
		contentPane.add(checkBoxMatchCase);
		
		buttonFindNext = new JButton("Find Next");
		buttonFindNext.setBounds(229, 6, 85, 35);
		buttonFindNext.addActionListener(this);
		contentPane.add(buttonFindNext);
		
		buttonReplace = new JButton("Replace");
		buttonReplace.setBounds(229, 42, 85, 35);
		buttonReplace.addActionListener(this);
		contentPane.add(buttonReplace);
		
		buttonCancel = new JButton("Cancel");
		buttonCancel.setBounds(229, 78, 85, 35);
		buttonCancel.addActionListener(this);
		contentPane.add(buttonCancel);
	}
	
	public void showDialog() {
		setVisible(true);
	}
	
	public void findOrReplace(int flag) {		// if flag is = 0, then find next, else replace...
		String[] texts = { textFieldFind.getText(), textArea.getText(), textFieldReplace.getText() };
		
		if (!checkBoxMatchCase.isSelected()) {
			for (int i=0; i<2; i++) {
				texts[i] = texts[i].toLowerCase();
			}
		}
		
		while((position = texts[1].indexOf(texts[0], position)) >= 0){
			textArea.select(position, (position + texts[0].length()));
			
			if (flag != 0) {
				textArea.replaceSelection(texts[2]);
				textArea.select(position, (position + texts[2].length()));
				position += texts[2].length();
			}
			else {
				position += texts[0].length();
			}
			
			break;
		}
		
		if (position == -1) {
			int selectionEnd = textArea.getSelectionEnd();
			
			textArea.setSelectionStart(selectionEnd);
			textArea.setSelectionEnd(selectionEnd);
			
			if (flag == 0) {
				JOptionPane.showMessageDialog(this, "Finished searching", "Information", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(this, "Finished replacing", "Information", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		try {
			if (event.getSource().equals(buttonFindNext)) {
				findOrReplace(0);
			}
			else if (event.getSource().equals(buttonReplace)) {
				findOrReplace(1);
			}
			else if (event.getSource().equals(buttonCancel)) {
				setVisible(false);
			}
		}
		catch (Exception exc) {
			JOptionPane.showMessageDialog(this, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}