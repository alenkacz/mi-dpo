package cvut.fit.dpo.mvc.controller;

import java.awt.Point;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import cvut.fit.dpo.mvc.exception.ShapeException;
import cvut.fit.dpo.mvc.model.Circle;
import cvut.fit.dpo.mvc.model.Shape2d;
import cvut.fit.dpo.mvc.model.ShapeModel;
import cvut.fit.dpo.mvc.model.Square;
import cvut.fit.dpo.mvc.view.GraphicalView;
import cvut.fit.dpo.mvc.view.TableView;

public class Controller implements ActionListener, MouseListener {

	public static final String ADD_CIRCLE_COMMAND = "addCircle";
	
	private ShapeModel model;
	private GraphicalView gView;
	private TableView tView;
	
	public Controller(ShapeModel model, GraphicalView gView, TableView tView) {
		this.model = model;
		this.gView = gView;
		this.tView = tView;

		gView.initActionListeners(this);
		tView.initActionListeners(this);
		
		model.addObserver(gView);
		model.addObserver(tView);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals(ADD_CIRCLE_COMMAND)) {
			//addCircle();
		}
	}
	
	private void addCircle(Point p) throws ShapeException {
		Shape2d s = new Circle(p);
		model.add(s);
	}
	
	private void addSquare(Point p) throws ShapeException {
		Shape2d s = new Square(p);
		model.add(s);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		try {
			if(e.getButton() == MouseEvent.BUTTON1) {
				// left button
				addCircle(e.getPoint());
			} else if(e.getButton() == MouseEvent.BUTTON3) {
				addSquare(e.getPoint());
			}
		} catch(ShapeException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// nothing
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// nothing
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// nothing
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// nothing
	}
	
}
