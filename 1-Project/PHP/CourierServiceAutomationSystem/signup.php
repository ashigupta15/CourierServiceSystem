<?php
include 'dbconfig.php';
?>
<!DOCTYPE html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--><html lang="en"> <!--<![endif]-->
<head>

    <!-- Basic Page Needs
  ================================================== -->
	<meta charset="utf-8">
	<title>Courier Service Automation System</title>
	<meta name="description" content="Free Responsive Html5 Css3 Templates | zerotheme.com">
	<meta name="author" content="www.zerotheme.com">
	
    <!-- Mobile Specific Metas
	================================================== -->
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    
    <!-- CSS
	================================================== -->
  	<link rel="stylesheet" href="css/zerogrid.css">
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/lightbox.css">
	<link rel="shortcut icon" href="images/appicon.png" />
	<link rel="stylesheet" href="stylemy.css?version=1" type="text/css">
	
	<!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	
	
	<link rel="stylesheet" href="css/menu.css">
	<script src="js/jquery1111.min.js" type="text/javascript"></script>
	<script src="js/script.js"></script>
	
	<!--[if lt IE 8]>
       <div style=' clear: both; text-align:center; position: relative;'>
         <a href="http://windows.microsoft.com/en-US/internet-explorer/Items/ie/home?ocid=ie6_countdown_bannercode">
           <img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." />
        </a>
      </div>
    <![endif]-->
    <!--[if lt IE 9]>
		<script src="js/html5.js"></script>
		<script src="js/css3-mediaqueries.js"></script>
	<![endif]-->
	
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
		<!--////////////////////////////////////Container-->
		<div class="homebody">
			<div class="logintable" style="background:#d0d3d4">
								<p style="color:black">Have an Account!!!!<br/>Then Click to sign in here...<br/>Once Register You can access for life long</p>
								<a href="index1.php" class="aa" style="padding:9=8px;margin:200px;">Log In</a>
			</div>					
			<div class="signupbg" style="background:#d0d3d4">							
				<div class="tableholder1" style="background:url('images/tablebg.jpg')">		
										<form method="post">
										<table>
										<tr><td><label>USER NAME</label></td><td><input type="text" name="username" placeholder="Enter Your Name" style="color:white;background:#616161;border:2px solid #d0d3d4;margin-left:10px;border-radius:10px;"/></td></tr>
										<tr><td><label>PASSWORD</label></td><td><input type="password" name="password" placeholder="Enter Your password" style="color:white;background:#616161;border:2px solid #d0d3d4;margin-left:10px;border-radius:10px;"/></td></tr>
										<tr><td><label>PASSWORD AGAIN</label></td><td><input type="password" name="repassword" placeholder="Re-Enter Your password" style="color:white;background:#616161;border:2px solid #d0d3d4;margin-left:10px;border-radius:10px;"/></td></tr>
										<tr><td><label>EMAIL ID</label></td><td><input type="email" name="email" placeholder="Enter Your Email id" style="color:white;background:#616161;border:2px solid #d0d3d4;margin-left:10px;border-radius:10px;"/></td></tr>
										<tr><td><label>MOBILE NUMBER</label></td><td><input type="number" name="mobile" placeholder="Enter Your Mobile Number" style="color:white;background:#616161;border:2px solid #d0d3d4;margin-left:10px;border-radius:10px;"/></td></tr>
										<tr><td><label>LOCATION</label></td><td><input type="text" name="location" placeholder="Enter Your location" style="color:white;background:#616161;border:2px solid #d0d3d4;margin-left:10px;border-radius:10px;"/></td></tr>
										<tr><td colspan="2" align="center"><input type="submit" name="submit" class="btn" value="SUBMIT"></td><td></td></tr>
										</table>
										</form>
				</div>
			</div>					
			
			<?php
		if(isset($_POST['submit']))
{
 $username = mysql_real_escape_string($_POST['username']);
 $password = mysql_real_escape_string($_POST['password']);
 $repassword = mysql_real_escape_string($_POST['repassword']);
 $email = mysql_real_escape_string($_POST['email']);
 $mobile = mysql_real_escape_string($_POST['mobile']);
 $location = mysql_real_escape_string($_POST['location']);
 if($username != "" and $password != "" and $repassword != "" and $email != "" and $mobile != "" and $location!="" )
 {
 if($password==$repassword)
 {
 if(mysql_query("INSERT INTO admin_authendication(admin_username, admin_password, admin_mailid, admin_mobilenumber, admin_location) VALUES ('".$username."','".$password."','".$email."','".$mobile."','".$location."')"))
 {
  ?>
        <script>alert('successfully registered ');
		
		window.location.href='index1.php';
		</script>
		
        <?php
 }
 else
 {
  ?>
        <script>alert('error while registering you...');</script>
        <?php
 }
 }
 else
 {
  ?>
        <script>alert('Password Mismatching...');</script>
        <?php
 }
}
else{
	?>
	<script>
	alert('Please enter all credintials..')
	</script>
	<?php
}
}
?>

			</div>
		</section>
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