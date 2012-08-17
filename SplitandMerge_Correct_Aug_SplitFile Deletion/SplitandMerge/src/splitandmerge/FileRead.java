/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package splitandmerge;

import java.io.File;



/**
 *
 * @author chana911
 */

public class FileRead {
    
       
    public static void main(String args[]){
        
    String path = "C:/Users/chana/Desktop/test/join";
    Read(path);
 
       //String Fname[];
    /*
File folder = new File(path);
File[] listOfFiles = folder.listFiles();
        
for (int i = 0; i < listOfFiles.length; i++) {
         
if (listOfFiles[i].isFile()) {
            String files = listOfFiles[i].getName();
            Count++;
 
     System.out.println(files);
     store(files);
        
  }

}
System.out.print("On of Files:"+Count);
*/
    }
    
   public static void store(String file,String path){
       
        String[] a =new String[10];
       for(int i=0;i<10;i++)
       {
           a[i]=file;
           Read(path);
           
           
       }
   System.out.print(a);
   }
   
   File[] listOfFiles = null;
   public static void Read(String Path){
   
       int Count =0;
       File folder = new File(Path);
File[] listOfFiles = folder.listFiles();

        
for (int i = 0; i < listOfFiles.length; i++) {
         
if (listOfFiles[i].isFile()) {
            String files = listOfFiles[i].getName();
            Count++;
 
     System.out.println(files);
     //store(files,Path);
        
  }

}
   System.out.print("No of File:"+Count);
   }
}

       


