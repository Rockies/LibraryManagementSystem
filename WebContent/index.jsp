<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>图书馆登录界面模板</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/body.css"/> 
</head>
<body>
<div class="container">
	<section id="content">
		<form action="dologin" method="post">
			<h1>用户登录</h1>
			<div>
				<input type="text" name="user.userName" />
			</div>
			<div>
				<input type="password" name="user.password" />
			</div>
			 <div class="">
				<span class="help-block u-errormessage" id="js-server-helpinfo">&nbsp;</span>			</div> 
			<div>
				<input type="submit" value="登录" class="btn btn-primary" id="js-btn-login"/>
				
				<a href="register.jsp">Register</a> 
			</div>
		</form>
		 <div class="button">
			<span class="help-block u-errormessage" id="js-server-helpinfo">&nbsp;</span>
		</div> 
	</section>
</div>


<br/><br/><br/><br/>

</body>
</html>