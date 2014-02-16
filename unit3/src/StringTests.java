public class StringTests {
    public static void main(String[] args) {
    	//http://stackoverflow.com/questions/1552301/immutability-of-strings-in-java
        //http://javarevisited.blogspot.ru/2010/10/why-string-is-immutable-in-java.html
    	String gfriend="Masha";
        if (gfriend=="Masha"){ 
        	// true or false?
        	System.out.println("String gfriend='Masha', " +
        			" gfriend=='Masha'");
        } else {
        	System.out.println("String gfriend='Masha', " +
        			" gfriend!='Masha'");
        }
        String gfriend1 = new String ("Natasha");
        String gfriend2 = new String ("Natasha");
        if (gfriend1==gfriend2){
        	System.out.println("\nString gfriend1 = new String ('Natasha')" +
        			" String gfriend2 = new String ('Natasha')"
        			+ "\ngfriend1==gfriend2" );
        } else {
        	System.out.println("\nString gfriend1 = new String ('Natasha')" +
        			" String gfriend2 = new String ('Natasha')"
        			+ "\ngfriend1!=gfriend2 -- comparing different objects" );
        }
        
        if (gfriend1.equals(gfriend2)){
        	System.out.println("\nString gfriend1 = new String ('Natasha')" +
        			" String gfriend2 = new String ('Natasha')"
        			+ "\ngfriend1.equals(gfriend2) -- different objects contain the same text" );
        } else {
        	System.out.println("String gfriend1 = new String ('Natasha')" +
        			" String gfriend2 = new String ('Natasha')"
        			+ "\ngfriend1.equals(gfriend2) -- false" );
        }
       
    }
}