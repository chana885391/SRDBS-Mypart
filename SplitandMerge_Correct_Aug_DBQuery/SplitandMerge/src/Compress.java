
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chana
 */
public class Compress {
  public static  String S_path="C:/Users/chana/Desktop/test/Source/Windows8-ConsumerPreview-64bit-English.iso";
  public static String D_path  =S_path+ ".zip";
  
    public static void main(String a[])
  {
      
      compressFile();

  }
    
    
    public static void compressFile(){
    
  try
  {
    ZipOutputStream out = new ZipOutputStream(new 
    BufferedOutputStream(new FileOutputStream(D_path)));
  
  byte[] data = new byte[1000]; 
  BufferedInputStream in = new BufferedInputStream(new FileInputStream(S_path));
  int count;
 out.putNextEntry(new ZipEntry("outFile.zip"));
 while((count = in.read(data,0,1000)) != -1)
 {  
 out.write(data, 0, count);
 }
 in.close();
 out.flush();
 out.close();
  System.out.println("Your file is zipped");
 }
 catch(Exception e)
  {
 e.printStackTrace();
  }  
    
 }
   
}
