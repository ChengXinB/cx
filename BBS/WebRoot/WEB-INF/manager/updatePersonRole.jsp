<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.mjs.com/myel" prefix="myel" %>
<%@ include file="header.jsp" %>

<div class="content-box">
      <!-- Start Content Box -->
      <div class="content-box-header">
        <h3>角色表</h3>
        <ul class="content-box-tabs">
          
          <!-- href must be unique and match the id of target div -->
          
        </ul>
        <div class="clear"></div>
      </div>
      <!-- End .content-box-header -->
      <div class="content-box-content">
       
        <!-- End #tab1 -->
        
        
        
        
         <div class="tab-content default-tab" id="tab1">
          <!-- This is the target div. id must match the href of this div's tab -->
         <form action="${pageContext.request.contextPath }/manager/person_updateRole.action" method="post">
          <table>
            <thead>
              <tr>
                <th>
		            <p>
		              <input class="text-input small-input" type="text" id="small-input" name="p_username" />
		             &nbsp; &nbsp; &nbsp; <input type="submit" value="查找">
		              <!-- Classes for input-notification: success, error, information, attention -->
		              <br />
		            <p>
                </th>
                <th></th>
              </tr>
            </thead>
            </table>
            </form>
         </div>
        
        
        
        
        
        
        
         <div class="tab-content default-tab" id="tab1">
          <!-- This is the target div. id must match the href of this div's tab -->
         <form action="${pageContext.request.contextPath }/manager/person_updateRole.action" method="post">
         <input type="hidden" name="p_username" value="<s:property value='#request.person.p_username'/>"/>
          <table>
            <thead>
              <tr>
                <th>昵称</th>
                <th>权限</th>
                <th>操作</th>
              </tr>
            </thead>
            
            
            <tfoot>
              <tr>
                <td colspan="6">
                 
                  <!-- End .pagination -->
                  <div class="clear"></div>
                </td>
              </tr>
            </tfoot>
           
            
            
            <tbody>
             
              <tr>
                <td>${requestScope.person.p_nick }</td>
                <td>
                
	               <c:forEach items="${requestScope.roles }" var="role"> 
	                	${role.r_name }
	                	<input type="checkbox" name="role" value="${role.r_name }" ${myel:checkUtil(role.r_name,requestScope.person.p_role)}/>&nbsp;&nbsp;
               		 </c:forEach>
                </td>
                <td>
                  <!-- Icons -->
                  <a href="#" title="Edit"><img src="${pageContext.request.contextPath}/resources/images/icons/pencil.png" alt="Edit" /></a> 
                  <a href="#" title="Delete"><img src="${pageContext.request.contextPath}/resources/images/icons/cross.png" alt="Delete" /></a> 
                  <input type="image" src="${pageContext.request.contextPath}/resources/images/icons/hammer_screwdriver.png"> </td>
              </tr>
          	
            </tbody>
          </table>
          </form>
        </div>
        
        
        
        
        
        
        
        
        
        
        <!-- End #tab2 -->
      </div>
      <!-- End .content-box-content -->
		</div>






<%@ include file="last.jsp" %>
