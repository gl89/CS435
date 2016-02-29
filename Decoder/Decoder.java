// Modified version:
// Has constructors taking InputStream, String or File as argument.

import java.util.Scanner;
import java.io.InputStream;
import java.io.File;

public class Decoder{
    static final int CLEAR_TABLE=256;
    static final int END_OF_DATA=257;
    Table table;
    Sequence s;
    Scanner scanner;
    boolean debug=false;

    public void setDebug(boolean b){debug=b;}

    // Constructors
    Decoder(InputStream is){scanner=new Scanner(is);}
    Decoder(String s){scanner=new Scanner(s);}
    Decoder(File f){
	try{
	    scanner=new Scanner(f);
	}catch(Exception e){
	    e.printStackTrace();
	}
    }


   public void decode(int n){
	   if(n==256||n==257){
      }
      else{
      Sequence t=table.get(n);
      int m=t.pop();
      t.push(m);
      s.push(m);
      table.add(s);
      s=new Sequence();
      s=table.get(n);
      } 
      if(n==256||n==257){
         }  
      else{
        System.out.println(table);
        //System.out.print(table.get(n)+" ");
        }    
    }
     
   
   public void decode(){
	table=new Table();
	s=new Sequence();
	while(scanner.hasNextInt()){
	    int n=scanner.nextInt();
	    decode(n);
	}
	if(!debug) System.out.println();
    }
}
   
   /*
  public void decode(int n){
	   if(n==256||n==257){
      }
      else{
      Sequence t=table.get(n);
      int m=t.pop();
      t.push(m);
      s.push(m);
      table.add(s);
      s=new Sequence();
      s=table.get(n);
      } 
      if(n==256||n==257){
         }  
      else{
        //System.out.println(table);
        System.out.print(table.get(n)+" ");
        }   
    }
    */