import java.util.HashMap;

public class Node extends HashMap<Character,Node>{
   
   boolean wordend=false;
   
   public String toString(){
      StringBuffer sb=new StringBuffer();
      sb.append("[").append(keySet()).append(",").append(wordend);
      return sb.toString();
   }

}