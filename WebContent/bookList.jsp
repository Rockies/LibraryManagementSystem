<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书列表</title>
</head>
<body>
<table style="border:1px solid green">
<tr><td>图书名<td>作者<td>出版日期<td>价格<td>所属分类<td>出版社</tr>
<s:iterator value="books" var="book">
<tr><td><s:property value="#book.bookName"/>
<td><s:property value="#book.author"/>
<td><s:property value="#book.publisherDate"/>
<td><s:property value="#book.price"/>
<td><s:property value="#book.publisherName"/>
<td><s:property value="#book.classification"/>
<td><s:url var="addCover" action="addCover">
         <s:param name="book.bookId" value="#book.bookId"/></s:url>
      <a href="${addCover}">添加封面</a>
</s:iterator>
</table>

</body>
</html>