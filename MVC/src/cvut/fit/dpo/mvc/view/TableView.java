package cvut.fit.dpo.mvc.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import cvut.fit.dpo.mvc.controller.Controller;
import cvut.fit.dpo.mvc.model.Circle;
import cvut.fit.dpo.mvc.model.Shape2d;
import cvut.fit.dpo.mvc.model.ShapeModel;

public class TableView extends View implements Observer{
	
	private static final String[] tableHeaderSquare = new String[]{"id", "x", "y", "side"};
	private static final String[] tableHeaderCircle = {"id", "x", "y", "r"};
	
	JButton clearButton;
	ShapeTableModel squareTableModel;
	ShapeTableModel circleTableModel;
	ShapeAdapter shapeAdapter = new ShapeAdapter();
	
	@Override
	public JPanel getView() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(250,250));
		clearButton = new JButton("Clear all");
		
		add(createSquareTable());
		add(createCircleTable());
		add(clearButton);
		
		return this;
	}
	
	private JPanel createSquareTable() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JTable table = new JTable();
		JScrollPane scroll = new JScrollPane(table);
		table.setPreferredSize(new Dimension(250,150));
		squareTableModel = new ShapeTableModel();
		squareTableModel.setColumnIdentifiers(tableHeaderSquare);
		table.setModel(squareTableModel);
		
		panel.add(scroll);
		return panel;
	}
	
	private JPanel createCircleTable() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JTable table = new JTable();
		JScrollPane scroll = new JScrollPane(table);
		table.setPreferredSize(new Dimension(250,150));
		circleTableModel = new ShapeTableModel();
		circleTableModel.setColumnIdentifiers(tableHeaderCircle);
		table.setModel(circleTableModel);
		
		panel.add(scroll);
		return panel;
	}
	
	@Override
	public void initActionListeners(Controller c) {
		clearButton.setActionCommand(Controller.CLEAR_COMMAND);
		clearButton.addActionListener(c);
		squareTableModel.addTableModelListener(c);
		circleTableModel.addTableModelListener(c);
	}
	
	private void clear() {
		
	}
	
	private void addShape(Shape2d shape) {
		
	}

	@Override
	public void update(Observable o, Object arg) {
		if(arg instanceof Shape2d) {
			addShape((Shape2d)arg);
		} else if(arg == null) {
			// clear all action
			clear();
		}
	}
	

}
