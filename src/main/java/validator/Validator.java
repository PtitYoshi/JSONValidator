package validator;

import java.io.IOException;
import java.io.InputStream;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * JSON Validator using JSON Schema
 * @author Vokleber Marius
 * @version 1.0
 */
public class Validator {
	
	private Schema schema;

	/**
	 * Construct the JSON validator.
	 * @param pathSchema 	 JSON Schema's path file
	 * @throws IOException 
	 */
	public Validator(Class<?> source, String pathSchema) throws IOException {
		// TODO Auto-generated constructor stub
		try (InputStream inputStream = source.getResourceAsStream(pathSchema)) {
			  JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
			  SchemaLoader loader = SchemaLoader.builder()
		                .schemaJson(rawSchema)
		                .draftV7Support()
		                .build();
			  
			  setSchema(loader.load().build());
			  inputStream.close();
		}
	}

	public boolean validate(Class<?> source, String pathSubject) throws IOException {
		// TODO Auto-generated method stub
		boolean res=false;
		
		InputStream stream = source.getResourceAsStream(pathSubject);
		JSONObject json = new JSONObject(new JSONTokener(stream));
		
		try
		  {
			  schema.validate(json);
			  res=true;
			  
		  }catch(ValidationException e)
		  {
			  System.out.println(e);
		  }
		
		stream.close();
		return res;
	}

	/**
	 * @return the schema
	 */
	public Schema getSchema() {
		return schema;
	}

	/**
	 * @param schema the schema to set
	 */
	public void setSchema(Schema schema) {
		this.schema = schema;
	}
}
