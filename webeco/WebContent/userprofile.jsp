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


	<!-- user.getAddress().getTelephone() -->


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
								&ensp;&ensp;&ensp;<p align="left">&ensp;&ensp;&ensp;Email:&emsp;${user.getMail()}</p><br>
								&ensp;&ensp;&ensp;<p align="left">&ensp;&ensp;&ensp;Name\surname:&emsp;${user.getName()} - ${user.getSurname()}</p><br>
								&ensp;&ensp;&ensp;<p align="left">&ensp;&ensp;&ensp;Greencoin:&emsp;${user.getGreenCoin()}</p><br>
								&ensp;&ensp;&ensp;<p align="left">&ensp;&ensp;&ensp;Address:&emsp;${indirizzo}</p><br>
					</div>
					<hr>
					<br>
					</div>
					
				</div>
				
				<div class="col-lg-4 card-right">
					<form class="promo-code-form" method="post" action="UserProfileServlet">
						<input type="text" placeholder="Enter your code" name="code"><br>
						<br>
						<input type="submit" class="site-btn" style="background-color:#4fe090" value="activate" name="activate">
					</form>
					<br><br><br><br><br><br>
					<a href="#continue" class="site-btn sb-dark" style="background-color:#66666">Check messages and history</a>

					
				</div>
			</div>
		</div>
	</section>
	<!-- cart section end -->
	
	<hr>
	
	
	<!-- SECTION MESSAGES AND HISTORY -->
		<section id="continue" class="cart-section spad">
		<div class="container">	
		<div class="row">	
				<div class="col-lg-6" style="overflow-y: scroll; height:400px;">
					<div class="cart-table">
						<div class="promo-code-form">
						<h3>MESSAGES</h3>
						<hr>
						<div class="cart-table">
							
								<table><thead><tr><th></th><th></th></tr></thead>
								<tbody>
								<c:forEach items="${user.getBoards().getList()}" var="item">
									<tr>
									
										<td class="product-col">
											${item.getDate()} :: <p>${item.getTitle()}</p>
										</td>
										<td class="quy-col">
											<p>${item.getBodymessage()}</p>
										</td>
									
									</tr>
								</c:forEach>
								</tbody>
								</table>
						</div>			
						<br>
					</div>	
				</div>
				</div>
				
				
				<div class="col-lg-6" style="overflow-y: scroll; height:400px;">
				<div class="cart-table">
						<h3>HISTORY</h3><div class="cart-table-warp"><div class="promo-code-form"><hr>		
							<form method="get" action="UserProfileServlet">
							
								<table><thead><tr><th></th></tr></thead>
								<tbody>
								<c:forEach items="${user.getHistory().getTranList()}" var="item">
									<tr>
									
										<td class="product-col">
											<P>${item.toString()}</p><br><hr>
										</td>
										
									</tr>
								</c:forEach>
								</tbody>
								</table>

							
							</form>							 
				</div></div><br><br></div></div>
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
