import java.util.ArrayList;

public class Table extends ArrayList<Sequence>{
    Table(){
	for(int i=0; i<258; i++) add(new Sequence(i));
    }
}