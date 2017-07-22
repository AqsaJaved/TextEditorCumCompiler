package JNote;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TabComponent extends JPanel implements MouseListener {
	
	
	
	private String title;
	private Icon icon;
	private Component component;
	
	public JLabel labelTitle;
	private JLabel labelCloseButton;
	
	public TabComponent(String title, Icon icon, Component component) {
		this.title = title;
		this.icon = icon;
		this.component = component;
		
		initialize();
	}
	
	private void initialize() {
		setOpaque(false);
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		labelTitle = new JLabel(title);
		labelTitle.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		labelTitle.setIcon(icon);
		add(labelTitle);
		
		labelCloseButton = new JLabel("X");
		labelCloseButton.setFont(new Font("Segoe UI", Font.BOLD, 11));
		labelCloseButton.addMouseListener(this);
		add(labelCloseButton);
	}
	
	@Override
	public void mouseClicked(MouseEvent event) {
		if (event.getSource().equals(labelCloseButton)) {
			if(JOptionPane.showConfirmDialog(null,
					"Unsaved progress of this document will be lost. Are you sure you want to close?",
					"JNote v0.01 (Beta)", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				Frame.removeTab(component, (TabbedPane) getParent().getParent().getParent().getParent());
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent event) {
		if (event.getSource().equals(labelCloseButton)) {
			labelCloseButton.setForeground(Color.RED);
		}
	}

	@Override
	public void mouseExited(MouseEvent event) {
		if (event.getSource().equals(labelCloseButton)) {
			labelCloseButton.setForeground(Color.BLACK);
		}
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
	
}