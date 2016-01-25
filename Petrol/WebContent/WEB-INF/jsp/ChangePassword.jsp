<!DOCTYPE html>
<%@page import="com.kavi.entity.user.LoginEn"%>
<html >
  <head>
    <meta charset="UTF-8">
    <title>ChangePassword</title>
        <link rel="stylesheet" href="css/login.css">
      <jsp:include page="Header.jsp" />
     <script language='javascript' type='text/javascript'>
    function check(input) {
        if (input.value != document.getElementById('password').value) {
            input.setCustomValidity('Both Password Must be Matching.');
        } else {
            // input is valid -- reset the error message
            input.setCustomValidity('');
        }
    }
</script>
<style >
table, th, td {
    padding: 10px;
}</style>
  </head>
  <body>
  
    <div class="wrapper">
	<div class="container">
	
		<h2>Enter your Old and New Passsword</h2>
		<form class="form" action="ChangePassword" method="post" style="display:inline-block;">
		
		<h3 style="color: black;font: bold; ">
		
		<%
		if(null != request.getAttribute("message"))
			out.print(request.getAttribute("message"));
		
		%></h3>

		<table border="0" style="width:100%" align="center" >

					<tr>
						<td width="50%" align="right">User Id (Read Only)</td>
						<td width="50%" align="left"> <input type="text" placeholder="Username" name="userId"  readonly value=<%=request.getSession().getAttribute("userId")%>> </td>
					</tr>
					<tr>
						<td width="50%" align="right">Old Password</td>
						<td width="50%" align="left"><input type="password" placeholder="Old Password" name="oldPassword" required  maxlength="8"></td>
					</tr>
					<tr>
						<td width="50%" align="right">New Password</td>
						<td width="50%" align="left"><input type="password" placeholder="New Password" name="newPassword" id="password" required></td>
					</tr>
					<tr>
						<td width="50%" align="right">Confirm Password</td>
						<td width="50%" align="left"><input type="password" placeholder="Re Enter New Password" name="reNewPassword" id="password_confirm" oninput="check(this)" required></td>
					</tr>
					<tr>
						<td width="50%" align="right"><input type="reset" value="Reset" ></td>
						<td width="50%" align="left"><input type="submit" tabindex="5" onclick="myFunction()" value="Change Password"></td>
					</tr>
				</table>
				
				
				
				
		</form>
		
	</div>
</div>
       
  </body>
</html>
