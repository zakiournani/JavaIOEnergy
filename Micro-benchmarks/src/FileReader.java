
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
//import java.io.FileReader;

public class FileReader extends IO {

	public int read(String file) throws IOException {
	
    BufferedReader reader = new BufferedReader(new java.io.FileReader(file));
	int total=0;
	while(reader.ready()) {
	     String line = reader.readLine();
	     total += consume(line);
	}
	reader.close();
	
	return total;
	}

	public int readU(String file) throws IOException {
		
	    
		java.io.FileReader reader = new java.io.FileReader(file);
		int total=0;    
		char[] buffer = new char[BUFFER_SIZE];
	    while(reader.ready()){
	    	reader.read(buffer);
	    	String line =String.valueOf(buffer);
	    
	    	
	        total += consume(line);
	        }

		reader.close();
		
		return total;
		}
	
	public void write(String file) throws IOException {
	BufferedWriter writer = new BufferedWriter(new FileWriter(file));
	for (int i=0;i<writedLines;i++) {
		String line= generateString();
		
	    writer.write(line);
	}
	writer.close();
	
	}
	
	
	public void writeU(String file) throws IOException {
		
		java.io.FileWriter writer = new java.io.FileWriter(file);
	 

		for (int i=0;i<writedLines;i++) {
			
			String line= generateString();
			writer.write(line, 0, line.length());
		}

		writer.close();
	
	}
	

}
