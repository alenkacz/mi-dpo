package cvut.fit.dpo.arithmetic.builder;

import cvut.fit.dpo.arithmetic.AddOperator;
import cvut.fit.dpo.arithmetic.ArithmeticExpression;
import cvut.fit.dpo.arithmetic.NumericOperand;
import cvut.fit.dpo.arithmetic.SubstractOperator;
import cvut.fit.dpo.arithmetic.component.Component;

public class ArithmeticExpressionBuilder implements IExpressionBuilder {
	ArithmeticExpression ex = new ArithmeticExpression();
	
	public ArithmeticExpression getExpression() {
		return ex;
	}
	
	public void buildSingleOperand(int a) {
		ex.setRoot(new NumericOperand(a));
	}
	
	////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////    Add Operator   //////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////
	
	public Component buildAddOperator(int a, int b) {
		NumericOperand n1 = new NumericOperand(a);
		NumericOperand n2 = new NumericOperand(b);
		AddOperator add = new AddOperator(n1, n2);
		ex.setRoot(add);
		
		return add;
	}
	public Component buildAddOperator(int a, Component b) {
		NumericOperand n1 = new NumericOperand(a);
		AddOperator add = new AddOperator(n1, b);
		ex.setRoot(add);
		
		return add;
	}
	public Component buildAddOperator(Component a, int b) {
		NumericOperand n1 = new NumericOperand(b);
		AddOperator add = new AddOperator(a, n1);
		ex.setRoot(add);
		
		return add;
	}
	public Component buildAddOperator(Component a, Component b) {
		AddOperator add = new AddOperator(a, b);
		ex.setRoot(add);
		
		return add;
	}
	
	////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////    Substract Operator   ////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////
	
	public Component buildSubstractOperator(int a, int b) {
		NumericOperand n1 = new NumericOperand(a);
		NumericOperand n2 = new NumericOperand(b);
		SubstractOperator sub = new SubstractOperator(n1, n2);
		ex.setRoot(sub);
		
		return sub;
	}
	public Component buildSubstractOperator(int a, Component b) {
		NumericOperand n1 = new NumericOperand(a);
		SubstractOperator sub = new SubstractOperator(n1, b);
		ex.setRoot(sub);
		
		return sub;
	}
	public Component buildSubstractOperator(Component a, int b) {
		NumericOperand n1 = new NumericOperand(b);
		SubstractOperator sub = new SubstractOperator(a, n1);
		ex.setRoot(sub);
		
		return sub;
	}
	public Component buildSubstractOperator(Component a, Component b) {
		SubstractOperator sub = new SubstractOperator(a, b);
		ex.setRoot(sub);
		
		return sub;
	}
}
