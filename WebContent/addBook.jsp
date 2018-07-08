<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
    <%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
	<%@ taglib prefix="sjr" uri="/struts-jquery-richtext-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新增图书</title>
<s:head/>
<sj:head/>
</head>
<body>
<form name="form" action="doAddBook">
<s:textfield name="book.isbn" label="书籍ISBN号"></s:textfield><br>
<s:textfield name="book.bookName" label="书名"></s:textfield><br>
<s:textfield name="book.author" label="作者"></s:textfield><br>
<s:select list="classMap" name="book.classificationId" label="请选择分类"></s:select><br>
<s:select list="publisherMap" name="book.publisherId" label="请选择出版社"></s:select><br>
选择出版日期<input type="date" name="book.publisherDate"/><br>
<s:textfield name="book.price" label="输入价格"/><br>
<input type="submit" value="添加"/>
</form>

</body>
</html>