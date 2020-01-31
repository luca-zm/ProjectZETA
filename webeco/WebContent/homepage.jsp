<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Product" %>
<html lang="zxx">
<head>
	<title>EcoClean</title>
	<meta charset="UTF-8">
	<meta name="description" content=" EcoClean">
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
					<li><a href="./index.jsp">Home</a></li>
					<li><a href="./userprofile.jsp">User Profile</a></li>
					<li><a href="./userprofile.jsp">Activation Code</a></li>
					<li><a href="./map.jsp">Map</a></li>
					<li><div class="shopping-card"><i class="flaticon-bag"></i><span>0</span></div><a href="./cart.jsp"> Shopping Cart</a></li>
				</ul>
			</div>
		</nav>



	<!-- Hero section -->
	<section class="hero-section">
		<div class="hero-slider owl-carousel">
			<div class="hs-item set-bg" data-setbg="img/borraccia.jpg">
				<div class="container">
					<div class="row">
						<div class="col-xl-6 col-lg-7 text-white">
                        
							<h2>TESTANDO</h2>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Quis ipsum sus-pendisse ultrices gravida. Risus commodo viverra maecenas accumsan lacus vel facilisis. </p>
							<a href="#" class="site-btn sb-line">DISCOVER</a>
						</div>
					</div>
				</div>
			</div>
			<div class="hs-item set-bg" data-setbg="img/comp.jpeg">
				<div class="container">
					<div class="row">
						<div class="col-xl-6 col-lg-7 text-white">
							<h2>TEST TEST</h2>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Quis ipsum sus-pendisse ultrices gravida. Risus commodo viverra maecenas accumsan lacus vel facilisis. </p>
							<a href="./map.jsp" class="site-btn sb-line">DISCOVER</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		
	</section>
	<!-- Hero section end -->



	<!-- letest product section -->
	<section class="top-letest-product-section">
		<div class="container">
			<div class="section-title">
				<h2>BEST PRODUCTS</h2>
			</div>
			

			<div class="product-slider owl-carousel">
			    <c:forEach items="${catalogomini}" var="item">
					<div class="product-item">
						<div class="pi-pic">
							<a href="${item.getImage()}"><img src="./img/product/1.png" alt=""></a>
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
	<!-- letest product section end -->

<hr>
<hr>

	<!-- Product filter section -->
	
	
	
	<section class="related-product-section">
		<div class="container">
			<div class="row">
			    <c:forEach items="${catalogo}" var="item">			
					<div class="col-lg-3 col-sm-6">
						 	<div class="product-item">
						 		<div class="pi-pic">	
						 		    <a href="${item.getImage()}"><img src="./img/product/1.png" alt="" width=240 height=240></a>								
									<div align="center">
										<input type="submit" value="cart" name="action" class="site-btn" style="background-color:#4fe090; margin: 0.3em;">
										<input type="submit" value="wish" name="action" class="site-btn" style="background-color:#2fb56e; margin: 0,3em;">
									</div>
							    </div>
									<div>
										<h6>${item.getPrice()} greencoin</h6>
										<p>${item.getName()}</p>
									</div>
								</div>					
					</div>
			    </c:forEach>				
			</div>
		</div>
	</section>
	<!-- Product filter section end -->




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
