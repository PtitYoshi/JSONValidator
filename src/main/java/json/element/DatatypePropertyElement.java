package json.element;

import utils.StructuredElementType;

public class DatatypePropertyElement extends PropertyElement {
	
	public DatatypePropertyElement(String name, String type) {
		super(name,checkType(type));
	}

	private static String checkType(String type) {
		String res="nil";
		
		for(int i=0; i<StructuredElementType._DATATYPE.length;i++)
		{
			if(type.equals(StructuredElementType._DATATYPE[i])) {
				res=type;
			}
		}
		return res;
	}

}
