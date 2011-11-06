package cvut.fit.dpo.mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cvut.fit.dpo.mvc.model.Circle;
import cvut.fit.dpo.mvc.model.Point;
import cvut.fit.dpo.mvc.model.Shape2d;
import cvut.fit.dpo.mvc.model.ShapeModel;
import cvut.fit.dpo.mvc.view.GraphicalView;
import cvut.fit.dpo.mvc.view.TableView;

public class Controller implements ActionListener {

	public static final String ADD_CIRCLE_COMMAND = "addCircle";
	
	private ShapeModel model;
	private GraphicalView gView;
	private TableView tView;
	
	public Controller(ShapeModel model, GraphicalView gView, TableView tView) {
		this.model = model;
		this.gView = gView;
		this.tView = tView;

		gView.initActionListeners();
		tView.initActionListeners();
		
		model.addObserver(gView);
		model.addObserver(tView);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals(ADD_CIRCLE_COMMAND)) {
			addCircle();
		}
	}
	
	private void addCircle() {
		
	}
	
	private void addSquare() {
		
	}
	
}
