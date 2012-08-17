
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chana
 */
public class Deletesp {
    
    public static void main(String args[]){
        
    String path ="C:/Users/chana/Desktop/test/Delete/20120731012005";
    File delfol = new File(path);
    File[] ListofFiles = delfol.listFiles();
            boolean isDeleted = deleteDir(delfol);
           //boolean isFilesDeleted = delete(path);
           System.out.println("Files are Deleted "+ isDeleted);
           //System.out.print("All Files Are Delete" + isFilesDeleted);
    
    }
    
 //  public static final boolean[] delete(File[] files)  
    
//      public static boolean[] delete(File[] files)
//  {
//    boolean[] b = new boolean[files.length];
//
//    for (int i = 0; i < files.length; i++) {
//      b[i] = files[i].delete();
//    }
//    return b;
//  }
  
  
public static boolean deleteDir(File dir) {
    
    if (dir.isDirectory()) {
        String[] children = dir.list();
        for (int i=0; i<children.length; i++) {
            
            boolean success = deleteDir(new File(dir, children[i]));
            if (!success) {
                return false;
            }
        }
    }

    // The directory is now empty so delete it
    return dir.delete();
 }

    public static boolean delete(String path)
  {
    boolean DeleteCheck = false;  
    String files1;
    File folder = new File(path);
    File[] listOfFiles = folder.listFiles(); 
    
      for (int i = 0; i < listOfFiles.length; i++) 
      {
  
         if (listOfFiles[i].isFile()) 
            {
                
             files1 = listOfFiles[i].getName();
             String Full_path = path +"/"+ files1;
             File DelFile = new File(Full_path);
             DeleteCheck = DelFile.delete();
             System.out.println(files1);
             
            }
         
      }
      
      return DeleteCheck;
  }
  
  
}
