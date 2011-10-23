package cvut.fit.dpo.arithmetic.builder;

import cvut.fit.dpo.arithmetic.ArithmeticExpression;
import cvut.fit.dpo.arithmetic.component.Component;

public interface IExpressionBuilder {
	ArithmeticExpression getExpression();
	
	Component buildAddOperator(int a, int b);
	Component buildAddOperator(int a, Component b);
	Component buildAddOperator(Component a, int b);
	Component buildAddOperator(Component a, Component b);
	
	Component buildSubstractOperator(int a, int b);
	Component buildSubstractOperator(int a, Component b);
	Component buildSubstractOperator(Component a, int b);
	Component buildSubstractOperator(Component a, Component b);
}
