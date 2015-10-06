<%@page contentType="text/html; charset=utf-8" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${result }" var="user">
 <option id="nan_usr_option_${user.id }" value="${user.id }">${user.userName } &nbsp;&nbsp;&nbsp;
    <c:if test="${user.insti_name!=null }">(*${user.insti_name})</c:if>
    &nbsp;&nbsp;&nbsp;
   <c:if test="${user.authType=='1' }">(*机构审核人)</c:if>
   <c:if test="${user.authType=='2' }">(*终极审核人)</c:if> 
 </option>
</c:forEach>

