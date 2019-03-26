package json;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.json.JSONObject;
import org.json.JSONTokener;

public class JSONSubject
{
	private JSONObject object;
	
	public JSONSubject(String path){
		
		setObject(path);
	}

	/**
	 * @return the object
	 */
	public JSONObject getObject() {
		return object;
	}

	/**
	 * @param object the object to set
	 */
	public void setObject(JSONObject object) {
		this.object = object;
	}
	
	public void setObject(String path) {
		try(InputStream stream = new FileInputStream(path)){
			object = new JSONObject(new JSONTokener(stream));
		} catch (IOException e) {
			e.printStackTrace();
			
			System.err.println("File not found ! Try to give the absolute path.");
			return;
		}
	}

	public boolean isEmpty() {
		return object==null;
	}
	
	
}
