/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package splitandmerge;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chana911
 */
public class Join extends javax.swing.JFrame {

    String FileName = "SQL Server 2008.iso";
    String S_path = "C:/Users/chana/Desktop/test/Split";
    String D_path = "C:/Users/chana/Desktop/test/join";
    
    String S_Complete = S_path +"/" + FileName;
    String D_Complete = D_path+ "/" +FileName;
    /**
     * Creates new form Join
     */
    public Join() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_Dpath = new javax.swing.JTextField();
        btn_Browse = new javax.swing.JButton();
        btn_Start = new javax.swing.JButton();
        btn_Viewdb = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_Browse.setText("Browse");

        btn_Start.setText("Start");
        btn_Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_StartActionPerformed(evt);
            }
        });

        btn_Viewdb.setText("ViewDB");

        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_Start)
                        .addGap(74, 74, 74)
                        .addComponent(btn_Viewdb)
                        .addGap(28, 28, 28)
                        .addComponent(btn_back))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_Dpath, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(btn_Browse)))
                .addContainerGap(158, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Dpath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Browse))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Start)
                    .addComponent(btn_Viewdb)
                    .addComponent(btn_back))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        // TODO add your handling code here:
        new Main().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_StartActionPerformed
        // TODO add your handling code here:
       
         //   DbConnect dbconnect = new DbConnect();
      
       // join(S_Complete,D_Complete);
       
     //  List<MYSpFile> listofFileSp = dbconnect.selectQuery(1);
       try{
            DbConnect dbconnection = new DbConnect();
            List<MYSpFile> listofFiles = ReadSPFile(S_path);
       
            if(HashCheck(listofFiles)){
//                    MyFile myfile = new MyFile();
//                    List<MyFile> mylist = dbconnection.selectFullQuery(1);
//                    String FileName = myfile.getName();
//                    String S_Complete =S_path +"/"+ FileName ;
//                    String D_Complete =D_path +"/"+ FileName;    
                    
                  join(S_Complete,D_Complete);
             }
                 else{
            System.out.println("Error");
            }
       } 
       catch(Exception ex){
            ex.printStackTrace();
       }         
     
       
        
    }//GEN-LAST:event_btn_StartActionPerformed

    static int join(String s, String s1) {
        int i = 0x10000;
        int j = 1;
        int k = 0;
        int l = 0;
        int i1 = 0;
        byte abyte0[] = new byte[i];
        Object obj = null;
        FileOutputStream fileoutputstream = null;
        File file = null;
        String s2 = "";
        long l1 = 0L;
        long l2 = System.currentTimeMillis();
        try {
            file = new File(s1);
            fileoutputstream = new FileOutputStream(file);
        } catch (Exception exception) {
            System.out.println("Error opening output: " + exception.toString());
            return 10;
        }
        try {
            do {
                String s3 = s + createSuffix(j++);
                FileInputStream fileinputstream = new FileInputStream(s3);
                while ((k = fileinputstream.read(abyte0)) > 0) {
                    l += k;
                    try {
                        fileoutputstream.write(abyte0, 0, k);
                        i1 += k;
                    } catch (Exception exception3) {
                        System.out.println("Error writing to output: " + exception3.toString());
                        return 10;
                    }
                }
                fileinputstream.close();
            } while (true);
        } catch (Exception exception1) {
            System.out.println("No more files to join: " + exception1.toString());
        }
        j--;
        try {
            fileoutputstream.close();
        } catch (Exception exception2) {
            System.out.println("Error closing output: " + exception2.toString());
        }
        if (k == 0 && j == 1) {
            file.delete();
            System.out.println("Error opening input file: Nothing to join.\n");
            return 5;
        } else {
            long l3 = System.currentTimeMillis() - l2;
            System.out.println("Done!\n\n");
            System.out.println("bytes read: " + String.valueOf(l) + "\nbytes written: " + String.valueOf(i1) + "\n");
            System.out.println("time used: " + String.valueOf(l3 / 1000L) + "." + String.valueOf(l3 % 1000L) + " sec.\n");
            return 0;
        }
    }
    
     static String createSuffix(int i) {
        String s;
        for (s = String.valueOf(i); s.length() < 3; s = "0" + s) ;
        return "." + s;
    }

      public static List<MYSpFile> ReadSPFile(String path) throws Exception{
		// int Count =0;
		// String Fname ;
                String Full_Path;
                String Hash,date;
                
		File folder = new File(path);
		List<MYSpFile> fileList = new ArrayList<MYSpFile>();
		for(File sysFile :  folder.listFiles()) {
                    Full_Path = path + "/" + sysFile.getName();
                    
                   Hash = getHash(Full_Path);
                   // Calendar cal = Calendar.getInstance();
                   // date = cal.getTime().toString();
                    
                    
			MYSpFile mySPFile = new MYSpFile();
			mySPFile.setName(sysFile.getName());
                        mySPFile.setHash(Hash);
                     // mySPFile.setcDate(date);
                     // mySPFile.setSize(S);
			mySPFile.setFile(sysFile);
                     // mySPFile.setCloud(1);
                     // mySPFile.setRcloud(2);
                        fileList.add(mySPFile);
		}
		
		return fileList;
	}
      
      public static String getHash(String Scomplete_path)
			throws Exception {

		String HValue;
		MessageDigest md = MessageDigest.getInstance("MD5");
		FileInputStream fis = new FileInputStream(Scomplete_path);

		byte[] dataBytes = new byte[1024];

		int nread = 0;
		try {
			while ((nread = fis.read(dataBytes)) != -1) {
				md.update(dataBytes, 0, nread);
			}
		} catch (IOException ex) {
			Logger.getLogger(Split.class.getName()).log(Level.SEVERE, null, ex);
		};
                
		byte[] mdbytes = md.digest();

		// convert the byte to hex format method 1
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < mdbytes.length; i++) {
			sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16)
					.substring(1));
		}

		System.out.println("Digest(in hex format):: " + sb.toString());

		HValue = sb.toString();
		return HValue;

	}
      
      public boolean HashCheck(List<MYSpFile> listoffiles)throws Exception{
      
          boolean Check = true;
          
       DbConnect dbconnect = new DbConnect();
      // List<MYSpFile> listofFiles = ReadSPFile(S_path);
             
       List<MYSpFile> listofFileSp = dbconnect.selectQuery(1);
       
       for(MYSpFile myfile: listoffiles){
            
               // String name = myspfile.getName();
               // String hash = myspfile.getHash();
                
                for(MYSpFile dbfile: listofFileSp){
                    
                   // String DbName = mysfile.getName();
                   // String DbHash = mysfile.getHash();
                    
                    if((myfile.getName().equalsIgnoreCase(dbfile.getName()))&&(myfile.getHash().equalsIgnoreCase(dbfile.getHash()))){
                            Check = true;
                            System.out.println("Pass");
                    }
                    else{
                            Check = false;
                            System.out.println("Fail");
                    }
                }
                
                
       }
      
          return Check;
      }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Join.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Join.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Join.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Join.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Join().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Browse;
    private javax.swing.JButton btn_Start;
    private javax.swing.JButton btn_Viewdb;
    private javax.swing.JButton btn_back;
    private javax.swing.JTextField txt_Dpath;
    // End of variables declaration//GEN-END:variables
}
