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

		
		<header>
			<div class="container">
				<div class="header-data">
					<div class="logo">
						<a href="Home" title=""><img src="images/logooo.png" alt=""></a>
					</div><!--logo end-->
					
					<div class="search-bar">
						<form action="SearchUser" method="post">
							<input type="text" name="search" placeholder="Search...">
							<button type="submit"><i class="la la-search"></i></button>
						</form>
					</div><!--search-bar end-->
					<nav>
						<ul>
							<li>
								<a href="Home" title="">
									<span><img src="images/icon1.png" alt=""></span>
									Home
								</a>
							</li>
							<li>
								
									<a href="SearchUser" title="">
										<span><img src="images/icon4.png" alt=""></span>
										Profiles</a>
							</li>
								
							<li>
								<a href="NewFeed" title="">
									<span><img src="images/icon3.png" alt=""></span>

									News Feed
								</a>
							</li>
							<li>

								<a href="UserProfile" title="">
									<span><img src="images/icon110.png" alt=""></span>
									My profile</a>
								
							</li>
							

						
						</ul>
					</nav><!--nav end-->
					<div class="menu-btn">
						<a href="#" title=""><i class="fa fa-bars"></i></a>
					</div><!--menu-btn end-->
					<div class="user-account">
						<div class="user-info">
							<img src="images/<%=auth.getImage() %>" alt="" width="30px" height="30px" style=" border-radius: 50%; overflow: hidden;">
							<a href="#" title=""><%=auth.getName() %></a>
							<i class="la la-sort-down"></i>
						</div>
						<div class="user-account-settingss">


							<h3>Setting</h3>
							<ul class="us-links">
								<li><a href="Setting" title="">Account Setting</a></li>
								<li><a href="Terms.jsp" title="">Terms & Conditions</a></li>
								<li><a href="About.jsp" title="">About</a></li>
							</ul>
							<h3 class="tc"><a href="Logout" title="">Logout</a></h3>
						</div><!--user-account-settingss end-->
					</div>
				</div><!--header-data end-->
			</div>
		</header><!--header end-->