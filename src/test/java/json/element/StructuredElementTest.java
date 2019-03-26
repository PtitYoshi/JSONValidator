package json.element;

import java.util.ArrayList;

import utils.StructuredElementType;

public class StructuredElementTest {
	
	public static void main(String[] args)
	{
		StructuredElement firstName = new DatatypePropertyElement("hasFirstName",StructuredElementType.STRING);
		StructuredElement YGName = new DatatypePropertyElement("hasYoungGirlName",StructuredElementType.STRING);
		StructuredElement name = new DatatypePropertyElement("hasName",StructuredElementType.STRING);
		StructuredElement age = new DatatypePropertyElement("hasAge",StructuredElementType.NUMBER);
		StructuredElement id = new DatatypePropertyElement("hasId", StructuredElementType.NUMBER);

		ArrayList<PropertyElement> humanProperties = new ArrayList<PropertyElement>();
		humanProperties.add(name.asPropertyElement());
		humanProperties.add(firstName.asPropertyElement());
		humanProperties.add(age.asPropertyElement());
		StructuredElement Human = new ObjectElement("Human",humanProperties);
		
		ArrayList<PropertyElement> maleProperties = new ArrayList<PropertyElement>();
		maleProperties.add(new ReferencedElement(Human));
		StructuredElement Male = new ObjectElement("Male", maleProperties);
		
		ArrayList<PropertyElement> femaleProperties = new ArrayList<PropertyElement>();
		femaleProperties.add(new ReferencedElement(Human));
		StructuredElement Female = new ObjectElement("Female", femaleProperties);
		
		ArrayList<PropertyElement> boatProperties = new ArrayList<PropertyElement>();
		boatProperties.add((PropertyElement) id);
		StructuredElement Boat = new ObjectElement("Boat", boatProperties);
		
		StructuredElement own = new ObjectPropertyElement("own");
	}
}
