import java.util.HashMap;

public class Memo{
   public static int counter=0;
   
   private static HashMap<Integer,Integer> cache=new HashMap<Integer,Integer>();

   public static int fib(int n){
      counter++;
      if(n<=2) return 1;
      else return fib(n-1)+fib(n-2);
   }
   
   public static int fibmemo(int n){
      if(!cache.containsKey(n)) cache.put(n,fibreal(n));
      return cache.get(n);
   }
    public static int fibreal(int n){
      counter++;
      if(n<=2) return 1;
      else return fibmemo(n-1)+fibmemo(n-2);
   }
   
  
   
   public static void main(String[] args){
      // for(int i=1; i<=10; i++) System.out.print(fib(i)+" ");
      // System.out.println();
      counter=0;
      System.out.println(fib(20)+" "+counter);
      counter=0;
      System.out.println(fibmemo(20)+" "+counter);
      counter=0;
      System.out.println(fibmemo(100)+" "+counter);
   


   }

}