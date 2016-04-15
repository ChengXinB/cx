<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>




<form action="${pageContext.request.contextPath }/invitation/invitation_addInvitation.action" method="post">
	 <a name="first" id="first">  <div class="outer-line" >
	   		<table align="center" width="700" height="300">
	   			
				<tr>
					<td></td>
					<td>标题：
					 <textarea  id="conn" name="i_name" rows="2" cols="51"></textarea>
					</td>
	   			</tr>
				
				
				<tr>
			  
					<td align="left">
						<div class="tips">1.请在遵守我们网站发帖的规则</div>
						<div class="tips">2.转载文章请注明出自“我的论坛”。</div>
						<div class="tips">如是商业用途请联系原作者。</div>
					</td>
				
					<td>
						<div>
						   <textarea  id="con" name="i_title" rows="10" cols="60"></textarea>
						</div>
						<script type="text/javascript">
							UE.getEditor('con');
						</script>
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


<div></div>
<div class="bottom_Info" align="justify">
 版权所有：XX工作室<br />
 免责声明：站内会员言论仅代表个人观点，并不代表本站同意其观点，本站不承担由此引起的法律责任。</div>${message }
</body>
</html>