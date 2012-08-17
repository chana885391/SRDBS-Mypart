package splitandmerge;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import sun.font.CreatedFontTracker;

/**
 * Secure and Redundant Data Backup System.
 * User: Chana911
 * Date: 5/23/12
 * Time: 2:42 PM
 
 */

public class DbConnect {

    public static Logger logger = Logger.getLogger("systemsLog");

    String url = "jdbc:mysql://localhost:3306/";
    String dbName = "SRDBSDB";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "SRDBS";
    String password = "terminator";

    public Connection connect() {

        Connection conn = null;

        try {

            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);
            logger.info("Connected to the database");
        } catch (Exception e) {
          //  logger.error(e);
        }

        return conn;
    }
    
      
             
           
    public List<MYSpFile> selectQuery(int fid) throws Exception{
        
            
        String sql = " select SP_FileName,HashValue from sp_file where F_ID="+fid+"";
	Connection connection = connect();
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(sql);
        List<MYSpFile> fileList = new ArrayList<MYSpFile>();
        
            while(rs.next()){
                   MYSpFile myspFile = new MYSpFile();
                   
                   myspFile.setName(rs.getString("SP_FileName"));
                   myspFile.setHash(rs.getString("HashValue"));
                   fileList.add(myspFile); 
                
            }
                
       
//        Statement s = connection.createStatement();
//        ResultSet rs = s.executeQuery(sql);

//            while (rs.next()) {
//                vhno.addItem(rs.getString("vhno"));
//            }
          //  rs = s.executeQuery("select vhtype,vhmodel,hirerate,dateofrenewlicence,date_of_insurance,servicedetail,maintainance_cost from vehicle
        
        
        return fileList;
    }
    
     public List<MyFile> selectFullQuery(int fid) throws Exception{
        
            
        String sql = " select F_ID,FName,HashValue from Full_File where F_ID="+fid+"";
	Connection connection = connect();
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(sql);
        List<MyFile> fileList = new ArrayList<MyFile>();
        
                while(rs.next()){
                   MyFile myFile = new MyFile();
                   
                   myFile.setId(rs.getLong("F_ID"));
                   myFile.setName(rs.getString("FName"));
                   myFile.setHash(rs.getString("HashValue"));
                   fileList.add(myFile); 
               
                }      
            
          return fileList;
    }
     
       public List<MYSpFile> selectLoadSpQuery(int fid) throws Exception{
        
            
        String sql = " select SP_FileName,Ref_Cloud_ID,Raid_Ref from sp_file where F_ID="+fid+"";
	Connection connection = connect();
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(sql);
        List<MYSpFile> fileList = new ArrayList<MYSpFile>();
        
            while(rs.next()){
                   MYSpFile myspFile = new MYSpFile();
                   
                   myspFile.setName(rs.getString("SP_FileName"));
                   myspFile.setCloud(rs.getInt("Ref_Cloud_ID"));
                   myspFile.setRcloud(rs.getInt("Raid_Ref"));
                   fileList.add(myspFile); 
                
            }
                
       
//        Statement s = connection.createStatement();
//        ResultSet rs = s.executeQuery(sql);

//            while (rs.next()) {
//                vhno.addItem(rs.getString("vhno"));
//            }
          //  rs = s.executeQuery("select vhtype,vhmodel,hirerate,dateofrenewlicence,date_of_insurance,servicedetail,maintainance_cost from vehicle
        
        
        return fileList;
    }
    
         
          
