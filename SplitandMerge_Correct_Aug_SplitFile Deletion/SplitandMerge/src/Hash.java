
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chana
 */
public class Hash {
    
    public static  void  main(String args[]){
        String path = "C:/Users/chana/Desktop/test/Source/Windows8-ConsumerPreview-64bit-English.iso";
        
        try{
       String V = md5(path);
        }
        catch(Exception ex){
            
        }
        
    }
    
    private static String md5(String Path) {
    try {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(Path.getBytes(), 0, Path.length());
        BigInteger i = new BigInteger(1,m.digest());
        return String.format("%1$032x", i);         
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    }
    return null;
}


    
}
