package cvut.fit.dpo.mvc.view.table;

import java.awt.Point;

import cvut.fit.dpo.mvc.exception.ShapeException;
import cvut.fit.dpo.mvc.model.Circle;
import cvut.fit.dpo.mvc.model.Shape2d;
import cvut.fit.dpo.mvc.model.Square;

public class SquareTableModel extends ShapeTableModel {

	@Override
	public Square getShape(int r) throws ShapeException {
		int id = Integer.parseInt((String)getValueAt(r, 0));
		int x = Integer.parseInt((String)getValueAt(r, 1));
		int y = Integer.parseInt((String)getValueAt(r, 2));
		int side = Integer.parseInt((String)getValueAt(r, 3));
		
		return new Square(id, new Point(x,y), side);
	}

}
