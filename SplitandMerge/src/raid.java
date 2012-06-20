/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.*;

/**
 *
 * @author chana
 */
public class raid {
    
    public static void raid(int pNumber, int c1, int c2, int c3) {

        int numberOfClouds = 3;
        int[] raidArray = new int[2 * pNumber];
        int count1 = (c1 * 2);
        int count2 = (c2 * 2);
        int count3 = (c3 * 2);
        ArrayList cloud1 = new ArrayList(); 
        ArrayList cloud2 = new ArrayList();
        ArrayList cloud3 = new ArrayList();
        int i = 0;
        int h=1;
		
        do {
            int o = getRandomCloud(numberOfClouds);
            int r = getRandomCloud(numberOfClouds);

            while (o == r) {
                r = getRandomCloud(numberOfClouds);
            }
            raidArray[i] = o;
            raidArray[i + 1] = r;
            i = i + 2;

            if (o == 1 && r == 2) {
                count1 = count1 - 1;
                count2 = count2 - 1;
            } else if (o == 1 && r == 3) {
                count1 = count1 - 1;
                count3 = count3 - 1;
            } else if (o == 2 && r == 1) {
                count2 = count2 - 1;
                count1 = count1 - 1;
            } else if (o == 2 && r == 3) {
                count2 = count2 - 1;
                count3 = count3 - 1;
            } else if (o == 3 && r == 1) {
                count3 = count3 - 1;
                count1 = count1 - 1;
            } else if (o == 3 && r == 2) {
                count3 = count3 - 1;
                count2 = count2 - 1;
            }
        }
        while ((count1 + count2 + count3) / 2 > 0);
		
		for(int j=0; j<raidArray.length;)
		{
			System.out.println("packet"+(j+2)/2+ "ori: "+raidArray[j]+"  "+" raid: "+raidArray[j+1]);
			j=j+2;
		}
                
                for(int k=0; k<raidArray.length;)    
		{
                    
			if(raidArray[k]==1 && raidArray[k+1]==2)
                        {
                            cloud1.add(h);
                            cloud2.add(h);
                        }
                        if(raidArray[k]==1 && raidArray[k+1]==3)
                        {
                            cloud1.add(h);
                            cloud3.add(h);
                        }
                        if(raidArray[k]==2 && raidArray[k+1]==1)
                        {
                            cloud2.add(h);
                            cloud1.add(h);
                        }
                        if(raidArray[k]==2 && raidArray[k+1]==3)
                        {
                            cloud2.add(h);
                            cloud3.add(h);
                        }
                        if(raidArray[k]==3 && raidArray[k+1]==1)
                        {
                            cloud3.add(h);
                            cloud1.add(h);
                        }
                        if(raidArray[k]==3 && raidArray[k+1]==2)
                        {
                            cloud3.add(h);
                            cloud2.add(h);
                        }
                            
			k=k+2;
                        h=h+1;
		}
                
		System.out.println("cloud1: "+ cloud1);
                System.out.println("cloud2: "+ cloud2);
                System.out.println("cloud3: "+ cloud3);
                        
			
		
                
                
                
                
   
    }

    private static int getRandomCloud(int numberOfClouds) {

        return (int) ((Math.random() * 10) % numberOfClouds) + 1;
    }
	
	public static void main (String  args[]){
	
	raid(10,5,4,1);
	
	}

    
}
