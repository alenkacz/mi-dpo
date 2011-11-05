package cvut.fit.dpo.mvc.model;

import cvut.fit.dpo.mvc.exception.ShapeException;

public class Square extends Shape2d {

	public Square(Point p, int x) throws ShapeException {
		super(p, x, x);
	}

}
