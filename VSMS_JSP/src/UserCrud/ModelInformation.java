package UserCrud;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Beans.Model;

public class ModelInformation {
	
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
	
	
	public static int save(Model m) {
		int status = 0;

		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("insert into models(manufacturer_id,model_name,model_description) values(?,?,?)");  
			ps.setInt(1, m.getManufacturerId());
			ps.setString(2, m.getModelName());
			ps.setString(3, m.getDescription());
			
			
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
	        PreparedStatement ps=con.prepareStatement("delete from models where id=" + id);    
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	  
	    return status;  
	}  
	
	
	public static List<Model> getAllRecords(){  
	    List<Model> list=new ArrayList<Model>();  
	      
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("SELECT models.id, manufacturers.manufacturer_name, models.model_name,models.model_description FROM models "
	        		+ "INNER JOIN manufacturers ON models.manufacturer_id = manufacturers.id");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	        	Model m = new Model(); 
	            m.setId(rs.getInt("id"));  
	            m.setModelName(rs.getString("model_name"));  
	            m.setManufacturerName(rs.getString("manufacturer_name"));
	            m.setDescription(rs.getString("model_description"));

	            list.add(m);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	} 

}
