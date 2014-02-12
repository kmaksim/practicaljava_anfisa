
public class NJTax extends Tax {
	
	public double calcTax() {
		if (grossIncome < 50000) {
			return grossIncome * 0.05 - 500;
		} else {
			return grossIncome * 0.06 - 500;
		}
	}
}
