<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>出版社列表</title>
</head>
<body>
<table style="border:1px solid green">
<tr><td>编号<td>分类</tr>
<s:iterator value="classificationList" var="classification">
<tr><td><s:property value="#classification.classificationId"/>
<td><s:property value="#classification.classification"/>
</s:iterator>
</table>
</body>
</html>