<%
    session=request.getSession(false);
if (session.getAttribute("name") == null) {
    response.sendRedirect("/VSMS_JSP");
} 
if(!session.getAttribute("accesss").equals("Admin")) {
    response.sendRedirect("/VSMS_JSP");
}

%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Dashboard | </title>

    <!-- Bootstrap -->
    <link href="vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="vendors/iCheck/skins/flat/green.css" rel="stylesheet">
	
    <!-- bootstrap-progressbar -->
    <link href="vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <!-- JQVMap -->
    <link href="vendors/jqvmap/dist/jqvmap.min.css" rel="stylesheet"/>
    <!-- bootstrap-daterangepicker -->
    <link href="vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
        <!-- Datatables -->
    <link href="vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="build/css/custom.min.css" rel="stylesheet">
  </head>

  <body class="nav-md">
    <div class="container body" Style="min-height:1000px;">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="dashboard.jsp" class="site_title"><i class="fa fa-paw"></i> <span>VSMS IN JSP</span></a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <div class="profile clearfix">
              <div class="profile_pic">
                <img src="images/admin.png" alt="..." class="img-circle profile_img">
              </div>
              <div class="profile_info">
                <span>Welcome,</span>
                <h2>${ sessionScope.name } </h2>
              </div>
            </div>
            <!-- /menu profile quick info -->

            <br />

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                  <li><a href="dashboard.jsp"><i class="fa fa-home"></i> Dashboard </a>
                  </li>
                  <li><a><i class="fa fa-edit"></i> Manage Employee <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="add_employee.jsp">Add Employee</a></li>
                      <li><a href="all_employee.jsp">All Employee</a></li>

                    </ul>
                  </li>
                  <li><a><i class="fa fa-desktop"></i> Manufacturer & Model <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="add_manufacturer.jsp">Add Manufacturer</a></li>
                      <li><a href="add_model.jsp">Add model</a></li>

                    </ul>
                  </li>
                  <li><a><i class="fa fa-table"></i> Vehicles <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="all_vehicles.jsp">All Vehicles</a></li>
                      <li><a href="sold_vehicle.jsp">Sold Vehicles</a></li>
                    </ul>
                  </li>

                </ul>
              </div>
              
              
              

            </div>
            <!-- /sidebar menu -->
            <div class="sidebar-footer hidden-small">
              <a data-toggle="tooltip" data-placement="top" title="Settings">
                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="Lock">
                <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="Logout" href="login.html">
                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
              </a>
            </div>
            <!-- /menu footer buttons -->
          </div>
        </div>

        <!-- top navigation -->
         <div class="top_nav">
          <div class="nav_menu">
            <nav>
              <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
              </div>

              <ul class="nav navbar-nav navbar-right">
                <li class="">
                  <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    <img src="images/admin.png" alt="">${ sessionScope.name }
                    <span class=" fa fa-angle-down"></span>
                  </a>
                  <ul class="dropdown-menu dropdown-usermenu pull-right">
                    <li><a href="logout.jsp"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                  </ul>
                </li>

                
              </ul>
            </nav>
          </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
        <%@page import="UserCrud.ModelInformation , UserCrud.ManufacturerInformation,Beans.Model,Beans.Manufacturer,java.util.*"%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    

              
          <div class="right_col" role="main">
    <div class="">
        <div class="page-title">
            <div class="title_left">
                <h3>Add New Vehicle</h3>
            </div>
        </div>
        <div class="clearfix"></div>
     			 <% 
                	List<Manufacturer> list =ManufacturerInformation.getAllRecords();
					request.setAttribute("list",list);
					%>
					
					<% 
                	List<Model> list1 =ModelInformation.getAllRecords();
					request.setAttribute("list1",list1);
					%>
					
        
        <div class="row">
            <div class=""col-md-12 col-sm-12 col-xs-12"">
            <form action="newvehicle.jsp" method="post" class="form-horizontal form-label-left"  enctype="multipart/form-data" novalidate>
                <fieldset>  
                    <div class="row">
                        <div class="col-xs-6">
                            <label>Vehicle Manufacturer</label>                            
                                <select class="form-control" name="manufacturer_id" id="parent_cat">
                                     <c:forEach items="${list}" var="ma">
                                            <option value="${ma.getId()}" >${ma.getManufacturerName()}</option>
                                   </c:forEach> 
                                </select>
                        </div>
                       
                        
                        <div class="col-xs-6">
                            <label>Vehicle Model</label>
                            <select class="form-control" name="model_id" >
                                <c:forEach items="${list1}" var="mo">
                                            <option value="${mo.getId()}" >${mo.getModelName()}</option>
                                   </c:forEach> 
                            </select>
                        </div>
                         </div>
                    
                            
                    <br>
                        
                    <div class="row">
                        <div class="col-xs-6">
                        <label>Vehicle Category</label>
                            <select class="form-control" name="category" >
                                <option value="Subcompact">Subcompact</option>
                                <option value="Compact">Compact</option>
                                <option value="Mid-size">Mid-size</option>
                                <option value="Full-size">Full-size</option>
                                <option value="Mini-Van">Mini-Van</option>
                            </select>
                        </div>
                        <div class="col-xs-6">
                            <br>
                            <input type="number" step="any" class="form-control" name="buying_price" placeholder="Buying Price" >
                        </div>
                    </div>
                            
                    <br>
                    <div class="row">
                        <div class="col-xs-6">
                            <br>
                            <label for="gear">Gear Type:</label>
                            <select name="gear" id="gear" class="form-control">
                                <option value="Auto">Auto</option>
                                <option value="Manual">Manual</option>
                            </select>
                        </div>
                        <div class="col-xs-6">
                        <br>
                            <label for="mileage">Mileage:</label>
                            <input type="text" step="any" class="form-control" name="mileage" placeholder="Mileage(km)" >
                        </div>
                    </div>
                            
                    <br>
                    <div class="row">
                        <div class="col-xs-6">
                            <br>
                            <input class="form-control" name="engine_no" placeholder="Engine Number" >
                        </div>
                        <div class="col-xs-6">
                            <br>
                            <input class="form-control" name="chassis_no" placeholder="Chassis Number" >
                        </div>
                    </div>
                            
                    <br>
                        
                    <div class="row">
                        <div class="col-xs-6">
                            <label>Add Date</label>
                            <input type="Date"class="form-control" name="add_date"   >
                        </div>
                        <div class="col-xs-6">
                            <br>
                            <input type="number" class="form-control" name="doors" placeholder="No of Doors" >
                        </div>
                    </div>
                            
                    <br>

                    <div class="row">
                        <div class="col-xs-6">
                            <br>
                            <input type="number"class="form-control" name="registration_year" placeholder="Registration Year (YYYY)" >
                        </div>
                        <div class="col-xs-6">
                            <br>
                            <input type="number" class="form-control" name="insurance_id" placeholder="Insurance ID" >
                        </div>
                    </div>
                            
                    <br>

                    <div class="row">
                        <div class="col-xs-6">
                            <input type="number"class="form-control" name="seats" placeholder="No of seats">
                        </div>
                        <div class="col-xs-6">
                            <input type="number" step="any" class="form-control" name="tank" placeholder="Tank Capacity(litters)" >
                        </div>
                    </div>
                    <br>
                            
                    <div class="row">
                        <div class="col-xs-6">
                         <input type="text"class="form-control" name="color" placeholder="Color">
                        </div>
                        <div class="col-xs-6">
                            <input type="file" class="form-control" name="image" >
                        </div>
                    </div>
