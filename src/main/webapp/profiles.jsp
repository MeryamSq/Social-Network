<%@page import="dao.*"%>
<%@page import="entities.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
User auth = (User) request.getSession().getAttribute("currentUser");
if (auth != null) {
    request.setAttribute("currentUser", auth);
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>StarPost_Search</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="stylesheet" type="text/css" href="css/animate.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/flatpickr.min.css">
<link rel="stylesheet" type="text/css" href="css/line-awesome.css">
<link rel="stylesheet" type="text/css" href="css/line-awesome-font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="lib/slick/slick.css">
<link rel="stylesheet" type="text/css" href="lib/slick/slick-theme.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/responsive.css">

<style>
.my-button {
  border: none;
  background-color: #FFFFFF;
  color: #333;
  font-size: 18px;
  padding: 10px 20px;
  border-radius: 4px;
  cursor: pointer;
}
.green{
 
  color: #FFFFFF;
  background-color: #00D100;
 
}
.gris{
 
  color: #000000;
  background-color: #C0C0C0;
 
}

.my-button:hover {

  background-color: #ddd;
}

.my-button:focus {
  outline: none;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
}</style>
</head>
<body>
<div class="wrapper">
<jsp:include page="WEB-INF/include/header.jsp" /> 	
		<div class="search-sec">
			<div class="container">
				<div class="search-box">
					<form action="SearchUser" method="post">
						<input type="text" name="search" placeholder="Search keywords" autocomplete="off">
						<button type="submit">Search</button>
					</form>
				</div><!--search-box end-->
			</div>
		</div><!--search-sec end-->

		<section class="companies-info">
			<div class="container">

				<div class="companies-list">
					<div class="row">
					<%
						ArrayList<User> users = (ArrayList<User>) request.getAttribute("users");
						
						if(users.size() == 0){
							%>
							<h4 style=" text-align: center; color: #000;font-size: 30px;">No result.</h4>
							<%
						}
						else{
						
						for(int i=0; i<users.size(); i++){
							%>
						<div class="col-lg-3 col-md-4 col-sm-6">
							<div class="company_profile_info">
								<div class="company-up-info">
									<img src="images/<%=users.get(i).getImage()%>" alt="" width="90px" height="90px" style=" border-radius: 50%; overflow: hidden;">
									<h3><%=users.get(i).getName() %></h3>
									<form action="Follow" method="post">
									<input type="text" name="follow" value=<%=users.get(i).getIduser()%> hidden>
									<% 
									FollowDao f=new FollowDao();
									boolean exist=new FollowDao().existFOllow(auth.getIduser(), users.get(i).getIduser());
									if(exist){
									%>
									
									<ul>
									
									<li><button class=" my-button gris" type="submit">Followed</button></li>
									
									</ul>
									<%}
									else if(!exist){%>
										<ul>
									
									<li><button class=" my-button green "  type="submit">Follow</button></li>
									
									</ul><%} %>
									
									
									</form>
								</div>
								<form action="Profil" method="post">
								<input type="text" name="userprofil" value=<%=users.get(i).getIduser()%> hidden>
								<button class=" my-button toggle-comments" data-comments="" type="submit">View Profile</button>
								</form>
								
							</div><!--company_profile_info end-->
						</div><%}} %>


					</div>
				</div><!--companies-list end-->
				<div class="process-comm">
					<div class="spinner">
						<div class="bounce1"></div>
						<div class="bounce2"></div>
						<div class="bounce3"></div>
					</div>
				</div><!--process-comm end-->
			</div>
		</section><!--companies-info end-->


	</div><!--theme-layout end-->



<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/popper.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/flatpickr.min.js"></script>
<script type="text/javascript" src="lib/slick/slick.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
</body>
</html>