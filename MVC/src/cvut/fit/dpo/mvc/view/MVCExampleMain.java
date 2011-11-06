package cvut.fit.dpo.mvc.view;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import cvut.fit.dpo.mvc.controller.Controller;
import cvut.fit.dpo.mvc.exception.ShapeException;
import cvut.fit.dpo.mvc.model.Circle;
import cvut.fit.dpo.mvc.model.ShapeModel;

public class MVCExampleMain extends JFrame {
	
	ShapeModel model;
	GraphicalView gView;
	TableView tView;
	
	public MVCExampleMain() {
		model = new ShapeModel();
		gView = new GraphicalView();
		tView = new TableView();	
		initGUI();
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
	
	private void initGUI() {
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setSize(500,500);
		
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		getContentPane().add(gView.getView());
		getContentPane().add(tView.getView());
		setVisible(true);
	}
	
	public static void main(String[] args)
	  {
		MVCExampleMain main = new MVCExampleMain();
	  }
}