<br>
                    <div class="row">
                        <div class="col-xs-6">
                        <label for="gear">Featured ?</label>
                            <select name="featured" id="featured" class="form-control">
                                <option value="0">No</option>
                                <option value="1">Yes</option>
                            </select>
                        </div>
                    </div>
                    <input type="hidden"  name="user_id" value="${sessionScope.Id }">
                    <br>
                    <input class="btn btn-primary" type="submit" name="buttonSubmit" value="Add New Vehicle" />
                                                            
                </fieldset>    
                </form>     
        
            <br>
            </div>
        </div>
          </div>
          </div>
          </div>




    <!-- jQuery -->
    <script src="vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="vendors/nprogress/nprogress.js"></script>
    <!-- Chart.js -->
    <script src="vendors/Chart.js/dist/Chart.min.js"></script>
    <!-- gauge.js -->
    <script src="vendors/gauge.js/dist/gauge.min.js"></script>
    <!-- bootstrap-progressbar -->
    <script src="vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
    <!-- iCheck -->
    <script src="vendors/iCheck/icheck.min.js"></script>
    <!-- Skycons -->
    <script src="vendors/skycons/skycons.js"></script>
    <!-- Flot -->
    <script src="vendors/Flot/jquery.flot.js"></script>
    <script src="vendors/Flot/jquery.flot.pie.js"></script>
    <script src="vendors/Flot/jquery.flot.time.js"></script>
    <script src="vendors/Flot/jquery.flot.stack.js"></script>
    <script src="vendors/Flot/jquery.flot.resize.js"></script>
    <!-- Flot plugins -->
    <script src="vendors/flot.orderbars/js/jquery.flot.orderBars.js"></script>
    <script src="vendors/flot-spline/js/jquery.flot.spline.min.js"></script>
    <script src="vendors/flot.curvedlines/curvedLines.js"></script>
    <!-- DateJS -->
    <script src="vendors/DateJS/build/date.js"></script>
    <!-- JQVMap -->
    <script src="vendors/jqvmap/dist/jquery.vmap.js"></script>
    <script src="vendors/jqvmap/dist/maps/jquery.vmap.world.js"></script>
    <script src="vendors/jqvmap/examples/js/jquery.vmap.sampledata.js"></script>
    <!-- bootstrap-daterangepicker -->
    <script src="vendors/moment/min/moment.min.js"></script>
    <script src="vendors/bootstrap-daterangepicker/daterangepicker.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="build/js/custom.min.js"></script>
	
  </body>
</html>
