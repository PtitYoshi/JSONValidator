import java.io.FileWriter;
import java.io.IOException;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.FileManager;

/*
 * Classe test prenant une ontologie OWL en entrée, ainsi que des fichiers JSON.
 * Convertit l'ontologie OWL en JSON-Schema afin de verifier la validation des fichiers JSON envoyés
 */
public class AppTestToMain2
{
	//1- Conversion OWL2JSON_SCHEMA
	public static void main(String[] args) throws IOException {
		OntModel m = ModelFactory.createOntologyModel();
		m.read(FileManager.get().open("/home/marius/Documents/OntoTest.owl"),null);
		
		/*
		StmtIterator iter = m.listStatements();
		while(iter.hasNext())
		{
			Statement stmt = iter.next();
			
			System.out.println("Subject : "+stmt.getSubject());
			System.out.println("Property : "+stmt.getPredicate());
			System.out.println("Object : "+stmt.getObject());
			
			System.out.println("TOTAL : "+stmt);
		}
		*/
		
		//System.out.println(m);
		
		m.write(new FileWriter("test.jsonld"),"JSONLD");
	}
	
	//2- VALIDATION JSON
}
