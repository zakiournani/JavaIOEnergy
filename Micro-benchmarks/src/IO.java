import java.io.IOException;
import java.util.Random;

public class IO {
int writedLines=SIZES;
int lineLength=LINES;
	public int consume(String in) {
		int temp=0;
		for(int i=0; i<in.length();i++) {
			temp=temp+in.charAt(i)%167;
		}
		return temp;
	}
	public int consume(byte[] in,int length) {

		return (in[0]%167)+length%167;
	}
	public String generateString() {
	    int leftLimit = 48; // letter '0'
	    int rightLimit = 122; // letter 'z'
	   
	    Random random = new Random();

	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .limit(lineLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();

	    return generatedString+ "\n";
	}
	public void write(String file) throws IOException{};
	public int read(String file) throws IOException{return 0;}
	public int readAll(String file) throws IOException{return 0;}
	public int readBinary(String file) throws IOException{return 0;}
	public void write(String file, int buffer) throws IOException{};
	public int read(String file,int buffer) throws IOException{return 0;}
	public void writeU(String file) throws IOException{};
	public int readU(String file) throws IOException{return 0;}
	public int seek(String string)  throws IOException{return 0;}
}
