<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login</title>
    <style>
		#main{
			width: 400px;
			height: 330px;
			flex-direction:column;
			border-radius: 2px;
			border: lightgrey solid 1px;
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
			height: 195px;
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
        }#btn1{
            margin-left: 25px;
            margin-top: 10px;
            background-color: lightgreen;
            text-align: center;
        }#btn2{
            margin-left: 25px;
            margin-top: 10px;
            background-color: lightgreen;
            text-align: center;
            z-index: 2000;
            position: absolute;
        }#btn2:hover{
            background-color: green;
            transition: all 0.5s ease;
        }#btn1:hover{
            background-color: green;
            transition: all 0.5s ease;
        }
	</style>
</head>
<body>
<div style="display: flex; justify-content: center;">
	<div id="main">
    <form action="login" method="post" style="width: 400px; height: 100%; margin: auto;">

		<div class="top">Sign In</div>
		<div class="mid">
        <div class="br1"></div>

        <label  for="email"><span>Email address</span>
            <div class="br2"></div>
            <input type="email" placeholder="   type here..." id="email" name ="email">
        </label>
        <div class="br1"></div>
        <label  for="password"><span>Password</span>
            <div class="br2"></div>
            <input type="password" placeholder="   type here..." id="password" name ="password">
        </label>
        <div class="br1"></div>


		</div>
		<div class="bot">
		    <input id="btn1" type="submit" value="Submit">
		</div>

    </form>

    <form action="register" method="get" style="width: 400px; height: 100%; margin: auto; margin-top: -40px">
        <input id="btn2" type="submit" value="Make new account" style="width: 150px; height:20px;">
    </form>
</div>
</div>
</body>
</html>
