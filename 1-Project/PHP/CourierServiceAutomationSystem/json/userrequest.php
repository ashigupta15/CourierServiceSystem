<?php

	if($_SERVER['REQUEST_METHOD']=='POST'){
		$name = $_POST['name'];
		$password = $_POST['pass'];
		$email = $_POST['mail'];
		$mobile = $_POST['mobil'];
		$loc = $_POST['loc'];
		$loc1 = $_POST['loc1'];
		$nulv="null";
		$pay1=$loc1*12;
		$DateOfRequest = date("Y-m-d");		
		require_once('dbHelper.php');
		$getData=mysqli_fetch_array(mysqli_query($con,"SELECT delivery_id FROM delivery_item_management WHERE delivery_id!='null' ORDER BY delivery_id DESC LIMIT 1"));
		$userId=$getData['delivery_id']+1;
		$sql = "INSERT INTO delivery_item_management(sender, sender_address, receiver, receiver_address, delivery_id, collecting_person_name, collecting_datetime, delevery_person_name, delivering_datetime, delivery_status, user_intimation_status) 
		VALUES ('$name','$password','$email','$mobile','$userId','$nulv','$DateOfRequest','$nulv','$nulv','$nulv','$nulv')";
		
		$sqll="INSERT INTO payment_details(sender_name,item_id,material_type,material_weight,amount_payable,payment_mode,payment_received_by) 
		VALUES ('$name','$userId','$loc','$loc1','$pay1','$nulv','$nulv')";
		
		
		mysqli_query($con,$sql);
			mysqli_query($con,$sqll);
			echo "Successfully Registered";
			
		}else{
echo 'error';
}