/*
Gabriel Loterena
2/18/16
CS435
Project 2: Intern 
*/

import java.util.HashMap;

public class ID{
    // object pool: class (not instance) variable
    private static HashMap<ID,ID> pool=new HashMap<ID,ID>();

    // fields for instance variables
    private String name;
    private int number;

    // constructor
    ID(String s, int n){name=s; number=n;}

    // string version
    public String toString(){
        StringBuffer sb=new StringBuffer();
        sb.append("[").append(name).append(",").append(number).append("]");
        return sb.toString();
    }

    // equals: is this equal to obj?
    public boolean equals(Object obj){ 
      if(obj==null) return false;
      if(!(obj instanceof ID)) return false; 
      ID y=(ID)obj; 
      if(!(hashCode()==y.hashCode())) return false; 
      return true; 
    }

    // hashCode: must be compatible with equals
    public int hashCode(){
      int ShC=name.hashCode(); //String hashCode()function
      return number + ShC;
    }

    // intern: returns reference to pool
    public ID intern(){ 
      ID rp=null; //The pointer points to the objec in the pool;
      ID ip=new ID(name,number);
      if(!pool.containsKey(ip)) //adds if it isn't already there. 
         pool.put(ip,ip);
      rp= pool.get(ip);//The pool pointer is now set to the object inside the pool
      return rp; 
    } 
   
    public static void main(String[] args){
        // create two equal but not identical objects
        ID id1=new ID("John",123);
        ID id2=new ID("John",123);
        ID id3=new ID("Johnathan",123);
        ID id4=new ID("Johnathan",123);
        ID id5=new ID("Johanna",1189);
        System.out.println(id1+" "+id2);
        System.out.println(id1.equals(id2)); // expect true
        System.out.println(id1==id2);        // expect false
        // intern the objects: they should now be identical
        id1=id1.intern();
        id2=id2.intern();
        id3=id3.intern();
        id4=id4.intern();
        id5=id5.intern();
        System.out.println(id1+" "+id2);
        System.out.println(id1.equals(id2)); // expect true
        System.out.println(id1==id2);        // expect true
        
        System.out.println(id1==id3);        // expect false Just checking things
        System.out.println(id2==id3);        // expect false
        System.out.println(id4==id3);        // expect true
       
        System.out.println(id1);        
        System.out.println(id2);       
        System.out.println(id3);       
        System.out.println(id4);        
        
        System.out.println(pool.values()); //Should have three things in it. *Sorted by int=key
      
    }
}