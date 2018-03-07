package esla;

import com.google.gson.Gson;

public class MainPersona {
	
	public static void main(String[] args) {
		
		Persona p = new Persona("Lidia", 16);
		
		Gson gson = new Gson();
		
		String json_persona = gson.toJson(p);
		
		System.out.println(json_persona);
		
	}

}
