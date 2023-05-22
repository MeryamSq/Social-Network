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
<title>StarPost_New Feed</title>
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
<style>

.red{
	color: red;
	
}
.label-file {
    cursor: pointer;
    color: #000000;
    font-weight: bold;
}
.label-file:hover {
    color: #e44d3a;
}
.my-button {
  border: none;
  background-color: #FFFFFF;
  color: #333;
  font-size: 16px;
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
}

.sort-buttons {
   
 
  margin-bottom: 10px;
}

.sort-buttons button {
  background-color: #fff;
  color: #333;
  border: 2px solid #333;
  padding: 10px 20px;
  font-size: 18px;
  font-weight: bold;
  margin-right: 10px;
   margin-bottom: 10px;
  cursor: pointer;
  transition: all 0.2s ease-in-out;
  width:200px;
}

.sort-buttons button:hover {
  background-color: #333;
  color: #fff;
}
</style>
</head>




<body>
	

	<div class="wrapper">
		


		<jsp:include page="WEB-INF/include/header.jsp" /> 
		<main>
			<div class="main-section">
				<div class="container">
					<div class="main-section-data">
						<div class="row justify-content-center">
							
							
							<div class="col-lg-6 col-md-8 no-pd">
								<div class="main-ws-sec">
					
									<div class="posts-section">
						<%
						ArrayList<Integer> followings=new FollowDao().getFollowing(auth.getIduser());
						ArrayList<Post> posts = new ArrayList<Post>();
						for(int k=0;k<followings.size();k++){
							ArrayList<Post> post = new ArrayList<Post>();
							post=new PostDao().getUserPost(followings.get(k));
							posts.addAll(post);
						}
						
						if(posts.size() == 0){
							%>
							<h4 style="text-align: center; color: #000000;font-size: 20px;">No Posts.</h4>
							<%
						}
						else{
						
							for(int i=0; i<posts.size(); i++){
								%>
											<div class="posty" style="margin-bottom: 30px">
												<div class="post-bar no-margin">
													<div class="post_topbar">
														<div class="usy-dt">
														<img src="images/<%=new UserImpl().finById(posts.get(i).getId_user()).getImage() %>" alt="" width="50px" height="50px" style=" border-radius: 50%; overflow: hidden;">
															<div class="usy-name">
																<h3><%= new UserImpl().finById(posts.get(i).getId_user()).getName()%></h3>
																<span><img src="images/clock.png" alt=""><%=new PostDao().PostTime(posts.get(i).getId_post()) %></span>
															</div>
														</div>
														
													</div>

													<div class="job_descp">
														<h3><%=posts.get(i).getDesc() %></h3>
														<img src="images/<%=posts.get(i).getBody() %>" alt="" height="300px" width=500px>

									
													</div>
													<div class="job-status-bar">
														<ul class="like-com">
														
														<%
														
														boolean islike=new LikeDao().existLike(posts.get(i).getId_post(), auth.getIduser());
														if(islike){
															
															%> 
															<li>
															<form action="AddLike" method="post">
															<input type="text" value="feed" name="source" hidden>
																 <input name="id_post" value=<%=posts.get(i).getId_post()%> hidden>
																<button class="my-button" type="submit">
																  <i class="fa fa-heart red"></i> 
																</button><%=posts.get(i).getNbr_like() %> Like
																</form>
															</li> <%}
														else if (!islike){%>
														<li>
															<form action="AddLike" method="post">
															<input type="text" value="feed" name="source" hidden>
																 <input name="id_post" value=<%=posts.get(i).getId_post() %> hidden>
																<button class="my-button" type="submit">
																  <i class="fa fa-heart"></i> 
																</button><%=posts.get(i).getNbr_like() %> Like
																</form>
															</li> 
														<%} %>
															<li>
															<button class=" my-button toggle-comments" data-comments="comments<%=posts.get(i).getId_post() %>"><i class="fa fa-comments"></i></button><%=posts.get(i).getNbr_cmt() %> Comment
																
															</li>
														</ul>
														<a class="my-button" data-toggle="modal" data-target="#like<%=posts.get(i).getId_post() %>" >Liked By</a>
													</div>
												</div><!--post-bar end-->
												<div style="display: none;" class="comment-section " id="comments<%=posts.get(i).getId_post() %>" >
			
													<div class="comment-sec ">

														<ul>
													<%
													ArrayList<Comment> comments=new CommentDao().getPostComments(posts.get(i).getId_post());
													for(int j=0; j<comments.size(); j++){
													%>
															
															<li>
																<div class="comment-list">
																	<div class="bg-img">
																<img src="images/<%=new UserImpl().finById(comments.get(j).getId_user()).getImage() %>" alt="" width="40px" height="40px" style=" border-radius: 50%; overflow: hidden;">

																	</div>
																	<div class="comment">
																		<h3><%=new UserImpl().finById(comments.get(j).getId_user()).getName() %></h3>
																		
																		<p><%=comments.get(j).getContenu() %></p>
																		
																	</div>
																</div><!--comment-list end-->
															</li>
														</ul><%} %>
													</div><!--comment-sec end-->
													<div class="post-comment">
														<div class="cm_img">
														<img src="images/<%=auth.getImage() %>" alt="" width="40px" height="40px" style=" overflow: hidden;">

														</div>
														<div class="comment_box">
															<form action="AddComment" method="post">
															<input type="text" value="feed" name="source" hidden>
															    <input name="id_post" value=<%=posts.get(i).getId_post() %> hidden>
																<input type="text" placeholder="Post a comment" name="contenu">
																<button type="submit" >Send</button>
															</form>
														</div>
													</div><!--post-comment end-->
												</div><!--comment-section end-->
											</div><!--posty end-->
											
																						 <!-- Modal -->
												  <div class="modal fade" id="like<%=posts.get(i).getId_post() %>" role="dialog">
												    <div class="modal-dialog">
												    
												      <!-- Modal content-->
												      <div class="modal-content">
												        <div class="modal-header">
												        <h4 class="modal-title">Liked By</h4>
												          <button type="button" class="close" data-dismiss="modal">&times;</button>
												          
												        </div>
												        <div class="modal-body">
												         <%
														ArrayList<Integer> userlikes=new LikeDao().userLike(posts.get(i).getId_post());
														ArrayList<User> usersidlike=new ArrayList<User>();
														for(int r=0;r<userlikes.size();r++){
															User user=new User();
															user=new UserImpl().finById(userlikes.get(r));
															usersidlike.add(user);
														}
														for(User user:usersidlike){%>
															<div class="suggestion-usd">
															<img src="images/<%=user.getImage()%>" alt="" width="40px" height="40px" style=" border-radius: 50%; overflow: hidden;">
															<div class="sgt-text">
																<h4><%=user.getName() %></h4>
																
															</div>
															<span>
									<form action="Follow" method="post">
									<input type="text" name="follow" value=<%=user.getIduser()%> hidden>
									<% 
									FollowDao f=new FollowDao();
									boolean exist=new FollowDao().existFOllow(auth.getIduser(), user.getIduser());
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
														</span>
														</div>
														<%}
											
											
											
														%></div>
												        <div class="modal-footer">
												          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
												        </div>
												      </div>
												      
												    </div>
												  </div>
											
											
											
											
											
											
											
											
											
											
											<%}} %>
											<div class="process-comm">
												<div class="spinner">
													<div class="bounce1"></div>
													<div class="bounce2"></div>
													<div class="bounce3"></div>
												</div>
											</div><!--process-comm end-->
										</div><!--posts-section end-->
								</div><!--main-ws-sec end-->
							</div>
						</div>
						
						</div>
					</div><!-- main-section-data end-->
				</div> 
			</div>
		</main>
			</div><!--theme-layout end-->

<script>

	

var toggleButtons = document.querySelectorAll('.toggle-comments');


for (var i = 0; i < toggleButtons.length; i++) {
  toggleButtons[i].addEventListener('click', function() {
   
    var commentsId = this.getAttribute('data-comments');

    
    var commentsDiv = document.getElementById(commentsId);

    // Afficher ou masquer le div de commentaires
    if (commentsDiv.style.display === 'none') {
      commentsDiv.style.display = 'block';
     
    } else {
      commentsDiv.style.display = 'none';
      
    }
  });
}
</script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/popper.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.mCustomScrollbar.js"></script>
<script type="text/javascript" src="lib/slick/slick.min.js"></script>
<script type="text/javascript" src="js/scrollbar.js"></script>
<script type="text/javascript" src="js/script.js"></script>

</body>
</html>