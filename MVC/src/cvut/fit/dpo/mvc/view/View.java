package cvut.fit.dpo.mvc.view;

import javax.swing.JPanel;

import cvut.fit.dpo.mvc.controller.Controller;

public abstract class View extends JPanel {
	public abstract JPanel getView();
	public abstract void initActionListeners(Controller c);
}
