package json.element;

import java.util.ArrayList;

public class ArrayElement extends StructuredElement {
	
	ArrayList<PropertyElement> value;
	
	public ArrayElement(String name, String type) {
		super(name, type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isObjectElement() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPropertyElement() {
		// TODO Auto-generated method stub
		return false;
	}
}
