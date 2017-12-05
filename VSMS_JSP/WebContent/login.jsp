<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.sql.*" %>

<%!
int userdbId;
String userdbEmail;
String userdbPsw;
String userdbName;
String userdbAccess;


%>
<%
    try{
        String email = request.getParameter("email");   
        String password = request.getParameter("password");
        
        if((!(email.equals(null) || email.equals("")) && !(password.equals(null) || password.equals("")))){
			    
        			Class.forName("com.mysql.jdbc.Driver"); // MySQL database connection
			        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vsms","root","");   
			        PreparedStatement pst = conn.prepareStatement("Select * from users where email=? and password=?");
			        pst.setString(1, email);
			        pst.setString(2, password);
			        ResultSet rs = pst.executeQuery();                        
			        if(rs.next()) {   
			        	
			        	userdbEmail = rs.getString("email");
			        	userdbPsw = rs.getString("password");
			        	userdbName = rs.getString("first_name");
			        	userdbAccess = rs.getString("type");
			        	userdbId = rs.getInt("id");
			        	
			        	if(email.equals(userdbEmail) && password.equals(userdbPsw) && userdbAccess.equals("Admin")){
						session.setAttribute("name",userdbName);
						session.setAttribute("accesss", userdbAccess);
						session.setAttribute("Id", userdbId);
			        	response.sendRedirect("dashboard.jsp");
			        }
			        	else if(email.equals(userdbEmail) && password.equals(userdbPsw) && userdbAccess.equals("Employee")){
			        		
			        		session.setAttribute("name",userdbName);
							session.setAttribute("accesss", userdbAccess);
							session.setAttribute("Id", userdbId);
				        	response.sendRedirect("dashboard1.jsp");
			        	}else{
			        	session.setAttribute("error"," Invalid Username or Password");
			        	RequestDispatcher rd=request.getRequestDispatcher("index.jsp");            
			        	rd.include(request, response);  
			        }
		}

			        else{
			        	session.setAttribute("error"," Invalid Email or Password...");
			        	RequestDispatcher rd=request.getRequestDispatcher("index.jsp");            
			        	rd.include(request, response);   
			        }
			    }
       
    }
        
   catch(Exception e){       
       out.println("Something went wrong !! Please try again");       
   }      
%>
