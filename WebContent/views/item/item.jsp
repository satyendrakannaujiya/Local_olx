<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home</title>
<link rel="stylesheet" type="text/css" href="./views/item/item.css">
</head>
<body>
<h2>List of Items</h2>
<c:forEach items="${allItems}" var="item">
 <div class="recent-category">
     <div class="recent-image">
           <figure>
            <img src="images/${item.image}" width="170px" height="130px"/>
            <figcaption style="font-size: 20px;">${item.name}</figcaption>
        </figure>
     </div>
     <div class="recent-image">
         <h2>Product Info</h2>
          
        
          <h3>Product-name::cycle</h3>          
          <h3>Price::${item.price}</h3>

          <h3>posted on::PPPPP</h3>
         
     </div>
      <div class="recent-image">
      <h2>Seller Info</h2>
           <h3>City::ddddd</h3>
          
          <h3>Name::kkkkkkkkkk</h3>
          
          <h3>Mobile::989999</h3>
          
          <h3>Email::lllllllllll</h3>
          
     </div>
 </div>
</c:forEach>
 </body>
 </html>