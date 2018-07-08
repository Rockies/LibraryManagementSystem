<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>编辑出版社信息</title>
</head>
<body>
<s:form action="updatePublisher">
<s:hidden name="publisher.publisherId"></s:hidden>
<s:textfield name="publisher.publisher" label="出版社"/>
<s:submit value="修改"/>
</s:form>
</body>
</html>