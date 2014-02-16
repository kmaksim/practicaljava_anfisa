//http://stackoverflow.com/questions/2315705/what-is-the-difference-between-i-i-in-for-loop-java
public class Increment
{
    public static void main(String [] args)
    {
    	
        for (int i = 0; i < 5; ++i)
        {
            System.out.println(i);
        }
    }
}

/*

//Compiled from Increment.java (version 1.7 : 51.0, super bit)
public class Increment {

// Method descriptor #6 ()V
// Stack: 1, Locals: 1
public Increment();
 0  aload_0 [this]
 1  invokespecial java.lang.Object() [8]
 4  return
   Line numbers:
     [pc: 0, line: 2]
   Local variable table:
     [pc: 0, pc: 5] local: this index: 0 type: Increment

// Method descriptor #15 ([Ljava/lang/String;)V
// Stack: 2, Locals: 2
public static void main(java.lang.String[] args);
  0  iconst_0
  1  istore_1 [i]
  2  goto 15
  5  getstatic java.lang.System.out : java.io.PrintStream [16]
  8  iload_1 [i]
  9  invokevirtual java.io.PrintStream.println(int) : void [22]
 12  iinc 1 1 [i]
 15  iload_1 [i]
 16  iconst_5
 17  if_icmplt 5
 20  return
   Line numbers:
     [pc: 0, line: 7]
     [pc: 5, line: 9]
     [pc: 12, line: 7]
     [pc: 20, line: 11]
   Local variable table:
     [pc: 0, pc: 21] local: args index: 0 type: java.lang.String[]
     [pc: 2, pc: 20] local: i index: 1 type: int
   Stack map table: number of frames 2
     [pc: 5, append: {int}]
     [pc: 15, same]
}

*/