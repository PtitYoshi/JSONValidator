package manager;

import com.hp.hpl.jena.rdf.model.Model;

import owl.OWLModel;

public class OWLManagerTest {
	
	private static String path = "/home/marius/Documents/HumanityBoat.owl";
	
	public static void main(String[] args) {
		OWLModel model = OWLManager.createOntologyModel(path);
		
		//OLD
		//Model m = model.describeClass();
		//NEW
		Model m = OWLManager.describe(model.extractClasses(), model);
		
		Model m2 = OWLManager.describe(model.extractSubjectWithProperty("a", "owl:Class"), model);
		
		OWLManager.displayModel(m2);
	}
}
