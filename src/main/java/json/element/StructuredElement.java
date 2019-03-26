package json.element;

public abstract class StructuredElement {

	public String key;
	public String type;
	
	public StructuredElement(String name, String type) {
		this.key = name;
		this.type = type;
	}
	public abstract boolean isObjectElement();
	public abstract boolean isPropertyElement();
	
	public PropertyElement asPropertyElement() {
		
		return (PropertyElement) this;
	}
	
}
