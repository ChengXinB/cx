<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>点评首页</title>
<link  rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/client/css/index.css"  />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/client/css/style.css" >

</head>

<body>
<c:if test="${sessionScope.clientPerson==null }">
<div class="head">
   <div class="inhead">
     <div class="inheadleft"> 收藏 | </div> 
     <div class="inheadright"><a href="${pageContext.request.contextPath}/client/login.jsp">用户登陆</a> | <a href="${pageContext.request.contextPath}/client/regist.jsp">注册</a></div>
   </div>
</div>
</c:if>
<c:if test="${sessionScope.clientPerson!=null }">
<div class="head">
   <div class="inhead">
     <div class="inheadleft"> <a href="${pageContext.request.contextPath }">回首页</a> | <a href="${pageContext.request.contextPath }/manager/person_showMeInvitation.action">查看自己的帖子</a></div> 
     <div class="inheadright">欢迎您：<a href="${pageContext.request.contextPath}/manager/person_showPersonDetail.action?personUsername=${sessionScope.clientPerson.p_username }">${sessionScope.clientPerson.p_nick }</a> | <a href="${pageContext.request.contextPath}/manager/person_clientUnLogin">注销</a></div>
   </div>
</div>
</c:if>
<div class="logo">
	<img src="${pageContext.request.contextPath}/client/images/banner.jpg" width="960" height="140"/>
	<br>
	<div><b>当前板块：</b>技术人生</div>
</div>