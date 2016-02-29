public class PrefixTree{
   private Node head=new Node();
   
   
   // instance method
   public void addword(String s){
      addword(head,s);
   }
   // parallel static method
   private static void addword(Node p, String s){
      System.out.println("addword("+s+")");
      if(s.length()==0){
         // mark current node as a word
         p.wordend=true;
         return;
      }
      char c=s.charAt(0);
      if(!p.containsKey(c)) p.put(c,new Node());
      addword(p.get(c),s.substring(1));
   }
   
   void traverse(){traverse(head,"");}
   private static void traverse(Node p, String prefix){
      if(p.wordend) System.out.println(prefix);
      for(char c: p.keySet()){
         traverse(p.get(c),prefix+c);
      }
   
   
   }
