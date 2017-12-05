package UserCrud;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Beans.Customer;
import Beans.User;

public class CustomerInformation {
	
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
	public static int save(Customer u) {
		int status = 0;

		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("insert into customer(vehicle_id,cf_name,cl_name,c_email,c_mobile,nid,w_start,w_end,payment_type,invoice_id,c_address,c_pass,extra) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");  

		    ps.setInt(1, u.getVehicleId());
			ps.setString(2, u.getCfName());
			ps.setString(3, u.getClName());
			ps.setString(4, u.getCEmail());
			ps.setString(5, u.getCMobile());
			ps.setNull(6, java.sql.Types.NULL);
			
			ps.setDate(7, new Date(u.getWStart().getTime()));
			ps.setDate(8, new Date(u.getWEnd().getTime()));
			ps.setString(9, u.getPaymentType());
			ps.setNull(10, java.sql.Types.NULL);
			
			ps.setString(11, u.getCAddress());
			ps.setString(12, "1234");
			ps.setNull(13, java.sql.Types.NULL);
			
			
			status=ps.executeUpdate();
			
			int id = u.getVehicleId();
			PreparedStatement pst = con.prepareStatement("update vehicles set selling_price = ?,sold_date = ?,status = ? where vehicle_id = "+ id);
			
			pst.setDouble(1, u.getSellingPrice());
			pst.setDate(2, new Date(u.getWStart().getTime()));
			pst.setString(3, "sold");
			status= pst.executeUpdate();
			
			
			
		}catch(Exception e) {
			System.out.println(e);
			
		}
		return status;
	}
	
	public static List<User> getAllRecords(){  
	    List<User> list=new ArrayList<User>();  
	      
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from users");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            User u=new User();  
	            u.setId(rs.getInt("id"));  
	            u.setFirstName(rs.getString("first_name"));  
	            u.setLastName(rs.getString("last_name")); 
	            u.setPassword(rs.getString("password"));  
	            u.setEmail(rs.getString("email"));   
	            u.setMobile(rs.getString("mobile"));  
	            u.setPosition(rs.getString("position")); 
	            u.setGender(rs.getString("gender")); 
	            u.setUserType(rs.getString("type"));  
	            u.setAddress(rs.getString("address"));
	            u.setBirthDate(rs.getDate("birthday"));
	            list.add(u);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	} 

}
