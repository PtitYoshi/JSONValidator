package utils;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.StmtIterator;

public class OWLRuleDefinition {

	public static final OWLRule[] RULES = {
			new OWLRule(OWLDefinition.OWL_FUNCTIONAL_PROPERTY, OWLDefinition.OWL_PROPERTY),
			new OWLRule(OWLDefinition.OWL_DATATYPE_PROPERTY, OWLDefinition.OWL_PROPERTY),
			new OWLRule(OWLDefinition.OWL_OBJECT_PROPERTY, OWLDefinition.OWL_PROPERTY)
			};
	
	public static boolean minimalCover(Model m) {
		
		StmtIterator iterator = m.listStatements();
		//iterator.		
		
		return false;
	}
}
