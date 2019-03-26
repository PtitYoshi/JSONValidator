package manager;

import java.util.List;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.StmtIterator;

import owl.OWLModel;

public class OWLManager {

	public static OWLModel createOntologyModel(String path) {
		return new OWLModel(path);
	}
	
	public static Model describe(List<Resource> resources, OWLModel model) {
		Model res = ModelFactory.createDefaultModel();
		//List<Resource> classes = extractClasses();
		
		for(Resource r:resources)
		{
			try
			{
				String SPARQLQueryString = "DESCRIBE <"+r+">";		
				Query query = QueryFactory.create(model.getPrefixes()+SPARQLQueryString);
				QueryExecution qexec = QueryExecutionFactory.create(query, model.getModel());
				
				res.add(qexec.execDescribe());
				qexec.close();
			}
			catch(Exception e) {
				System.err.println(e+"\nResource blocked : "+r);
			}
		}
		
		return res;
	}
	
	public static Model describe(String r, OWLModel model) {
		Model res = ModelFactory.createDefaultModel();
		//List<Resource> classes = extractClasses();
	
		try
		{
			String SPARQLQueryString = "DESCRIBE <"+r+">";		
			Query query = QueryFactory.create(model.getPrefixes()+SPARQLQueryString);
			QueryExecution qexec = QueryExecutionFactory.create(query, model.getModel());
			
			res.add(qexec.execDescribe());
			qexec.close();
		}
		catch(Exception e) {
			System.err.println(e+"\nResource blocked : "+r);
		}
		
		return res;
	}
	
	public static void extractSubClassOf(OWLModel model)
	{
		@SuppressWarnings("unused")
		Model res = ModelFactory.createDefaultModel();
		
		String SPARQLQueryString = "SELECT DISTINCT ?p1 ?p2 "
				+ "WHERE { ?p1 rdfs:subClassOf ?p2 }";
		Query query = QueryFactory.create(model.getPrefixes()+SPARQLQueryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, model.getModel());
		
		ResultSet queryResults = qexec.execSelect();
		
		System.out.println("\nAnswers :");
		while(queryResults.hasNext())
		{
			QuerySolution qs = queryResults.nextSolution();
			System.out.println(qs.getResource("?p1")+"\t=>\t"+qs.getResource("?p2"));
		}
	}

	public static void displayModel(Model m) {
		StmtIterator iterator = m.listStatements();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		
	}

}
