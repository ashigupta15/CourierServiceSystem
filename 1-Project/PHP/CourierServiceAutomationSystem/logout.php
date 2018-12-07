<?php
session_start();

 session_destroy();
 unset($_SESSION['user']);
 unset($_SESSION['userid']);
 header("Location: index1.php");

?>
		