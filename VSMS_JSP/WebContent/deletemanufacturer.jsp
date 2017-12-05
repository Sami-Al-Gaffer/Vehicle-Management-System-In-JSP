<%@page import="UserCrud.ManufacturerInformation " %>  

<%  
String id = request.getParameter("id");  

int i = ManufacturerInformation.delete(Integer.parseInt(id)); 
if(i>0){
response.sendRedirect("add_manufacturer.jsp");  
}
%>  