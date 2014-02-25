
public class Recursion3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(mystery(4));

	}
	
	public static int mystery(int n)
	{
	   if (n <= 0) { return 0; }
	   return n + mystery(n - 1);
	}

}
