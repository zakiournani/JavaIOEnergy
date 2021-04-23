
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class scanner extends IO{

	
	public int read(String file) throws IOException {
	     Scanner scan = new Scanner(new File(file));
	     int total =0;
	     while(scan.hasNextLine()){
	         String line = scan.nextLine();
	         total += consume(line);
	     }
		scan.close();
		return total;
}
	

	
	

}
