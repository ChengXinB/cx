<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.mjs.com/myel" prefix="myel" %>
<%@ include file="header.jsp" %>


<div class="content-box">
      <!-- Start Content Box -->
      <div class="content-box-header">
        <h3>角色</h3>
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
         </div>
        
        
        
        
        
        
        
         <div class="tab-content default-tab" id="tab1">
          <!-- This is the target div. id must match the href of this div's tab -->
        
          <table>
            <thead>
              <tr>
                <th>
                  <input  type="checkbox" />
                </th>
                <th>角色名</th>
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
            <c:forEach items="${requestScope.roles }" var="r">
              <form action="${pageContext.request.contextPath }/role/role_upAuthority.action" method="post"> 
            	 <input type="hidden" name="rol" value="${r.r_name }"/>
					              <tr>
								                <td>
								                  <input type="checkbox" />
								                </td>
						                		 <td><a href="#" title="title">${r.r_name }</a></td>
								                 <td>
								                 		<c:forEach items="${requestScope.authoritys }" var="a">
									                	${a.a_name }&nbsp;
									                	<input type="checkbox" name="auth" value="${a.a_name }" ${myel:checkUtil(a.a_name,r.r_name) }/>&nbsp;&nbsp;
									                	
									                	</c:forEach>
								               	</td>
								                <td>
								                  <!-- Icons -->
								                  <a href="#" title="Edit"><img src="${pageContext.request.contextPath}/resources/images/icons/pencil.png" alt="Edit" /></a>
								                  <a href="#" title="Delete"><img src="${pageContext.request.contextPath}/resources/images/icons/cross.png" alt="Delete" /></a>
								                  <input type="image" src="${pageContext.request.contextPath}/resources/images/icons/hammer_screwdriver.png" alt="修改权限" title="修改权限">
								                </td>
					              </tr>
              </form>
           </c:forEach>
            </tbody>
          </table>
         
        </div>
        
        
        
        	
        
        
        
        
        
        
        <!-- End #tab2 -->
      </div>
      <!-- End .content-box-content -->
</div>






<%@ include file="last.jsp" %>
