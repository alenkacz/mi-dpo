package cvut.fit.dpo.mvc.model;

import cvut.fit.dpo.mvc.exception.ShapeException;

public class Circle extends Shape2d {

	public Circle(Point p, int x) throws ShapeException {
		super(p, x, x);
	}

}
