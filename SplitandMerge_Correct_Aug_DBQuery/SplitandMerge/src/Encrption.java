import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chana
 */

public class Encrption {
    public static  String S_path="C:/Users/chana/Desktop/test/Source/AngryBirdsRioInstaller_1.2.2.exe";
    private static final int IV_LENGTH=16;
    
             
public static void encrypt(InputStream in, OutputStream out, String password) throws Exception{

		SecureRandom r = new SecureRandom();
		byte[] iv = new byte[IV_LENGTH];
		r.nextBytes(iv);
		out.write(iv); //write IV as a prefix
		out.flush();
		//System.out.println(">>>>>>>>written"+Arrays.toString(iv));

		Cipher cipher = Cipher.getInstance("AES/CFB8/NoPadding"); //"DES/ECB/PKCS5Padding";"AES/CBC/PKCS5Padding"
		SecretKeySpec keySpec = new SecretKeySpec(password.getBytes(), "AES");
		IvParameterSpec ivSpec = new IvParameterSpec(iv);
		cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);    	

		out = new CipherOutputStream(out, cipher);
		byte[] buf = new byte[1024];
		int numRead = 0;
		while ((numRead = in.read(buf)) >= 0) {
			out.write(buf, 0, numRead);
		}
		out.close();
	}

public static void decrypt(InputStream in, OutputStream out, String password) throws Exception{

		byte[] iv = new byte[IV_LENGTH];
		in.read(iv);
		//System.out.println(">>>>>>>>red"+Arrays.toString(iv));

		Cipher cipher = Cipher.getInstance("AES/CFB8/NoPadding"); //"DES/ECB/PKCS5Padding";"AES/CBC/PKCS5Padding"
		SecretKeySpec keySpec = new SecretKeySpec(password.getBytes(), "AES");
		IvParameterSpec ivSpec = new IvParameterSpec(iv);
		cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

		in = new CipherInputStream(in, cipher);
		byte[] buf = new byte[1024];
		int numRead = 0;
		while ((numRead = in.read(buf)) >= 0) {
			out.write(buf, 0, numRead);
		}
		out.close();
	}

public static void copy(int mode, String inputFile, String outputFile, String password) throws Exception {

		BufferedInputStream is = new BufferedInputStream(new FileInputStream(inputFile));
		BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(outputFile));
		if(mode==Cipher.ENCRYPT_MODE){
			encrypt(is, os, password);
		}
		else if(mode==Cipher.DECRYPT_MODE){
			decrypt(is, os, password);
		}
		else throw new Exception("unknown mode");
		is.close();
		os.close();
	}

public static void main(String[] args){

//		if(args.length<1){
//			System.out.println("Pass at least one argument (filename)");		
//			return;
//		}
		try{
			//check files - just for safety
			//String fileName=args[0];
                        String fileName = S_path;
			String tempFileName=fileName+".enc";
			String resultFileName=fileName+".dec";

			File file = new File(fileName);
			if(!file.exists()){
				System.out.println("No file "+fileName);
				return;
			}
			File file2 = new File(tempFileName);
			File file3 = new File(resultFileName);
			if(file2.exists() || file3.exists()){
				System.out.println("File for encrypted temp file or for the result decrypted file already exists. Please remove it or use a different file name");
				return;
			}

			copy(Cipher.ENCRYPT_MODE, fileName, tempFileName, "password12345678");
			copy(Cipher.DECRYPT_MODE, tempFileName, resultFileName, "password12345678");

			System.out.println("Success. Find encrypted and decripted files in current directory");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}	

   
}
