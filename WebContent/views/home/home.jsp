<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home Page</title>
<link rel="stylesheet" type="text/css" href="./views/home/home.css">
</head>
<body>
	<div class="header">
		<div class="local">
			<h3>Local-Olx</h3>
		</div>
		<div class="logo-fb">
			<img src="assets/fb1.svg" width="150px" height="40px" />
		</div>
	</div>
	<div class="main-container">
		<form action="./viewItems" method="GET">
			<div class="view-all">
				<h2>Categories</h2>
				<input type="submit" name="action" value="VIEW_ALL">
			</div>
		</form>
		<div class="category-panel">
		
			<c:forEach items="${categories}" var="list">
				<div class="category">
					<a href="./viewItems?action=viewcategorywise&categoryid=${list.id}"> <figure> <img src="assets/${list.image}"
							width="150px" height="100px" /> <figcaption>${list.title}</figcaption>
						</figure>
					</a>
				</div>
			</c:forEach>
			


		</div>
		<h2 style="color: red;">Recent Items</h2>
		<div class="recent-items">
			<div class="recent-category">
				<div class="recent-image">
					<figure> <img src="assets/cycle.jpg" width="150px"
						height="100px" /> <figcaption style="font-size: 20px;">Cycle</figcaption>
					</figure>
				</div>
				<div class="recent-image">
					<h2>Product Info</h2>
					<h3>Category</h3>
					<h4>Bicyle</h4>
					<h3>Product-name</h3>
					<h4>Milton-gold</h4>
					<h3>City</h3>
					<h4>Allahabad</h4>
					<h3>Price</h3>
					<h4>Rs.2000</h4>
				</div>
				<div class="recent-image">
					<h2>Seller Info</h2>
					<h3>Name</h3>
					<h4>Satyendra kannaujiya</h4>
					<h3>Mobile</h3>
					<h4>9910662891</h4>
					<h3>Email</h3>
					<h4>satyendra250896@gmail.com</h4>
				</div>
			</div>
			<div class="recent-category">
				<div class="recent-image">
					<figure> <img src="assets/book.jpg" width="150px"
						height="120px" /> <figcaption style="font-size: 20px;">Book</figcaption>
					</figure>
				</div>
				<div class="recent-image">
					<h2>Product Info</h2>
					<h3>Category</h3>
					<h4>Books</h4>
					<h3>Product-name</h3>
					<h4>Data-structure</h4>
					<h3>City</h3>
					<h4>Allahabad</h4>
					<h3>Price</h3>
					<h4>Rs.500</h4>
				</div>
				<div class="recent-image">
					<h2>Seller Info</h2>
					<h3>Name</h3>
					<h4>Satyendra kannaujiya</h4>
					<h3>Mobile</h3>
					<h4>9910662891</h4>
					<h3>Email</h3>
					<h4>satyendra250896@gmail.com</h4>
				</div>
			</div>
			<div class="recent-category">
				<div class="recent-image">
					<figure> <img src="assets/iron.jpeg" width="150px"
						height="120px" /> <figcaption style="font-size: 20px;">Iron</figcaption>
					</figure>
				</div>
				<div class="recent-image">
					<h2>Product Info</h2>
					<h3>Category</h3>
					<h4>Electronics</h4>
					<h3>Product-name</h3>
					<h4>Iron</h4>
					<h3>City</h3>
					<h4>Allahabad</h4>
					<h3>Price</h3>
					<h4>Rs.800</h4>
				</div>
				<div class="recent-image">
					<h2>Seller Info</h2>
					<h3>Name</h3>
					<h4>Satyendra kannaujiya</h4>
					<h3>Mobile</h3>
					<h4>9910662891</h4>
					<h3>Email</h3>
					<h4>satyendra250896@gmail.com</h4>
				</div>
			</div>
		</div>
	</div>
	<form action="./Login" method="GET">
		<div class="post">
			<a href="./viewItems?action=plus" title="Post your Ads">+</a>
		</div>
	</form>
</body>
</html>