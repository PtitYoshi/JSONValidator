package manager;

import java.util.ArrayList;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.json.JSONObject;

import json.JSONSchema;
import json.JSONSubject;

public final class JSONManager
{
	private static boolean isInstanciate = false;
	private static Schema schema;
	private static ArrayList<JSONObject> objects;
	
	private JSONManager(){
		schema =null;
		objects = new ArrayList<JSONObject>();
	}
	public static JSONManager instanciate()
	{
		if(!isInstanciate)
		{
			isInstanciate = true;
			return new JSONManager();
		}
		else
		{
			System.err.println("Already JSONManager instanciated class");
			return null;
		}
	}
	
	private void setSchema(String path) {
		schema = new JSONSchema(path).getSchema();
	}
	public void loadSchema(String path) {
		setSchema(path);
	}
	public boolean addSubject(String path) {
		boolean res = false;
		JSONSubject subject = new JSONSubject(path);
		try 
		{
			schema.validate(subject.getObject());
			objects.add(subject.getObject());
			res=true;
		}
		catch(ValidationException e)
		{
			System.out.println(e);
		}
		return res;
	}
	
	public void displayObject() {
		for(JSONObject json : objects){
			System.out.println("\n"+json.toString());
		}
	}
}
