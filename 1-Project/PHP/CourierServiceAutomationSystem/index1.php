<?php
session_start();
include 'dbconfig.php';
?>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<title>Courier Service Automation System</title>
	<meta name="description" content="Free Responsive Html5 Css3 Templates | zerotheme.com">
	<meta name="author" content="www.zerotheme.com">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

	<link rel="shortcut icon" href="images/appicon.png" />
  	<link rel="stylesheet" href="css/zerogrid.css">
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/lightbox.css">
	<link rel="stylesheet" href="stylemy.css?version=4">
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="css/menu.css">
	<script src="js/jquery1111.min.js" type="text/javascript"></script>
	<script src="js/script.js"></script>	
</head>

<body>

<div class="wrap-body">
	<header class="zerogrid">
		<div class="logo">
			<div class="ttr"></div>
			<h1>Courier Service Automation System</h1>
			<div class="ttr"></div>
		</div>
		
	</header>
		<div class="homebody">		
			<div class="homebdy">
			<div class="logintable1" style="background:#d0d3d4;border:2px solid black">
				<div class="tableholder" style="background:url('images/tablebg.jpg')">
					<form method="post">
					<table class="tbl">
					<tr><td></td><td></td></tr>
					<tr><td><label>USER NAME : </label></td><td><input type="text" name="username" placeholder="Enter User Name Here" style="color:white;background:#616161;;border:2px solid #d0d3d4;margin-left:10px;border-radius:10px;"></td></tr>
					<tr><td><label>PASSWORD : </label></td><td><input type="password" name="password" placeholder="Enter Password Here" style="color:white;background:#616161;border:2px solid #d0d3d4;margin-left:10px;border-radius:10px;"></td></tr>
					<tr><td colspan="2" align="center"><input type="submit" name="submitbtn" value="Submit" style="margin-top:30px;"></td><td></td></tr>
					</table>
					</form>
				</div>
			</div>					
			<div class="signupbg" style="background:#d0d3d4">	
				<p style="color:green">Don't Have Account!!!!<br/>One Click to Register for free of cost..<br/>Once Register You can access for life long</p>
				<a href="signup.php" class="aa">Sign Up</a>
			</div>	
			</div>			
		</div>												
						<?php 
		  	
					if(isset($_POST['submitbtn']))
				{
					$username= mysql_real_escape_string($_POST['username']);
					$password = mysql_real_escape_string($_POST['password']);
					if($username!="" and $password!="")
					{
					$res=mysql_query("SELECT * FROM admin_authendication WHERE admin_username='$username'");
					$row=mysql_fetch_array($res);
						if($row['admin_password']==$password)
						{
							$_SESSION['userid'] = $row['admin_id'];
							$_SESSION['user'] = $row['admin_username'];
							?>
					<script>window.location.href="Home.php";</script>
					<?php
							header("Home.php");
						}
					else
					{
			?>
					<script>alert('wrong details');</script>
			<?php
					}
 
					}
					else{
						?>
						<script>alert('please enter credentials');</script>
						<?php
					}
				}
			?>
				
						
		<hr class="line">
		<!--////////////////////////////////////Footer-->
		<footer>
			<div class="wrap-footer">
				<div class="zerogrid">
					<div class="row">
						<div class="col-1-3">
							<div class="wrap-col">
								<p>Copyright - <a href="http://www.zerotheme.com" target="_blank" rel="nofollow">Free Html5 Templates</a> designed by <a href="http://www.zerotheme.com" target="_blank" rel="nofollow">ZEROTHEME</a></p>
							</div>
						</div>
						<div class="col-1-3">
							<div class="wrap-col">
								<ul class="social-buttons">
									<li><a href="#"><i class="fa fa-twitter"></i></a>
									</li>
									<li><a href="#"><i class="fa fa-facebook"></i></a>
									</li>
									<li><a href="#"><i class="fa fa-linkedin"></i></a>
									</li>
								</ul>
							</div>
						</div>
						<div class="col-1-3">
							<div class="wrap-col">
								<ul class="quick-link">
									<li><a href="#">Privacy Policy</a></li>
									<li><a href="#">Terms of Use</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</footer>
<script src="js/lightbox-plus-jquery.min.js"></script>
</div>
</body>
</html>