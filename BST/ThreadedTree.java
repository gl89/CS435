import java.util.Random;

public class ThreadedTree extends BinaryTree{

    Node root;

    ThreadedTree(){
        root=new Node(Integer.MIN_VALUE); // -infinity
        root.thread=true;
        root.right=root;
    }

    void insert(Node p, Node q){ 
        // always called with p non null
        // note difference with regular binary 
        // with recursion on right subtree
        if(q.data<p.data){ //left
            if(p.left!=null) insert(p.left,q);
            else insertLeft(p,q);
        }else if(p.data<q.data){ //right 
            //*********** note difference with BinaryTree
            if(!p.thread) insert(p.right,q);
            else insertRight(p,q);
        }
    }
    //essentially same idea as !null.
    //make sure next thread is true and previous false.
    void insertRight(Node p, Node q){
        q.right=p.right;
        p.right=q;
        p.thread=false;
        q.thread=true;
        
     
    }

    void insertLeft(Node p, Node q){
        p.left=q;
        q.thread=true;
        q.right=p;
     
    }
    
    void insert(int n){
        Node q=new Node(n);
        insert(root,q);
    }
   
    //I don't under this for whatever reason
    Node succ(Node p){
        // Find inorder successor of p
        Node q=p.right;
        if(p.thread) return q;
        while(q.left!=null) q=q.left;
        return q;
    }
    
    /*
    We start at the leftmost node in the tree, print it, and follow its right thread  
   If we follow a thread to the right, we output the node and continue to its right 
   If we follow a link to the right, we go to the leftmost node, print it, and continue 
    */
    Node leftmost(Node n) { //could do this within the inorder function while(p.left!=null){p=p.left}; same thing
    Node ans = n;
    if (ans == null) {
         return null;
    }
    while (ans.left != null) {
        ans = ans.left;
    }
    return ans;
    }

    void inorder(){ //this is infinite right
    Node cur = root; 
    cur = leftmost(root);
    
      while (cur != null){
         System.out.print(cur.data+" ");
            if(cur.thread){
               cur = cur.right;
               if(cur==root){//Avoid infinite loops
               break;
               }
            }else{
            cur = leftmost(cur.right);
            }
         }
    }
    /*
    void inorder(){ //no threads
        Node curr=root, pre;
        while (curr != null) {
            if (curr.left == null) {
                System.out.print(curr.data + " ");
                curr = curr.right;
            } else {
                // Find the inorder predecessor of current 
                // Have to figure how to use the given succ method 
                pre = curr.left;
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }
                // Make current as right child of its inorder predecessor 
                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                } 
                 // Revert the changes made in if part to restore the original 
                 //tree i.e., fix the right child of predecssor 
                 else {
                    pre.right = null;
                    System.out.print(curr.data + " ");
                    curr = curr.right;
                }   // End of if condition pre->right == NULL 
            } // End of if condition current->left == NULL       
        } // End of while       
    } 
     */
    //Could always use regular binart tree inorder to check tree is correct      
}
   
       