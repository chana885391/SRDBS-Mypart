
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chana
 */
public class DateTime {
    
  	public static void main(String args[]){

DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
Date date = new Date();
System.out.println(dateFormat.format(date));


	}

}
    

