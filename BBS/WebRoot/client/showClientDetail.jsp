<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>用户信息</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/client/css/register.css" />

</script>
</head>


<body style="overflow-y:hidden; ">




	<div class="mod-header grid-96">
	</div>

	<div class="regoutter">
		<div class="reginner">
				<s:hidden name="p_username" />
				<table width="100%">
					<tr>
						<td class="fronttd">登录账号</td>
						<td style="width:200px">：<s:property value="p_username" /></td>
						<td align="left"><div id="usrdiv"></div>
						</td>
					</tr>
					<tr>
						<td class="fronttd">昵称</td>
						<td>：<s:property value="p_nick" /></td>
						<td align="left"><div id="nicknamediv"></div>
						</td>
					</tr>
					<tr>
						<td class="fronttd">性别</td>
						<td>
							：${requestScope.person.p_sex=='1'?"男":"女" }
							
							</td>
						<td align="left"><div id="nicknamediv"></div>
						</td>
					</tr>
					<tr>
						<td class="fronttd">生日</td>
						<td>：<s:property value="p_rbirthday" /> </td>
						<td align="left"><div id="repwddiv">${requestScope.errors.p_birthday
								}</div>
						</td>
					</tr>
					<tr>
						<td class="fronttd">照片：</td>
						<td><img
							src="${pageContext.request.contextPath}/manager/person_showImage?personUsername=<s:property value='p_username'></s:property>"
							width="108" height="93" /><br />
						</td>
						<td align="left"><div id="repwddiv"></div></td>
					</tr>

					
					<table>
						</div>
						</div>

						<div class="regFooter"><a href="${pageContext.request.contextPath }">回首页</a></div>

						${message }
</body>
</html>
