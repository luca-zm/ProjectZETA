<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.CollectionPoint" %>
<%@ page import="controller.ControllerManageCollPoint" %>
<%@ page import="java.net.MalformedURLException"%>
<%@ page import="java.net.URL" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="javax.imageio.ImageIO" %>
<%@ page import="javax.swing.*" %>

<%@ page import="java.awt.image.BufferedImage" %>

<%@ page import="java.net.URLEncoder" %>

<%@ page import="java.util.ResourceBundle" %>


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
					<li><a href="./homepage.jsp">Home</a></li>
					<li><a href="./userprofile.jsp">User Profile</a></li>
					<li><a href="./map.jsp">Map</a></li>
					<li><a href="./wishlist.jsp">Wishlist</a></li>
					<li><div class="shopping-card"><i class="flaticon-bag"></i><span>${user.getCart().getProductList().size()}</span></div><a href="./cart.jsp"> Shopping Cart</a></li>
				</ul>
			</div>
		</nav>

	<!-- Contact section -->
	<section class="contact-section">
		<div class="container">
			<div class="row">
				<div class="col-lg-4 contact-info">
						<div class="cart-table">
							<h3>Map of our EcoPoint</h3>
							
								<table>
								<thead>
									<tr>
									<th></th>
									<th></th>
									</tr>
								</thead>
								
								<tbody>
								<c:forEach items="${collpoint}" var="item">
									<tr>
									
										<td class="product-col">
											<p>${item.getId()} :</p>
										</td>
										<td class="quy-col">
											${item.getAddress()}<p>${item.getOpeningTime()}:00 am - ${item.getClosingTime()}:00 pm</p>
										</td>
									
									</tr>
								</c:forEach>
								</tbody>
								</table>
					</div>
				</div>
				<div class="col-lg-8 contact-info">
					<div class="cart-table">
						<img src="${mapImage}">
					</div>
				</div>
		</div>
		</div>
		<br><br><br>
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
