<?php 

	if($_SERVER['REQUEST_METHOD']=='GET'){
		
		$id  = $_GET['iid'];
		
		require_once('dbHelper.php');
		
		$sq="SELECT item_id FROM employee WHERE employee_id='".$id."'";
		$quer=mysqli_query($con,$sq);
		$result=mysqli_fetch_array($quer);
		$itid=$result["item_id"];
		
		$sql = "SELECT * FROM payment_details WHERE item_id='".$itid."'";
		
		$r = mysqli_query($con,$sql);
		
		$res = mysqli_fetch_array($r);
		
		
		$result = array();
		
		array_push($result,array(
			"name"=>$res['material_type'],
			"address"=>$res['material_weight'],
			"service"=>$res['amount_payable']
			)
		);
		
		echo json_encode(array("result"=>$result));
		
		mysqli_close($con);
		
	}