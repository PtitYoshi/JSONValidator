package json;

public class JSONSubjectTest {

	static String path = "/home/marius/eclipse-workspace/JSONValidator/target/test-classes/sampleRight.json";
	static String path2 = "/home/marius/eclipse-workspace/JSONValidator/target/test-classes/sampleWrong.json";
	public static void main(String[] args) {
		
		System.out.println("JSONSubject's class test !");
		
		System.out.println("Create a JSONSubject with "+path);
		JSONSubject subject = new JSONSubject(path);
		if(subject.isEmpty())
		{
			System.out.println("Failed..");
			return;
		}
		else
			System.out.println("Clear ! \n");
		
		System.out.println("Try to get object..");		
		System.out.println(subject.getObject()+"\n");
		
		System.out.println("Try to set another object : "+path2);
		subject.setObject(path2);
		System.out.println(subject.getObject()+"\n");
	}

}
