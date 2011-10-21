package cvut.fit.dpo.arithmetic.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cvut.fit.dpo.arithmetic.elements.ExpressionElement;

public class InOrderIterator implements Iterator<ExpressionElement>
{
	private List<ExpressionElement> elements;
	private int position = 0;
	
	public InOrderIterator(ExpressionElement e) {
		elements = new ArrayList<ExpressionElement>();
		elements.add(e);
	}
	
	public InOrderIterator(List<ExpressionElement> elements) {
		this.elements = elements;
	}
	
	@Override
	public boolean hasNext()
	{
		return (position < elements.size());
	}

	@Override
	public ExpressionElement next()
	{
		return elements.get(position++);
	}

	@Override
	public void remove()
	{
		elements.remove(position);
	}

}
