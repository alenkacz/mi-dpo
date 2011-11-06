package cvut.fit.dpo.mvc.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import cvut.fit.dpo.mvc.controller.Controller;
import cvut.fit.dpo.mvc.model.Circle;
import cvut.fit.dpo.mvc.model.Square;

public class GraphicalView extends View implements Observer {
	
	public GraphicalView() {
		initComponents();
	}
	
	private void initComponents() {
	}

	@Override
	public void initActionListeners(Controller c) {
		addMouseListener(c);
	}

	@Override
	public void update(Observable o, Object arg) {
		if(arg instanceof Circle) {
			Circle c = (Circle) arg;
			getGraphics().drawOval(c.getPoint().x, c.getPoint().y, c.getX(), c.getY());
		} else if(arg instanceof Square) {
			Square r = (Square) arg;
			getGraphics().drawRect(r.getPoint().x, r.getPoint().y, r.getX(), r.getY());
		}
	}

	@Override
	public JPanel getView() {
		setPreferredSize(new Dimension(100,100));
		return this;
	}
}
