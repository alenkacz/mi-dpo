package cvut.fit.dpo.mvc.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import cvut.fit.dpo.mvc.controller.Controller;
import cvut.fit.dpo.mvc.model.ShapeModel;

public class TableView extends View implements Observer{
	
	private static final String[] tableHeaderSquare = new String[]{"id", "x", "y", "side"};
	private static final String[] tableHeaderCircle = {"id", "x", "y", "r"};
	
	JButton clearButton;
	
	@Override
	public JPanel getView() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		clearButton = new JButton("Clear all");
		JTable table = new JTable();
		ShapeTableModel model = new ShapeTableModel();
		model.setColumnIdentifiers(tableHeaderSquare);
		table.setModel(model);
		
		add(table);
		add(clearButton);
		return this;
	}
	
	@Override
	public void initActionListeners(Controller c) {
		clearButton.setActionCommand(Controller.CLEAR_COMMAND);
		clearButton.addActionListener(c);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
