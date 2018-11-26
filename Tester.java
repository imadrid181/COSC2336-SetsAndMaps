public class Tester{
 public static void main(String [] args){
  final int L = 5;
  int x = 23;
  double y = 7;
  double z = x * (y + L);
  try{
   if( z%2 == 0)
      System.out.println("CS");
   else
      System.out.println("SC");
  }
  catch(ArithmeticException e){
   e.printStackTrace();
  }
 }
}