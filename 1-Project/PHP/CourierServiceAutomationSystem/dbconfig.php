<?php
if(!mysql_connect("localhost","root",""))
{
     die('oops connection problem ! --> '.mysql_error());
}
if(!mysql_select_db("courier_service"))
{
     die('oops database selection problem ! --> '.mysql_error());
}
?>