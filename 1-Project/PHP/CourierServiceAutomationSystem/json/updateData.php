		<?php

		$stat = $_GET['id'];		
		$iid = $_GET['iid'];		
		
		$status=str_replace("+"," ",$stat);
		
		require_once('dbHelper.php');
		
		$sq="SELECT item_id FROM employee WHERE employee_id='".$iid."'";
		$quer=mysqli_query($con,$sq);
		$result=mysqli_fetch_array($quer);
		$itid=$result["item_id"];
		
		$sql = "UPDATE delivery_item_management SET delivery_status='".$status."' WHERE  delivery_id='".$itid."'";
	
		
		if(mysqli_query($con,$sql)){
			echo "Successfully Registered";
		}
		else
		{
			echo "Could not register";

		}
	
	