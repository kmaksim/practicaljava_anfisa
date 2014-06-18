package ejb;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;

@Stateless
@Startup
// @Singleton
public class StockServerBean {
	private String price = null;
	private ArrayList<String> nasdaqSymbols = new ArrayList<String>();

	@EJB
	private MessageSenderBean messageSenderBean;

	public StockServerBean() {

		// Define some hard-coded NASDAQ symbols
		nasdaqSymbols.add("AAPL");
		nasdaqSymbols.add("MSFT");
		nasdaqSymbols.add("YHOO");
		nasdaqSymbols.add("AMZN");
		nasdaqSymbols.add("MOT");
	}

	@Schedule(second = "*/5", minute = "*", hour = "*")
	public void sendQuote() {
		for (String nasdaqSymbol : nasdaqSymbols) {
			price = getQuote(nasdaqSymbol);
			//System.out.println("sending message");
			messageSenderBean.sendMessage("The price of " + nasdaqSymbol
					+ " is " + price);
		}
	}

	public String getQuote(String symbol) {

		if (nasdaqSymbols.indexOf(symbol.toUpperCase()) != -1) {

			// Generate a random price for valid symbols
			price = (new Double(Math.random() * 100)).toString();
		}
		// System.out.println("The price of "+ symbol + " is " + price);
		return price;
	}
}