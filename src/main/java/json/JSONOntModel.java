package json;

import java.util.ArrayList;
import java.util.Iterator;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;

import json.element.StructuredElement;
import manager.OntModelManager;

public class JSONOntModel {

	ArrayList<StructuredElement> definitions;
	ArrayList<Resource> instanciableClasses;
	ArrayList<Resource> ResourceList;
	ArrayList<Resource> PropertyList;
	
	public JSONOntModel(Model m) {
		
		definitions = new ArrayList<StructuredElement>();
		instanciableClasses = new ArrayList<Resource>();
		ResourceList = new ArrayList<Resource>();
		PropertyList = new ArrayList<Resource>();
		
		//HashMap<Resource, HashMap<Property, ArrayList<RDFNode>>> contentModel = OntModelManager.constructMapFromModel(m);
		OntModelManager.constructMapFromModel(m);
		
		//DISPLAY
		OntModelManager.displayTripletsMap();
		
		Iterator<Resource> key = OntModelManager.contentModel.keySet().iterator();
		while(key.hasNext())
		{
			Resource stepKey = key.next();
			//if(!knew(stepKey)) { definition.put(stepKey, OntModelManager.define(stepKey)) }
			if(!ResourceList.contains(stepKey)&&!PropertyList.contains(stepKey)) {
				switch(OntModelManager.extractType(stepKey)) {
				case 0 : //Property
					PropertyList.add(stepKey);
					break;
				case 1 : //Class
					ResourceList.add(stepKey);
					break;
				default :
					System.err.println("Switch function error... : "+stepKey);
				}
			}
		}
		
		System.out.println("\n\n"+ResourceList+"\n"+PropertyList);
		
	}

	public void display() {
		
	}

}
