

<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Product" %>
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
				<ul class="main-menu">
					<li><a href="./index.html">Home</a></li>
					<li><a href="./userprofile.html">User Profile</a></li>
					<li><a href="./userprofile.html">Activation Code</a></li>
					<li><a href="./map.html">Map</a></li>
					<li><div class="shopping-card"><i class="flaticon-bag"></i><span>0</span></div><a href="./cart.html"> Shopping Cart</a></li>
				</ul>
			</div>
		</nav>


	

	<!-- cart section end -->
	<section class="cart-section spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-8">
					<div class="cart-table">
						<h3>Your Cart</h3>
						<div class="cart-table-warp">
							<table>
							<thead>
								<tr>
									<th class="product-th">Product</th>
									<th class="total-th">Price</th>
								</tr>
							</thead>
							<tbody>
								
								<c:forEach items="${user.getCart().getProductList()}" var="item">
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
									
									<form action="ShopCartCheckOutServlet" method="get">
									<input type="hidden" name="productId" value ="${item.getId()}">
										<input type="submit" name="action" value="del" class="site-btn" style="background-color:#666666">
									</form>
									
									</td>
								</tr>
							
								</c:forEach>
							</tbody>
						</table>
						</div>
						<div class="total-cost" style="background-color:#4fe090">
							<h6>TOTAL <span>${user.getCart().getTotalPrice()} greencoin</span></h6>
						</div>
					</div>
				</div>
				<div class="col-lg-4 card-right">
					<form class="promo-code-form">
						<input type="text" placeholder="Enter promo code">
						<button style="color:#4fe090">Submit</button>
					</form>
					
					<a href="./checkout.jsp" class="site-btn" style="background-color:#4fe090">Proceed to checkout</a>
					<a href="#continue" class="site-btn sb-dark" style="background-color:#66666">Continue shopping</a>
				</div>
			</div>
		</div>
	</section>
	<!-- cart section end -->
	
	
	<br><br>
	
	
	<!-- Related product section -->
	<section class="top-letest-product-section">
		<div class="container">
			<div class="section-title">
				<h2>CONTINUE SHOPPING</h2>
			</div>
			

			<div class="product-slider owl-carousel">
			    <c:forEach items="${catalogo}" var="item">
					<div class="product-item">
						<div class="pi-pic">
							<a href="#"><img src="${item.getImage()}" alt=""></a>
							<div align="center">
							<input type="submit" value="cart" name="action" class="site-btn" style="background-color:#4fe090; margin: 0.3em;">
							<!--  <a href="#" class="add-card"><i class="flaticon-bag"></i><span>ADD TO CART</span></a>-->
							<!--  <a href="#" class="wishlist-btn"><i class="flaticon-heart"></i></a>-->
							<input type="submit" value="wish" name="action" class="site-btn" style="background-color:#2fb56e; margin: 0,3em;">
							</div>
						</div>
						<div align="center">
							<br>
							<h6>${item.getPrice()} greencoin</h6>
							<p>${item.getName()}</p>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</section>
	<!-- Related product section end -->



	


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
