package quoteGeneratorOnlineSlowInternet;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class QuoteListener
 *
 */
@WebListener
public class QuoteListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public QuoteListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0) {
      HttpSession  session = arg0.getSession();
      System.out.println("Quote session is created; id:"+ session.getId());
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0) {
      HttpSession    session = arg0.getSession();
      System.out.println("Quote session is destroyed; id:"+ session.getId());
    }
	
}