/*	
    public int saveFiles(List<MyFile> fileList) throws SQLException {
		
	//	String sql = "insert into Full_File (FName, FSize, HashValue,Up_Date) values (?, ?, ?,?)";
                String sql = "insert into Full_File (FName,FSize,HashValue,Up_Date) values (?,?,?,?)";
		Connection connection = connect();
		PreparedStatement ps = connection.prepareStatement(sql);
		 
		for (MyFile myFile: fileList) {
		 // java.sql.Date sqlDate = new java.sql.Date(myFile.getcDate().getTime());
		    ps.setString(1, myFile.getName());
                    ps.setLong(2, myFile.getSize());
                    ps.setString(3, myFile.getHash());
                    ps.setString(4,myFile.getcDate());
		    ps.addBatch();
		}
		ps.executeBatch();
		ps.close();
		connection.close();
                
                return 1;
	
	}
        * 
        */
     
      public int saveFiles(String Fname,long Size,String Hash,String Date) throws SQLException {
		
	//	String sql = "insert into Full_File (FName, FSize, HashValue,Up_Date) values (?, ?, ?,?)";
                String sql = "insert into Full_File (FName,FSize,HashValue,Up_Date) values (?,?,?,?)";
		Connection connection = connect();
		PreparedStatement ps = connection.prepareStatement(sql);
		 
		//for (MyFile myFile: fileList) {
		 // java.sql.Date sqlDate = new java.sql.Date(myFile.getcDate().getTime());
                    MyFile myFile = new MyFile();
		    ps.setString(1, Fname);
                    ps.setLong(2, Size);
                    ps.setString(3, Hash);
                    ps.setString(4,Date);
		    ps.addBatch();
		//}
		ps.executeBatch();
		ps.close();
		connection.close();
                
                return 1;
	
	}
    /*
       public int saveSPFiles(List<MYSpFile> fileList) throws SQLException {
		
	
                String sql = "insert into Sp_File (F_ID,SP_FileName,F_Size,HashValue,Ref_Cloud_ID,Raid_Ref) values (?,?,?,?,?,?)";
		Connection connection = connect();
		PreparedStatement ps = connection.prepareStatement(sql);
		 
		for (MYSpFile mySFile: fileList) {
		 // java.sql.Date sqlDate = new java.sql.Date(myFile.getcDate().getTime());
                    
                    ps.setLong(1, mySFile.getFid());
		    ps.setString(2, mySFile.getName());
                    ps.setLong(3, mySFile.getSize());
                    ps.setString(4, mySFile.getHash());
                  //  ps.setString(4,mySFile.getcDate());
                    ps.setInt(5, mySFile.getCloud());
                    ps.setInt(6, mySFile.getRCloud());
		    ps.addBatch();
		}
		ps.executeBatch();
		ps.close();
		connection.close();
                
                return 1;
	
	}
        * 
        */
        public int saveSPFiles(long fid,String Fname,long Size,String Hash,int Cl_ID,int R_ID ) throws SQLException {
		
                
            
                String sql = "insert into Sp_File (F_ID,SP_FileName,F_Size,HashValue,Ref_Cloud_ID,Raid_Ref) values (?,?,?,?,?,?)";
		Connection connection = connect();
		PreparedStatement ps = connection.prepareStatement(sql);
		
                
		//for (MYSpFile mySFile: fileList) {
		 // java.sql.Date sqlDate = new java.sql.Date(myFile.getcDate().getTime());
                    MYSpFile mySFile = new MYSpFile();
                    ps.setLong(1, fid);
		    ps.setString(2, Fname);
                    ps.setLong(3, Size);
                    ps.setString(4, Hash);
                  //  ps.setString(4,mySFile.getcDate());
                    ps.setInt(5, Cl_ID);
                    ps.setInt(6, R_ID);
		    ps.addBatch();
		//}
		ps.executeBatch();
		ps.close();
		connection.close();
                
                return 1;
	
	}
        
         public long RowCount() throws SQLException {
		
                long fid;
            
                String sql = "select F_ID from Full_File ";
		Connection connection = connect();
                Statement s = connection.createStatement();
                ResultSet rs = s.executeQuery(sql);
		
                while(rs.next()){
                    MyFile myfile = new MyFile();
                    
                    myfile.setId(rs.getLong("F_ID"));
                }
                rs.last();
                fid=rs.getRow();
                
                return fid;
	
	}
         
          public int saveQueueSPFiles(long fid,String Fname,String FolderName ) throws SQLException {
		
                
              //  String sql=("update sp_file set Rpath = '" + Flname +  "' where F_ID = '" + fid + "'");
              String sql = "update Sp_File set Rpath = ? where F_ID = '" +fid +"'and SP_FileName = '" + Fname+"'";
		Connection connection = connect();
		PreparedStatement ps = connection.prepareStatement(sql);
		
                
		//for (MYSpFile mySFile: fileList) {
		 // java.sql.Date sqlDate = new java.sql.Date(myFile.getcDate().getTime());
                    MYSpFile mySFile = new MYSpFile();
                    ps.setString(1, FolderName);

                    ps.addBatch();
                    //}
                    ps.executeBatch();
                    ps.close();
                    connection.close();
                
                return 1;
               
           	
	}
       
       public int Delete(long fid,String Fpath) throws SQLException {
		
                
              //  String sql=("update sp_file set Rpath = '" + Flname +  "' where F_ID = '" + fid + "'");
              String sql =  "DELETE FROM fail_upload where F_ID = ? and File_Source_path = ?";

		Connection connection = connect();
		PreparedStatement ps = connection.prepareStatement(sql);
		
                
		    ps.setLong(1, fid);
                    ps.setString(2, Fpath);
                    
                    
                    ps.executeUpdate();
                    ps.close();
                    connection.close();
                
                return 1;
               
           	
	}
          
         
         
}
