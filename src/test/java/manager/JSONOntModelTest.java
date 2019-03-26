package manager;

import com.hp.hpl.jena.rdf.model.Model;

import json.JSONOntModel;
import owl.OWLModel;
import utils.OWLDefinition;

public class JSONOntModelTest {
	
	private static String path = "/home/marius/Documents/oeso.owl";
	
	public static void main(String[] args) {
		OWLModel model = OWLManager.createOntologyModel(path);
		Model m2 = OWLManager.describe(model.extractSubjectWithProperty("a", "owl:Class"), model);
		
		OWLManager.displayModel(m2);
		
		JSONOntModel mod = new JSONOntModel(m2);
		
		model.getPrefixes();
		
		//OWLManager.extractSubClassOf(model);
		//OWLManager.displayModel(OWLManager.describe(OWLDefinition.OWL_PROPERTY, model));
		//mod.display();
	}
}
