<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<title>BBS论坛管理</title>
<!--                       CSS                       -->
<!-- Reset Stylesheet -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css" type="text/css" media="screen" />
<!-- Main Stylesheet -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" type="text/css" media="screen" />
<!-- Invalid Stylesheet. This makes stuff look pretty. Remove it if you want the CSS completely valid -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/invalid.css" type="text/css" media="screen" />
<!--                       Javascripts                       -->
<!-- jQuery -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/ajax.js"></script>
<!-- jQuery Configuration -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/simpla.jquery.configuration.js"></script>
<!-- Facebox jQuery Plugin -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/facebox.js"></script>
<!-- jQuery WYSIWYG Plugin -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/jquery.wysiwyg.js"></script>
<!-- jQuery Datepicker Plugin -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/jquery.datePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/jquery.date.js"></script>
</head>
<body>
<div id="body-wrapper">
  <!-- Wrapper for the radial gradient background -->
  <div id="sidebar">
    <div id="sidebar-wrapper">
      <!-- Sidebar with logo and menu -->
      <h1 id="sidebar-title"><a href="#">Simpla Admin</a></h1>
      <!-- Logo (221px wide) -->
      <a href="#"><img id="logo" src="${pageContext.request.contextPath}/resources/images/logo.png" alt="Simpla Admin logo" /></a>
      <!-- Sidebar Profile links -->
      <div id="profile-links"> 您好, <a href="#" title="Edit your profile">${sessionScope.managerPerson.p_nick }</a>, 欢迎您 <!-- <a href="#messages" rel="modal" title="3 Messages">3 条信息</a> --><br />
        <br />
        <a href="#" title="View the Site">重新登录</a> | <a href="${pageContext.request.contextPath}/manager/person_unlogin.action" title="Sign Out">注销</a> </div>
      <ul id="main-nav">
        <!-- Accordion Menu -->
        <li> <a href="#/" class="nav-top-item no-submenu">
          <!-- Add the class "no-submenu" to menu items with no sub menu -->
          	注册人员管理 </a> 
          	
          <ul>
            <li><a href="${pageContext.request.contextPath }/manager/person_listLimitPerson.action">查看所有注册人员</a></li>
            <li><a href="${pageContext.request.contextPath }/manager/person_findPersonByNick.action">按昵称查找</a></li>
            <!-- Add class "current" to sub menu items also -->
            <li><a href="${pageContext.request.contextPath }/manager/person_findLimitInvitation.action">查看发帖</a></li>
          </ul>
          	
          	</li>
        <li> <a href="#" class="nav-top-item no-submenu">
          <!-- Add the class "current" to current menu item -->
          发帖管理 </a>
          <ul>
            <li><a href="${pageContext.request.contextPath }/invitation/invitation_findAllInvitation.action">查看所有帖子</a></li>
            <li><a href="${pageContext.request.contextPath }/invitation/invitation_findInvitationByName.action">按名称查找</a></li>
            <!-- Add class "current" to sub menu items also -->
          </ul>
        </li>
        <li> <a href="#" class="nav-top-item"> 角色管理 </a>
          <ul>
            <li><a href="${pageContext.request.contextPath }/role/role_findAllRole.action">查看所有角色</a></li>
            <li><a href="${pageContext.request.contextPath }/manager/person_addPerson.action">添加角色</a></li>
            <li><a href="${pageContext.request.contextPath }/role/role_updateRole.action">修改角色</a></li>
          </ul>
        </li>
        <li> <a href="#" class="nav-top-item"> 权限管理 </a>
          <ul>
            <li><a href="${pageContext.request.contextPath }/authority/authority_findAllAuthority">查看所有权限</a></li>
            <li><a href="#">添加权限</a></li>
            <li><a href="#">修改权限</a></li>
          </ul>
        </li>
        <li> <a href="javascript:ss(){alert('暂未实现！')}" class="nav-top-item"> 暂未实现 </a>
          <ul>
          </ul>
        </li>
      </ul>
     
      
      <!-- 弹窗 -->
      <div id="messages" style="display: none">
        <!-- Messages are shown when a link with these attributes are clicked: href="#messages" rel="modal"  -->
        <h3>3 Messages</h3>
        <p> <strong>17th May 2009</strong> by Admin<br />
          Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus magna. Cras in mi at felis aliquet congue. <small><a href="#" class="remove-link" title="Remove message">Remove</a></small> </p>
        <p> <strong>2nd May 2009</strong> by Jane Doe<br />
          Ut a est eget ligula molestie gravida. Curabitur massa. Donec eleifend, libero at sagittis mollis, tellus est malesuada tellus, at luctus turpis elit sit amet quam. Vivamus pretium ornare est. <small><a href="#" class="remove-link" title="Remove message">Remove</a></small> </p>
        <p> <strong>25th April 2009</strong> by Admin<br />
          Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus magna. Cras in mi at felis aliquet congue. <small><a href="#" class="remove-link" title="Remove message">Remove</a></small> </p>
        <form action="#" method="post">
          <h4>New Message</h4>
          <fieldset>
          <textarea class="textarea" name="textfield" cols="79" rows="5"></textarea>
          </fieldset>
          <fieldset>
          <select name="dropdown" class="small-input">
            <option value="option1">Send to...</option>
            <option value="option2">Everyone</option>
            <option value="option3">Admin</option>
            <option value="option4">Jane Doe</option>
          </select>
          <input class="button" type="submit" value="Send" />
          </fieldset>
        </form>
      </div>
      
      
      
      <!-- End #messages -->
    </div>
  </div>
  <!-- End #sidebar -->
  <div id="main-content">
    <!-- Main Content Section with everything -->
    <noscript>
    <!-- Show a notification if the user has disabled javascript -->
    <div class="notification error png_bg">
      <div> Javascript is disabled or is not supported by your browser. Please <a href="http://browsehappy.com/" title="Upgrade to a better browser">upgrade</a> your browser or <a href="http://www.google.com/support/bin/answer.py?answer=23852" title="Enable Javascript in your browser">enable</a> Javascript to navigate the interface properly.
        Download From <a href="http://www.exet.tk">exet.tk</a></div>
    </div>
    </noscript>
    <!-- Page Head -->
    <h2>BBS论坛管理</h2>
    <p id="page-intro">What would you like to do?</p>

    <!-- 图标 -->
    
    <ul class="shortcut-buttons-set">
      <li><a class="shortcut-button" href="${pageContext.request.contextPath}/manager/person_addPerson.action"><span> <img src="${pageContext.request.contextPath}/resources/images/icons/pencil_48.png" alt="icon" /><br />
       	添加会员 </span></a></li>
      <li><a class="shortcut-button" href="${pageContext.request.contextPath}/manager/person_updateRole.action"><span> <img src="${pageContext.request.contextPath}/resources/images/icons/paper_content_pencil_48.png" alt="icon" /><br />
       	 分配角色 </span></a></li>
      <li><a class="shortcut-button" href="#"><span> <img src="${pageContext.request.contextPath}/resources/images/icons/image_add_48.png" alt="icon" /><br />
        	删除信息 </span></a></li>
      <li><a class="shortcut-button" href="#"><span> <img src="${pageContext.request.contextPath}/resources/images/icons/clock_48.png" alt="icon" /><br />
        Add an Event </span></a></li>
      <li><a class="shortcut-button" href="#messages" rel="modal"><span> <img src="${pageContext.request.contextPath}/resources/images/icons/comment_48.png" alt="icon" /><br />
        Open Modal </span></a></li>
    </ul>
    
    
    
    
    
    
    <!-- End .shortcut-buttons-set -->
    <div class="clear"></div>
    <!-- End .clear -->
    <!-- End .content-box -->
    
    
    
    
    <div id="listAllPerson"></div>