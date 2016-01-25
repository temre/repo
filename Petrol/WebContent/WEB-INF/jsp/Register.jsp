<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>
<jsp:include page="Header.jsp" />
 <link rel="stylesheet" href="/Petrol/css/login.css">
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
</head>
<body>
	<div class="wrapper">
			<form action="Register" method="post" >
			<h3 align="center" style="color:black; margin-bottom: 20px"><%	if(null != request.getAttribute("message")) out.print(request.getAttribute("message")); %></h3>
				<table border="0" style="width: 100%">

					<tr>
						<td width="20%" align="right">Full Name</td>
						<td width="30%" align="left"><input type="text" name="fullName"	placeholder="First and last name" required></td>
						<td width="20%" align="right">MS NOZZLE COUNT </td>
						<td width="30%" align="left"><input type="number" name="noOfMsNozzle" min=0 max=10 placeholder="" required></td>
					</tr>

					<tr>
						<td width="20%" align="right">User Id</td>
						<td width="30%" ><input type="text" name="userId"
							placeholder="user id" required ></td>


						<td width="20%" align="right">HSD NOZZLE COUNT</td>
						<td width="30%" align="left"><input type="number" name="noOfHsdNozzle" min=0
							max=10 placeholder="" required></td>
					</tr>

					<tr>
						<td width="20%" align="right">Set Password</td>
						<td width="30%" align="left"><input type="password" id="password" name="password" required id="password" > </td>
						<td width="20%" align="right"> POWER NOZZLE COUNT</td>
						<td width="30%" align="left"> <input type="number" name="noOfPowerNozzle" min=0 max=10 placeholder="" required></td>
					</tr>

					<tr>
						<td width="20%" align="right">Renter Password</td><td width="30%" align="left"> <input type="password" id="repassword"
							id="password_confirm" oninput="check(this)" name="repassword" required>
						</td>
						<td width="20%" align="right">MS TANK COUNT </td><td width="30%" align="left"><input type="number" name="noOfMsTank" min=0
							max=10 placeholder="" required></td>
					</tr>

					<tr>
						<td width="20%" align="right">Email </td>
						<td width="30%" align="left"> <input type="email" name="email"placeholder="example@domain.com" required>	</td>
						<td width="20%" align="right">HSD TANK COUNT</td>
						<td width="30%" align="left"> <input type="number" name="noOfHsdTank" min=0	max=10 placeholder="" required></td>
					</tr>

					<tr>
						<td width="20%" align="right">Mobile Number </td>
						<td width="30%" align="left"><input type="number" name="mobileNumber" min="7000000000" max="9999999999"placeholder="enter your 10 digit mobile no" required></td>
						<td width="20%" align="right">POWER TANK COUNT </td>
						<td width="30%" align="left"><input type="number" name="noOfPowerTank"	min=0 max=10 placeholder="" required></td>
					</tr>
					<tr></tr>
				</table>
						<table border="0"  style="width: 100%" align="center">
						<tr>
						<td ></td>
							<td width="20%" align="right">
							<input type="reset" value="Reset" style="size:150px;"></td>
							<td width="20%" align="left"><input class="buttom" name="submit" id="submit"value="Create User Account!" type="submit">
							</td>
							<td ></td>
							</tr>
						</table>

			</form>
		</div>
</body>
</html>
