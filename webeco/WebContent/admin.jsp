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
				<form method="get" action="AdminServlet">
					
				<ul class="main-menu">
					<li><input type="submit" class="site-btn" style="background-color:#a7aba9" name="action" value="logout"></li>
				</ul>
				
				</form>
			</div>
	</nav>
		
		
		
		
	<section class="cart-section spad">
		<div class="container">
			<div class="row">
			

				
				<!-- AGGIUNGE NUOVO PRODOTTO, RIMUOVE PRODOTTO DA ID, COLLEGATA ALLA SERVLET 'ADMINSERVLET' -->
				<div class="col-lg-8"><div class="cart-table">
						<h3>PRODUCT OPTIONS</h3><div class="cart-table-warp"><div class="promo-code-form"><hr>		
						
							<h4>ADD NEW PRODUCT</h4>
							<form method="post" action="AdminServlet">
							
								<table><thead><tr><th></th><th></th></tr></thead><tbody>
									<tr><!-- prima riga -->
										<td><input type="text" placeholder="Name" name="name" ></td>
										<td><input type="text" placeholder="Price" name="price"></td>
									</tr><!-- fine prima riga -->
								
									<tr>
									<td><input type="text" placeholder="Image Path" name="imgpath"></td>
									<td>(./img/*name of the image* . *png/jpg/jpeg*)</td>
									</tr></tbody></table>
								<input type="text" placeholder="Description" name="descr">
								<br>
								<input type="submit" class="site-btn" style="background-color:#4fe090" name="action" value="add">
							
							</form>
							
							<hr><hr>
							
							<h4>DELETE PRODUCT</h4>
							<form method="post" action="AdminServlet">
							
							<table><thead><tr><th></th><th></th></tr></thead><tbody>
								<tr><!-- prima riga -->
									<td><input type="text" placeholder="Product ID" name="productId"></td>
									<td><input type="submit" class="site-btn" style="background-color:#4fe090" name="action" value="delete"></td>
								</tr><!-- fine prima riga -->
							</tbody></table>
							
							</form>							 
				</div></div><br><br></div></div>
			
			

			

			<!-- BANNA UTENTE, COLLEGATA ALLA SERVLET 'ADMINSERVLET' -->
			<div class="col-lg-4">
					<div class="cart-table">
						<h3>USER OPTIONS</h3>
						<hr>
						<form action="AdminServlet" method="post">
						
							<div class="promo-code-form">
								<input type="text" placeholder="User ID" name="userId">
							</div>
							<br>
							<input type="submit" class="site-btn" style="background-color:#4fe090" name="action" value="ban">
							
						</form>
						<br><br>
					</div>	
			</div>
			
			
		</div></div></section>
		
		
		<!-- SECTION LIST OF PRODUCTS -->
		<section class="cart-section spad">
		<div class="container" align="center">
		
				<div class="col-lg-12">
					<div class="cart-table">
						<div class="promo-code-form">
						<h3>PRODUCT LIST</h3>
						<hr>
						<div class="cart-table">
							
								<table><thead><tr><th></th><th></th><th></th></tr></thead>
								<tbody>
								<c:forEach items="${catalogo}" var="item">
									<tr>
									
										<td class="product-col">
											${item.getId()} - <p>${item.getName()}</p>
										</td>
										<td class="quy-col">
											<p>${item.getPrice()}</p>
										</td>
										<td class="product-col">
											<p>${item.isAvailability()}</p>
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
		</div>
		</section>
		
		
		<!-- SECTION LIST OF USERS -->
		<section class="cart-section spad">
		<div class="container" align="center">
		
				<div class="col-lg-12">
					<div class="cart-table">
						<div class="promo-code-form">
						<h3>USER LIST</h3>
						<hr>
						<div class="cart-table">
							
								<table><thead><tr><th></th><th></th></tr></thead>
								<tbody>
								<c:forEach items="${users}" var="item">
									<tr>
									
										<td class="product-col">
											${item.getId()} - <p>${item.getName()}</p>
										</td>
										<td class="quy-col">
											<p>${item.getMail()}</p>
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
