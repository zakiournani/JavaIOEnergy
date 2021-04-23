import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class Channel extends IO{
	
	public int read(String file) throws IOException {
	FileChannel channel = new FileInputStream(file).getChannel();
	int total=0;
	String line;
	int byteCount=1;
	while(byteCount > 0) {
    int bufferSize = BUFFER_SIZE;
    if (bufferSize > channel.size()) {
        bufferSize = (int) channel.size();
    }

  
    
    
    ByteBuffer buff = ByteBuffer.allocate(bufferSize);
    byteCount=channel.read(buff);
    line = new String(buff.array(), StandardCharsets.UTF_8);
   // buff.flip();
    //line=new String(buff.array());
    total += consume(line);}
	
	 channel.close();


	return total;
	}
	
	public int readMem(String file) throws IOException {
	final FileChannel channel = new FileInputStream(file).getChannel();
	MappedByteBuffer buff = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
	int total=0;
	String line;
    channel.read(buff);
    line = new String(buff.array(), StandardCharsets.UTF_8);
   // buff.flip();
    //line=new String(buff.array());

    total += consume(line);
	
	channel.close();

	return total;
	}
	

	
	public void write(String file) throws IOException {

		final FileChannel channel = new FileOutputStream(file).getChannel();


		for (int i=0;i<writedLines;i++) {
			String line = generateString();

			byte[] strBytes = line.getBytes();
		    ByteBuffer buffer = ByteBuffer.allocate(strBytes.length);
		    buffer.put(strBytes);
		    buffer.flip();
		    channel.write(buffer);
		}
		channel.close();

		
	}
	
	public int seek(String file) throws IOException {
		
    
		long pos=INIT;
		final FileChannel channel = new FileInputStream(file).getChannel();
		channel.position(pos);
		int total=0;
		String line;
		int byteCount=1;
		while(byteCount > 0) {
	    int bufferSize = BUFFER_SIZE;
	    if (bufferSize > channel.size()) {
	        bufferSize = (int) channel.size();
	    }

	    ByteBuffer buff = ByteBuffer.allocate(bufferSize);
	    byteCount=channel.read(buff);
	    line = new String(buff.array(), StandardCharsets.UTF_8);

		pos+=STEP;
		channel.position(pos);
	    buff.flip();
	    total += consume(line);}
		
		 channel.close();

		return total;
	    
	}
}
