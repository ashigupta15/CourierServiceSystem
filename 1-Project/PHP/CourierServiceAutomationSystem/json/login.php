<?php

$username = $_POST['username'];
$password = $_POST['password'];

require_once('dbHelper.php');
$sql = "SELECT * FROM user_details WHERE user_name='$username' and user_password='$password'";   
$res = mysqli_query($con,$sql);
$check = mysqli_fetch_array($res);
if(isset($check)){
echo 'success';
}else{
echo 'failure';
}
?>