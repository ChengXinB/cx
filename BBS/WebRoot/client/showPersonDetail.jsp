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
			<form
				action="${pageContext.request.contextPath }/manager/person_clientUpdate.action"
				method="post" id="regform" name="regform">
				<s:hidden name="p_username" />
				<table width="100%">
					<tr>
						<td class="fronttd">登录账号</td>
						<td style="width:200px"><s:property value="p_username" /></td>
						<td align="left"><div id="usrdiv">${requestScope.errors.p_username
								}</div>
						</td>
					</tr>
					<tr>
						<td class="fronttd">昵称</td>
						<td><s:textfield name="p_nick"></s:textfield></td>
						<td align="left"><div id="nicknamediv"></div>
						</td>
					</tr>
					<tr>
						<td class="fronttd">性别</td>
						<td><input type="radio" name="p_sex" value="1"
							${requestScope.person.p_sex== '1'?"checked='checked' ":"" }/>男 <input
							type="radio" name="p_sex" value="0" ${requestScope.person.p_sex==
							'0'?"checked='checked' ":"" }/>女</td>
						<td align="left"><div id="nicknamediv"></div>
						</td>
					</tr>
					<tr>
						<td class="fronttd">密码</td>
						<td><s:password name="p_password"></s:password></td>
						<td align="left"><div id="pwddiv">${requestScope.errors.p_password
								}</div>
						</td>
					</tr>
					<tr>
						<td class="fronttd">确认密码</td>
						<td><s:password name="p_rpassword"></s:password></td>
						<td align="left"><div id="repwddiv">${requestScope.errors.p_rpassword
								}</div>
						</td>
					</tr>
					<tr>
						<td class="fronttd">生日</td>
						<td><s:textfield name="p_rbirthday"></s:textfield> </td>
						<td align="left"><div id="repwddiv">${requestScope.errors.p_birthday
								}</div>
						</td>
					</tr>
					<tr>
						<td class="fronttd">照片</td>
						<td><img
							src="${pageContext.request.contextPath}/manager/person_showImage?personUsername=<s:property value='p_username'></s:property>"
							width="108" height="93" /><br />
						</td>
						<td align="left"><div id="repwddiv"><input type="submit" value="修改" class="submitbutton" /></div></td>
					</tr>

					
					<table>
						</form>
						</div>
						</div>

						<div class="regFooter"><a href="${pageContext.request.contextPath }">回首页</a></div>

						${message }
</body>
</html>
