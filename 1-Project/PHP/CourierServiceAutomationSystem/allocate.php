<?php
include 'dbconfig.php';
$itemid=$_GET['id'];
$empid=$_GET['emid'];
$selemp=mysql_query("SELECT * FROM employee WHERE employee_table_id='$empid'");
$empfe=mysql_fetch_array($selemp);
$emp_name=$empfe["employee_name"];
mysql_query("UPDATE delivery_item_management SET collecting_person_name='$emp_name',delivery_status='need to collect',user_intimation_status='allocated' WHERE table_id='$itemid'");
mysql_query("UPDATE employee SET type_of_service='receiving',item_id='$itemid' WHERE employee_table_id='$empid'");
?>
<script>
alert("Successfully Allocated");
window.location.href='Home.php';
</script>