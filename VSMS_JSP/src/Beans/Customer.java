package Beans;

import java.util.Date;

public class Customer {
	private int vehicle_id,c_id,invoice_id;
	private String cf_name,cl_name,c_email,c_mobile,nid;
	private String c_pass,c_address,payment_type;
	private Date  w_start,w_end;
	private double selling_price;

	public int getVehicleId() {
		return vehicle_id;
	}
	public void setVehicleId(int id) {
		this.vehicle_id = id;
	}
	
	public int getCustomerId() {
		return c_id;
	}
	public void setCustomerId(int id1) {
		this.c_id = id1;
	}
	
	public int getInvoiceId() {
		return invoice_id;
	}
	public void setInvoiceId(int id2) {
		this.invoice_id = id2;
	}
	public String getCfName() {
		return cf_name;
	}
	public void setCfName(String fn) {
		this.cf_name = fn;
		
	}
	
	public String getClName() {
		return cl_name;
	}
	
	public void setClName(String ln) {
		this.cl_name = ln;
	}
	public String getCPassword() {
		return c_pass;
	}
	public void setPassword(String password) {
		this.c_pass = password;
	}
	public String getCEmail() {
		return c_email;
	}
	public void setCEmail(String email) {
		this.c_email = email;
	}
	
	public String getCMobile() {
		return c_mobile;
	}
	public void setCMobile(String mob) {
		this.c_mobile = mob;
	}
	
	public String getNId() {
		return nid;
	}
	public void setNId(String pos) {
		this.nid = pos;
	}
	public Date getWStart() {
		return w_start;
	}
	public void setWStart(Date bd) {
		this.w_start = bd;
	}
	
	public Date getWEnd() {
		return w_end;
	}
	public void setWEnd(Date d) {
		this.w_end = d;
	}
	
	public String getPaymentType() {
		return payment_type;
	}

	public void setPaymentType(String us) {
		this.payment_type = us;
	}
	public String getCAddress() {
		return c_address;
	}
	public void setCAddress(String add) {
		this.c_address = add;
	}
	
	public double getSellingPrice() {
		return selling_price;
	}
	public void setSellingPrice(double s) {
		this.selling_price = s;
	}

	}

