package quoteGeneratorOnlineSlowInternet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QuoteGenerator
 * Generates online form to get quotes from YAHOO
 * and gets quotes from get request
 */

@WebServlet(urlPatterns = { "/quote" }, initParams = { @WebInitParam(name = "symbol", value = "AAPL") })
public class QuoteGenerator extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public QuoteGenerator() {
    super();
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // Get or create the session
    request.getSession(true);

    String symbol = request.getParameter("symbol");
    
    if (symbol == null ) {symbol = "NULL";} //protection against first run with empty symbol string
    
    if (symbol.length() == 0 ) {symbol = "NULL";} //protection against test with empty symbol text field submitted
    
    ExecutorService executor = Executors.newSingleThreadExecutor();
    Future<String> future = executor.submit(new Util(symbol));

    String symbolPrice = "-1";
    try {
      System.out.println("Thread started..");
      
      symbolPrice = future.get(5, TimeUnit.SECONDS); // wait for at least 5 seconds for results to return
      
      System.out.println("Thread finished!");
    } catch (TimeoutException e) {
      System.out.println("Terminated!");
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }

    executor.shutdownNow();

    //print response html form
    PrintWriter out = response.getWriter();
    response.setContentType("text/html");
    out.println("<html><body bgcolor=\"#CCCCCC\">");
    if (Float.parseFloat(symbolPrice) > 0) {
      out.println("<h2>The " + symbol + " share costs " + symbolPrice + "</h2>");
      // out.println("<p>How many shares would you like to buy?");
    } else {
      out.println("<h2>I was unable to perform a request. Please enter the name again or try later on. </h2>");
    }

    out.println("<p>Enter quote name in the following form");
    out.println("<br> ( For example, \"EPAM\", \"LXFT\", \"AAPL\" or \"IBM\" )");
    out.println(" <form action=http://localhost:8080/unit14_anfisa2/quote method=Get>");
    out.println("  <input type=Text name=symbol> <input type=Submit");
    out.println("     value=\"Search for quote\">");
    out.println(" </form>");

    out.println("</body></html>");

    // Destroy the session
    request.getSession(true).invalidate();
  }


}