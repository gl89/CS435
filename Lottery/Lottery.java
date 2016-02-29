import java.util.Random;

public class Lottery{
   // pick 6 distinct integers in range 0-49 and print them in order
   static Random random=new Random(0);
   int[] ticket=new int[50];
   
   int count(){
      int s=0;
      for(int i=0; i<50; i++) s+=ticket[i];
      return s;
   }
   void pick1(){ // pick 1 number
      int n=random.nextInt(50);// pick number in range 0-49
      ticket[n]=1;
   }
   void pick6() { // pick exactly 6 distinct numbers
      while(count()<6) pick1();
   }
   
   public String toString(){
      StringBuffer sb=new StringBuffer();
      for(int i=0; i<50; i++)
         if(ticket[i]==1) sb.append(i).append(" ");
      return sb.toString();
   
   }
   public static void main(String[] args){
      Lottery lottery=new Lottery();
      lottery.pick6();
      System.out.println(lottery);
   
   }
   


}