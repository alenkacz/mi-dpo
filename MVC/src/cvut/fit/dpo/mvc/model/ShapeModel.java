package cvut.fit.dpo.mvc.model;

import java.awt.Shape;
import java.util.Hashtable;
import java.util.Observable;

/**
 * Storage of all shapes
 * @author Alena Varkockova (varkockova.a@gmail.com)
 *
 */
public class ShapeModel extends Observable {
	Hashtable<Integer, Shape> shapes = new Hashtable<Integer, Shape>();
	
	public void add(Shape2d s) {
		
	}
	
	public void remove(Shape2d s) {
		
	}
	
	public void update(Shape2d s) {
		
	}
}
