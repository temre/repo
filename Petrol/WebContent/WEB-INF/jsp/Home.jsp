<html>
<head>
<jsp:include page="Header.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="/Petrol/css/Main.css">
</head>

<body>
	<div class="wrapper">

		
<h3 align="center" style="color:black; margin-bottom: 20px"><%	if(null != request.getAttribute("message")) out.print(request.getAttribute("message")); %></h3>
		<table width="100%" border="0">
			<tr>
			</tr>
		</table>

</body>
</html>