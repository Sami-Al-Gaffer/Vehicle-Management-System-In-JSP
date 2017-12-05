<%@ page import ="UserCrud.ManufacturerInformation" %>
<%@ page import ="Beans.Manufacturer" %>



<%

String fn = request.getParameter("manufacturerName");



Manufacturer m = new Manufacturer();
m.setManufacturerName(fn);



int i = ManufacturerInformation.save(m);
if(i>0){  
response.sendRedirect("add_manufacturer.jsp");  
}//else{  
//response.sendRedirect("dashboard.jsp");  
//} 

%>