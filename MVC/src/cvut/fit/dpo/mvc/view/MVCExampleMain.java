package cvut.fit.dpo.mvc.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import cvut.fit.dpo.mvc.controller.Controller;
import cvut.fit.dpo.mvc.exception.ShapeException;
import cvut.fit.dpo.mvc.model.Circle;
import cvut.fit.dpo.mvc.model.Point;
import cvut.fit.dpo.mvc.model.ShapeModel;

public class MVCExampleMain extends JFrame {
	
	ShapeModel model;
	
	public MVCExampleMain() {
		model = new ShapeModel();
		GraphicalView gView = new GraphicalView();
		TableView tView = new TableView();	
		Controller c = new Controller(model, gView, tView);
		
		addInitData();
	}
	
	public void addInitData() {
		try {
			model.add(new Circle(new Point(10,10),5));
		} catch(ShapeException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	  {
		MVCExampleMain main = new MVCExampleMain();
	    main.setVisible(true);
	  }
}
