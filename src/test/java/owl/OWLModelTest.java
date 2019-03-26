package owl;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.StmtIterator;

public class OWLModelTest {

	private static String path = "/home/marius/Documents/HumanityBoat.owl";
	
	public static void main(String[] args) {
		OWLModel model = new OWLModel(path);
		//DISPALY FONCTIONS TEST
		//model.displaySubject();
		//model.displayAllResources();
		//model.displayPrefixes();
		
		//PREFIXES EXTRACTION TEST
		//System.out.println(model.prefixQuery());
		
		//UNGENERALS CLASSES EXTRACTION TEST
		/*
		List<Resource> classes = model.extractClasses();
		for(Resource r:classes) {
			System.out.println(r);
		}
		*/
		
		//MODEL FILTERING TEST
		Model m = model.describeClass();
		StmtIterator iterator = m.listStatements();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}

}
