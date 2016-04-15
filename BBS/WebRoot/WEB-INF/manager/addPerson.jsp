<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ include file="header.jsp" %>
  ${requestScope.message }
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
        
        
        
        <div class="tab-content default-tab" id="tab2">
      
          <form action="${pageContext.request.contextPath}/manager/person_toAddPerson.action" method="post" enctype="multipart/form-data">
            <fieldset>
            <!-- Set class to "column-left" or "column-right" on fieldsets to divide the form into columns -->
            <p>
              <label>用户名</label>
              <input class="text-input small-input" type="text" id="small-input" name="p_username" />
              ${errors.p_username }
              <!-- Classes for input-notification: success, error, information, attention -->
              <br />
              <small>10~15位字母或数字组成</small> </p>
            <p>
            <p>
              <label>昵称</label>
              <input class="text-input small-input" type="text" id="small-input" name="p_nick" />
              <!-- Classes for input-notification: success, error, information, attention -->
              <br />
              <small>请填写真实姓名</small> </p>
            <p>
            <p>
              <label>性别</label>
              <input type="radio" name="p_sex" value="1" />
              	男&nbsp;&nbsp;&nbsp;&nbsp;
              <input type="radio" name="p_sex" value="0" />
              	女</p>
            <p>
            <p>
              <label>密码</label>
              <input class="text-input small-input" type="password" id="small-input" name="p_password" />
              ${errors.p_password }
              <!-- Classes for input-notification: success, error, information, attention -->
              <br />
              <small>10~15位字母或数字组成</small> </p>
            <p>
              <label>确认密码</label>
              <input class="text-input small-input" type="password" id="small-input" name="p_rpassword" />
              <!-- Classes for input-notification: success, error, information, attention -->
              <br />
              <small>10~15位字母或数字组成</small> </p>
            <p>
            <p>
              <label>生日</label>
              <input class="text-input small-input" type="text" id="small-input" name="p_rbirthday" />
              ${errors.p_birthday }
              <!-- Classes for input-notification: success, error, information, attention -->
              <br />
              <small>yyyy-MM-dd格式</small> </p>
            <p>
              <label>照片</label>
              <input class="text-input small-input" type="file" id="medium-input" name="p_photo" />
              ${errors.p_photo }
            
            <p>
              <input class="button" type="submit" value="提交" />
            </p>
            </fieldset>
            <div class="clear"></div>
            <!-- End .clear -->
          </form>
        </div>
        
        
       
        
        
        
        
        <!-- End #tab2 -->
      </div>
      <!-- End .content-box-content -->
</div>






<%@ include file="last.jsp" %>
