package UserCrud;



import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Beans.Vehicle;

public class VehicleInformation {
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
	
	
//	public static int save(Vehicle v) {
//		int status = 0;
//
//		try {
//			Connection con = getConnection();
//			PreparedStatement ps = con.prepareStatement("insert into Vehicles(password,email,position,gender,type,mobile,address,last_name,first_name,birthday) values(?,?,?,?,?,?,?,?,?,?)");  
//
//		    ps.setString(1, u.getPassword());
//			ps.setString(2, u.getEmail());
//			ps.setString(3, u.getPosition());
//			ps.setString(4, u.getGender());
//			ps.setString(5, u.getVehicleType());
//			ps.setString(6, u.getMobile());
//			ps.setString(7, u.getAddress());
//			ps.setString(8, u.getLastName());
//			ps.setString(9, u.getFirstName());
//			ps.setDate(10, new Date(u.getBirthDate().getTime()));
//			
//			
//			status= ps.executeUpdate();
//			
//		}catch(Exception e) {
//			System.out.println(e);
//			
//		}
//		return status;
//	}
	
	
	
	  
	
	public static List<Vehicle> getAllRecords(){  
	    List<Vehicle> list=new ArrayList<Vehicle>();  
	      
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("SELECT vehicles.vehicle_id,models.model_name,manufacturers.manufacturer_name,vehicles.category,vehicles.add_date,vehicles.status,vehicles.buying_price,vehicles.sold_date,vehicles.image FROM vehicles INNER JOIN manufacturers on manufacturers.id = vehicles.manufacturer_id INNER JOIN models on models.id = vehicles.model_id"); 
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            Vehicle v =new Vehicle();  
	            v.setId(rs.getInt("vehicle_id"));  
	            v.setModel(rs.getString("model_name"));      
	            v.setMake(rs.getString("manufacturer_name")); 
	            v.setCategory(rs.getString("category"));  
	            v.setAddedOn(rs.getDate("add_date"));   
	            v.setStatus(rs.getString("status"));  
	            v.setBought(rs.getString("buying_price")); 
	            v.setSoldOn(rs.getDate("sold_date")); 
	            v.setImage(rs.getString("image")); 

	            list.add(v);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	} 
	
	
	public static Vehicle getRecordById(int id){  
	    Vehicle v=null;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from Vehicles where id=?");  
	        ps.setInt(1,id);  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            v=new Vehicle();  
	            
	            v.setId(rs.getInt("id"));  
	            v.setModel(rs.getString("model_name"));      
	            v.setMake(rs.getString("manufacturer_name")); 
	            v.setCategory(rs.getString("category"));  
	            v.setAddedOn(rs.getDate("add_date"));   
	            v.setStatus(rs.getString("status"));  
	            v.setBought(rs.getString("buying_price")); 
	            v.setSoldOn(rs.getDate("sold_date")); 
	            v.setImage(rs.getString("image")); 
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return v;  
	}  
	
	public static int delete(int id){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("delete from vehicles where vehicle_id= " + id);    
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	  
	    return status;  
	} 
	
	
}  




