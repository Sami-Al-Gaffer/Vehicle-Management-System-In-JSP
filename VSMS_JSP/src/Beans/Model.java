
package Beans;

public class Model {
    
    private int id,manufacturer_id;
    private String modelName,manufacturerName,description;
    

    
    public int getId(){
        return this.id;
    }
    
    public void setManufacturerId(int id) {
    	this.manufacturer_id = id;
    }
    
    public int getManufacturerId(){
        return this.manufacturer_id;
    }
    
    public void setId(int id) {
    	this.id = id;
    }
    

    public String getModelName(){
        return this.modelName;
    }
    public void setModelName(String modN) {
    	this.modelName = modN;
    }
    
    
    public String getManufacturerName(){
        return this.manufacturerName;
    }
    public void setManufacturerName(String mn) {
    	this.manufacturerName = mn;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String d) {
    	this.description = d;
    }
    
    

    
}
