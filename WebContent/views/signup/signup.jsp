<!DOCTYPE html>
<html>
<head>

<title>Sign Up</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/views/signup/signup.css">
</head>
<body>
	<h2 style="text-align: center;">Sign up</h2>
	
	<div class="main-box">
		<form action="${pageContext.request.contextPath}/SIGNUP" method="GET" >
			<div class="items">
				<label>City</label> <input type="text" name="city">
			</div>
			<div class="items">
				<label>Your-Name</label> <input type="text" name="name">
			</div>
			<div class="items">
				<label>Mobile</label> <input type="text" name="mobile">
			</div>
			<div class="items">
				<label>Email</label> <input type="text" name="email">
			</div>
			<div class="items">
				<label>Password</label> <input type="password" name="password">
			</div>
			<div class="items">
				<input type="submit" value="submit">
			</div>
		</form>
	</div>
</body>
</html>