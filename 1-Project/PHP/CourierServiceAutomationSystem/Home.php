<?php 
include 'dbconfig.php';
session_start();
if(isset($_SESSION['user'])=="")
		{
			header("location:index.php");
		}
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
	<link rel="stylesheet" href="mystyle.css">
	<link rel="stylesheet" href="mystyle1.css">
	<link rel="shortcut icon" href="images/appicon.png" />
	
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
		<div id='cssmenu' class="align-center">
			<ul>
			   <li class="active"><a href='Home.php'><span>Home</span></a></li>
			   <li class=' has-sub'><a href='viewManagementEmployee.php'><span>Employee</span></a>
				  <ul >
					 <li class='has-sub'><a href='viewManagementEmployee.php'><span>View Employee</span></a>
						<ul>
						   <li><a href='viewManagementEmployee.php'><span>Management Person</span></a></li>
						   <li class='last'><a href='viewFieldEmployee.php'><span>Field Person</span></a></li>
						</ul>
					 </li>
					 <li class='has-sub'><a href='addManagementEmployee.php'><span>Add Employee</span></a>
						<ul>
						   <li><a href='addManagementEmployee.php'><span>Management Employee</span></a></li>
						   <li class='last'><a href='addFieldEmployee.php'><span>Field Employee</span></a></li>
						</ul>
					 </li>
				  </ul>
			   </li>
			   <li><a href='deliveredDetails.php'><span>Delivered Details</span></a></li>
			  <li><a href='paymentDetails.php'><span>Payment Details	</span></a></li>
			   <li><a href='contact.php'><span>Contacts</span></a></li>
			   <li class='last'><a href='logout.php'><span>Logout</span></a></li>
			</ul>
		</div>
	</header>
		<!--////////////////////////////////////Container-->
		<section id="container">
			<div class="wrap-container">
			<div id="main-content">
					<div class="wrap-content zerogrid ">
						<article class="background-gray">
							<div class="art-header">
								<h1>Tracking Details</h1>
							</div>
							<div class="art-content">
								<div class="row">
									<table class="tablestyle">
										<tr>
											<th style="border:1px solid black">Sl No.</th>
											<th style="border:1px solid black">Sender</th>
											<th style="border:1px solid black">From Place</th>
											<th style="border:1px solid black">Receiver</th>
											<th style="border:1px solid black">To Place</th>
											<th style="border:1px solid black">Delivery Number</th>
											<th style="border:1px solid black">Collecting Person</th>
											<th style="border:1px solid black">Deliver Person</th>
											<th style="border:1px solid black">Item Status</th>
											<th style="border:1px solid black">Allocation Status</th>
										</tr>
										<?php
										$strr="Delivered";
										$quer=mysql_query("SELECT * FROM delivery_item_management WHERE delivery_status!='".$strr."'");
										$s=1;
										 $DateOfRequest = date("Y-m-d"); 
										while($row=mysql_fetch_array($quer))
										{
											?>
											<tr>
											<td style="border:1px solid black"><?= $s;?></td>
											<td style="border:1px solid black"><?= $row['sender'];?></td>
											<td style="border:1px solid black"><?= $row['sender_address'];?></td>
											<td style="border:1px solid black"><?= $row['receiver'];?></td>
											<td style="border:1px solid black"><?= $row['receiver_address'];?></td>
											<td style="border:1px solid black"><?= $row['delivery_id'];?></td>
											<td style="border:1px solid black"><?= $row['collecting_person_name'];?></td>
											<td style="border:1px solid black"><?= $row['delevery_person_name'];?></td>
											<td style="border:1px solid black"><?= $row['delivery_status'];?></td>
											<td style="border:1px solid black"><a href="allocat_person.php?id=<?= $row['table_id'];?>&&sen=<?= $row['sender_address'] ?>&&rec=<?= $row['receiver_address'] ?>"><?= $row['user_intimation_status'];?></a></td>
											
											<?php
											++$s;
										}
										?>
										</tr>
									</table>
								
							</div>
						
						<div class="col-1-2">
							<div class="wrap-col">
								<div class="row">
									<div class="t-center" style="padding-top: 30px;">
										
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
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