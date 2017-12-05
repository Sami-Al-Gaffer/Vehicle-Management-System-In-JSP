<%@page import="UserCrud.VehicleInformation " %>  

<%  
String id = request.getParameter("id");  
int d =Integer.parseInt(id);

int i = VehicleInformation.delete(d); 
if(i>0){
response.sendRedirect("all_vehicles.jsp");  
}
%>  