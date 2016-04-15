<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE>
<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
	 
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

		<title>用户注册</title>
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/client/css/register.css" />

		</script>
	</head>
	
 
	<body  style="overflow-y:hidden; ">
	
	 
			
			
	<div class="mod-header grid-96">
		<!--
        <div class="logo">
            <a href="#"   >
				<img alt="header blog" src="${pageContext.request.contextPath}/client/images/headerlogo.png" style="border:none 0px #fff">
			</a>
        </div>
		-->
    </div>
	<div class="mod-bread  ">
        <div class="grid-96">
            <div class="bread-left">
                填写注册信息
            </div>
            <div class="bread-right">
                <a href="${pageContext.request.contextPath }">回首页</a>&nbsp;|&nbsp;<a  href="${pageContext.request.contextPath }/client/login.jsp">马上登录</a>
            </div>
        </div>
    </div>
	
	<div class="regoutter" >
		<div class="reginner" >
			<form action="${pageContext.request.contextPath }/manager/person_clientAddPerson.action" method="post" id="regform" name="regform" enctype="multipart/form-data">
				<table width="100%" >
					<tr>
						<td class="fronttd" >登录账号</td>
						<td style="width:200px">
							<input type="text" name="p_username" id="usr" class="inputtext" value="${person.p_username }"/>
						</td>
						<td align="left"><div id="usrdiv">${requestScope.errors.p_username }</div></td>
					</tr>
					<tr >
						<td class="fronttd">昵称</td>
						<td >
							<input type="text" name="p_nick" id="nickname" class="inputtext" value="${person.p_nick }"/>
						</td>
						<td align="left"><div id="nicknamediv" ></div></td>
					</tr>
					<tr >
						<td class="fronttd">性别</td>
						<td >
							<input type="radio" name="p_sex" value="1" ${person.p_sex=='1'?"checked='checked'":"" }/>男
							<input type="radio" name="p_sex"  value="0" ${person.p_sex=='0'?"checked='checked'":"" }/>女
						</td>
						<td align="left"><div id="nicknamediv"></div></td>
					</tr>
					<tr >
						<td class="fronttd">密码</td>
						<td >
							<input type="password" name="p_password" id="pwd" class="inputtext"/>
						</td>
						<td align="left"><div id="pwddiv">${requestScope.errors.p_password }</div></td>
					</tr>
					<tr >
						<td class="fronttd">确认密码</td>
						<td >
							<input type="password" name="p_rpassword" id="repwd" class="inputtext"/>
						</td>
						<td align="left"><div id="repwddiv">${requestScope.errors.p_rpassword }</div></td>
					</tr>
					<tr >
						<td class="fronttd">生日</td>
						<td >
							<input type="text" name="p_rbirthday" id="repwd" class="inputtext" value="${person.p_rbirthday }"/>
						</td>
						<td align="left"><div id="repwddiv">${requestScope.errors.p_birthday }</div></td>
					</tr>
					<tr >
						<td class="fronttd">照片</td>
						<td >
							<input type="file" name="p_photo"/>
						</td>
						<td align="left"><div id="codeindiv">${requestScope.errors.p_photo }</div></td>
					</tr>
					
					<tr>
						<td class="fronttd">&nbsp;</td>
						<td >
							<input type="submit" value="注册" class="submitbutton"/>
						</td>
						<td>&nbsp;</td>
					</tr>
				<table>
			</form>
		</div>
	</div>
	
	<div  class="regFooter" >
		&copy;2015 Header Blog  
	</div>
	
 
 
	 
	${message }
	</body>
</html>
