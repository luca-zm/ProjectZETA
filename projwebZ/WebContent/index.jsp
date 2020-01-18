<!-- login page -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <title>EcoClean</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  
  
  	
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<!------ Include the above in your HEAD tag ---------->

	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
  
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
  <!-- Style --> 
  
    <link href="css/style.css" rel="stylesheet" />
    <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:400,300,200,700' rel='stylesheet' type='text/css'>

	
  <!-- log -->
  <style>
	.vl {
  border-left: 10px solid #666666;
  height: 800px;
  position: absolute;
  left: 50%;
  margin-left: -3px;
  top: 20;
}
  </style>
  
  
</head>

<body>
<div class="vl"></div>

<div id="fold">
<div class="container">

<br><br><br><br><br><br>
<div class="row">
	<aside class="col-sm-5">
		<div class="card">
			<article class="card-body">
				<h4 class="card-title text-center mb-4 mt-1">Login</h4>
				<hr>
				<p class="text-success text-center">Are you already registered?</p>
				<form>
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-prepend">
		    					<span class="input-group-text"> <i class="fa fa-user"></i> </span>
		 					</div>
							<input name="" class="form-control" placeholder="Email" type="email">
						</div> <!-- input-group.// -->
					</div> <!-- form-group// -->
					<br>
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-prepend">
		   						<span class="input-group-text"> <i class="fa fa-lock"></i> </span>
		 					</div>
	    					<input class="form-control" placeholder="******" type="password">
						</div> <!-- input-group.// -->
					</div> <!-- form-group// -->
					<br><br>
					<div class="form-group">
						<button type="submit" class="btn btn-default btn-lg btn-block"> Login  </button>
					</div> <!-- form-group// -->
				</form>
			</article>
		</div>
	</aside>
	
	
	<aside class="col-sm-2">
	</aside>
	

	<aside class="col-sm-5">
		<div class="card">
			<article class="card-body">
				<h4 class="card-title text-center mb-4 mt-1">Sign up</h4>
				<hr>
				<p class="text-success text-center">Enter your details to register!</p>
				<form>
					<div class="form-group">
						<div class="input-group">
							<input name="" class="form-control" placeholder="Email" type="email">
							<br><br><br>
							<input name="" class="form-control" placeholder="Confirm your Email" type="email">
						</div> <!-- input-group.// -->
					</div> <!-- form-group// -->
					<br>
					<div class="form-group">
						<div class="input-group">
	    					<input class="form-control" placeholder="Password" type="password">
	    					<br><br><br>
	    					<input class="form-control" placeholder="Confirm your password" type="password">
						</div> <!-- input-group.// -->
					</div> <!-- form-group// -->
					<br><br>
					<div class="form-group">
						<button type="submit" class="btn btn-default btn-lg btn-block"> Register  </button>
					</div> <!-- form-group// -->
				</form>
			</article>
		</div>
	</aside>
	
</div> <!-- row.// -->
<br><br><br><br><br><br>
</div>
<p class="text-right"><a href="#" class="btn" style="color:#666666">Proceed without sign in</a></p>
</div>

</body>
</html>