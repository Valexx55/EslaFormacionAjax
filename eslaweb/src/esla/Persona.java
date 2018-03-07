package esla;

public class Persona {
	
	private String name;
	private int age;
	
	@Override
	public boolean equals(Object obj) {
		boolean iguales = false;
		Persona paux = (Persona) obj;
		
			iguales = (paux.age==this.age)&&(paux.name.equals(this.name));
		
		return iguales;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Persona(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public Persona ()
	{
		
	}
	
}
