import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

public class Apache extends IO{
	
	public int read(String filename) throws IOException {
		 File file= new File(filename);
		 int total=0;
		    
		 LineIterator it = FileUtils.lineIterator(file, "UTF-8");
		 FileUtils.readFileToString(file,"UTF-8");
		 
		     while (it.hasNext()) {
		         String line = it.nextLine();
		         total += consume(line);
		     }
		
		     LineIterator.closeQuietly(it);

	return total;
	}
	public int readAll(String filename) throws IOException {
		 File file= new File(filename);
		 int total=0;

		 String content=FileUtils.readFileToString(file,"UTF-8");
		 total += consume(content);
		
	return total;
	}
	public void write(String filename) throws IOException {
	File file= new File(filename);	
	List<String> list = new ArrayList<String>();
	for (int i=0;i<writedLines;i++) {
		if(list.size()<MAX_SIZE) {
		String line = generateString();
	
	    list.add(line);
		}
		else {
		FileUtils.writeLines(file, list,true);
		list.clear();
		}
	}
	if(list.size()>0) FileUtils.writeLines(file, list,true);

	
	}

}
