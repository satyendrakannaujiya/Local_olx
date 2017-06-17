<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<link rel="stylesheet" type="text/css" href="./views/login/login.css">
</head>
<body>
<h2 style="text-align: center; padding-top: 20px;color: red;">LogIn</h2>
<div class="main-box">
<form action="./Login" method="GET">
<div class="items">
<label>Email</label>
<input type="text" name="email" placeholder="Email">
</div>
<div class="items">
<label>Password</label>
<input type="password" name="password" placeholder="Password">
</div>
<div class="footer">
<input class="signin" type="submit" name="action" value="SIGNIN">
</div>
</form>
<div class="footer">
<form action="views/signup/signup.jsp" method="GET">
<input class="signup" type="submit"  name="action" value="SIGNUP">
</form>
<a href="#">Forgot password</a>
</div>
</div>
</body>
</html>