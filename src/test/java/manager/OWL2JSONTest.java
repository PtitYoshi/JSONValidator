package manager;

import owl.OWLModel;

public class OWL2JSONTest
{
	private static String inPath = "/home/marius/Documents/HumanityBoat.owl";
	private static String outPath = "/home/marius/Docuents/HumanityBoat.json";
	
	public static void main(String[] args) {
		OWLModel model = OWLManager.createOntologyModel(inPath);
		
		OWL2JSON.parse(model,outPath);
	}
}
