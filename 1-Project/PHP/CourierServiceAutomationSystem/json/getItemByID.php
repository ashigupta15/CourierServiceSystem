<?php 

	if($_SERVER['REQUEST_METHOD']=='GET'){
		
		$id  = $_GET['un'];
		
		require_once('dbHelper.php');
		
		$sql = "SELECT * FROM delivery_item_management WHERE delivery_id='".$id."'";
		$sql1 = "SELECT * FROM payment_details WHERE item_id='".$id."'";
		
		$r = mysqli_query($con,$sql);
		$r1 = mysqli_query($con,$sql1);
		
		$res = mysqli_fetch_array($r);
		$res1 = mysqli_fetch_array($r1);
		
		$result = array();
		
		array_push($result,array(
			"sender"=>$res['sender'],
			"sender_address"=>$res['sender_address'],
			"receiver"=>$res['receiver'],
			"receiver_address"=>$res['receiver_address'],
			"collecting_person_name"=>$res['collecting_person_name'],
			"delivery_status"=>$res['delivery_status'],
			"material_type"=>$res1['material_type'],
			"material_weight"=>$res1['material_weight'],
			"amount_payable"=>$res1['amount_payable'],
			"payment_received_by"=>$res1['payment_received_by'],
			"note"=>$res1['note']
			)
		);
		
		echo json_encode(array("result"=>$result));
		
		mysqli_close($con);
		
	}