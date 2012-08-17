
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chana
 */
public class Decompress {
    
  public static  String S_path="C:/Users/chana/Desktop/test/join/SQL Server 2008.iso.zip";
  
  public static String Filename = "SQL Server 2008.iso";
  
  public static  String D_path ="C:/Users/chana/Desktop/test/join" +"/"+ Filename;
//  public static String D_path  =S_path+ ".zip";
    
    public static void main(String a[])
  {
  try
  {
 BufferedOutputStream out = null;
  ZipInputStream  in = new ZipInputStream
(new BufferedInputStream(new FileInputStream(S_path)));
  ZipEntry entry;
  while((entry = in.getNextEntry()) != null)
 {
 int count;
 byte data[] = new byte[1000];
 out = new BufferedOutputStream(new 
FileOutputStream(D_path),1000);
 while ((count = in.read(data,0,1000)) != -1)
 {
  out.write(data,0,count);
 }
 out.flush();
 out.close();
 }
 }catch(Exception e)
  {
 e.printStackTrace();
 }
 } 
 
    
}
