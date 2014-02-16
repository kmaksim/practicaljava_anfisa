
public class IncrementTests {

	public static void main(String[] args) {
		int i = 5;
		//seems like no difference in ++i and i++ in cycles:
		////http://stackoverflow.com/questions/2315705/what-is-the-difference-between-i-i-in-for-loop-java
		//http://answers.yahoo.com/question/index?qid=20080723002132AAXxLY6
		System.out.println("Example with ++i");
		for (i=0;i<5;++i) {
			System.out.println("i=" + i);
		}
		System.out.println("Example with i++");
		for (i=0;i<5;++i) {
			System.out.println("i=" + i);
		}
		//but!:
		i=0;
		i=i++;
		System.out.println("i++=" + i);
		i=0;
		i=++i; //compiler warns that the assignment to i has no effect!
		System.out.println("++i=" + i);
		//but!:
		i=0;
		System.out.println("i++=" + i++);
		i=0;
		System.out.println("++i=" + ++i);
	}
}

/*

//Compiled from Tests.java (version 1.7 : 51.0, super bit)
public class Tests {

// Method descriptor #6 ()V
// Stack: 1, Locals: 1
public Tests();
 0  aload_0 [this]
 1  invokespecial java.lang.Object() [8]
 4  return
   Line numbers:
     [pc: 0, line: 2]
   Local variable table:
     [pc: 0, pc: 5] local: this index: 0 type: Tests

// Method descriptor #15 ([Ljava/lang/String;)V
// Stack: 4, Locals: 2
public static void main(java.lang.String[] args);
  0  iconst_5
  1  istore_1 [i]
  2  getstatic java.lang.System.out : java.io.PrintStream [16]
  5  ldc <String "Example with ++i"> [22]
  7  invokevirtual java.io.PrintStream.println(java.lang.String) : void [24]
 10  iconst_0
 11  istore_1 [i]
 12  goto 40
 15  getstatic java.lang.System.out : java.io.PrintStream [16]
 18  new java.lang.StringBuilder [30]
 21  dup
 22  ldc <String "i="> [32]
 24  invokespecial java.lang.StringBuilder(java.lang.String) [34]
 27  iload_1 [i]
 28  invokevirtual java.lang.StringBuilder.append(int) : java.lang.StringBuilder [36]
 31  invokevirtual java.lang.StringBuilder.toString() : java.lang.String [40]
 34  invokevirtual java.io.PrintStream.println(java.lang.String) : void [24]
 37  iinc 1 1 [i]
 40  iload_1 [i]
 41  iconst_5
 42  if_icmplt 15
 45  getstatic java.lang.System.out : java.io.PrintStream [16]
 48  ldc <String "Example with i++"> [44]
 50  invokevirtual java.io.PrintStream.println(java.lang.String) : void [24]
 53  iconst_0
 54  istore_1 [i]
 55  goto 83
 58  getstatic java.lang.System.out : java.io.PrintStream [16]
 61  new java.lang.StringBuilder [30]
 64  dup
 65  ldc <String "i="> [32]
 67  invokespecial java.lang.StringBuilder(java.lang.String) [34]
 70  iload_1 [i]
 71  invokevirtual java.lang.StringBuilder.append(int) : java.lang.StringBuilder [36]
 74  invokevirtual java.lang.StringBuilder.toString() : java.lang.String [40]
 77  invokevirtual java.io.PrintStream.println(java.lang.String) : void [24]
 80  iinc 1 1 [i]
 83  iload_1 [i]
 84  iconst_5
 85  if_icmplt 58
 88  return
   Line numbers:
     [pc: 0, line: 5]
     [pc: 2, line: 6]
     [pc: 10, line: 7]
     [pc: 15, line: 8]
     [pc: 37, line: 7]
     [pc: 45, line: 10]
     [pc: 53, line: 11]
     [pc: 58, line: 12]
     [pc: 80, line: 11]
     [pc: 88, line: 14]
   Local variable table:
     [pc: 0, pc: 89] local: args index: 0 type: java.lang.String[]
     [pc: 2, pc: 89] local: i index: 1 type: int
   Stack map table: number of frames 4
     [pc: 15, append: {int}]
     [pc: 40, same]
     [pc: 58, same]
     [pc: 83, same]
}

*/