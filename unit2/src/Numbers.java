
public class Numbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double rnd1 = Math.random();
		double rnd2 = Math.random();
		System.out.println( rnd1 + " "  + rnd2);
		System.out.println( (int)rnd1 + " "  + (int)rnd2 );
		System.out.println( Math.round(rnd1) + " "  + Math.round(rnd2) );
		System.out.println( (int)Math.round(rnd1) + " "  + (int)Math.round(rnd2) );
	
	/**
	 * prints 
	 * 0.16400087182878476 0.7681167005743772
	 * 0 0
	 * 0 1
	 * 0 1	
	 */
	}

}
