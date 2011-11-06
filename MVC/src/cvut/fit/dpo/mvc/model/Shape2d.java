package cvut.fit.dpo.mvc.model;

import java.awt.Point;
import java.util.Random;

import cvut.fit.dpo.mvc.exception.ShapeException;

public class Shape2d {
	private static final int DEFAULT_SIZE = 10;
	private static Random generator = new Random( 19500427 );
	
	private int id;
	private int x;
	private int y;
	private Point point;
	
	public Shape2d(Point p) throws ShapeException {
		id = generateId();
		this.point = p;
		setX(DEFAULT_SIZE);
		setY(DEFAULT_SIZE);
	}
	
	public Shape2d(Point p, int x, int y) throws ShapeException {
		id = generateId();
		setX(x);
		setY(y);
		this.point = p;
	}

	private int generateId() {
		return generator.nextInt();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) throws ShapeException {
		if( x < 0 ) {
			throw new ShapeException();
		}
		this.x = x;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}
