package cvut.fit.dpo.mvc.model;

import java.awt.Point;

import cvut.fit.dpo.mvc.exception.ShapeException;

public class Square extends Shape2d {

	public Square(Point p) throws ShapeException {
		super(p);
	}
	
	public Square(Point p, int x) throws ShapeException {
		super(p, x, x);
	}

}
