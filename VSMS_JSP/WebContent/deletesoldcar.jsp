<%@page import="UserCrud.SoldInformation " %>  

<%  
String id = request.getParameter("vehicle_id");  

int i = SoldInformation.delete(Integer.parseInt(id)); 
if(i>0){
response.sendRedirect("sold_vehicle.jsp");  
}
%>  