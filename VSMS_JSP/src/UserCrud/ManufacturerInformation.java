package UserCrud;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Beans.Manufacturer;

public class ManufacturerInformation {
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); // MySQL database connection
	         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vsms","root",""); 
		}catch(Exception e){
			System.out.println(e);
			
		}
		return con;
		
	}
	
	
	public static int save(Manufacturer m) {
		int status = 0;

		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("insert into manufacturers(manufacturer_name) values(?)");  

			ps.setString(1, m.getManufacturerName());
			
			
			status= ps.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e);
			
		}
		return status;
	}
	
	public static int delete(int id){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("delete from manufacturers where id=" + id);    
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	  
	    return status;  
	}  
	
	
	public static List<Manufacturer> getAllRecords(){  
	    List<Manufacturer> list=new ArrayList<Manufacturer>();  
	      
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from manufacturers");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	        	Manufacturer m = new Manufacturer(); 
	            m.setId(rs.getInt("id"));  
	            m.setManufacturerName(rs.getString("manufacturer_name"));  

	            list.add(m);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	} 

}
