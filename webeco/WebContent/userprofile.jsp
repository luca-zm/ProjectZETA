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
				<ul class="main-menu">
					<li><a href="./index.jsp">Home</a></li>
					<li><a href="./userprofile.jsp">User Profile</a></li>
					<li><a href="./map.jsp">Map</a></li>
					<li><a href="./wishlist.jsp">Wishlist</a></li>
					<li><div class="shopping-card"><i class="flaticon-bag"></i><span>${user.getCart().getProductList().size()}</span></div><a href="./cart.jsp"> Shopping Cart</a></li>
				</ul>
			</div>
		</nav>


	


	<!-- cart section end -->
	<section class="cart-section spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-8">
					<div class="cart-table">
						<h3>Your Profile</h3>
						<hr>
					<img src="./img/avatar.png" alt="" align="left">&emsp;
					<div align="right">
								<p align="left">&ensp;&ensp;&ensp;Username:&emsp;${user.getName()}</p><br>
								<p align="left">&ensp;&ensp;&ensp;Email:&emsp;${user.getMail()}</p><br>
								<p align="left">&ensp;&ensp;&ensp;Greencoin:&emsp;${user.getGreenCoin()}</p><br>
								<p align="left">&ensp;&ensp;&ensp;Address:&emsp;${user.getAddress().getAddress()}&emsp;${user.getAddress().getCity()}<br>
												&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;${user.getAddress().getPostalCode()}&emsp;${user.getAddress().getTelephone()}<br>
												&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;${user.getAddress().getState()}&emsp;${user.getAddress().getZone()}</p><br>
					</div>
					<hr>
					<br>
					</div>
					
				</div>
				
				<div class="col-lg-4 card-right">
					<form class="promo-code-form" method="post" action="UserProfileServlet">
						<input type="text" placeholder="Enter your code" name="code">
						<br>
						<input type="submit" class="site-btn" style="background-color:#4fe090" value="activate" name="activate">
					</form>
				</div>
			</div>
		</div>
	</section>
	<!-- cart section end -->


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
