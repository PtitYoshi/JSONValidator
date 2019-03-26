package manager;

public class JSONManagerTest {
	
	static String schemaPath = "/home/marius/eclipse-workspace/JSONValidator/target/test-classes/sampleModel.json";
	static String path = "/home/marius/eclipse-workspace/JSONValidator/target/test-classes/sampleRight.json";
	static String path2 = "/home/marius/eclipse-workspace/JSONValidator/target/test-classes/sampleWrong.json";

	/*
	@Test
	void test() {
		fail("Not yet implemented");
	}*/
	
	public static void main(String[] args) {
		JSONManager manager = JSONManager.instanciate();
		
		manager.loadSchema(schemaPath);
		addSubjectTest(manager, path);
		addSubjectTest(manager, path2);
		
		manager.displayObject();		
	}
	
	private static void addSubjectTest(JSONManager manager, String path) {
		if(manager.addSubject(path))
			System.out.println("JSON valide et ajouté : "+path);
		else
			System.out.println("JSON invalide et refusé : "+path);
	}
}
