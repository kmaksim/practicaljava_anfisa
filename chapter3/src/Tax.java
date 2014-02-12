
public class Tax {
    double grossIncome;
    String state;
    int dependents;
	
	public double calcTax() {
		if (grossIncome < 30000) {
			return grossIncome * 0.05;
		} else {
			return grossIncome * 0.06;
		}
	}
}
