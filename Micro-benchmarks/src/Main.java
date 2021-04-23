import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;


public class Main {

	public static void main(String[] args) throws Exception {
	int hash= readAll();
	writeBench();	
	hash= bufferBench();
	hash= readBecnh();
	hash= seekBecnh();
 	PrintStream stdout = System.out;
	System.setOut(stdout); 
	System.out.println("hash :"+hash);
	
	

	}
	
	static int readBench() throws Exception{
		PrintStream fileStream = new PrintStream("saveReadData");
		System.setOut(fileStream);
		int hash=0, iter=50;
		List<String> files = Arrays.asList("tiny","small","medium","medlarge","large");

	
	for(String bench : files) {	
		for (int i=0;i<iter;i++) {
			IO read = new FileReader();
			Energy j = new Energy();
			j.init();
			long startTime = System.currentTimeMillis();
				hash+= read.read(bench);//the read operation
			j.stop();
			long stopTime = System.currentTimeMillis();
			System.out.println(bench+",BufferedFileReader,"+j.getEnergy()+","+(stopTime - startTime));
		}
		for (int i=0;i<iter;i++) {
			IO read = new IOStream();
			Energy j = new Energy();
			j.init();
			long startTime = System.currentTimeMillis();
				hash+= read.read(bench);//the read operation
			j.stop();
			long stopTime = System.currentTimeMillis();
			System.out.println(bench+",BufferedIOStream,"+j.getEnergy()+","+(stopTime - startTime));
		}
		for (int i=0;i<iter;i++) {
			IO read = new NIO();
			Energy j = new Energy();
			j.init();
			long startTime = System.currentTimeMillis();
				hash+= read.read(bench);//the read operation
			j.stop();
			long stopTime = System.currentTimeMillis();
			System.out.println(bench+",NIO,"+j.getEnergy()+","+(stopTime - startTime));
		}
		for (int i=0;i<iter;i++) {
			IO read = new scanner();
			Energy j = new Energy();
			j.init();
			long startTime = System.currentTimeMillis();
				hash+= read.read(bench);//the read operation
			j.stop();
			long stopTime = System.currentTimeMillis();
			System.out.println(bench+",Scanner,"+j.getEnergy()+","+(stopTime - startTime));
		}
		for (int i=0;i<iter;i++) {
			IO read = new Apache();
			Energy j = new Energy();
			j.init();
			long startTime = System.currentTimeMillis();
				hash+= read.read(bench);//the read operation
			j.stop();
			long stopTime = System.currentTimeMillis();
			System.out.println(bench+",Apache,"+j.getEnergy()+","+(stopTime - startTime));
		}
		for (int i=0;i<iter;i++) {
			IO read = new Guava();
			Energy j = new Energy();
			j.init();
			long startTime = System.currentTimeMillis();
				hash+= read.read(bench);//the read operation
			j.stop();
			long stopTime = System.currentTimeMillis();
			System.out.println(bench+",Guava,"+j.getEnergy()+","+(stopTime - startTime));
		}
		for (int i=0;i<iter;i++) {
			IO read = new Channel();
			Energy j = new Energy();
			j.init();
			long startTime = System.currentTimeMillis();
				hash+= read.read(bench);//the read operation
			j.stop();
			long stopTime = System.currentTimeMillis();
			System.out.println(bench+",Channel,"+j.getEnergy()+","+(stopTime - startTime));
		}
		for (int i=0;i<iter;i++) {
			if(bench=="large")break;
			IO read = new Channel();
			Energy j = new Energy();
			j.init();
			long startTime = System.currentTimeMillis();
				hash+= read.read(bench);//the read operation
			j.stop();
			long stopTime = System.currentTimeMillis();
			System.out.println(bench+",OnMemoryChannel,"+j.getEnergy()+","+(stopTime - startTime));
		}
		for (int i=0;i<iter;i++) {
			IO read = new FileReader();
			Energy j = new Energy();
			j.init();
			long startTime = System.currentTimeMillis();
				hash+= read.readU(bench);//the read operation
			j.stop();
			long stopTime = System.currentTimeMillis();
			System.out.println(bench+",FileReader,"+j.getEnergy()+","+(stopTime - startTime));
		}
		for (int i=0;i<iter;i++) {
			IO read = new IOStream();
			Energy j = new Energy();
			j.init();
			long startTime = System.currentTimeMillis();
				hash+= read.readU(bench);//the read operation
			j.stop();
			long stopTime = System.currentTimeMillis();
			System.out.println(bench+",IOStream,"+j.getEnergy()+","+(stopTime - startTime));
		}
		for (int i=0;i<iter;i++) {
			IO read = new RAF();
			Energy j = new Energy();
			j.init();
			long startTime = System.currentTimeMillis();
				hash+= read.read(bench);//the read operation
			j.stop();
			long stopTime = System.currentTimeMillis();
			System.out.println(bench+",RAF,"+j.getEnergy()+","+(stopTime - startTime));
		}

	}
		return hash;
	}
	

	
	static void writeBench() throws Exception{
		PrintStream fileStream = new PrintStream("saveWriteData");
		System.setOut(fileStream);
		int iter=50;
		List<Integer> files = Arrays.asList(1000,100000,1000000,8000000,40000000);
	for(int bench : files) {
		
		for (int i=0;i<iter;i++) {
			IO write = new FileReader();
			write.writedLines=bench;
			Energy j = new Energy();
			j.init();
			long startTime = System.currentTimeMillis();
				 write.write("dump");//the write operation
			j.stop();
			long stopTime = System.currentTimeMillis();
			System.out.println(bench+",BufferedFilewriter,"+j.getEnergy()+","+(stopTime - startTime));
			File dump = new File("dump");
			dump.delete();
		}
		for (int i=0;i<iter;i++) {
			IO write = new IOStream();
			write.writedLines=bench;
			Energy j = new Energy();
			j.init();
			long startTime = System.currentTimeMillis();
				 write.write("dump");//the write operation
			j.stop();
			long stopTime = System.currentTimeMillis();
			System.out.println(bench+",BufferedIOStream,"+j.getEnergy()+","+(stopTime - startTime));
			File dump = new File("dump");
			dump.delete();
		}
		for (int i=0;i<iter;i++) {
			IO write = new NIO();
			write.writedLines=bench;
			Energy j = new Energy();
			j.init();
			long startTime = System.currentTimeMillis();
				write.write("dump");//the write operation
			j.stop();
			long stopTime = System.currentTimeMillis();
			System.out.println(bench+",NIO,"+j.getEnergy()+","+(stopTime - startTime));
			File dump = new File("dump");
			dump.delete();
		}
		
		for (int i=0;i<iter;i++) {
			IO write = new Apache();
			write.writedLines=bench;
			Energy j = new Energy();
			j.init();
			long startTime = System.currentTimeMillis();
				write.write("dump");//the write operation
			j.stop();
			long stopTime = System.currentTimeMillis();
			System.out.println(bench+",Apache,"+j.getEnergy()+","+(stopTime - startTime));
			File dump = new File("dump");
			dump.delete();
		}	
		for (int i=0;i<4;i++) {
			IO write = new Guava();
			write.writedLines=bench;
			Energy j = new Energy();
			j.init();
			long startTime = System.currentTimeMillis();
				write.write("dump");//the write operation
			j.stop();
			long stopTime = System.currentTimeMillis();
			System.out.println(bench+",Guava,"+j.getEnergy()+","+(stopTime - startTime));
			File dump = new File("dump");
			dump.delete();
		}

		for (int i=0;i<iter;i++) {
			IO write = new RAF();
			write.writedLines=bench;
			Energy j = new Energy();
			j.init();
			long startTime = System.currentTimeMillis();
				write.write("dump");//the write operation
			j.stop();
			long stopTime = System.currentTimeMillis();
			System.out.println(bench+",RAF,"+j.getEnergy()+","+(stopTime - startTime));
			File dump = new File("dump");
			dump.delete();
		}
		
		for (int i=0;i<iter;i++) {
			IO write = new FileReader();
			write.writedLines=bench;
			Energy j = new Energy();
			j.init();
			long startTime = System.currentTimeMillis();
				 write.writeU("dump");//the write operation
			j.stop();
			long stopTime = System.currentTimeMillis();
			System.out.println(bench+",Filewriter,"+j.getEnergy()+","+(stopTime - startTime));
			File dump = new File("dump");
			dump.delete();
		}
		for (int i=0;i<iter;i++) {
			IO write = new IOStream();
			write.writedLines=bench;
			Energy j = new Energy();
			j.init();
			long startTime = System.currentTimeMillis();
				 write.writeU("dump");//the write operation
			j.stop();
			long stopTime = System.currentTimeMillis();
			System.out.println(bench+",IOStream,"+j.getEnergy()+","+(stopTime - startTime));
			File dump = new File("dump");
			dump.delete();
		}
		for (int i=0;i<iter;i++) {
			IO write = new Channel();
			write.writedLines=bench;
			Energy j = new Energy();
			j.init();
			long startTime = System.currentTimeMillis();
				write.write("dump");//the write operation
			j.stop();
			long stopTime = System.currentTimeMillis();
			System.out.println(bench+",Channel,"+j.getEnergy()+","+(stopTime - startTime));
			File dump = new File("dump");
			dump.delete();
		}


	}
	
	}
	
