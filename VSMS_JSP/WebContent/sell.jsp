<%@ page import ="UserCrud.CustomerInformation,java.text.DateFormat" %>
<%@ page import ="Beans.Customer,java.util.Date, java.text.SimpleDateFormat" %>



<%

String id = request.getParameter("vehicle_id");
int vehicle_id = Integer.parseInt(id);
String fn = request.getParameter("cf_name");
String ln = request.getParameter("cl_name");
String email = request.getParameter("c_email");

String payment_type = request.getParameter("payment_type");

String selling_price = request.getParameter("selling_price");
double sell = Double.parseDouble(selling_price);
String mobile = request.getParameter("c_mobile");
String address = request.getParameter("c_address");

String wDate = request.getParameter("w_start");
DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
Date wDate1 = formatter.parse(wDate);

String wEnd = request.getParameter("w_end");
DateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
Date wEnd1 = formatter1.parse(wEnd);

Customer u = new Customer();
u.setVehicleId(vehicle_id);
u.setCfName(fn);
u.setClName(ln);
u.setCEmail(email);
u.setPaymentType(payment_type);

u.setSellingPrice(sell);
u.setCMobile(mobile);
u.setCAddress(address);
u.setWStart(wDate1);
u.setWEnd(wEnd1);



int i = CustomerInformation.save(u);
if(i>0){  
response.sendRedirect("all_vehicles.jsp");  
}else{  
response.sendRedirect("dashboard.jsp");  
} 

%>