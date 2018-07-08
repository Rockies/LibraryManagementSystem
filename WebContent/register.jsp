<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
       <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册</title>
</head>
<body>
<s:form name="form" method="post" action="doregister">
<s:textfield name="user.userName" label="用户名"/>
<s:password name="user.password" label="密码"/>
<s:password name="rePassword" label="重复密码"/>
<s:submit value="注册"/>
</s:form>
</body>
</html>