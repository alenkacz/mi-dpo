package cvut.fit.dpo.mvc.view.table;

import java.awt.Point;

import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

import cvut.fit.dpo.mvc.exception.ShapeException;
import cvut.fit.dpo.mvc.model.Shape2d;

public abstract class ShapeTableModel extends DefaultTableModel {
	
	@Override
	public boolean isCellEditable(int r, int c) {
		// lets make id parameter not editable
		if(c == 0) {
			return false;
		}
		
		return true;
	}
	
	public void clearAll() {
		while(getRowCount() > 0) {
			removeRow(0);
		}
	}
	
	public abstract Shape2d getShape(int r) throws ShapeException ;
}
