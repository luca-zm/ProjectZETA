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
					<li></li>
					<li><a href="./homepage.jsp">Home</a></li>
					<li><a href="./userprofile.jsp">User Profile</a></li>
					<li><a href="./map.jsp">Map</a></li>
					<li><a href="./wishlist.jsp">Wishlist</a></li>
					<li><div class="shopping-card"><i class="flaticon-bag"></i><span>${user.getCart().getProductList().size()}</span></div><a href="./cart.jsp"> Shopping Cart</a></li>
				</ul>
				
				</form>
			</div>
		</nav>


	<!-- product section -->
	<section class="product-section">
		<div class="container">
			<div class="row">
				<div class="col-lg-6">
					<div class="product-pic-zoom">
						<img class="product-big-img" src="${product.getImage()}" alt="">
					</div>
					<div class="product-thumbs" tabindex="1" style="overflow: hidden; outline: none;">
						
					</div>
				</div>
				<div class="col-lg-6 product-details">
					<h2 class="p-title">${product.getName()}</h2>
					<h3 class="p-price">${product.getPrice()}</h3>					

					<form method="get" action="ShopCartServlet">
					<input type="hidden" name="productIdup" value ="${product.getId()}">
					<input type="submit" value="add to cart" name="action" class="site-btn" style="background-color:#4fe090; margin: 0.3em;">
					</form>
					
					<div id="accordion" class="accordion-area">
						<div class="panel">
							<div class="panel-header" id="headingOne">
								<button class="panel-link active" data-toggle="collapse" data-target="#collapse1" aria-expanded="true" aria-controls="collapse1">information</button>
							</div>
							<div id="collapse1" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
								<div class="panel-body">
									<p>${product.getDescription()}
									</div>
							</div>
						</div>
						
						
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- product section end -->


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
