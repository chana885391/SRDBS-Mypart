/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package splitandmerge;

import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author chana911
 */
public class MD5Hash {
    
      public static void main(String[] args)throws Exception
    {
        MessageDigest md = MessageDigest.getInstance("MD5");
        FileInputStream fis = new FileInputStream("C:/Users/chana/Desktop/test/Source/Windows8-ConsumerPreview-64bit-English.iso");
 
        byte[] dataBytes = new byte[1024];
 
        int nread = 0; 
        while ((nread = fis.read(dataBytes)) != -1) {
          md.update(dataBytes, 0, nread);
        };
        byte[] mdbytes = md.digest();
 
        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < mdbytes.length; i++) {
          sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
        }
 
        System.out.println("Digest(in hex format):: " + sb.toString());
 
        //convert the byte to hex format method 2
        StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<mdbytes.length;i++) {
    		String hex=Integer.toHexString(0xff & mdbytes[i]);
   	     	if(hex.length()==1) hexString.append('0');
   	     	hexString.append(hex);
    	}
    	System.out.println("Digest(in hex format):: " + hexString.toString());
        String Hash = hexString.toString();
        
       /*  List<Map<String,String>> fileList = null;
         for()
         
         
         fileList = new ArrayList<Map<String,String>>();
       */  
    }
      
     
    
}
