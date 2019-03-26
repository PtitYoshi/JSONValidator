package utils;

public class OWLDefinition {
	//RDF Domain
	//RDF vocabulary link : https://www.w3.org/TR/rdf-schema/
	public static final String RDF_PREFIX = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
	public static final String RDF_TYPE = "http://www.w3.org/1999/02/22-rdf-syntax-ns#type"; //Utilisé dans OntModelManager.generateType()
	public static final String RDF_LIST = "http://www.w3.org/1999/02/22-rdf-syntax-ns#List";
	public static final String RDF_FIRST = "http://www.w3.org/1999/02/22-rdf-syntax-ns#first";
	public static final String RDF_REST = "http://www.w3.org/1999/02/22-rdf-syntax-ns#rest";
	public static final String RDF_NULL = "http://www.w3.org/1999/02/22-rdf-syntax-ns#nil";
	
	//RDFS Domain
	//RDFS vocabulary link : https://www.w3.org/TR/rdf-schema/
	public static final String RDFS_PREFIX = "http://www.w3.org/2000/01/rdf-schema#";
	public static final String RDFS_CLASS = "http://www.w3.org/2000/01/rdf-schema#Class";
	public static final String RDFS_RESOURCE = "http://www.w3.org/2000/01/rdf-schema#Resource";
	public static final String RDFS_DOMAIN = "http://www.w3.org/2000/01/rdf-schema#domain";
	public static final String RDFS_RANGE = "http://www.w3.org/2000/01/rdf-schema#range";
	public static final String RDFS_SUBCLASSOF = "http://www.w3.org/2000/01/rdf-schema#subClassOf";
	public static final String RDFS_LITERAL = "http://www.w3.org/2000/01/rdf-schema#Literal";
	
	//OWL Domain
	public static final String OWL_PREFIX = "http://www.w3.org/2002/07/owl#";
	public static final String OWL_FUNCTIONAL_PROPERTY = "http://www.w3.org/2002/07/owl#FunctionalProperty";
	public static final String OWL_DATATYPE_PROPERTY = "http://www.w3.org/2002/07/owl#DatatypeProperty";
	public static final String OWL_OBJECT_PROPERTY = "http://www.w3.org/2002/07/owl#ObjectProperty";
	public static final String OWL_PROPERTY = "http://www.w3.org/1999/02/22-rdf-syntax-ns#Property";
	public static final String OWL_THING = "http://www.w3.org/2002/07/owl#Thing";
	public static final String OWL_INVERSEOF = "http://www.w3.org/2002/07/owl#inverseOf";
	public static final String OWL_DISJOINTUNIONOF = "http://www.w3.org/2002/07/owl#disjointUnionOf";
	public static final String OWL_CLASS = "http://www.w3.org/2002/07/owl#Class";
	
	//XML Domain
	public static final String XML_STRING = "http://www.w3.org/2001/XMLSchema#string";
	
	//Type Range
	public static final String[] PROPERTIES = {OWL_PROPERTY, OWL_FUNCTIONAL_PROPERTY, OWL_DATATYPE_PROPERTY};
	public static final String[] OBJECTS = {OWL_THING};
	public static final String[][] RDF_TYPE_RANGE = {OBJECTS, PROPERTIES};
	
	//Prefix List
	public static final String[] PREFIXES = {RDF_PREFIX, RDFS_PREFIX, OWL_PREFIX};
	
}
