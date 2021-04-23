
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;

public class Guava extends IO{
	
	public int read(String filename) throws IOException {
		 File file= new File(filename);
		 int total=0;
		 CharSource source = Files.asCharSource(file, Charsets.UTF_8);
		
	
		BufferedReader reader= source.openBufferedStream();
		while (reader.ready())
			 total+=consume(reader.readLine());

	return total;
	}
	public int readAll(String filename) throws IOException {
		File file= new File(filename);
		List<String> s= Files.readLines(file, Charsets.UTF_8);
		Iterator<String> it=s.iterator() ;
		int total=0;
		while(it.hasNext()) {
			 String line =it.next();
		     total += consume(line);
		}
		return total;
	}
	
	public void write(String filename) throws IOException {
	File file= new File(filename);	
	CharSink sink = Files.asCharSink(file, Charsets.UTF_8);
	   
	for (int i=0;i<writedLines;i++) {
		String line = generateString();
		 sink.write(line);
	
	}

	
	}

}
