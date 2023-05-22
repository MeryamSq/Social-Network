<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>StarPost_Setting</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="stylesheet" type="text/css" href="css/animate.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/line-awesome.css">
<link rel="stylesheet" type="text/css" href="css/line-awesome-font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/jquery.mCustomScrollbar.min.css">
<link rel="stylesheet" type="text/css" href="lib/slick/slick.css">
<link rel="stylesheet" type="text/css" href="lib/slick/slick-theme.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/responsive.css">
</head>


<body>
	

	<div class="wrapper">
	<jsp:include page="WEB-INF/include/header.jsp" /> 
	<section class="profile-account-setting">
			<div class="container">
				<div class="account-tabs-setting">
					<div class="row">
						<div class="col-lg-3">
							<div class="acc-leftbar">
								<div class="nav nav-tabs" id="nav-tab" role="tablist">
								    <a class="nav-item nav-link active" id="nav-acc-tab" data-toggle="tab" href="#nav-acc" role="tab" aria-controls="nav-acc" aria-selected="true"><i class="la la-cogs"></i>Change information</a>

								    <a class="nav-item nav-link" id="nav-password-tab" data-toggle="tab" href="#nav-password" role="tab" aria-controls="nav-password" aria-selected="false"><i class="fa fa-lock"></i>Change Password</a>

								  </div>
							</div><!--acc-leftbar end-->
						</div>
						<div class="col-lg-9">
						
							<div class="tab-content" id="nav-tabContent">
							<%
				if(request.getAttribute("pmsg") != null){
					%>
					<div  class="alert alert-info" role="alert">
					  <%=request.getAttribute("pmsg")%>
					  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
					    <span aria-hidden="true">&times;</span>
					  </button>
					</div>
					<%
				}
			%>
								<div class="tab-pane fade show active" id="nav-acc" role="tabpanel" aria-labelledby="nav-acc-tab">
									<div class="acc-setting">
										<h3>Account Setting</h3>
										<form action="Setting" method="post">
										<input type="text" name="setting" value="info" hidden>
											<div class="cp-field">
												<h5>Username</h5>
												<div class="cpp-fiel">
													<input type="text" name="username" placeholder="Username" required>
													<i class="fa fa-user"></i>
												</div>
											</div>
											<div class="cp-field">
												<h5>Email</h5>
												<div class="cpp-fiel">
													<input type="text" name="email" placeholder="Email" required>
													<i class="fa fa-envelope"></i>
												</div>
											</div>
											<div class="cp-field">
												<h5>Contact</h5>
												<div class="cpp-fiel">
													<input type="text" name="number" placeholder="Phone Number" required>
													<i class="fa fa-phone"></i>
												</div>
											</div>

											<div class="save-stngs pd2">
												<ul>
													<li><button type="submit" >Save Setting</button></li>
													
												</ul>
											</div><!--save-stngs end-->
										</form>
									</div><!--acc-setting end-->
								</div>
							
							  	<div class="tab-pane fade" id="nav-password" role="tabpanel" aria-labelledby="nav-password-tab">
							  		<div class="acc-setting">
										<h3>Account Setting</h3>
										<form action="Setting" method="post">
										<input type="text" name="setting" value="password" hidden>
											<div class="cp-field">
												<h5>Old Password</h5>
												<div class="cpp-fiel">
													<input type="text" name="oldPassword" placeholder="Old Password">
													<i class="fa fa-lock"></i>
												</div>
											</div>
											<div class="cp-field">
												<h5>New Password</h5>
												<div class="cpp-fiel">
													<input type="text" name="password" placeholder="New Password">
													<i class="fa fa-lock"></i>
												</div>
											</div>
											<div class="cp-field">
												<h5>Repeat Password</h5>
												<div class="cpp-fiel">
													<input type="text" name="cpassword" placeholder="Repeat Password">
													<i class="fa fa-lock"></i>
												</div>
											</div>
											
											<div class="save-stngs pd2">
												<ul>
													<li><button type="submit">Save Setting</button></li>
													
												</ul>
											</div><!--save-stngs end-->
										</form>
									</div><!--acc-setting end-->
							  	</div>

							</div>
						</div>
					</div>
				</div><!--account-tabs-setting end-->
			</div>
		</section>



		<footer>
			<div class="footy-sec mn no-margin">
				<div class="container">
					<ul>
						<li><a href="#" title="">Help Center</a></li>
						<li><a href="#" title="">Privacy Policy</a></li>
						<li><a href="#" title="">Community Guidelines</a></li>
						<li><a href="#" title="">Cookies Policy</a></li>
						<li><a href="#" title="">Career</a></li>
						<li><a href="#" title="">Forum</a></li>
						<li><a href="#" title="">Language</a></li>
						<li><a href="#" title="">Copyright Policy</a></li>
					</ul>
					<p><img src="images/copy-icon2.png" alt="">Copyright 2018</p>
					<img class="fl-rgt" src="images/logo2.png" alt="">
				</div>
			</div>
		</footer>

	</div><!--theme-layout end-->



<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/popper.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.mCustomScrollbar.js"></script>
<script type="text/javascript" src="lib/slick/slick.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>


</body>
</html>

</body>
</html>