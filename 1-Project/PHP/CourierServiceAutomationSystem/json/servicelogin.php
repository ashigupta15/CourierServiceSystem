<?php

$username = $_POST['username'];
$password = $_POST['password'];

require_once('dbHelper.php');
$sql = "SELECT * FROM employee WHERE employee_name='$username' and employee_id='$password'";   
$res = mysqli_query($con,$sql);
$check = mysqli_fetch_array($res);
if(isset($check)){
echo 'success';
}else{
echo 'failure';
}
?>