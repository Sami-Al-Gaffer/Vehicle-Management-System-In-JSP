<%@ page import ="UserCrud.UserInformation,java.text.DateFormat" %>
<%@ page import ="Beans.User,java.util.Date, java.text.SimpleDateFormat" %>



<%

String fn = request.getParameter("firstName");
String ln = request.getParameter("lastName");
String email = request.getParameter("email");
String password = request.getParameter("password");
String position = request.getParameter("position");
String mobile = request.getParameter("mobile");
String address = request.getParameter("address");
String birthDate = request.getParameter("birthDate");
String gender = request.getParameter("gender");
String userType = request.getParameter("userType");

DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
Date myDate = formatter.parse(birthDate);

User u = new User();
u.setFirstName(fn);
u.setLastName(ln);
u.setEmail(email);
u.setPassword(password);
u.setPosition(position);
u.setMobile(mobile);
u.setAddress(address);
u.setBirthDate(myDate);
u.setGender(gender);
u.setUserType(userType);


int i = UserInformation.save(u);
if(i>0){  
response.sendRedirect("all_employee.jsp");  
}else{  
response.sendRedirect("dashboard.jsp");  
} 

%>