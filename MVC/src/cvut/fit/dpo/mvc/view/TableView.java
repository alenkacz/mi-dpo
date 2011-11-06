package cvut.fit.dpo.mvc.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import cvut.fit.dpo.mvc.controller.Controller;
import cvut.fit.dpo.mvc.model.ShapeModel;

public class TableView extends View implements Observer{
	
	private static final String[] tableHeaderSquare = new String[]{"id", "x", "y", "side"};
	private static final String[] tableHeaderCircle = {"id", "x", "y", "r"};
	
	@Override
	public JPanel getView() {
		JPanel tPanel = new JPanel();
		JTable table = new JTable();
		ShapeTableModel model = new ShapeTableModel();
		model.setColumnIdentifiers(tableHeaderSquare);
		table.setModel(model);
		
		tPanel.add(table);
		return tPanel;
	}
	
	@Override
	public void initActionListeners(Controller c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
