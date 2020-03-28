<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Document</title>
	<style>
		#main{
			width: 400px;
			height: 550px;
			flex-direction: column;
			border-radius: 2px;
			border: lightgrey solid 1px;
            z-index: 100;
            position: absolute;
		}
        .top{
			background-color: forestgreen;
			width: 400px;
			height: 35px;
			color: white;
			text-align: center;
			padding-top: 15px;
			font-size: 18px;
			font-family: sans-serif;
		}
		.mid{
			height: 440px;
			width: 450px;

		}
		.bot{
			height: 50px;
			width: 400px;
			border-top: lightgrey solid 1px;
		}
		input{
			border-radius: 5px;
			border: lightgrey solid 1px;
			height: 35px;
			width: 350px;
			display: flex;
            margin-left: 25px;
		}
		lable{
			margin-left: 25px;
			margin-top: 20px;
			font-size: 18px;
			font-family: sans-serif;
        }span{
            margin-left: 25px;
			margin-top: 200px;
			font-size: 18px;
			font-family: sans-serif;
        }.br1{
            height: 15px;
        }.br2{
            height: 10px;
        }#btn{
            margin-left: 25px;
            margin-top: 10px;
            background-color: lightgreen;
            text-align: center;
        }
	</style>
</head>
<body>
<form action="register" method="post" style="width: 400px; height: 100%; margin: auto;">

    <div style="width: 100%; height: 850px; z-index: 10; background-color: white; position: absolute; top: 0; left: 0"></div>

	<div id="main">
		<div class="top">Sign In</div>
		<div class="mid">
        <div class="br1"></div>
        <label for="firstName"><span>First Name</span>
            <div class="br2"></div>
            <input type="text" placeholder="   type here..." required id="firstName" name ="firstName">
        </label>
        <div class="br1"></div>
        <label  for="secondName"><span>Second Name</span>
            <div class="br2"></div>
            <input type="text" placeholder="   type here..." required id="secondName" name ="secondName">
        </label>
        <div class="br1"></div>
        <label  for="email"><span>Email address</span>
            <div class="br2"></div>
            <input type="email" placeholder="   type here..." id="email" name ="email">
        </label>
        <div class="br1"></div>
        <label  for="password"><span>Password</span>
            <div class="br2"></div>
            <input type="password" placeholder="   type here..." id="password1" name ="password1">
        </label>
        <div class="br1"></div>
        <label><span>Repeat password</span>
            <div class="br2"></div>
            <input type="password" placeholder="   type here..." id="password2" name ="password2">
        </label>
        <div class="br1"></div>

		</div>
		<div class="bot">
		    <input id="btn" type="submit" value="Submit" disabled>
		</div>
	</div>
</form>
	<script src="js/register.js"></script>
</body>
</html>