public class Figure {
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
}