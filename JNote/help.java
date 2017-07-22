/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JNote;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class help extends JDialog implements ActionListener, MouseListener {
	
	
	private JPanel contentPane, panelAboutDeveloper;
	private JScrollPane scrollPaneAboutDeveloper;
	private JLabel labelLogo, labelSoftwareName, labelDeveloper;
	private JTextArea textAreaAboutDeveloper;
	private JButton buttonOk;
	
	public help() {
		initialize();
	}
	
	private void initialize() {
		setSize(450,300);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(JNote.About.class.getResource("/icons/logo1.png")));
		setTitle("Help");
		setModal(true);
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		labelLogo = new JLabel("");
		labelLogo.setHorizontalAlignment(SwingConstants.CENTER);
		labelLogo.setIcon(new ImageIcon(JNote.About.class.getResource("/icons/logo1large.png")));
		labelLogo.setBounds(10, 10, 128, 128);
		contentPane.add(labelLogo);
	
		labelSoftwareName = new JLabel("JNote-A Programmer's Editor");
		labelSoftwareName.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		labelSoftwareName.setHorizontalAlignment(SwingConstants.CENTER);
		labelSoftwareName.setBounds(148, 25, 286, 55);
		contentPane.add(labelSoftwareName);
		
		labelDeveloper = new JLabel("Find JNote at Github");
		labelDeveloper.setHorizontalAlignment(SwingConstants.CENTER);
		labelDeveloper.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		labelDeveloper.setBounds(148, 75, 286, 14);
		labelDeveloper.setCursor(new Cursor(Cursor.HAND_CURSOR));
		labelDeveloper.addMouseListener(this);
		contentPane.add(labelDeveloper);
		
		panelAboutDeveloper = new JPanel();
		panelAboutDeveloper.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelAboutDeveloper.setLayout(new BorderLayout(0, 0));
		panelAboutDeveloper.setBounds(148, 105, 286, 155);
		contentPane.add(panelAboutDeveloper);
		
		scrollPaneAboutDeveloper = new JScrollPane();
		panelAboutDeveloper.add(scrollPaneAboutDeveloper, BorderLayout.CENTER);

		textAreaAboutDeveloper = new JTextArea();
                textAreaAboutDeveloper.setSize(250, 250);
                textAreaAboutDeveloper.setText("Help Index: \n 1.Press Ctrl+N for New File \n 2.Press Ctrl+O to Open File \n 3.Press Ctrl+S to Save File  \n 4.Press Ctrl+P to Print File \n 5.Press Ctrl+Space for Panel Suggestion \n 6.Press Ctrl+z for Undo; Ctrl+Y for Redo \n 7.Press F5 for Time/date \n 8.Press Ctrl+G for Go to line \n 9.Press Ctrl+X for Cut,Press Ctrl+C for Copy, Ctrl+V for Paste \n 10.Press Ctrl+A for Select All \n 11.Press Ctrl+F for Find/Replace \n 12.Press F3 for Find Next \n 13.Press F4 for Replace Next\n 14.Double click for Pop Up Menu");
		textAreaAboutDeveloper.setEditable(false);
		textAreaAboutDeveloper.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textAreaAboutDeveloper.setTabSize(4);
		textAreaAboutDeveloper.setWrapStyleWord(true);
		textAreaAboutDeveloper.setLineWrap(true);
		scrollPaneAboutDeveloper.setViewportView(textAreaAboutDeveloper);
		
		buttonOk = new JButton("OK");
		buttonOk.setBounds(10, 230, 89, 30);
		buttonOk.addActionListener(this);
		contentPane.add(buttonOk);
	}
	
	public void showDialog() {
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource().equals(buttonOk)) {
			setVisible(false);
		}
	}

    @Override
    public void mouseClicked(MouseEvent event) {
		if (event.getSource().equals(labelDeveloper)) {
			try {
				Desktop.getDesktop().browse(new URL("https://github.com/AqsaJaved/Project-TextEditorCumCompiler").toURI());
			}
			catch (Exception exc) {
				/*
				 * don't need to know this exception...
				 */
			}
		}
	}

    @Override
    public void mousePressed(MouseEvent e) {
         /*
		 * nothing to be implemented here...
		 */
    }

    @Override
    public void mouseReleased(MouseEvent e) {
          /*
		 * nothing to be implemented here...
		 */
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        /*
		 * nothing to be implemented here...
		 */
    }

    @Override
    public void mouseExited(MouseEvent e) {
          /*
		 * nothing to be implemented here...
		 */
    }
    
}
