
public class Tax {

	double grossIncome;
    String state;
    int dependents;
    static int customerCounter;
    
    Tax (double gi,String st, int depen) {
    	grossIncome = gi;
        state = st;
        dependents = depen;
        customerCounter++;
        System.out.println("Preparing the tax data for customer #" + customerCounter);
    }
    
    double calcTax() {
    	return (grossIncome*0.33  - dependents*100);
    }

    void printConvertedTax(double calculatedTax, String currencyName) {
    	double tax = calculatedTax * ConversionRate.getExchangeRate(currencyName);
    	System.out.println("tax in " +  currencyName + " = " + tax ); 
    }
}
