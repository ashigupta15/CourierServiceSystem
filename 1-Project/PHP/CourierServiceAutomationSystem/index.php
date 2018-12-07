 <html>
	<head>
	
		<style>
			@font-face
			{
				font-family:heading-font;
				src:url(fonts/AppleChancery.ttf);
			}
			body{
				background:white;
			}
			img{
				margin-top:250px;
				margin-left:500px;
			}
			p{
				margin-left:510px;
				font-size:30px;
				font-family:heading-font;
			}
			span
			{
				font-size:50px;
				font-weight:normal
			}
			
			@import "compass/css3";

/*Be sure to look into browser prefixes for keyframes and annimations*/
.flash {
   animation-name: flash;
    animation-duration: 0.2s;
    animation-timing-function: linear;
    animation-iteration-count: infinite;
    animation-direction: alternate;
    animation-play-state: running;
}

@keyframes flash {
    from {color: skyblue;}
    to {color: green;}
}
		</style>
	</head>
	<body class="background:#E0E0E0">
		<div>
			<img src="images/myloading.gif" />
			<p class="flash">Loading...Please Wait...</p>
			<?php header("Refresh :5;index1.php"); ?>
			
		</div>
	</body>
</html>