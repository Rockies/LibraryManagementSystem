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
<tr><td>编号<td>出版社名<td>操作</tr>
<s:iterator value="publisherList" var="publisher">
<tr><td><s:property value="#publisher.publisherId"/>
<td><s:property value="#publisher.publisher"/>
<td><s:url var="editPublisher" action="editPublisher">
         <s:param name="publisher.publisherId" value="#publisher.publisherId"/>
          <s:param name="publisher.publisher" value="#publisher.publisher"/></s:url>
      <a href="${editPublisher}">编辑出版社信息</a>
      <s:url var="delPublisher" action="delPublisher">
         <s:param name="publisher.publisherId" value="#publisher.publisherId"/>
         </s:url>
      <a href="${delPublisher}">删除</a>
</s:iterator>
</table>
</body>
</html>