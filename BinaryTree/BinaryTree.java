public class BinaryTree{
   Node root;
   
   void insert(int key){root=insert(root,key);}
   static Node insert(Node p, int key){
      // insert into the binary tree with root p,
      // and returns a reference to the new tree.
      if(p==null) p=new Node(key);
      else{
         if(key<p.data) p.left=insert(p.left,key);
         else if(key>p.data) p.right=insert(p.right,key);
      }
      return p;
   }
   
   
   
   boolean search(int key){return search(root,key);}
   
   static boolean search(Node p, int key){
      if(p==null) return false;
      if(p.data==key) return true;
      else if(key<p.data) return search(p.left,key);
      else if(p.data<key) return search(p.right,key);
      return false; // statement never reached
   }
   
   void traverse(){traverse(root);}
   
   static void traverse(Node p){
      // inorder traversal
      
      // left subtree
      if(p.left!=null) traverse(p.left);
      // root
      System.out.print(p.data+" ");
      // right subtree
      if(p.right!=null) traverse(p.right);
   }
   
   
   
   public static void main(String[] args){
      // Node n=new Node(42);
      // System.out.println(n+" "+n.left+" "+n.right);
      BinaryTree b=new BinaryTree();
      int[] input={5,2,6,4,7,8};
      for(int v: input) b.insert(v);
      b.traverse(); System.out.println();
      int[] searchdata={5,2,6,-1,3,10};
      for(int k: searchdata) System.out.print(b.search(k)+" ");
      System.out.println();

   }
}