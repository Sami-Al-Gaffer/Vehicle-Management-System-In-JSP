package Beans;

import java.util.Date;

public class NewVehicle {
	
	private int vehicle_id,manufacturer_id,model_id,mileage,registration_year,
				insurance_id,user_id,doors,seats,tank,engine_no,chassis_no,featured;
	private String category,color,status,gear,image;
	private Date add_date,sold_date;
	private double buying_price,selling_price;
	
	public int getVehicleId() {
		return vehicle_id;
	}
	
	public void setVehicleId(int vd) {
		this.vehicle_id = vd;
	}
	
	public int getManufacturerId() {
		return manufacturer_id;
	}
	
	public void setManufacturerId(int mand) {
		this.manufacturer_id = mand;
	}
	
	public int getModelId() {
		return model_id;
	}
	
	public void setModelId(int md) {
		this.model_id = md;
	}
	
	public int getMileage() {
		return mileage;
	}
	
	public void setMileage(int mg) {
		this.mileage = mg;
	}
	
	public int getRegistrationYear() {
		return registration_year;
	}
	
	public void setRegistrationYear(int ry) {
		this.registration_year = ry;
	}
	
	public int getInsuranceId() {
		return insurance_id;
	}
	
	public void setInsuranceId(int ind) {
		this.insurance_id = ind;
	}
	
	public int getUserId() {
		return user_id;
	}
	
	public void setUserId(int ud) {
		this.user_id = ud;
	}
	
	public int getDoors() {
		return doors;
	}
	
	public void setDoors(int d) {
		this.doors = d;
	}
	
	public int getSeats() {
		return seats;
	}
	
	public void setSeats(int s ) {
		this.seats = s;
	}
	
	public int getTank() {
		return tank;
	}
	
	public void setTank(int t) {
		this.tank = t;
	}
	
	public int getEngineNo() {
		return engine_no;
	}
	
	public void setEngineNo(int e) {
		this.engine_no = e;
	}
	
	public int getChassisNo() {
		return chassis_no;
	}
	
	public void setChassisNo(int c) {
		this.chassis_no = c;
	}
	
	public int getFeatured() {
		return featured;
	}
	
	public void setFeatured(int f) {
		this.featured = f;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String ca) {
		this.category = ca;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String  co) {
		this.color = co;
	}
	
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String  st) {
		this.status = st;
	}
	
	public String getGear() {
		return gear;
	}
	
	public void setGear(String  g) {
		this.gear = g;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String  img) {
		this.image = img;
	}
	
	public Date getAddDate() {
		return add_date;
	}
	
	public void setAddDate(Date  ad) {
		this.add_date = ad;
	}
	
	public Date getSoldDate() {
		return sold_date;
	}
	
	public void setSoldDate(Date  sd) {
		this.sold_date = sd;
	}
	
	public double getBuyingPrice() {
		return buying_price;
	}
	
	public void setBuyingPrice(double  bp) {
		this.buying_price = bp;
	}
	
	public double getSellingPrice() {
		return selling_price;
	}
	
	public void setSellingPrice(double  sp) {
		this.selling_price = sp;
	}
	
	

}
