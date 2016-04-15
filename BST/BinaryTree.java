public class BinaryTree{
    // Uses Nodes, ignores thread field.

    Node root;

    BinaryTree(){
        root=new Node(Integer.MIN_VALUE); // -infinity
    }

    void insert(Node p, Node q){ 
        // always called with p non null
        // slightly more complicated because we want to 
        // adapt it to threaded trees
        if(q.data<p.data){
            if(p.left!=null) insert(p.left,q);
            else insertLeft(p,q);
        }else if(p.data<q.data){
            if(p.right!=null) insert(p.right,q);
            else insertRight(p,q);
        }
    }

    void insertRight(Node p, Node q){p.right=q;}

    void insertLeft(Node p, Node q){p.left=q;}

    void insert(int n){
        Node q=new Node(n);
        insert(root,q);
    }

    void inorder(Node p){
         if(p.left!=null){ //traverse left root, if it is null then we know that's it. 
            inorder(p.left);
         } 
         System.out.print(p.data+" "); //This is the root, only prints after all p.left has been exhausted.
         
         if(p.right!=null){ //same as traverse right root. 
            inorder(p.right);
         }
    }

    void inorder(){inorder(root);System.out.println();}

}