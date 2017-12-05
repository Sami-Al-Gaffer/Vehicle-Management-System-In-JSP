package UserCrud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Beans.User;

public class UserInformation {

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
	public static int save(User u) {
		int status = 0;

		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("insert into users(password,email,position,gender,type,mobile,address,last_name,first_name,birthday) values(?,?,?,?,?,?,?,?,?,?)");  

		    ps.setString(1, u.getPassword());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPosition());
			ps.setString(4, u.getGender());
			ps.setString(5, u.getUserType());
			ps.setString(6, u.getMobile());
			ps.setString(7, u.getAddress());
			ps.setString(8, u.getLastName());
			ps.setString(9, u.getFirstName());
			ps.setDate(10, new Date(u.getBirthDate().getTime()));
			
			
			status= ps.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e);
			
		}
		return status;
	}
	
	public static int update(User u){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement(  
	"update users set password=?,email=?,position=?,gender=?,type =?,mobile =?,address =?,last_name =?,first_name =?,birthday =? where id=?");  
	        
		    ps.setString(1, u.getPassword());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPosition());
			ps.setString(4, u.getGender());
			ps.setString(5, u.getUserType());
			ps.setString(6, u.getMobile());
			ps.setString(7, u.getAddress());
			ps.setString(8, u.getLastName());
			ps.setString(9, u.getFirstName());
			
			ps.setDate(10, new Date(u.getBirthDate().getTime()));
			ps.setInt(11, u.getId());
			
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    
	    return status;  
	}  
	
	
	public static int delete(int id){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("delete from users where id=" + id);    
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	  
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
	
	
	public static User getRecordById(int id){  
	    User u=null;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from users where id=?");  
	        ps.setInt(1,id);  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            u=new User();  
	            u.setId(rs.getInt("id"));  
	            u.setFirstName(rs.getString("first_name"));  
	            u.setLastName(rs.getString("last_name")); 
	            u.setPassword(rs.getString("password"));  
	            u.setEmail(rs.getString("email"));   
	            u.setMobile(rs.getString("mobile"));  
	            u.setPosition(rs.getString("position")); 
	            u.setGender(rs.getString("gender")); 
	            u.setUserType(rs.getString("type")); 
	            u.setBirthDate(rs.getDate("birthday"));
	            u.setAddress(rs.getString("address"));
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return u;  
	}  
	
	
}  


