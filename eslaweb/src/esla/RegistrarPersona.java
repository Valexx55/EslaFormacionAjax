package esla;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

/**
 * Servlet implementation class RegistrarPersona
 */
@WebServlet("/RegistrarPersona")
public class RegistrarPersona extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HttpSession sesion = null;
       
	private List<Persona> lpersonas = null;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		Persona p = new Persona("israel", 35);
		Persona p1 = new Persona("marta", 35);
		Persona p2 = new Persona("manuel", 35);
		Persona p3 = new Persona("victor", 53);
		Persona p4 = new Persona("vale", 34);
		Persona p5 = new Persona("loli", 30);
		Persona p6 = new Persona("samir", 31);
		
		lpersonas = new LinkedList<Persona>();
		lpersonas.add(p);
		lpersonas.add(p1);
		lpersonas.add(p2);
		lpersonas.add(p3);
		lpersonas.add(p4);
		lpersonas.add(p5);
		lpersonas.add(p6);
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarPersona() {
        super();
        // TODO Auto-generated constructor stub
    }

    private boolean personaAcreditada (Persona p)
    {
    	boolean acreditada = false;
    	
    		Iterator<Persona> it = lpersonas.iterator();
    		while ((!acreditada)&&(it.hasNext()))
    		{
    			acreditada = it.next().equals(p);
    		}
    	
    	return acreditada;
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Web Tonta").append(request.getContextPath());
		HttpSession sesion = request.getSession(false);
		if (sesion==null)
		{
			System.out.println("No tenía sesión. Le creo");
			sesion = request.getSession(true);
		} else 
		{
			System.out.println("Sí tenía sesión");
		}
		System.out.println("ID sesion = " + sesion.getId());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost
	(HttpServletRequest request, 
	HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String persona_json = request.getReader().readLine();
		System.out.println("Persona recibida = " + persona_json);
		
		Gson gson = new Gson ();
		
		Persona p = gson.fromJson(persona_json, Persona.class);
		
		//creo sesión
		
		
		
		
		
		
		if (personaAcreditada(p))
		{
			String nombre_reves = new StringBuffer(p.getName()).reverse().toString();
			int doble_edad = p.getAge()*2;
			
			Persona p_nueva = new Persona(nombre_reves, doble_edad);
			String json_nueva_persona = gson.toJson(p_nueva);
			
			response.getWriter().write(json_nueva_persona);
			response.setContentType("application/json");
			response.setStatus(200);
		} else {
			response.setStatus(403);
		}
		
	}

}
