package json.element;

public class ReferencedElement extends PropertyElement {

	public ReferencedElement(String name, String type) {
		super(name, type);
		// TODO Auto-generated constructor stub
	}

	public ReferencedElement(StructuredElement e) {
		super("$ref",""); //TODO
	}

}
