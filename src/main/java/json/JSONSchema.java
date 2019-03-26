package json;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;

public class JSONSchema {
	private Schema schema;
	
	public JSONSchema(String path)
	{
		setSchema(path);
	}

	/**
	 * Return the JSON Schema.
	 * WARNING : Display JSONSchema Produces a JSONException if you use dependencies.
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
	
	public void setSchema(String path) {
		SchemaLoader loader = SchemaLoader.builder()
                .schemaJson(new JSONSubject(path).getObject())
                .draftV7Support()
                .build();
		
		schema = loader.load().build();
	}

	public boolean isEmpty() {
		return schema==null;
	}
}
