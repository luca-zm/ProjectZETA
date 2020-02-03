<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="zxx">
<head>
	<title>EcoClean</title>
	<meta charset="UTF-8">
	<meta name="description" content="EcoClean">
	<meta name="keywords" content="EcoClean, html">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- Favicon -->
	<link href="img/product/1.png" rel="shortcut icon"/>

	<!-- Google Font -->
	<link href="https://fonts.googleapis.com/css?family=Josefin+Sans:300,300i,400,400i,700,700i" rel="stylesheet">


	<!-- Stylesheets -->
	<link rel="stylesheet" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" href="css/font-awesome.min.css"/>
	<link rel="stylesheet" href="css/flaticon.css"/>
	<link rel="stylesheet" href="css/slicknav.min.css"/>
	<link rel="stylesheet" href="css/jquery-ui.min.css"/>
	<link rel="stylesheet" href="css/owl.carousel.min.css"/>
	<link rel="stylesheet" href="css/animate.css"/>
	<link rel="stylesheet" href="css/style.css"/>


	<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->

</head>
<body>
	<nav class="main-navbar">
			<div class="container">
				<!-- menu -->
				<form method="post" action="LoginControllerServlet">
				
				<ul class="main-menu">
					<li><input type="submit" class="site-btn" style="background-color:#a7aba9" name="action" value="logout"></li>
					<li><a href="./homepage.jsp">Home</a></li>
					<li><a href="./userprofile.jsp">User Profile</a></li>
					<li><a href="./map.jsp">Map</a></li>
					<li><a href="./wishlist.jsp" style="color:#4fe090">Wishlist </a></li>
					<li><div class="shopping-card"><i class="flaticon-bag"></i><span>${user.getCart().getProductList().size()}</span></div><a href="./cart.jsp"> Shopping Cart</a></li>
				</ul>
				
				</form>
			</div>
	</nav>


	

	<!-- cart section end -->
	<section class="cart-section spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="cart-table">
						<h3>Your Wishlist</h3>
						<div class="cart-table-warp">
							<table>
							<thead>
								<tr>
									<th class="product-th">Product</th>
									<th class="quy-th">Price</th>
									<th class="total-th"></th>
								</tr>
							</thead>
							<tbody>
							
							
								<c:forEach items="${user.getWishList().getList()}" var="item">
								<tr>
									<td class="product-col">
										<img src="${item.getImage()}" alt="">
										<div class="pc-title">
											<h4>${item.getName()}</h4>
										</div>
									</td>
									<td class="quy-col">
										<p>${item.getPrice()} greencoin</p>
									</td>
									<td>
									
									<form action="WishlistServlet" method="get">
									<input type="hidden" name="productId" value ="${item.getId()}">
										<!--<a href="./checkout.html" class="site-btn" style="background-color:#4fe090">Add to cart!</a>-->
										<input type="submit" name="action" value="cart" class="site-btn" style="background-color:#4fe090">
										<input type="submit" name="action" value="del" class="site-btn" style="background-color:#666666">
										<!--  <a href="./checkout.html" class="site-btn" style="background-color:#666666">Remove</a>-->
									</form>
									
									</td>
								</tr>
							
								</c:forEach>
								
								
							</tbody>
						</table>
						</div>
						
					</div>
				</div>
				
			</div>
		</div>
	</section>
	<!-- cart section end -->
	
	
	<br><br>
		


	<!--====== Javascripts & Jquery ======-->
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.slicknav.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.nicescroll.min.js"></script>
	<script src="js/jquery.zoom.min.js"></script>
	<script src="js/jquery-ui.min.js"></script>
	<script src="js/main.js"></script>

	</body>
</html>