	static int seekBench() throws Exception{
		
		PrintStream fileStream = new PrintStream("saveSeekData");
		System.setOut(fileStream);
		int hash=0, iter=50;
		List<String> files = Arrays.asList("tiny","small","medium","medlarge","large");
	
	for(String bench : files) {	
		for (int i=0;i<iter;i++) {
			IO read = new IOStream();
			Energy j = new Energy();
			j.init();
			long startTime = System.currentTimeMillis();
				hash+= read.seek(bench);//the read operation
			j.stop();
			long stopTime = System.currentTimeMillis();
			System.out.println(bench+",IOStream,"+j.getEnergy()+","+(stopTime - startTime));
		}
		
		for (int i=0;i<iter;i++) {
			IO read = new RAF();
			Energy j = new Energy();
			j.init();
			long startTime = System.currentTimeMillis();
				hash+= read.seek(bench);//the read operation
			j.stop();
			long stopTime = System.currentTimeMillis();
			System.out.println(bench+",RAF,"+j.getEnergy()+","+(stopTime - startTime));
		}
		for (int i=0;i<iter;i++) {
			IO read = new Channel();
			Energy j = new Energy();
			j.init();
			long startTime = System.currentTimeMillis();
				hash+= read.seek(bench);//the read operation
			j.stop();
			long stopTime = System.currentTimeMillis();
			System.out.println(bench+",Channel,"+j.getEnergy()+","+(stopTime - startTime));
		}
		
	}
	return hash;
	}
	
