<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ include file="header.jsp" %>


<div class="content-box">
      <!-- Start Content Box -->
      <div class="content-box-header">
        <h3>会员表</h3>
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
         <form action="${pageContext.request.contextPath }/manager/person_findPersonByNick.action" method="post">
          <table>
            <thead>
              <tr>
                <th>
		            <p>
		              <input class="text-input small-input" type="text" id="small-input" name="p_nick" />
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
         
          <table>
            <thead>
              <tr>
                <th>
                  <input class="check-all" type="checkbox" />
                </th>
                <th>账号</th>
                <th>昵称</th>
                <th>性别</th>
                <th>注册时间</th>
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
             <s:iterator value="%{persons}" var="r">
              <tr>
                <td>
                  <input type="checkbox" />
                </td>
                <td><s:property value="#r.p_username"/></td>
                <td><a href="#" title="title"><s:property value="#r.p_nick"/></a></td>
                <td><s:property value="#r.p_sex==1?'男':'女'"/></td>
                <td><s:property value="#r.p_date"/></td>
                <td>
                  <!-- Icons -->
                  <a href="#" title="Edit"><img src="${pageContext.request.contextPath}/resources/images/icons/pencil.png" alt="Edit" /></a> <a href="#" title="Delete"><img src="${pageContext.request.contextPath}/resources/images/icons/cross.png" alt="Delete" /></a> <a href="#" title="Edit Meta"><img src="${pageContext.request.contextPath}/resources/images/icons/hammer_screwdriver.png" alt="Edit Meta" /></a> </td>
              </tr>
            </s:iterator>
            </tbody>
          </table>
        </div>
        
        
        
        
        
        
        
        
        
        
        <!-- End #tab2 -->
      </div>
      <!-- End .content-box-content -->
</div>






<%@ include file="last.jsp" %>
