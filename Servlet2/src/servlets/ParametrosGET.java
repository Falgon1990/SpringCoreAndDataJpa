package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParametrosGET
 */
@WebServlet(name="ParametrosGET", urlPatterns="/ParametrosGET")
public class ParametrosGET extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recibimos par�metros y los asignamos a variables Java
		int id=Integer.parseInt(request.getParameter("id"));
		String nombre=request.getParameter("nombre");
		
		//Imprimimos los par�metros recibidos
		System.out.println("M�todo doGet que recibe par�metros: Id ("+ id +") y nombre ("+ nombre +")");
		
		//Aplicamos la l�gica de nuestro modelo de negocio
		//Si el id del usuario es mayor de 5, se devolver� una respuesta HTML"
        if (id==10) {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Login</title>");
                out.println("<style type=\"text/css\">\r\n"
                		+ "body{\r\n"
                		+ "background-color: red;\r\n"
                		+ "\r\n"
                		+ "}\r\n"
                		+ "</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h3>Identificador de usuario ("+id+" correcto)"+ nombre+" es correcto"+" </h3>");
                out.println("</body>");
                out.println("</html>");
            }
        } else {
        	//Respuesta de error indicando que no estamos autorizados
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("M�todo doPost");		
	}

}