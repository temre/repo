<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Login</title>
        <link rel="stylesheet" href="css/login.css">
        <jsp:include page="LoginHeader.html"></jsp:include>
  </head>
  <body>
  <% if(session.getAttribute("loginStatus")!=null && session.getAttribute("loginStatus").equals(true))
		{
	  	System.out.println("-------already logged in--------");
	  	(request.getRequestDispatcher("WEB-INF/jsp/Home.jsp")).forward(request, response);
   		
		}%>
  
    <div class="wrapper">
	<div class="container">
	
		<h2>Enter your Credential</h2>
		<br/><br/>
		<form class="form" action="Login" method="post">
		
		<h3 style="color: black;font: bold; ">
		
		<%
		if(null != request.getAttribute("message"))
			out.print(request.getAttribute("message"));
		
		%></h3><br/>
		
			User Id<input type="text" placeholder="Username" name="userId" required>
			Password <input type="password" placeholder="Password" name="password" required>
			<button type="submit" id="login-button">Login</button>
		</form>
		
	</div>
	<ul class="bg-bubbles">
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
	</ul>
	<ul class="bg-bubbles">
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
	</ul>
</div>
  </body>
</html>
