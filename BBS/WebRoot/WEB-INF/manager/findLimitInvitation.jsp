<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ include file="header.jsp" %>


<div class="content-box">
      <!-- Start Content Box -->
      <div class="content-box-header">
        <h3>个人贴</h3>
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
         <form action="${pageContext.request.contextPath }/manager/person_findLimitInvitation.action" method="post">
          <table>
            <thead>
              <tr>
                <th>
		            <p>
		              <input class="text-input small-input" type="text" id="small-input" name="p_invita" />
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
                <th>主题</th>
                <th>发表时间</th>
                <th>查看次数</th>
                <th>回复次数</th>
                <th>发帖人</th>
                <th>操作</th>
              </tr>
            </thead>
            
            
            
             <tfoot>
              <tr>
                <td colspan="6">
                 
                  <div class="pagination"> 
	                  	<a href="${pageContext.request.contextPath }/manager/person_findLimitInvitation.action?num=<s:property value='startPage'/>" title="shouye">&laquo; 首页</a>
	                  	<a href="${pageContext.request.contextPath }/manager/person_findLimitInvitation.action?num=<s:property value='pagenum==1?1 : pagenum-1'/>" title="Previous Page">&laquo; 上一页</a> 
	                  	<s:iterator begin="startPage" end="endPage" var="w">
		                  	<a href="${pageContext.request.contextPath }/manager/person_findLimitInvitation.action?num=<s:property value='#w'/>" class="number current" title="3"><s:property value='#w'/></a> 
	                  	</s:iterator>
	                  	<a href="${pageContext.request.contextPath }/manager/person_findLimitInvitation.action?num=<s:property value='pagenum>=endPage?endPage : pagenum+1'/>" title="Next Page">下一页 &raquo;</a>
	                  	<a href="${pageContext.request.contextPath }/manager/person_findLimitInvitation.action?num=<s:property value='endPage'/>" title="Last Page">尾页 &raquo;</a> 
                  </div>
                  <!-- End .pagination -->
                  <div class="clear"></div>
                </td>
              </tr>
            </tfoot>
            
            
            
            
            
            <tfoot>
              <tr>
                <td colspan="6">
                 
                  <!-- End .pagination -->
                  <div class="clear"></div>
                </td>
              </tr>
            </tfoot>
           
            
            <tbody>
             <s:iterator value="%{records}" var="r">
              <tr>
                <td>
                  <input type="checkbox" />
                </td>
                <td><a href="#" title="title"><s:property value="#r.i_name"/></a></td>
                <td><s:date name="#r.i_date" format="yyyy-MM-dd"/></td>
                <td><s:property value="#r.i_stime"/></td>
                <td><s:property value="#r.i_rtime"/></td>
                <td><s:property value="#r.i_person.p_nick"/></td>
                <td>
                  <!-- Icons -->
                  <a href="" title="Edit"><img src="${pageContext.request.contextPath}/resources/images/icons/pencil.png" alt="Edit" /></a> 
                  <a href="${pageContext.request.contextPath }/invitation/invitation_deleteInvitation.action?invitationId=<s:property value='#r.i_id'/>" title="Delete"><img src="${pageContext.request.contextPath}/resources/images/icons/cross.png" alt="Delete" /></a> 
                  <a href="#" title="Edit Meta"><img src="${pageContext.request.contextPath}/resources/images/icons/hammer_screwdriver.png" alt="Edit Meta" /></a> </td>
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
