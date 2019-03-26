package json.element;

public abstract class PropertyElement extends StructuredElement {
	
	public PropertyElement(String name, String type) {
		super(name, type);
	}
	
	@Override
	public boolean isObjectElement() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPropertyElement() {
		// TODO Auto-generated method stub
		return true;
	}
}
