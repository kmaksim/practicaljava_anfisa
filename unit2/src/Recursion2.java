
public class Recursion2 {

	public static void main(String[] args) {
		printTriangle(5);
		printTriangle1(4);
		System.out.println("----");
		printTriangleNonRecursivly(5);

	}
	
	public static void printTriangle(int sideLength)
	{
	  if (sideLength < 1) { return; }// if to take out this line there will be an exception	
	   printTriangle(sideLength - 1);
	   for (int i = 0; i < sideLength; i++)
	   {
	      System.out.print("[]");
	   }
	   System.out.println();
	}
	public static void printTriangle1(int sideLength)
	{
	   for (int i = 0; i < sideLength; i++)
	   {
	      System.out.print("[]");
	   }
	   if (sideLength < 1) { return; }
	   System.out.println();
		// if to take out this line there will be an exception	
		printTriangle1(sideLength - 1);
	}
	
	public static void printTriangleNonRecursivly(int sideLength)
	{
	  //if (sideLength < 1) { return; }// if to take out this line there will be an exception	
	  //printTriangle(sideLength - 1);
	   for (int i = 1; i < sideLength; i++) {
		   for (int j = 0; j < i; j++)
		   {
		      System.out.print("[]");
		   }
	   System.out.println();
	   }
	}

}

