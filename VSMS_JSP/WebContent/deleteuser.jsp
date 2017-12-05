<%@page import="UserCrud.UserInformation " %>  

<%  
String id = request.getParameter("id");  

int i = UserInformation.delete(Integer.parseInt(id)); 
if(i>0){
response.sendRedirect("all_employee.jsp");  
}
%>  