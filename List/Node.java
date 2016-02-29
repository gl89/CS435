public class Node{
   int data;
   Node next;
   
   Node(int n){data=n;}
   
   public String toString(){return ""+data;}
   
   static void printList(Node p){
      System.out.print("[ ");
      while(p!=null){
         System.out.print(p+" ");
         p=p.next;
      }
      System.out.print("]");
   }
   
   static Node appendI(Node p, int n){// append n to p iteratively
      if(p==null) return new Node(n);
      Node oldp=p;
      while(p.next!=null) p=p.next;
      // Now p refers to last Node in list
      // Method 1
      //Node q=new Node(n);
      //p.next=q;
      //
      // Method 2
      p.next=new Node(n);   
      return oldp;
   } 
  
   static Node appendR(Node p, int n){// append n to p recursively
      if(p==null) return new Node(n);
      p.next=appendR(p.next,n);
      return p; 
   }
   
   static void reverse(Node p){
      if(p!=null){
         reverse(p.next);
         System.out.print(p.data+" "); 
      }
   }
   public static void main(String[] args){
      //Node n=new Node(42);
      //printList(n);
      {
         Node p=new Node(42);
         p=appendI(p,13);
         p=appendI(p,7);
         printList(p);
         System.out.println();
      }
      {
         Node p=null;
         p=appendI(p,42);
         p=appendI(p,13);
         p=appendI(p,7);
         printList(p);
         System.out.println();

     }
     {
         Node p=null;
         p=appendR(p,42);
         p=appendR(p,13);
         p=appendR(p,7);
         printList(p);
         System.out.println();
         reverse(p);
         System.out.println();

      }
   }

}