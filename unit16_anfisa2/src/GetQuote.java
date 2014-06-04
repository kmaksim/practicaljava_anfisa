

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "The servlet that Receives a message to a queue", urlPatterns = { "/getQuote" }, 
name="GetQuote")
public class GetQuote extends HttpServlet {
	private static final long serialVersionUID = 2L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get or create the session
		request.getSession(true);
		
		PrintWriter out = response.getWriter();
		out.println("<html><body bgcolor=\"#cff\">");
		out.println("<h2>Receiving quote... (see reults in traces)</h2>");
		
		try {
      MessageReceiver myReceiver=new MessageReceiver();
      
    } catch (NamingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
		
		//Destroy the session
		request.getSession(true).invalidate();
	}
	
}

