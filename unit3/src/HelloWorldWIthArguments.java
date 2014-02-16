import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class HelloWorldWIthArguments {
	public static void main(String[] args) throws FileNotFoundException {
		if (args.length>0 && args[0].charAt(0) == '-' ) {
			String fileName=args[1];
			Scanner in = new Scanner(new File(fileName));
			System.out.print("Hello World and ");
			while (in.hasNextLine())
	        {
	            // Read an entire line, which contains all the details for 1 account
	            String line = in.nextLine();
	            System.out.print(line);
	            System.out.print("\n");
	            
	        }
			in.close();
		} else {
			usage();
		}
		
	}
	
	public static void usage() {
		System.out.print("Usage: HelloWorldWithArguments -f <filename>");
	}
}

