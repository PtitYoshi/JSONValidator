package manager;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;

import owl.OWLModel;

public class OWL2JSON
{
	//private static HashMap<,>
	private OWL2JSON() {}

	@SuppressWarnings("unused")
	public static void parse(OWLModel model, String outPath) 
	{
		//1-Le keyword a/rdf:type owl:Class
		Model m = OWLManager.describe(model.extractSubjectWithProperty("a", "owl:Class"), model);
		//Map <K,V> ou K une classe, et V ses properties
		//HashMap<Resource, Properties> resourceMap = new HashMap<Resource, Properties>();
		
		StmtIterator iterator = m.listStatements();
		while(iterator.hasNext())
		{
			Statement stmt = iterator.next();
			
			//Reconnaitre la property
			
			//Reconnaitre le rôle de l'object dans la propriété.
		}
	}

}
