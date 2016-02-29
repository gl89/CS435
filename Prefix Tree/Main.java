import java.util.Scanner;
import java.io.File;

public class Main{

   public static void main(String[] args){
      //Node n=new Node();
      //System.out.println(n);
      try{
         PrefixTree tree=new PrefixTree();
         Scanner scanner=new Scanner(new File("input.txt"));
         while(scanner.hasNext()){
            String word=scanner.next();
            tree.addword(word);
         }
         tree.traverse();
      }catch(Exception e){
         e.printStackTrace();
      }   
   }
}