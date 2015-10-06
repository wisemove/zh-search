<%@page contentType="text/html; charset=utf-8" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../../commons/header.jsp">
<jsp:param value="个人信息" name="titleName"/>
</jsp:include>
	
<div class="panel panel-default" style="font-size: 15px;">
     <div style="width: 100%; text-align: center; margin-top: 10px;">
        <img class="img-circle" width="38" src="<%=request.getContextPath() %>/assets/images/user-3.png">&nbsp;
		<span>${user.realName }</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     </div>	
     <div style="width: 100%; text-align: center; margin-top: 50px;">
       <table id="table_info" class="table" style="margin: 0 auto; width: 380px;">
        <tr>
          <td>机构：</td>
          <td>${user.insti_name }</td>
       </tr>
       <tr>
          <td>机构权限：</td>
          <td>
            <c:if test="${user.authType ==0}">普通用户</c:if>
            <c:if test="${user.authType ==1}">审核人</c:if>
            <c:if test="${user.authType ==2}">终审</c:if>
          </td>
       </tr>
       <tr>
          <td>性别：</td>
          <td><c:if test="${user.sex==0}"> 女</c:if><c:if test="${user.sex==1}"> 男</c:if></td>
       </tr>
       <tr>
          <td>年龄：</td>
          <td>${user.age}</td>
       </tr>
       <tr>
          <td width="200">电子邮箱：</td>
          <td width="200">${user.email}</td>
       </tr>
         <tr>
          <td>电话：</td>
          <td>${user.phone}</td>
       </tr>
       <tr>
          <td>创建时间：</td>
          <td><fmt:formatDate value="${user.createDate}" pattern="yyyy年MM月dd日  HH:mm"/></td>
       </tr>
        <tr>
          <td>状态：</td>
          <td><c:if test="${user.isValid==0 }">禁用</c:if><c:if test="${user.isValid==1 }">启用</c:if></td>
       </tr>
       </table>
     </div>	
</div>
<script type="text/javascript">
$(document).ready(function(){

	$("#table_info tr td").attr('align','left')
});
</script>
<%@include file="../../commons/footer.jsp" %>
	