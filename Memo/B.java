import java.util.Arrays;

public class B{
   int number;
   String name;
   int[] a=new int[10];
   
   B(int i, String s, int first){
      number=i;
      name=s;
      a[0]=first;
   } 
  
   public boolean equals(Object obj){
      if(obj==null) return false;
      if(!(obj instanceof B)) return false;
      B y=(B) obj; // cast obj to class B
      if(!(number==y.number))return false;
      if(!(name.equals(y.name))) return false;
      // Good
      //for(int i=0; i<a.length; i++)
      //    if (a[i]!=y.a[i]) return false;
      //return true;
      // Bad
      boolean flag=true;
      for(int i=0; i<a.length; i++){
         if (a[i]!=y.a[i]) flag=false;
      }
      return flag;

   }
  
   public String toString(){
      StringBuffer sb=new StringBuffer();
      sb.append("[").append(number+",").append(name+",");
      sb.append(Arrays.toString(a)).append("]");
      return sb.toString();
   
   }
     public int hashCode(){
      return number+name.hashCode()+a[0];
   }

   public static void main(String[] args){
      B x=new B(123,"John",7);
      System.out.println(x);
      B y=new B(123,"Bill",7);
      System.out.println(y);
      System.out.println("x==y "+(x==y));
      System.out.println("x.equals(y) "+(x.equals(y)));
      B z=new B(123,"John",8);
      System.out.println("x.equals(z) "+(x.equals(z)));
      System.out.println(x.hashCode()+" "+y.hashCode()+" "+z.hashCode());      
   }
   
 }