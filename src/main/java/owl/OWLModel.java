package owl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.util.FileManager;

public class OWLModel
{
	OntModel model;
	String prefix;
	String prefixOntology;

	public OWLModel(String path) {
		model = ModelFactory.createOntologyModel();
		model.read(FileManager.get().open(path), null);
		prefix=prefixQuery();
		prefixOntology="";
	}

	private ArrayList<Resource> getSubjects() {
		ArrayList<Resource> res = new ArrayList<Resource>();
		StmtIterator iterator = model.listStatements();
		while(iterator.hasNext())
		{
			Statement stmt = iterator.next();
			Resource r = stmt.getSubject();
			if(!res.contains(r))
				res.add(r);
		}
		return res;
	}
	
	public String getPrefixes()
	{
		return prefix;
	}
	
	public OntModel getModel() {
		return model;
	}
	
	private HashMap<Resource,ArrayList<Statement>> mapTriplets() {
		HashMap<Resource, ArrayList<Statement>> res = new HashMap<Resource, ArrayList<Statement>>();
		
		StmtIterator iterator = model.listStatements();
		while(iterator.hasNext())
		{
			Statement stmt = iterator.next();
			if(!res.containsKey(stmt.getSubject()))
				res.put(stmt.getSubject(), new ArrayList<Statement>());
			res.get(stmt.getSubject()).add(stmt);
		}
		
		return res;
	}
	
	public String prefixQuery() {
		String res="";
		
		Map<String, String> prefixes = model.getNsPrefixMap();
		Set<String> keys = prefixes.keySet();
		
		for(String key:keys) {
			res+="PREFIX "+key+": <"+prefixes.get(key)+"> \n";	
		}
		
		return res;
	}
	
	public List<Resource> extractClasses() {
		String SPARQLQueryString = "SELECT DISTINCT * "
				+"WHERE { ?s a rdfs:Class "
				+ "FILTER(STRSTARTS(STR(?s), STR("+prefixOntology+":))) }";
		//List<Statement> results = new ArrayList<Statement>();
		List<Resource> results = new ArrayList<Resource>();
		
		Query query = QueryFactory.create(prefix+SPARQLQueryString);
		
		QueryExecution qexec = QueryExecutionFactory.create(query, model);
		ResultSet queryResults = qexec.execSelect();
		
		while (queryResults.hasNext()) {
			QuerySolution qs = queryResults.nextSolution();
			results.add(qs.getResource("?s"));
			//System.out.println(qs);
		}
		qexec.close();
		
		return results;
	}
	
	public List<Resource> extractSubjectWithProperty(String p, String o) {
		String SPARQLQueryString = "SELECT DISTINCT ?s ?p ?o "
				+ "WHERE { ?s ?p ?o "
				+ "FILTER(STRSTARTS(STR(?s), STR("+prefixOntology+":))) }";
		
		List<Resource> results = new ArrayList<Resource>();
		
		Query query = QueryFactory.create(prefix+SPARQLQueryString);
		
		QueryExecution qexec = QueryExecutionFactory.create(query,model);
		ResultSet queryResults = qexec.execSelect();
		
		while(queryResults.hasNext()) {
			QuerySolution qs = queryResults.nextSolution();
			results.add(qs.getResource("?s"));
		}
		qexec.close();
		
		return results;
	}
	/*
	public List<Resource> extractClassWithProperty(Property p, Object o) {
		String SPARQLQueryString = "SELECT DISTINCT ?s ?p ?o "
				+ "WHERE { ?s a rdfs:Class "
				+ "FILTER(STRSTARTS(STR(?s), STR("+prefixOntology+":))) }";
		
		List<Resource> results = new ArrayList<Resource>();
		
		Query query = QueryFactory.create(prefix+SPARQLQueryString);
		
		QueryExecution qexec = QueryExecutionFactory.create(query,model);
		ResultSet queryResults = qexec.execSelect();
		
		while(queryResults.hasNext()) {
			QuerySolution qs = queryResults.nextSolution();
			if(qs.getResource("?p").equals(p) && qs.getResource("?o").equals(o))
				results.add(qs.getResource("?s"));
		}
		qexec.close();
		
		return results;
	}*/
	
	public Model describeClass() {
		Model res = ModelFactory.createDefaultModel();
		List<Resource> classes = extractClasses();
		
		for(Resource r:classes)
		{
			String SPARQLQueryString = "DESCRIBE <"+r+">";		
			Query query = QueryFactory.create(prefix+SPARQLQueryString);
			QueryExecution qexec = QueryExecutionFactory.create(query, model);
			
			res.add(qexec.execDescribe());
			qexec.close();
		}
		
		return res;
	}
	
	@SuppressWarnings("unused")
	private void displayModel(Model m) {
		StmtIterator iterator = m.listStatements();
		while(iterator.hasNext())
		{
			Statement stmt = iterator.next();
			System.out.println(stmt+"\n");
		}
	}

	public void displayPrefixes() {
		System.out.println(model.getNsPrefixMap());
	}
	
	public void displaySubject()
	{
		ArrayList<Resource> tmp = getSubjects();
		for(Resource r:tmp) {
			System.out.println("\n"+r);
		}
	}

	public void displayAllResources() {
		ArrayList<Resource> tmp = getSubjects();
		HashMap<Resource, ArrayList<Statement>> values = mapTriplets();
		
		for(Resource r:tmp) {
			System.out.println("\nKey="+r+" : Values="+values.get(r));
		}
	}
}