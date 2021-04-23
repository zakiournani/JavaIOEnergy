import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RAF extends IO{
	
	public int read(String fil) throws IOException {
	
	RandomAccessFile file = new RandomAccessFile(fil, "r");

	int total=0;
	String line;
	while((line = file.readLine()) != null) {
		total += consume(line);
	}
	file.close();

	return total;
	}
	
	
	public void write(String file) throws IOException {
		
		RandomAccessFile writer = new RandomAccessFile(file, "rw");
		for (int i=0;i<writedLines;i++) {
			String line = generateString();
		    writer.writeBytes(line);
		}
	    writer.close();
		
	}
	
	
	public int seek(String file) throws IOException {
		
		RandomAccessFile seek = new RandomAccessFile(file, "r");
		long pos=INIT;
		seek.seek(pos);
		String line;
	    int total =0;
		while((line = seek.readLine()) != null) {
			total += consume(line);
			pos+=STEP;
			seek.seek(pos);
	}
	    seek.close();
	return total;	
	}
}
