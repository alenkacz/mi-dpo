package cvut.fit.dpo.mvc.model;

import java.awt.Point;

import cvut.fit.dpo.mvc.exception.ShapeException;

public class Circle extends Shape2d {

	public Circle(Point p) throws ShapeException {
		super(p);
	}
	
	public Circle(Point p, int x) throws ShapeException {
		super(p, x, x);
	}

}
