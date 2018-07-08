<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>欢迎管理员登录</title>
</head>
<body>

<a href="addClassification.jsp">新增分类</a>
<a href="addPublisher.jsp">新增出版社</a>
<s:url var="ClassificationList" action="ClassificationList">
      </s:url>
      <a href="${ClassificationList}">类别列表</a>
<s:url var="PublisherList" action="PublisherList">
 </s:url>
      <a href="${PublisherList}">出版社列表</a>
  <s:url var="addBook" action="addBookPage"/>
      <a href="${addBook}" >添加图书</a>
<s:url var="logout" action="dologout">
      </s:url>
      <a href="bookList">图书列表</a>
      <a href="${logout}">注销</a>
      
</body>
</html>