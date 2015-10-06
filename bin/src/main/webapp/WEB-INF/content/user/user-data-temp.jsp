<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
  <c:forEach items="${user_datas }" var="user">
	<tr>
		<td>${user.userName }</td>
		<td>${user.realName }</td>
		<td><c:if test="${user.sex==0 }">女</c:if><c:if test="${user.sex==1 }">男</c:if></td>
		<td>${user.age }</td>
		<td>${user.email }</td>
		<td>${user.phone }</td>
		<td>${user.instiId }</td>
		<td><c:if test="${user.isValid==0 }"><font color=red>无效</font></c:if><c:if test="${user.isValid==1 }">有效</c:if></td>
<%-- 		<td><fmt:formatDate value="${user.createDate }" pattern="yyyy-MM-dd" /></td> --%>
        <td>
   <a class="btn btn-pink btn-sm btn-icon icon-left" href="#">修改</a>
<a class="btn btn-danger btn-sm btn-icon icon-left" href="#">禁用</a>
<a class="btn btn-red btn-sm btn-icon icon-left" href="#">删除</a>     
        </td>
	</tr>
</c:forEach>
