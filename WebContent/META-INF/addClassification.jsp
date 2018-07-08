<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新增分类</title>
</head>
<body>
<s:form name="form" method="post" action="doAddClassification" theme="simple">
新增分类：<s:textfield name="classification.classification"/>
<s:submit value="新增"/>
</s:form>
</body>
</html>