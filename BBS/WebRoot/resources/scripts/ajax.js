function listAllPerson(){
	$("#leftTable").remove();
	$("#rightTable").remove();
	$.post("../ajmanager/person_listLimitPerson.action",{pagenum : '1'},function(){
//		userJson = eval("("+data+")");
//		for(var i=0; i<userJson.length; i++){
//		alert('回来了');
			$("#listAllPerson").append(
				"	<div class='content-box'>    " +                                                   
				 "     <!-- Start Content Box --> " +
				 "     <div class='content-box-header'> " +
				  "      <h3>Content box</h3> " +
				   "     <ul class='content-box-tabs'> " +
				    "    </ul> " +
				    "    <div class='clear'></div> " +
				    "  </div> " +
				    "  <!-- End .content-box-header --> " +
				   "   <div class='content-box-content'> " +
				   "     <!-- End #tab1 --> " +
				   
				   
				   
				   
				   
				   
				   
				   
				   
				   "<div class='tab-content default-tab' id='tab1'>       " +
			         " <!-- This is the target div. id must match the href of this div's tab -->       " +
			          "<table>       " +
			          "  <thead>       " +
			            "  <tr>       " +
			              "  <th>       " +
			              "    <input class='check-all' type='checkbox' />       " +
			              "  </th>       " +
			              "  <th>账号</th>       " +
			              "  <th>昵称</th>       " +
			              "  <th>性别</th>       " +
			              "  <th>注册时间</th>       " +
			              "  <th>操作</th>       " +
			             " </tr>       " +
			           " </thead>       " +
			          "  <tfoot>       " +
			            "  <tr>       " +
			              "  <td colspan='6'>       " +
			               "   <div class='bulk-actions align-left'>       " +
			               "<input type='text'>"+
//			                "    <select name='dropdown'>       " +
//			                "      <option value='option1'>Choose an action...</option>       " +
//			                "      <option value='option2'>Edit</option>       " +
//			                 "     <option value='option3'>Delete</option>       " +
//			                 "   </select>       " +
			                 "   <a class='button' href='#'>按姓名查找</a> </div>       " +
			                 " <div class='pagination'> <a href='#' title='First Page'>&laquo; 首页</a><a href='#' title='shangyiye'>&laquo; 上一页</a> <a href='#' class='number current' title='1'>1</a>  <a href='#' title='Next Page'>下一页 &raquo;</a><a href='#' title='Last Page'>尾页 &raquo;</a> </div>       " +
			                "  <!-- End .pagination -->       " +
			                "  <div class='clear'></div>       " +
			               " </td>       " +
			             " </tr>       " +
			          "  </tfoot>       " +
			           " <tbody>   %{#session.page}    " +
			          " <s:iterator value='%{#session.page}' var='page'>" +
			          " <s:iterator value='%{page.records}' var='p'>" +
			          "    <tr>       " +
			           "     <td>       " +
			            "      <input type='checkbox' />       " +
			             "   </td>       " +
			              "  <td><s:property value=''/></td>       " +
			              "  <td><a href='#' title='title'><s:property value='%{p.p_nick}'/></a></td>       " +
			              "  <td><s:property value='%{p.p_sex}'/></td>       " +
			             "   <td><s:property value='%{p.p_date}'/></td>       " +
			              "  <td>       " +
			               "   <!-- Icons -->       " +
			               "   <a href='#' title='Edit'><img src='${pageContext.request.contextPath}/resources/images/icons/pencil.png' alt='Edit' /></a> <a href='#' title='Delete'><img src='${pageContext.request.contextPath}/resources/images/icons/cross.png' alt='Delete' /></a> <a href='#' title='Edit Meta'><img src='${pageContext.request.contextPath}/resources/images/icons/hammer_screwdriver.png' alt='Edit Meta' /></a> </td>       " +
			             " </tr>       " +
			            " </s:iterator>" +
			            " </s:iterator>" +
			           " </tbody>       " +
			        "  </table>       " +
			      "  </div>       " +
				   
				   
				   
				   
				   
				   
				   
				   
				   
				   
				   
				   
				  "      <!-- End #tab2 --> " +
				   "   </div>" +
				"</div>"
			);
//		}
	});
}