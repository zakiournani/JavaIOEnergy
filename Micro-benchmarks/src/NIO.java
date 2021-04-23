import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.LineIterator;

public class NIO extends IO{

	public int read(String file) throws IOException {
	Path path = Paths.get(file);

    BufferedReader reader = Files.newBufferedReader(path);
    Iterator<String> it=Files.lines(path).iterator();
	int total=0;
	while(reader.ready()) {
		 String line = reader.readLine();
	     total += consume(line);
	}
	reader.close();
	return total;
	}
	
	public int readAll(String file) throws IOException {
		Path path = Paths.get(file);
		List<String> s=Files.readAllLines(path);
		Iterator<String> it=s.iterator() ;
		int total=0;
		while(it.hasNext()) {
			 String line =it.next();
		     total += consume(line);
		}
		return total;
	}
	
	public void write(String file) throws IOException {
		
	Path path = Paths.get(file);
	BufferedWriter writer = Files.newBufferedWriter(path);
	for (int i=0;i<writedLines;i++) {
		String line = generateString();
	    writer.write(line);
	}
    writer.close();
	
	}
	
	public int readU(String file) throws IOException {
	Path path = Paths.get(file);
    Iterator<String> it=Files.lines(path).iterator();
	int total=0;
	while(it.hasNext()) {
		 String line =it.next();
	     total += consume(line);
	}
	return total;
	}
	
	public void writeU(String file) throws IOException {
		
	Path path = Paths.get(file);
	Files.createFile(path);
	for (int i=0;i<writedLines;i++) {
		String line = generateString();
		Files.writeString(path,line, StandardOpenOption.APPEND);
	}

	
	}
	
}
