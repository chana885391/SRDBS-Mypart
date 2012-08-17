/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chana
 */
public class StringEx {
    
     public static void main(String[] args)
          {
               String textString="SQL Server 2008.iso.001";
                             
              // textString = JOptionPane.showInputDialog("Enter a string:");
               
                             
              // totalString(textString);
              // convLowerCase(textString);
               replaceLetters(textString);
             //  convUpperCase(textString);
               
               System.out.println();
               System.exit( 0 );     
          }  
     
     public static void replaceLetters(String text)
          {
               System.out.println("Here it is with the a and z swapped "
               + text.replace(".001",""));
          }
    
}
