<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>

<br>
  <table width="70%" height="22" border="0" cellpadding="3" cellspacing="0" align="center">
    <tbody >
      <tr valign="top" align="left">
        <td><span class="a"><img src="${pageContext.request.contextPath}/client/images/post-16x16.gif" alt="发表新主题" border="0" height="16" width="16" /> 发表新主题</span><span class="nobreak">　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　页:
          <s:property value='totalpage'/> - <span class="jive-paginator"> [ <a href="${pageContext.request.contextPath }/invitation/invitation_listAllInvitation.action?pagenum=<s:property value='pagenum==1?1 : pagenum-1'/>">上一页</a> | 
         <s:iterator begin="startPage" end="endPage" var="w">
          <a href="${pageContext.request.contextPath }/invitation/invitation_listAllInvitation.action?pagenum=<s:property value='#w'/>" class="jive-current"><s:property value='#w'/></a> 
          </s:iterator>
           | 
          <a href="${pageContext.request.contextPath }/invitation/invitation_listAllInvitation.action?pagenum=<s:property value='endPage'/>">下一页</a> ] </span> </span> </td>
      </tr>
    </tbody>
  </table>
  <table border="0" cellpadding="0" cellspacing="0" width="70%" align="center">
    <tbody>
      <tr valign="top">
        <td width="99%">
		<div class="jive-thread-list">
          <div class="jive-table">
<table summary="List of threads" cellpadding="0" cellspacing="0" width="100%">
                <thead>
                  <tr>
                    <th class="jive-first" colspan="3"> 主题 </th>
                    <th class="jive-author"> <nobr> 作者
                      &nbsp; </nobr> </th>
                    <th class="jive-view-count"> <nobr> 浏览
                      &nbsp; </nobr> </th>
                    <th class="jive-search-results" nowrap="nowrap"> 回复 </th>
                    <th class="jive-last" nowrap="nowrap"> 发表时间 </th>
                    <th class="jive-last" nowrap="nowrap"> 操作 </th>
                  </tr>
                </thead>
                <tbody>
				<s:iterator value="%{records}" var="record">
                  <tr class="jive-even">
                    <td class="jive-first" nowrap="nowrap" width="1%"><div class="jive-bullet"> <img src="${pageContext.request.contextPath}/client/images/read-16x16.gif" alt="已读" border="0" height="16" width="16">
                        <!-- div-->
                      </div></td>
     
                    <td class="jive-thread-name" width="95%" colspan=2><a id="jive-thread-1" href="${pageContext.request.contextPath}/invitation/invitation_findInvitation.action?inId=<s:property value="#record.i_id"></s:property>"><s:property value="#record.i_name"></s:property></a></td>
                    <td class="jive-author" nowrap="nowrap" width="1%"><span class=""> <a href="${pageContext.request.contextPath}/manager/person_showPersonDetail.action?personUsername=<s:property value="#record.i_person.p_username"></s:property>"><s:property value="#record.i_person.p_nick"></s:property></a> </span></td>
                    <td class="jive-view-count" width="1%"><s:property value="#record.i_stime"></s:property></td>
                    <td class="jive-msg-count" width="1%"><s:property value="#record.i_rtime"></s:property></td>
                    <td class="jive-last" nowrap="nowrap" width="1%"><div class="jive-last-post"><s:property value="record.i_date"></s:property><br>
                        <a href="#" title="jingjiangjun" style=""><s:date name="#record.i_date" format="yyyy-MM-dd HH:mm:ss"/> &#187;</a> </div></td>
                        <td class="jive-view-count" width="1%"><a href="${pageContext.request.contextPath }/invitation/invitation_clientDelInvitation.action?invitationId=<s:property value="#record.i_id"></s:property>">删除</a></td>
                  </tr>
				  
				  
				  
				  
				  </s:iterator>
				  
				  
				  
				  
				  
				  
				  
				  
				  
                </tbody>
              </table>
            </div>
          </div>
          <div class="jive-legend"></div></td>
      </tr>
    
    </tbody>
</table>
</div>
<table width="70%" height="22" border="0" cellpadding="3" cellspacing="0" align="center">
    <tbody >
      <tr valign="top"  align="right">
        <td>   <span class="nobreak"> 页:
          <s:property value='totalpage'/> - <span class="jive-paginator"> [ <a href="${pageContext.request.contextPath }/invitation/invitation_listAllInvitation.action?pagenum=<s:property value='pagenum==1?1 : pagenum-1'/>">上一页</a> | 
         <s:iterator begin="startPage" end="endPage" var="w">
          <a href="${pageContext.request.contextPath }/invitation/invitation_listAllInvitation.action?pagenum=<s:property value='#w'/>" class="jive-current"><s:property value='#w'/></a> 
          </s:iterator>
           | 
          <a href="${pageContext.request.contextPath }/invitation/invitation_listAllInvitation.action?pagenum=<s:property value='endPage'/>">下一页</a> ] </span> </span> </td>
      </tr>
    </tbody>
</table>


<div class="bottom_Info" align="justify">
 免责声明：站内会员言论仅代表个人观点，并不代表本站同意其观点，本站不承担由此引起的法律责任。</div>
