package UserCrud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Beans.Sold;

public class SoldInformation {

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
	
	public static int delete(int id){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("delete from vehicles where vehicle_id=" + id);    
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	  
	    return status;  
	} 
	
	public static List<Sold> getAllRecords(){  
	    List<Sold> list=new ArrayList<Sold>();  
	      
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("SELECT customer.c_id,customer.vehicle_id,customer.cf_name,customer.cl_name,customer.c_email,customer.c_mobile,manufacturers.manufacturer_name, models.model_name,vehicles.buying_price,vehicles.selling_price, vehicles.selling_price - vehicles.buying_price as profit, customer.w_start,customer.w_end,vehicles.insurance_id,vehicles.engine_no FROM customer INNER JOIN vehicles on vehicles.vehicle_id = customer.vehicle_id INNER JOIN manufacturers on manufacturers.id = vehicles.manufacturer_id INNER JOIN models on models.id = vehicles.model_id");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            Sold u=new Sold();  
	            u.setCId(rs.getInt("c_id")); 
	            u.setVehicleId(rs.getInt("vehicle_id"));  
	            u.setCfName(rs.getString("cf_name"));  
	            u.setClName(rs.getString("cl_name")); 
	            u.setCEmail(rs.getString("c_email"));  
	            u.setCMobile(rs.getString("c_mobile"));   
	            u.setManufacturerName(rs.getString("manufacturer_name"));  
	            u.setModelName(rs.getString("model_name")); 
	            u.setBuyingPrice(rs.getDouble("buying_price")); 
	            u.setSellingPrice(rs.getDouble("selling_price"));  
	            u.setProfit(rs.getDouble("profit"));
	            u.setWarrantyStart(rs.getDate("w_start"));
	            u.setWarrantyEnd(rs.getDate("w_end"));
	            u.setInsuranceId(rs.getInt("insurance_id")); 
	            u.setEngineNo(rs.getInt("engine_no")); 
	            list.add(u);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	} 
	
}