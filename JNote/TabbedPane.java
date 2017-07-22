package JNote;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class TabbedPane extends JTabbedPane implements MouseListener {
		
	private JLabel label;
	
	public TabbedPane(int tabPlacement) {
		super(tabPlacement);
		
		label = new JLabel("+");
		label.setFont(new Font("Segoe UI", Font.BOLD, 20));
                label.setBackground(Color.red);
		label.addMouseListener(this);
	}
	
	@Override
	public void addTab(String title, Component component) {
		super.addTab(title, null, component);
	}
	
	@Override
	public void addTab(String title, Icon icon, Component component) {
		super.addTab(title, icon, component, null);
	}
	
	@Override
	public void addTab(String title, Icon icon, Component component, String tip) {
		try {
			removeTabAt(getTabCount() - 1);
		}
		catch (Exception exc) {
			/*
			 * don't need to know this exception...
			 */
		}
		
		super.addTab(title, icon, component, tip);
		setTabComponentAt((getTabCount() - 1), new TabComponent(title, icon, component));
		
		super.addTab("", null, null);
		setTabComponentAt((getTabCount() - 1), label);
		
		setSelectedComponent(component);
		((Tab) getSelectedComponent()).textArea.requestFocusInWindow();
	}
	
	@Override
	public void setTitleAt(int index, String title) {
		super.setTitleAt(index, title);
		((TabComponent) getTabComponentAt(index)).labelTitle.setText(title);
	}
	
	@Override
	public void mouseClicked(MouseEvent event) {
		if (event.getSource().equals(label)) {
			Frame.newFile("Untitled " + Frame.tabs);
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
	
}