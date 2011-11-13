package cvut.fit.dpo.mvc.view;

import java.util.Observer;

import javax.swing.JPanel;

import cvut.fit.dpo.mvc.controller.Controller;
import cvut.fit.dpo.mvc.model.ShapeModel;

/**
 * Generic view class
 * 
 * @author Alena Varkockova (varkockova.a@gmail.com)
 *
 */
public abstract class View extends JPanel{
	protected ShapeModel model;
	public View(ShapeModel model) {
		this.model = model;
	}
	
	public abstract JPanel getView();
	public abstract void initActionListeners(Controller c);
}
