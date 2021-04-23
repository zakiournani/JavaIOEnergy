

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
 

public class Main {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";
    
	public static void main(String[] args) throws Exception {
		
		Energy j = new Energy();
		j.init();
		long startTime = System.currentTimeMillis();
		//DecryptIOStream(Cipher.DECRYPT_MODE, "AesEncryptionKey",new File( "file"));
		//DecryptChannel(Cipher.DECRYPT_MODE, "AesEncryptionKey",new File( "file"));
		//DecryptFR(Cipher.DECRYPT_MODE, "AesEncryptionKey", "file");
		//DecryptBIOStream(Cipher.DECRYPT_MODE, "AesEncryptionKey",new File( "file"));
		DecryptNIOF(Cipher.DECRYPT_MODE, "AesEncryptionKey", "file");
		j.stop();
		long stopTime = System.currentTimeMillis();
		System.out.println("Crypto"+",NIOF,"+j.getEnergy()+","+(stopTime - startTime));
	}
 
  

 

    private static void DecryptIOStream(int cipherMode, String key,File file) throws Exception{
    	Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(cipherMode, secretKey);
    	
    	InputStream reader = new FileInputStream(file);
		 byte[] readBuff = new byte[BUFFER_SIZE];

		while ((reader.read(readBuff)) != -1) {
			 cipher.doFinal(readBuff);
		}
		reader.close();
    }
    
    private static void DecryptChannel(int cipherMode, String key,File file) throws Exception{
    	Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(cipherMode, secretKey);
    	
         FileChannel reader = new FileInputStream(file).getChannel();
         int byteCount=1;
         while(byteCount > 0) {
        	    int bufferSize = BUFFER_SIZE;
        	    if (bufferSize > reader.size()) {
        	        bufferSize = (int) reader.size();
        	    }
           	    ByteBuffer buff = ByteBuffer.allocate(bufferSize);
        	    byteCount=reader.read(buff);
        	    cipher.doFinal(buff.array());
  }
		reader.close();
    }
    private static void DecryptNIOF(int cipherMode, String key,String file) throws Exception{
    	Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(cipherMode, secretKey);
        Path path = Paths.get(file);
        Iterator<String> it=Files.lines(path).iterator();
    	while(it.hasNext()) {
    		 String line =it.next();
    		 cipher.doFinal(line.getBytes());

    	}   
    } 
    private static void DecryptFR(int cipherMode, String key,String file) throws Exception{
    	Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(cipherMode, secretKey);
        java.io.FileReader reader = new java.io.FileReader(file);
 
		char[] buffer = new char[BUFFER_SIZE];
	    while(reader.ready()){
	    	reader.read(buffer);
   		    cipher.doFinal(new String(buffer).getBytes());
	        }

		reader.close();
    } 
    private static void DecryptBIOStream(int cipherMode, String key,File file) throws Exception{
    	Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(cipherMode, secretKey);
        InputStream inputstream = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputstream));
    	while(reader.ready()) {
    	String line = reader. readLine();
   		 cipher.doFinal(line.getBytes());

    	}  
		reader.close();
    }
    
    
    
}
