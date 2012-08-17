
import java.io.File;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chana
 */
public class FileSize {
     public long getFileSize(String filename) {

    File file = new File(filename);
    
    if (!file.exists() || !file.isFile()) {
      System.out.println("File doesn\'t exist");
      return -1;
    }
    
    //Here we get the actual size
    return file.length();
  }

  public static void main(String[] args) {
    FileSize filesize = new FileSize();
    long size = filesize.getFileSize("C:/Users/chana/Desktop/test/Source/Windows8-ConsumerPreview-64bit-English.iso");
    System.out.println("Filesize in bytes: " + size);
  }
}
