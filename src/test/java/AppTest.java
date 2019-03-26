import java.io.IOException;
import java.io.InputStream;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

public class AppTest {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try (InputStream inputStream = AppTest.class.getResourceAsStream("exampleSchema.json")) {
			  JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
			  SchemaLoader loader = SchemaLoader.builder()
		                .schemaJson(rawSchema)
		                .draftV7Support()
		                .build();
			  
			  Schema schema = loader.load().build();
			  
			  //Schema schema = SchemaLoader.load(rawSchema);  
			  
			  InputStream stream1 = AppTest.class.getResourceAsStream("exampleTest1.json");
			  JSONObject json1 = new JSONObject(new JSONTokener(stream1));
			  
			  InputStream stream2 = AppTest.class.getResourceAsStream("exampleTest2.json");
			  JSONObject json2 = new JSONObject(new JSONTokener(stream2));
			  
			  
			  try
			  {
				  schema.validate(json1);
				  System.out.println("exampleTest1.json validé");
			  }catch(ValidationException e)
			  {
				  System.out.println("exampleTest1.json non valide : "+ e);
			  }
			  
			  try
			  {
				  schema.validate(json2);
				  System.out.println("exampleTest2.json validé");
			  }catch(ValidationException e)
			  {
				  System.out.println("exampleTest2.json non valide : "+ e);
			  }
		}
	}

}
