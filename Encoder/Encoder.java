import java.util.Scanner;
import java.io.InputStream;

public class Encoder{
    static final int CLEAR_TABLE=256;
    static final int END_OF_DATA=257;
    Table table;
    Sequence s;
    Scanner scanner;
    boolean debug=false;
    public void setDebug(boolean b){debug=b;}
    Encoder(InputStream is){
	scanner=new Scanner(is);
    }
    void add(Sequence s){
	table.add(s);
	if(debug)System.out.println("add  "+s+"->"+code(s));
    }
    void emit(int n){
	if(debug)System.out.println("emit "+table.get(n)+"->"+n);
	else System.out.print(n+" ");
    }
    public int code(Sequence s){return table.indexOf(s);}
    
    public void encode(int n){
	    if(debug) System.out.println("encode "+n);
	      s.push(n);
	    if(!table.contains(s)){
	      Sequence t=s.copy();
	      add(t);
	      s.pop();
	      emit(code(s));
	      Sequence s=new Sequence(n);
	    }
    }
    
    public void encode(){
	table=new Table();
	s=new Sequence();
	emit(CLEAR_TABLE);
	while(scanner.hasNextInt()){
	    int n=scanner.nextInt();
	    encode(n);
	}
	if (!s.empty()) emit(code(s));
	emit(END_OF_DATA);
	if(!debug) System.out.println();
   }
}