<?php

	if($_SERVER['REQUEST_METHOD']=='POST'){
		$name = $_POST['name'];
		$password = $_POST['pass'];
		$email = $_POST['mail'];
		$mobile = $_POST['mobil'];
		$loc = $_POST['loc'];
		
		
		require_once('dbHelper.php');
		
		$sql = "INSERT INTO user_details(user_name, user_password, user_mail, user_mobile_number, user_location) VALUES ('$name','$password','$email','$mobile','$loc')";
		
		
		if(mysqli_query($con,$sql)){
			echo "Successfully Registered";
		}
		else
		{
			echo "Could not register";

		}
	}else{
echo 'error';
}