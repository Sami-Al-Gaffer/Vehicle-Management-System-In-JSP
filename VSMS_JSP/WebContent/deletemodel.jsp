<%@page import="UserCrud.ModelInformation " %>  

<%  
String id = request.getParameter("id");  

int i = ModelInformation.delete(Integer.parseInt(id)); 
if(i>0){
response.sendRedirect("add_model.jsp");  
}
%>  