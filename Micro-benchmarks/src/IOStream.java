import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class IOStream extends IO {

	public int read(String file) throws IOException {
	InputStream inputstream = new FileInputStream(file);
	BufferedReader reader = new BufferedReader(new InputStreamReader(inputstream));

	int total=0;
	while(reader.ready()) {
	     String line = reader. readLine();
	     total += consume(line);
	}
	reader.close();
	inputstream.close();

	return total;
	}
	
	public int readBinary(String file) throws IOException {

	 InputStream reader = new FileInputStream(new File(file));
	          
	 byte[] readBuff = new byte[BUFFER_SIZE];
	int total=0;
	while ((reader.read(readBuff)) != -1) {
		String line=new String(readBuff, StandardCharsets.UTF_8);
		
	     total += consume(line);
	}
	reader.close();

	return total;
	}
	
	public void write(String file) throws IOException {
	BufferedOutputStream w = new BufferedOutputStream(new FileOutputStream(file));
	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(w));
	

	for (int i=0;i<writedLines;i++) {
		String line = generateString();
		
	    writer.write(line);
	}
    writer.close();
	w.close();
	
	}
	public int read(String file, int bufferSize) throws IOException {
	InputStream inputstream = new FileInputStream(file);
	BufferedReader reader = new BufferedReader(new InputStreamReader(inputstream), bufferSize);
	
	int total=0;
	while(reader.ready()) {
	     String line = reader. readLine();
	
	     total += consume(line);
	}
	reader.close();
	inputstream.close();
	return total;
	}	
	public int readAll(String file) throws IOException {
		 InputStream reader = new FileInputStream(new File(file));
		
		int total=0;
		byte[] b=reader.readAllBytes();
		total =consume(new String(b, StandardCharsets.UTF_8));
		reader.close();
		
		return total;
	}
	
	
	public void write(String file, int bufferSize) throws IOException {
	BufferedOutputStream w = new BufferedOutputStream(new FileOutputStream(file),  bufferSize);
	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(w));

	for (int i=0;i<writedLines;i++) {
		String line = generateString();
		
	    writer.write(line);
	}
    writer.close();
	w.close();
	
	}
	public int readU(String file) throws IOException {
		
		 InputStream reader = new FileInputStream(new File(file));
		 byte[] readBuff = new byte[BUFFER_SIZE];
		int total=0;
		while ((reader.read(readBuff)) != -1) {
			String line=new String(readBuff, StandardCharsets.UTF_8);
			
		     total += consume(line);
		}
		reader.close();

		return total;
		}

	public void writeU(String file) throws IOException {
		OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file));
	

		for (int i=0;i<writedLines;i++) {
			String line= generateString();
			writer.write(line);

		}

		writer.close();
		
		}
	
	public int seek(String file) throws IOException {
		ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
		FileInputStream seek = new FileInputStream(file);
		long pos=INIT;
		seek.skip(pos);

		String line;
	    int total =0;
		while((line =new String(seek.readNBytes(BUFFER_SIZE), StandardCharsets.UTF_8)).length() > 1) {
			total += consume(line);

			seek.skip(STEP); 

		}
	    seek.close();
	return total;	
	}
}
