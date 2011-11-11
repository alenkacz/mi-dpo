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
	Hashtable<Integer, Shape2d> shapes = new Hashtable<Integer, Shape2d>();
	
	public void add(Shape2d s) {
		shapes.put(Integer.valueOf(s.getId()), s);
		setChanged();
		notifyObservers(s);
	}
	
	public void remove(Shape2d s) {
		
	}
	
	public void update(Shape2d s) {
		Shape2d shape = shapes.get(s.getId());
		if(shape != null) {
			shapes.put(s.getId(), s);
			setChanged();
			notifyObservers(shapes);
		}
	}
	
	public void clearAll() {
		shapes = new Hashtable<Integer, Shape2d>();
		setChanged();
		notifyObservers();
	}
}
