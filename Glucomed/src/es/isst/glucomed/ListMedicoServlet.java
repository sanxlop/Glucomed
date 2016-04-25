package es.isst.glucomed;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.isst.glucomed.dao.UserDAO;
import es.isst.glucomed.dao.UserDAOImpl;
import es.isst.glucomed.model.User;




@SuppressWarnings("serial")
public class ListMedicoServlet extends HttpServlet {

	public ListMedicoServlet() {
		// TODO Auto-generated constructor stub
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		
		HttpSession session = req.getSession();
		String urlLogueado="ListMedicoView.jsp";
		String urlNoLogueado="LoginView.jsp";
		String url="";
		//String email = (String) session.getAttribute("email");
		//System.out.println(email);
		if(session.getAttribute("email") == null){
			//System.out.println("sin loguear");
			url = urlNoLogueado;
		}else{
			//System.out.println("logueado");
			url = urlLogueado;
		}
		
		//==================================================

		UserDAO dao = UserDAOImpl.getInstance();
			
		List<User> viewMedico = dao.viewMedico();
			
		session.setAttribute( "viewMedico" , new ArrayList<User>( viewMedico ));
	
		RequestDispatcher view = req.getRequestDispatcher(url);
		
		try {
			//Con el view, devolvemos una vez ejecutada la peticion, el contral al servlet que la envio.
			view.forward(req, resp);
		} catch (ServletException e) {
			
			e.printStackTrace();
				
		}

	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		UserDAO dao = UserDAOImpl.getInstance();
		HttpSession session = req.getSession();
	
		String medicoMail = req.getParameter("MedicoMail");
		String emailSession = (String) session.getAttribute("email");
		
		if(medicoMail.equals("")||!medicoMail.matches("[-\\w\\.]+@\\w+\\.\\w+")){
			session.setAttribute("error_code_registro", "Elige un m�dico de la lista");
			resp.sendRedirect("listMedico");
		}
	
		else{
			
			 dao.addMedico(medicoMail, emailSession);
			 resp.sendRedirect("/pruebaUser");
			/*	
			if (result) {
				session.setAttribute("error_code_registro", "");
				resp.sendRedirect("dashboard");
			} else {
				session.setAttribute("error_code_registro", "Error en la elecci�n de medico");
				resp.sendRedirect("listMedico");
				//resp.getWriter().println("Error Registro. El usuario " + nombre + " ya existe en la base de datos !!");
			}
		}
		
		*/
			 }
		}

}
