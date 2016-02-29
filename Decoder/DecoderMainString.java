public class DecoderMainString{
    public static void main(String[] args){
	String inputstring="256 45 258 258 65 259 66 257"; 
	Decoder decoder=new Decoder(inputstring);
	//decoder.setDebug(true);
	decoder.decode();
    }
}