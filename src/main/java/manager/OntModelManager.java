package manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;

import utils.OWLDefinition;

public class OntModelManager {
	
	public static HashMap<Resource, HashMap<Property, ArrayList<RDFNode>>> contentModel = new HashMap<Resource, HashMap<Property, ArrayList<RDFNode>>>();

	
	public static HashMap<Resource, HashMap<Property, ArrayList<RDFNode>>> constructMapFromModel(Model model) {
		StmtIterator ite = model.listStatements();
		clean();
		
		while(ite.hasNext()) {
			Statement stmt = ite.next();
			//Subject
			Resource s = stmt.getSubject();
			if(!contentModel.containsKey(s)) {
				contentModel.put(s, new HashMap<Property,ArrayList<RDFNode>>());
				//ResourceList.add(s);
			}
			//Property
			Property p = stmt.getPredicate();
			if(!contentModel.get(s).containsKey(p))
			{
				contentModel.get(s).put(p, new ArrayList<RDFNode>());
				//PropertyList.add(p);
			}
			
			//stmt.getObject();
			contentModel.get(s).get(p).add(stmt.getObject());
		}
		
		return contentModel;
	}
	
	public static void displayTripletsMap() {
		System.out.println("\n\n");
		String tab;
		Iterator<Resource> key = contentModel.keySet().iterator();
		while(key.hasNext())
		{
			tab="|";
			Resource stepKey = key.next();
			System.out.println(tab+stepKey);
			Iterator<Property> prop = contentModel.get(stepKey).keySet().iterator();
			tab+="\t|";
			while(prop.hasNext())
			{
				Property stepProp = prop.next();
				System.out.println(tab+stepProp);
				tab+="\t|";
				for(int i=0;i<contentModel.get(stepKey).get(stepProp).size();i++)
				{
					System.out.println(tab+contentModel.get(stepKey).get(stepProp).get(i));
				}
				tab="|\t|";
			}
			tab="|";
		}
		
	}

	public static void clean() {
		contentModel = new HashMap<Resource, HashMap<Property, ArrayList<RDFNode>>>();
		
	}
	
	public static void define(Resource target) {
		
	}
	
	public static int extractType(Resource target) {
		
		ArrayList<RDFNode> types = extractObjectsByProperties(target, OWLDefinition.RDF_TYPE);
		
		int res = -1;
		for(int i=0;i<types.size();i++)
		{
			if(types.get(i).toString().equals(OWLDefinition.OWL_PROPERTY))
			{
				res = 0;
				break;
			}
			else if(types.get(i).toString().equals(OWLDefinition.OWL_CLASS))
			{
				res = 1;
				break;
			}
		}
		return res;
	}
	
	private static ArrayList<RDFNode> extractObjectsByProperties(Resource target, String propExtracted)
	{
		ArrayList<RDFNode> res = new ArrayList<RDFNode>();
		Iterator<Property> props = contentModel.get(target).keySet().iterator();
		
		while(props.hasNext())
		{
			Property p = props.next();
			if(p.toString().equals(propExtracted))
			{
				res.addAll(contentModel.get(target).get(p));
			}
		}
		
		return res;
	}
}
