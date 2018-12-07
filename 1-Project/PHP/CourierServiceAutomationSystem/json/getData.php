<?php 

	if($_SERVER['REQUEST_METHOD']=='GET'){
		
		$id  = $_GET['id'];
		
		require_once('dbHelper.php');
		
		$sql = "SELECT * FROM employee WHERE employee_id='".$id."'";
		
		$r = mysqli_query($con,$sql);
		
		$res = mysqli_fetch_array($r);
		
		$itemid=$res['item_id'];
		
		$sqq="SELECT * FROM delivery_item_management WHERE delivery_id='".$itemid."'";
		$r1 = mysqli_query($con,$sqq);
		$res1 = mysqli_fetch_array($r1);

		$sque="SELECT * FROM payment_details WHERE item_id='".$itemid."'";
		$resu1=mysqli_query($con,$sque);
		$ot=mysqli_fetch_array($resu1);
		
		$result = array();
		
		array_push($result,array(
			"name"=>$ot['amount_payable'],
			"address"=>$res['addrss_allocated'],
			"service"=>$res['type_of_service'],
			"itemid"=>$res['item_id'],
			"sender"=>$res1['sender'],
			"senderaddress"=>$res1['sender_address'],
			"materialtype"=>$ot['material_type'],
			"materialwgt"=>$ot['material_weight']
			)
		);
		
		echo json_encode(array("result"=>$result));
		
		mysqli_close($con);
		
	}