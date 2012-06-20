/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package splitandmerge;
import java.io.*;
/**
 *
 * @author chana911
 */
public class SplitandMerge {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String Filename;
File folder = new File("C:/Users/chana911/Desktop/test");
File[] listOfFiles = folder.listFiles();

for (File listOfFile : listOfFiles)
    if (listOfFile.isDirectory())
        System.out.println(listOfFile.getName());
        Filename = listOfFiles.toString();
        System.out.println(Filename);
    }
    
    
}
