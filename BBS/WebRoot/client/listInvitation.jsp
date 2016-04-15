<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>点评首页</title>
	<link  rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/client/css/index.css"  />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/client/css/style.css" />
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/utf8-jsp/ueditor.config.js"></script> 
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/utf8-jsp/ueditor.all.min.js"> </script> 
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
 	 <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/utf8-jsp/lang/zh-cn/zh-cn.js"></script> 
</head>

<body>

<c:if test="${sessionScope.clientPerson==null }">
<div class="head">
   <div class="inhead">
     <div class="inheadleft"> 收藏 | <a href="${pageContext.request.contextPath }">回首页</a></div> 
     <div class="inheadright"><a href="${pageContext.request.contextPath}/client/login.jsp">用户登陆</a> | <a href="${pageContext.request.contextPath}/client/regist.jsp">注册</a></div>
   </div>
</div>
</c:if>
<c:if test="${sessionScope.clientPerson!=null }">
<div class="head">
   <div class="inhead">
     <div class="inheadleft"> 收藏 | <a href="${pageContext.request.contextPath }">回首页</a></div> 
     <div class="inheadright">欢迎您：<a href="${pageContext.request.contextPath}/client/login.jsp">${sessionScope.clientPerson.p_nick }</a> | <a href="${pageContext.request.contextPath}/manager/person_clientUnLogin">注销</a></div>
   </div>
</div>
</c:if>

<div class="logo">
	<img src="${pageContext.request.contextPath}/client/images/banner.jpg" width="960" height="140"/>
	<br>
</div>


<div>
<table width="969" border="0" align="center" >
  <tr>
    <td colspan="2" bgcolor="#CCCCFF" height="20"><b>主贴标题:</b><s:property value="invitation.i_name"/></td>
    </tr>
  <tr bgcolor="#CCCCFF" style="border-right:#00000 1px;border-left:#000000 1px;border-top:#000000 1px;border-bottom:#000000 1px">
    <td width="151" bgcolor="#FFFFFF"><table border="0" cellpadding="0" cellspacing="0" width="150">
      <tbody>
	  
	  
        <tr>
          <td bgcolor="#9FDDD6"><table border="0" cellpadding="0" cellspacing="0" width="100%">
            <tbody>
              <tr valign="top">
                <td style="padding: 0px;" width="1%"><nobr><s:property value="invitation.i_person.p_nick"/></nobr></td>
                <td style="padding: 0px;" width="99%"><img class="jive-status-level-image" src="${pageContext.request.contextPath}/client/images/level3.gif" title="世界新手" alt="" border="0" /><br /></td>
              </tr>
            </tbody>
          </table>
            <br />
            <img src="${pageContext.request.contextPath}/manager/person_showImage?personUsername=<s:property value='invitation.i_person.p_username'></s:property>" width="108" height="93" /><br />
            <span class="jive-description"> 发表:
               <s:property value="invitation.i_person.p_time"/> <br />
              
              注册:
             <s:property value="invitation.i_person.p_date"/> <br />
              
        </tr>
      </tbody>
    </table></td>
    <td valign="top"><s:property value="invitation.i_title"/></td>
    </tr>
</table>
</div>

<s:iterator value="invitation.i_leave" var="leave">


<div>
<table width="969" border="0" align="center" >
  <tr>
    <td colspan="2"  height="10"></td>
    </tr>
  <tr bgcolor="#CCCCFF" style="border-right:#00000 1px;border-left:#000000 1px;border-top:#000000 1px;border-bottom:#000000 1px">
    <td width="151" bgcolor="#FFFFFF"><table border="0" cellpadding="0" cellspacing="0" width="150">
      <tbody>
        <tr>
          <td bgcolor="#9FDDD6"><table border="0" cellpadding="0" cellspacing="0" width="100%">
            <tbody>
              <tr valign="top">
                <td style="padding: 0px;" width="1%"><nobr><s:property value="#leave.l_person.p_nick"/></nobr></td>
                <td style="padding: 0px;" width="99%"><img class="jive-status-level-image" src="${pageContext.request.contextPath}/client/images/level3.gif" title="世界新手" alt="" border="0" /><br /></td>
              </tr>
            </tbody>
          </table>
            <br />
            <img src="${pageContext.request.contextPath}/manager/person_showImage?personUsername=<s:property value='#leave.l_person.p_username'></s:property>" width="111" height="125" /><br />
            <span class="jive-description"> 发表:
              <s:property value="#leave.l_person.p_time"/> <br />
              注册:
              <s:property value="#leave.l_person.p_date"/> <br />
        </tr>
      </tbody>
    </table></td>
    <td valign="top"><s:property value="#leave.l_content"/></td>
    </tr>
</table>


</s:iterator>
<form action="${pageContext.request.contextPath }/invitation/invitation_addLeave.action" method="post">
	<input type="hidden" name="invit" value="<s:property value='invitation.i_id'></s:property>">
	 <a name="first" id="first">  <div class="outer-line" >
	   		<table align="center" width="700" height="300">			
				<tr>			
					<td>
						<div>
						  <script id="editor" type="text/plain" style="width:700px;height:300px;"></script>
						</div>
					</td>
				</tr>
		              
		        <tr>
		            <td  align="center" colspan="2">
		                <input name="submit" type="submit" value="发帖"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                <input name="submit" type="reset" value="重置"/>
		            </td>
		        </tr>
		    </table>
           </div>
		</a>          
</form>
</div>
<div class="bottom_Info" align="justify">
免责声明：站内会员言论仅代表个人观点，并不代表本站同意其观点，本站不承担由此引起的法律责任。
</div>
<script type="text/javascript">
var ue = UE.getEditor('editor');
</script>
</body>
</html>