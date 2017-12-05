package Beans;

import java.util.Date;

public class Sold {
	 private int c_id,insurance_id,engine_no,vehicle_id;
	    private String cf_name,cl_name,c_email,c_mobile,manufacturer_name,model_name;
	    private double buying_price,selling_price,profit;
	    private Date w_start,w_end;
	    
		public int getVehicleId() {
			return vehicle_id;
		}
		
		public void setVehicleId(int vd) {
			this.vehicle_id = vd;
		}
	    
	    public int getCId() {
	    	return c_id;
	    }
	    public void setCId(int id) {
	    	this.c_id= id;
	    }
	    
	    public String getCfName(){
	         return cf_name;
	     }
	    
	    public void setCfName(String cf) {
	    	this.cf_name= cf;
	    }
	    
	    public String getClName(){
	         return cl_name;
	     }
	    
	    public void setClName(String cl) {
	    	this.cl_name= cl;
	    }
	    
	    public String getCEmail(){
	         return this.c_email;
	     }
	    
	    public void setCEmail(String email) {
	    	this.c_email= email;
	    }
	    
	    public String getCMobile(){
	         return this.c_mobile;
	     }
	    
	    public void setCMobile(String mobile) {
	    	this.c_mobile= mobile;
	    }
	   
	    
	    
	     public String getManufacturerName(){
	         return manufacturer_name;
	     }
	     
	     public void setManufacturerName(String ma) {
		    	this.manufacturer_name= ma;
		    }
	     
	     
	     public String getModelName(){
	         return model_name;
	     }
	     
	     public void setModelName(String mo) {
		    	this.model_name= mo;
		    }
	    

	     public double getBuyingPrice(){
	         return buying_price;
	     }
	     public void setBuyingPrice(double bp){
	         this.buying_price= bp;
	     }
	     
	     public double getSellingPrice(){
	         return selling_price;
	     }
	     public void setSellingPrice(double sp){
	         this.selling_price= sp;
	     }
	     
	     public double getProfit(){
	         return profit;
	     }
	     public void setProfit(double p){
	         this.profit= p;
	     }
	     
	     
	     public Date getWarrantyEnd(){
	         return w_end;
	     }
	     public void setWarrantyEnd(Date we){
	         this.w_end= we;
	     }
	     
	     public Date getWarrantyStart(){
	         return w_start;
	     }
	     public void setWarrantyStart(Date ws){
	         this.w_start= ws;
	     }
	     
	     public int getInsuranceId(){
	            return insurance_id;
	        }
	     
	     public void setInsuranceId(int in) {
	    	 this.insurance_id = in;
	     }
	     
	     public int getEngineNo() {
	    	 return engine_no;
	     }
	     public void setEngineNo(int en) {
	    	 this.engine_no = en;
	     }
	    
	        
	        
	}