	static int bufferBench() throws Exception{
		
		PrintStream fileStream = new PrintStream("saveBufferData");
		System.setOut(fileStream);
		int hash=0, iter=50;
		List<String> files = Arrays.asList("tiny","small","medium","medlarge","large");
		List<Integer> sizes = Arrays.asList(4,128);
		List<Integer> filesToWrite = Arrays.asList(1000,100000,1000000,30000000);

	for(int size : sizes) {
	for(String bench : files) {	
		for (int i=0;i<iter;i++) {
			IO read = new IOStream();
			Energy j = new Energy();
			j.init();
			long startTime = System.currentTimeMillis();
				hash+= read.read(bench,size);//the read operation
			j.stop();
			long stopTime = System.currentTimeMillis();
			System.out.println(size+","+bench+",ReadBufferedIOStream,"+j.getEnergy()+","+(stopTime - startTime));
		}
	}
	for(int bench : filesToWrite) {	
		for (int i=0;i<iter;i++) {
			IO write = new IOStream();
			write.writedLines=bench;
			Energy j = new Energy();
			j.init();
			long startTime = System.currentTimeMillis();
				 write.write("dump",size);//the write operation
			j.stop();
			long stopTime = System.currentTimeMillis();
			System.out.println(size+","+bench+",WriteBufferedIOStream,"+j.getEnergy()+","+(stopTime - startTime));
			File dump = new File("dump");
			dump.delete();
		}
	}	
	
		
	
	}
	return hash;
	}
	
	static int readAll() throws Exception{
		PrintStream fileStream = new PrintStream("saveReadAllData");
		System.setOut(fileStream);
		int hash=0, iter=50;
		List<String> files = Arrays.asList("tiny","small","medium");
	
	for(String bench : files) {	

		for (int i=0;i<iter;i++) {
			IO read = new NIO();
			Energy j = new Energy();
			j.init();
			long startTime = System.currentTimeMillis();
				hash+= read.readAll(bench);//the read operation
			j.stop();
			long stopTime = System.currentTimeMillis();
			System.out.println(bench+",NIOF,"+j.getEnergy()+","+(stopTime - startTime));
		}

		for (int i=0;i<iter;i++) {
			IO read = new Apache();
			Energy j = new Energy();
			j.init();
			long startTime = System.currentTimeMillis();
				hash+= read.readAll(bench);//the read operation
			j.stop();
			long stopTime = System.currentTimeMillis();
			System.out.println(bench+",Apache,"+j.getEnergy()+","+(stopTime - startTime));
		}
		for (int i=0;i<iter;i++) {
			IO read = new Guava();
			Energy j = new Energy();
			j.init();
			long startTime = System.currentTimeMillis();
				hash+= read.readAll(bench);//the read operation
			j.stop();
			long stopTime = System.currentTimeMillis();
			System.out.println(bench+",Guava,"+j.getEnergy()+","+(stopTime - startTime));
		}

		for (int i=0;i<iter;i++) {
			IO read = new IOStream();
			Energy j = new Energy();
			j.init();
			long startTime = System.currentTimeMillis();
				hash+= read.readAll(bench);//the read operation
			j.stop();
			long stopTime = System.currentTimeMillis();
			System.out.println(bench+",IOStream,"+j.getEnergy()+","+(stopTime - startTime));
		}

	}
		return hash;
	}
	

}
