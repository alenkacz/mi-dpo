package cvut.fit.dpo.mvc.view;

import java.awt.Point;

import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

import cvut.fit.dpo.mvc.exception.ShapeException;
import cvut.fit.dpo.mvc.model.Shape2d;

public class ShapeTableModel extends DefaultTableModel {
	
	@Override
	public boolean isCellEditable(int r, int c) {
		// lets make id parameter not editable
		if(c == 0) {
			return false;
		}
		
		return true;
	}
	
	public Shape2d getShape(int r) throws ShapeException {
		int id = Integer.parseInt((String)getValueAt(r, 0));
		int x = Integer.parseInt((String)getValueAt(r, 1));
		int y = Integer.parseInt((String)getValueAt(r, 2));
		int side = Integer.parseInt((String)getValueAt(r, 3));
		
		return new Shape2d(id, new Point(x,y), side);
	}
}
