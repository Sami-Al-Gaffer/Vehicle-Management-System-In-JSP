package Beans;
import java.util.Date;

public class Vehicle {
    private int id;
    private String model,make,category,statuss,bought;
    private String image;
    private Date added_on,sold_on;
    

    public int getId(){
        return id;
    }
    
    public void setId(int id) {
    	this.id = id;
    }
    
    public String getModel(){
        return model;
    }
    
    public void setModel(String mo) {
    	this.model = mo;
    }
    
    
    public String getMake(){
        return make;
    }
    
    public void setMake(String ma) {
    	this.make = ma;
    }
    public String getCategory(){
        return category;
    }
    
    public void setCategory(String ca) {
    	this.category = ca;
    }
        public Date getAddedOn(){
        return added_on;
    }
      public void setAddedOn(Date addD) {
        	this.added_on= addD;
        }
        
    public String getStatus(){
        return statuss;
    }
     
    public void setStatus(String sta) {
    	this.statuss = sta;
    }
    
        public String getBought(){
        return bought;
    }
        
        public void setBought(String bo) {
        	this.bought = bo;
        }
    public Date getSoldOn(){
        return sold_on;
    }
    
    public void setSoldOn(Date sold) {
    	this.sold_on = sold;
    }
    public String getImage(){
        return image;
    }
    public void setImage(String img) {
    	this.image = img;
    }
    
    
    
    
}