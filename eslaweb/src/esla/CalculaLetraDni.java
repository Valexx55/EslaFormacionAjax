package esla;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculaLetraDni
 */
@WebServlet("/CalculaLetraDni")
public class CalculaLetraDni extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //http://localhost:8080/eslaweb/tortilla?dni=2515 
	//http://localhost:8080/eslaweb/letradni.html
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculaLetraDni() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    public static final String SECUENCIA_DNI="TRWAGMYFPDXBNJZSQVHLCKE";
    //http://localhost:8080/eslaweb/CalculaLetraDni?dni=247059
	protected void doGet
	(HttpServletRequest request, 
	HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String dni = request.getParameter("dni");
		int num_dni = Integer.parseInt(dni);
		int resto = num_dni%23;//resto estará 0-22
		char letra = SECUENCIA_DNI.charAt(resto);
		
		String mensaje_respuesta = "Tu letra es "+letra;
		response.setContentType("text/html");
		response.setStatus(200);
		PrintWriter pw = response.getWriter();
		pw.write(mensaje_respuesta);
		pw.write("<h1>Maestros del WEB</h1>");
		
		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
