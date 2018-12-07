<?php
include 'dbconfig.php';
$itemid=$_GET['id'];
$empid=$_GET['emid'];
$selemp=mysql_query("SELECT * FROM employee WHERE employee_table_id='$empid'");
$empfe=mysql_fetch_array($selemp);
$emp_name=$empfe["employee_name"];
mysql_query("UPDATE delivery_item_management SET delevery_person_name='$emp_name',delivery_status='need to deliver',user_intimation_status='allocate to deliver' WHERE table_id='$itemid'");
mysql_query("UPDATE employee SET type_of_service='delivering',item_id='$itemid' WHERE employee_table_id='$empid'");
?>
<script>
alert("Successfully Allocated");
window.location.href='Home.php';
</script>