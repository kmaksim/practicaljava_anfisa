
final class ConversionRate {

	public static double DollarEuro = 1.25;
	public static double DollarRuble = 50;
	
	public static double getExchangeRate(String currencyName) {
		switch (currencyName) {
		case "euro":
			return DollarEuro;
		case "ruble":
			return DollarRuble;
		}
		return 1;
	}
}
 