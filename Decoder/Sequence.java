import java.util.Stack;

public class Sequence extends Stack<Integer>{
    Sequence(){super();}
    Sequence(int n){push(n);}
    public Sequence copy(){
	 Sequence t=new Sequence(); 
	 t.addAll(this);
	 return t;
    }
}