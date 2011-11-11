package cvut.fit.dpo.mvc.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Hashtable;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import cvut.fit.dpo.mvc.controller.Controller;
import cvut.fit.dpo.mvc.model.Circle;
import cvut.fit.dpo.mvc.model.Shape2d;
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
	
	public void drawShape(Shape2d shape) {
		
		if(shape instanceof Circle) {
			Circle c = (Circle) shape;
			getGraphics().drawOval(c.getPoint().x, c.getPoint().y, c.getX(), c.getY());
		} else if(shape instanceof Square) {
			Square r = (Square) shape;
			getGraphics().drawRect(r.getPoint().x, r.getPoint().y, r.getX(), r.getY());
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		if(arg instanceof Shape2d) {
			drawShape((Shape2d)arg);
		} else if(arg instanceof Object[]) {
			// draw all
			clear();
			Object[] model = (Object[]) arg;
			for(int i = 0; i < model.length; i++) {
				drawShape((Shape2d)model[i]);
			}
		} else if(arg == null) {
			// clear all action
			clear();
		}
	}
	
	private void clear() {
		getGraphics().clearRect(0, 0, getWidth(), getHeight());
	}

	@Override
	public JPanel getView() {
		setPreferredSize(new Dimension(300,150));
		setVisible(true);
		return this;
	}
}
