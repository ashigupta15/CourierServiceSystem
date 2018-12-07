<?php

		$paymode = $_GET['paymode'];		
		$sts = $_GET['status'];		
		$id = $_GET['itemid'];		
		$una = $_GET['username'];		
		
		require_once('dbHelper.php');
		
		$sq="SELECT item_id FROM employee WHERE employee_id='".$id."'";
		$quer=mysqli_query($con,$sq);
		$result=mysqli_fetch_array($quer);
		$iid=$result["item_id"];
		
		$sql = "UPDATE payment_details SET payment_mode='".$paymode."',payment_received_by='".$una."',note='".$sts."' WHERE item_id='".$iid."'";
		
		
		if(mysqli_query($con,$sql)){
			echo "Successfully Registered";
		}
		else
		{
			echo "Could not register";

		}
	