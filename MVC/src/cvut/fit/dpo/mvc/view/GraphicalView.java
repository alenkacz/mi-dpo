package cvut.fit.dpo.mvc.view;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import cvut.fit.dpo.mvc.controller.Controller;

public class GraphicalView extends View implements Observer {
	
	JPanel gPanel;
	
	public GraphicalView() {
		initComponents();
	}
	
	private void initComponents() {
	}

	@Override
	public void initActionListeners(Controller c) {
		gPanel.addMouseListener(c);
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}

	@Override
	public JPanel getView() {
		JLabel label = new JLabel("aa");
		gPanel = new JPanel();
		gPanel.setPreferredSize(new Dimension(100,100));
		gPanel.add(label);
		return gPanel;
	}
}
