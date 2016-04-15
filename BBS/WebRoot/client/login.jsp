<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
 <link type="text/css" rel="stylesheet" href="css/login-min.css" />
</head>
<body>
<center>
<div id="forlogin"  class="forlogin" style="display:block;width:350px;height:190px;">
		<form action="${pageContext.request.contextPath }/manager/person_clientLogin.action" method="post" >
			<table >
					 <tr >
						<td class="firsttr_td">&nbsp;&nbsp;</td>
						<td class="firsttr_td" >
							 
						</td>
						<td  class="firsttr_td">&nbsp;</td>
					</tr>
					<tr>
						<td class="fronttr_td" >账号</td>
						<td style="width:200px">
							<input type="text" class="inputtext" name="p_username"/>
						</td>
						<td>&nbsp;</td>
					</tr>
					<tr >
						<td class="fronttr_td">密码</td>
						<td >
						<input type="password"  class="inputtext" name="p_password"/>
						</td>
						<td>&nbsp;</td>
					</tr>
					<tr >
						<td class="lasttr_td"  >&nbsp;</td>
						<td class="lasttr_td"  >
							<font  size="2"><a href="${pageContext.request.contextPath }">回首页</a></font>
						</td>
						<td class="lasttr_td"  >&nbsp;</td>
					</tr>
					<tr height="32px">
						<td   class="extratr_td">&nbsp;</td>
						<td  class="extratr_td">
							 <input type="submit" value="登录" class="submitbutton"/> 
							 <input type="reset" value="重置" class="submitbutton"/> 

						</td>
						<td   class="extratr_td">&nbsp;</td>
					</tr>
			</table>
		</form>
</div>
 </center>
</body>
</html>
