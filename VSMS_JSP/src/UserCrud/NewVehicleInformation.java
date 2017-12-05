package UserCrud;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import Beans.NewVehicle;

public class NewVehicleInformation {
	
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
	public static int save(NewVehicle u) {
		int status = 0;

		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("insert into vehicles(manufacturer_id,model_id,category,buying_price,selling_price,mileage,color,add_date,sold_date,status,registration_year,insurance_id,user_id,gear,doors,seats,tank,image,engine_no,chesis_no,featured) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");  

		    ps.setInt(1, u.getManufacturerId());
			ps.setInt(2, u.getModelId());
			ps.setString(3, u.getCategory());
			ps.setDouble(4, u.getBuyingPrice());
			ps.setNull(5, java.sql.Types.NULL);
			ps.setInt(6, u.getMileage());
			ps.setString(7, u.getColor());
			
			ps.setDate(8, new Date(u.getAddDate().getTime()));
			ps.setNull(9, java.sql.Types.NULL);
			ps.setString(10, "available");
			
			ps.setInt(11, u.getRegistrationYear());
			ps.setInt(12, u.getInsuranceId());
			ps.setInt(13, u.getUserId());
			ps.setString(14, u.getGear());
			ps.setInt(15, u.getDoors());
			ps.setInt(16, u.getSeats());
			ps.setInt(17, u.getTank());
			ps.setString(18,u.getImage());
			ps.setInt(19, u.getEngineNo());
			ps.setInt(20, u.getChassisNo());
			ps.setInt(21, u.getFeatured());
			
			
			status= ps.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e);
			
		}
		return status;
	}

}
