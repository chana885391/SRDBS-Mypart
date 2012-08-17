
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chana
 */
public class CreateDirectory {
    
     public static void main(String args[])
  {
  try{
  
String fldate;
      
DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HHmmss");
Date date = new Date();
fldate = dateFormat.format(date);


 String strDirectoy ="C:/Users/chana/Desktop/test"+ "/" +fldate;
 
 // String strManyDirectories="dir1/dir2/dir3";

  // Create one directory
  boolean success = (
  new File(strDirectoy)).mkdir();
  if (success) {
  System.out.println("Directory: " + strDirectoy + " created");
  } 
  
  // Create multiple directories
  /*
  success = (new File(strManyDirectories)).mkdirs();
  if (success) {
  System.out.println("Directories: " 
   + strManyDirectories + " created");
  }
  * 
  */

  }catch (Exception e){//Catch exception if any
  System.err.println("Error: " + e.getMessage());
  }
  }
    
}
