package json;

public class JSONSchemaTest {

	static String path = "/home/marius/eclipse-workspace/JSONValidator/target/test-classes/sampleModel.json";
	static String path2 = "/home/marius/eclipse-workspace/JSONValidator/target/test-classes/exampleSchema.json";
	
	public static void main(String[] args) {
		System.out.println("JSONSubject's class test !");
		
		System.out.println("Create a JSONSchema with "+path);
		JSONSchema subject = new JSONSchema(path);
		
		if(subject.isEmpty())
		{
			System.out.println("Failed..");
			return;
		}
		else
			System.out.println("Clear ! \n");
		
		System.out.println("Try to get schema..");		
		System.out.println(subject.getSchema()+"\n");
		
		System.out.println("Try to set another schema : "+path2);
		subject.setSchema(path2);
		System.out.println(subject.getSchema()+"\n");
	}

}
