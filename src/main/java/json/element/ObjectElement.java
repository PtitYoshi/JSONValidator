package json.element;

import java.util.ArrayList;

import utils.StructuredElementType;

public class ObjectElement extends StructuredElement {
	ArrayList<PropertyElement> properties;

	public ObjectElement(String string, ArrayList<PropertyElement> humanProperties) {
		super(string, StructuredElementType.OBJECT);
		this.properties = humanProperties;
	}

	@Override
	public boolean isPropertyElement() {
		return false;
	}

	@Override
	public boolean isObjectElement() {
		return true;
	}
}
