// Hash table implementation of set of integers.

public class Hash{
    private int M;
    private int[] table;
    
    Hash(int m){M=m; table=new int[M];}
   
    //function to find index
    private int h(int k){return k % M;}

    private int next(int i){return (i+1)%M;}

    private int index(int k){
	int i=h(k);
	while((table[i]!=k)&&(table[i]!=0)) i=next(i);
	return i;
    }

    public void insert(int k){table[index(k)]=k;}

    public boolean contains(int k){return table[index(k)]==k;}


    public String toString(){return java.util.Arrays.toString(table);}


    public static void main(String[] args){
	Hash hash=new Hash(11);
	int[] values={1,3,0,2,6,9,12,16};
	for(int v: values) hash.insert(v);
	System.out.println(hash);
	
    }

}