
import java.util.Map;
public class TestTax {
	public static void main(String[] args) {

		Map<String, String> env = System.getenv();
		String JAVA_MAIN_CLASS = null;
        for (String envName : env.keySet()) {
        	if (envName.contains("JAVA_MAIN_CLASS")) {
        		JAVA_MAIN_CLASS = envName;
        		break;
        	}
        }
		
		if (args.length != 3){
		      System.out.println("Sample usage of the program: java "   	                              
		                               + System.getenv(JAVA_MAIN_CLASS)
		                              + " 50000 NJ 2");	      
		      System.exit(0);
		}		
		
		double grossIncome = Double.parseDouble(args[0]);
		String state = args[1];
		int dependents = Integer.parseInt(args[2]);
		
		Tax t = new Tax(grossIncome,state, dependents);
		double yourTax =  t.calcTax();
		
		System.out.println("Your tax is " + yourTax);
		t.printConvertedTax(yourTax, "euro");
		t.printConvertedTax(yourTax , "ruble");
		
		Tax t2 = new Tax(65000, "TX", 4);
		double hisTax = t2.calcTax();
		
		System.out.println("His tax is " + hisTax);
		t2.printConvertedTax(hisTax , "euro");
		t2.printConvertedTax(hisTax , "ruble");
		
	}
}
