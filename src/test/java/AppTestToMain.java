import java.io.IOException;

import validator.Validator;

public class AppTestToMain {

		private static String pathSchema = "sampleModel.json";
		private static String RightPathSubject = "sampleRight.json";
		private static String WrongPathSubject = "sampleWrong.json";
		
		public static void displayValidate(Validator val, String path) throws IOException
		{
			if(val.validate(AppTestToMain.class, path))
				System.out.println("\tLe fichier "+path+" est valide");
			else
				System.out.println("\tLe fichier "+path+" n'est pas valide");
		}
		
		public static void main(String[] args) throws IOException
		{
			Validator val = new Validator(AppTestToMain.class, pathSchema);
						
			System.out.println("Test avec "+RightPathSubject+" : ");
			displayValidate(val, RightPathSubject);
			
			System.out.println("Test avec "+WrongPathSubject+" : ");
			displayValidate(val, WrongPathSubject);
		}
}