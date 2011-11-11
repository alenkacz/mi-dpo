package cvut.fit.dpo.mvc.view.table;

import cvut.fit.dpo.mvc.model.Shape2d;

public class ShapeAdapter {
	public Object[] getTableData(Shape2d s) {
		String[] result = new String[4];
		result[0] = String.valueOf(s.getId());
		result[1] = String.valueOf(s.getPoint().x);
		result[2] = String.valueOf(s.getPoint().y);
		result[3] = String.valueOf(s.getX());
		
		return result;
	}
}
