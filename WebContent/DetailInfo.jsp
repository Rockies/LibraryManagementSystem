<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>书籍详细信息</title>
</head>
<body>
<table border="1">
<tr>
<td>书名</td>
<td><s:property value="book.bookName"/></td>
<tr>
<td>ISBN号</td>
<td><s:property value="book.isbn"/></td>
<tr>
<td>作者</td>
<td><s:property value="book.author"/></td>
<tr>
<td>出版社</td>
<td><s:property value="book.publisherName"/></td>
<tr>
<td>所属分类</td>
<td><s:property value="book.classification"/></td>
<tr>
<td>出版日期</td>
<td><s:property value="book.publisherDate"/></td>
<tr>
<td>价格</td>
<td><s:property value="book.price"/></td>
<tr>
<td>平均评分</td>
<td><s:property value="grade"/></td>
</table>
<hr/>
评价列表：<br>
<s:iterator value="comments" var="comment">
评价用户的编号：<s:property value="#comment.userId"/><br>
<s:property value="#comment.commentary"/><br>
</s:iterator>
<hr>
在此做出你的评价

<form action="addComment" >
<s:hidden name="book.bookId"/>
<s:radio list="{1,2,3,4,5}" name="comment.score" label="请选择分数">
</s:radio>
<br>
在此做出评价：<br>
<s:textarea cols="40" rows="10" name="comment.commentary">
</s:textarea>
<s:submit value="评价"></s:submit>
</form>
</body>
</html>