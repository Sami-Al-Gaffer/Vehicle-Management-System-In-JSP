<%@ page import ="UserCrud.ModelInformation" %>
<%@ page import ="Beans.Model" %>



<%

String fn = request.getParameter("modelName");
String manufactuer_id = request.getParameter("manufacturer_id");
String d = request.getParameter("description");

int m = Integer.parseInt(manufactuer_id);




Model u = new Model();
u.setModelName(fn);
u.setManufacturerId(m);
u.setDescription(d);



int i = ModelInformation.save(u);
if(i>0){  
response.sendRedirect("add_model.jsp");  
}else{  
response.sendRedirect("dashboard.jsp");  
} 

%>