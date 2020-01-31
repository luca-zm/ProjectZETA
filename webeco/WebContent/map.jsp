<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.CollectionPoint" %>
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


	<!-- Contact section -->
	<section class="contact-section">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 contact-info">
					<h3>Map of our EcoPoint</h3>
					<c:forEach items="${collpoint}" var="item">
								<tr>
									<td class="product-col">
										<div class="pc-title">
											<h4>${item.getName()}</h4>
										</div>
									</td>
									<td class="quy-col">
										<p>${item.getAddress()}</p>
									</td>
								</tr>		
					</c:forEach>
					<br><br><br><br><br><br><br>
					<br><br><br><br><br><br><br>
					<br><br><br><br><br><br><br>
				</div>
			</div>
		</div>
		<div class="map"><a href="https://maps.googleapis.com/maps/api/staticmap?center=Rome,Italy&zoom=11&size=600x500&maptype=roadmap&key=AIzaSyDWaK_dXLPOBO43oLeAkMTrgkh-6qSlnuc">Nome Sito</a></div>
	</section>
	
	<!-- Contact section end -->

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
