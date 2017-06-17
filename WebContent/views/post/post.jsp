<!DOCTYPE html>
<html>
<head>
<title>Post a new Ads</title>
<link rel="stylesheet" type="text/css" href="./views/post/post.css">
</head>
<body>
	<div class="header">
		<div class="local">
			<h3>Local-Olx</h3>
		</div>
		<div class="logo-fb">
			<img src="assets/fb1.svg" width="150px" height="40px" />
		</div>
		<form align="right" name="form1" method="POST" action="./Logout">
			<label> <input name="submit2" type="submit" id="submit2"
				value="log out">
			</label>
		</form>
	</div>

	<h2 style="text-align: center; padding-top: 70px;">Add a Free Ads</h2>
	<h3 style="color:red;align:center;">${message}</h3>
	<div class="main-box">
		<form action="./POSTADS" enctype="multipart/form-data" method="POST">
			<div class="items">
				<div class="catogry">
					Catogry: <select name="category">
						<option value="Books">Book</option>
						<option value="Bicycles">Bicycle</option>
						<option value="Electronics">Electronic</option>
						<option value="Sports">Sport</option>
						<option value="Mobiles">Mobile</option>
						<option value="Bikes">Bikes</option>
						<option value="Laptopss">Laptop</option>
						<option value="Fashions">Fashion</option>
						<option value="Others">Others</option>
					</select>
				</div>
			</div>
			<div class="items">
				<label>Product-Name</label> <input type="text" name="productname">
			</div>
			<div class="items">
				<label>Price</label> <input type="text" name="price">
			</div>
			<div class="items">
				<label>Photo</label> <input type="file" name="pic">
			</div>
			<div class="items">
				<input type="submit" value="submit">
			</div>
		</form>
	</div>
</body>
</html>