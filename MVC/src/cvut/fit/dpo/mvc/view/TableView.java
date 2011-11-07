package cvut.fit.dpo.mvc.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
		clearButton = new JButton("Clear all");
		
		add(createSquareTable());
		add(createCircleTable());
		add(clearButton);
		fillData();
		
		return this;
	}
	
	private JTable createSquareTable() {
		JTable table = new JTable();
		table.setPreferredSize(new Dimension(200,100));
		squareTableModel = new ShapeTableModel();
		squareTableModel.setColumnIdentifiers(tableHeaderSquare);
		table.setModel(squareTableModel);
		
		return table;
	}
	
	private JTable createCircleTable() {
		JTable table = new JTable();
		table.setPreferredSize(new Dimension(200,100));
		circleTableModel = new ShapeTableModel();
		circleTableModel.setColumnIdentifiers(tableHeaderCircle);
		table.setModel(circleTableModel);
		
		return table;
	}
	
	private void fillData() {
		try {
			Shape2d s = new Circle(new Point(10,20));
			squareTableModel.addRow(shapeAdapter.getTableData(s));
			squareTableModel.addRow(shapeAdapter.getTableData(s));
			squareTableModel.addRow(shapeAdapter.getTableData(s));
			circleTableModel.addRow(shapeAdapter.getTableData(s));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void initActionListeners(Controller c) {
		clearButton.setActionCommand(Controller.CLEAR_COMMAND);
		clearButton.addActionListener(c);
		squareTableModel.addTableModelListener(c);
		circleTableModel.addTableModelListener(c);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
	}

}
