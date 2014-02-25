
public class Recursion1 {

	public static void main(String[] args) {
		printTriangle(5);


	}
	
	public static void printTriangle(int sideLength)
	{
	  //if (sideLength < 1) { return; }// if to take out this line there will be an exception	
	  //printTriangle(sideLength - 1);
	   for (int i = 0; i < sideLength; i++) {
		   for (int j = 0; j < i; j++)
		   {
		      System.out.print("[]");
		   }
	   System.out.println();
	   }
	}
	

}

