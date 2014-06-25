package com.practicaljava.lesson34;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StockService {
	
	public static String[] stockNames = {"EPAM", "LXFT", "AAPL", "IBM", "GOOG", "A"};
	
    public static void addStock(Stock stock) {
        stocks.put(stock.getSymbol(), stock);
    }
    
    public static String getPredefinedStockNames() {
    	
    	StringBuilder builder = new StringBuilder();
    	for(String s : stockNames) {
    	    builder.append(s + " ");
    	}
    	return builder.toString();
    	
    }

    public static void removeStock(String symbol) {
        stocks.remove(symbol);
    }

    public static Stock getStock(String symbol) {
        return stocks.get(symbol);
    }

    private static Map<String, Stock> stocks = new HashMap<String, Stock>();

    static {
        generateStocks();
    }

    private static void generateStocks() {
    	
    	
    	//ArrayList<String> stockNamesList = (ArrayList<String>) Arrays.asList(stockNames);
    	for (String s: stockNames ) {
    		addStock(new Stock(s, GetQuoteFromYahoo.getYahooQuote(s), "USD", "US"));
    	}    	
              
    }
}
