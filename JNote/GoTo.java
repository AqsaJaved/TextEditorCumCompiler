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

public class GoTo extends JDialog implements ActionListener {
	private JPanel contentPane;
	private JLabel labelLineNumber;
	private JTextField textFieldLineNumber;
	private JTextArea textArea;
	private JButton buttonCancel, buttonOk;
	
	public GoTo(JTextArea textArea) {
		this.textArea = textArea;
		
		initialize();
	}
	
	private void initialize() {
		setSize(350, 110);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GoTo.class.getResource("/icons/logo1.png")));
		setTitle("GoTo");
		setModal(true);
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		labelLineNumber = new JLabel("Line Number");
		labelLineNumber.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		labelLineNumber.setBounds(10, 13, 81, 14);
		contentPane.add(labelLineNumber);
		
		textFieldLineNumber = new JTextField();
		textFieldLineNumber.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textFieldLineNumber.setBounds(108, 9, 227, 22);
		contentPane.add(textFieldLineNumber);
		textFieldLineNumber.setColumns(10);
		
		buttonCancel = new JButton("Cancel");
		buttonCancel.setBounds(147, 40, 89, 30);
		buttonCancel.addActionListener(this);
		contentPane.add(buttonCancel);
		
		buttonOk = new JButton("OK");
		buttonOk.setBounds(246, 40, 89, 30);
		buttonOk.addActionListener(this);
		contentPane.add(buttonOk);
	}
	
	public void showDialog() {
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource().equals(buttonCancel) ||
				event.getSource().equals(buttonOk)) {
			try {
				if (event.getSource().equals(buttonOk)) {
					textArea.setCaretPosition(textArea.getLineStartOffset(Integer.parseInt(textFieldLineNumber.getText()) - 1));
				}
				
				setVisible(false);
			}
			catch (Exception exc) {
				JOptionPane.showMessageDialog(this, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
}