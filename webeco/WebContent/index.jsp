<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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


	<section class="cart-section spad">
		<div class="container">
			<div class="row">
			
			
			
				<div class="col-lg-4">
					<div class="cart-table">
						<h3>SIGN IN</h3>
						<hr>
						<form action="LoginControllerServlet" method="post">
						<div class="promo-code-form">
							<input id="usr" type="text" placeholder="Email" name="username"><br><br>
							<input id="psw" type="text" placeholder="Password" name="password"><br><br>
						</div>
						<button class="site-btn" style="background-color:#4fe090">Login</button>
						</form>
						<br><br>
					</div>	
				</div>
				
				
				
				
				
				
				<div class="col-lg-8">
				
					<div class="cart-table">
						<h3>REGISTER ACCOUNT</h3>
						<div class="cart-table-warp">
						<form class="promo-code-form">
							<table><thead><tr><th></th><th></th></tr></thead><tbody>
								<tr><!-- prima riga -->
									<td><input type="text" placeholder="Name"></td>
									<td><input type="text" placeholder="Surname"></td>
								</tr><!-- fine prima riga -->
								
								<tr>
								<td><input type="password" placeholder="Password"></td>
								<td><input type="password" placeholder="Confirm password"></td>
								</tr>
							</tbody></table>
							
							
							<input type="text" placeholder="Email">
							
							
							<table><thead><tr><th></th><th></th></tr></thead><tbody>
								<tr><!-- prima riga -->
									<td><input type="text" placeholder="Address"></td>
									<td><input type="text" placeholder="City"></td>
								</tr><!-- fine prima riga -->
								
								<tr>
								<td><input type="password" placeholder="Zipcode"></td>
								<td><input type="password" placeholder="Telephone"></td>
								</tr>
								
								<tr>
								<td><input type="password" placeholder="State"></td>
								<td><input type="password" placeholder="Zone"></td>
								</tr>
							</tbody></table>
							
						</form>
						</div>
						
					</div>
	
				
				
			</div>
		</div>
		</div>
	</section>

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
