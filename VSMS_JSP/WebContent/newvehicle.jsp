<%@ page import ="UserCrud.NewVehicleInformation,java.text.DateFormat" %>
<%@ page import ="Beans.NewVehicle,java.util.Date, java.text.SimpleDateFormat" %>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload" %>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@ page import="org.apache.commons.fileupload.*"%>
<%@ page import="java.util.*, java.io.*" %>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="java.io.File"%>
<%@ page contentType="text/html;charset=UTF-8" %>



<%

			/*String uid = request.getParameter("user_id");
			int u_id = Integer.parseInt(uid);
			
			String man_id1 = request.getParameter("manufacturer_id");
			int manId = Integer.parseInt(man_id1);
			
			
			String mod_id = request.getParameter("model_id");
		    int modId = Integer.parseInt(mod_id);
		    
		
			
			String category = request.getParameter("category");
			String buy = request.getParameter("buying_price");
			double buying = Double.parseDouble(buy);
			
			String gear = request.getParameter("gear");
			String mile = request.getParameter("mileage");
			int mileage = Integer.parseInt(mile);
			
			String eng = request.getParameter("engine_no");
			int engine = Integer.parseInt(eng);
			
			String chas = request.getParameter("chassis_no");
			int chassis = Integer.parseInt(chas);
			
			String addD = request.getParameter("add_date");
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date addDate = formatter.parse(addD);
			
			String dor = request.getParameter("doors");
			int doors = Integer.parseInt(dor);
			
			String ry = request.getParameter("registration_year");
			int regYear = Integer.parseInt(ry);
			
			String ins = request.getParameter("insurance_id");
			int insurance = Integer.parseInt(ins);
			
			String set = request.getParameter("seats");
			int seats = Integer.parseInt(set);
			String color = request.getParameter("color");
			
			String tan = request.getParameter("tank");
			int tank = Integer.parseInt(tan);
			
			String f = request.getParameter("featured");
			int featured = Integer.parseInt(f);*/



String u_id = "",manId ="",modId="",gear="",mileage="",engine = "",chassis  = "",category="",buying="",addDate="";
String image="",itemName="",doors="",regYear="",insurance="",color="",tank="",featured="",seats="";
String path ="C:/Users/SAMI/Documents/VSMS_JSP/WebContent/uploads";




boolean isMultipart = ServletFileUpload.isMultipartContent(request);
if (!isMultipart)
{
	
}
else
{
FileItemFactory factory = new DiskFileItemFactory();
ServletFileUpload upload = new ServletFileUpload(factory);
List items = null;
try
{
items = upload.parseRequest(request);
}
catch (FileUploadException e)
{
e.getMessage();
}
 
Iterator itr = items.iterator();
while (itr.hasNext())
{

FileItem item = (FileItem) itr.next();
if (item.isFormField())
{
String name = item.getFieldName();
String value = item.getString();
if(name.equals("image"))
{
image=value;

}
if(name.equals("user_id")){
	u_id = value;
}

if(name.equals("manufacturer_id")){
	manId = value;
}
if(name.equals("model_id")){
	modId = value;
}
if(name.equals("gear")){
	gear = value;
}
if(name.equals("mileage")){
	mileage = value;
}

if(name.equals("engine_no")){
	engine = value;
}
if(name.equals("chassis_no")){
	chassis = value;
}

if(name.equals("category")){
	category = value;
}
if(name.equals("buying_price")){
	buying = value;
}
if(name.equals("add_date")){
	addDate = value;
}

if(name.equals("doors")){
	doors = value;
}

if(name.equals("registration_year")){
	regYear = value;
}

if(name.equals("user_id")){
	u_id = value;
}
if(name.equals("insurance_id")){
	insurance = value;
}
if(name.equals("color")){
	color = value;
}

if(name.equals("tank")){
	tank = value;
}
if(name.equals("featured")){
	featured = value;
}
if(name.equals("seats")){
	seats = value;
}
 
}
else
{
try
{
itemName = item.getName();
File savedFile = new File(path,itemName);
item.write(savedFile);
}
catch (Exception e)
{
out.println("Error"+e.getMessage());
}
}
}
}


int u_id1 = Integer.parseInt(u_id);
int manId1 = Integer.parseInt(manId);
int modId1 = Integer.parseInt(modId);
double buying1 = Double.parseDouble(buying);
int mileage1 = Integer.parseInt(mileage);
int engine1 = Integer.parseInt(engine);
int chassis1 = Integer.parseInt(chassis);

DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
Date addDate1 = formatter.parse(addDate);

int doors1 = Integer.parseInt(doors);
int regYear1 = Integer.parseInt(regYear);
int insurance1 = Integer.parseInt(insurance);
int seats1 = Integer.parseInt(seats);
int tank1 = Integer.parseInt(tank);
int featured1 = Integer.parseInt(featured);



NewVehicle u = new NewVehicle();
u.setManufacturerId(manId1);
u.setModelId(modId1);
u.setCategory(category);
u.setBuyingPrice(buying1);
u.setGear(gear);
u.setMileage(mileage1);
u.setEngineNo(engine1);
u.setChassisNo(chassis1);
u.setAddDate(addDate1);
u.setDoors(doors1);
u.setRegistrationYear(regYear1);
u.setInsuranceId(insurance1);
u.setSeats(seats1);
u.setColor(color);
u.setTank(tank1);
u.setFeatured(featured1);
u.setImage(itemName);
u.setUserId(u_id1);


		int i = NewVehicleInformation.save(u);
		if(i>0){  
		response.sendRedirect("all_vehicles.jsp");  
		}else{  
		response.sendRedirect("dashboard.jsp");  
		} 

%>