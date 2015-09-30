<%@page contentType="text/html; charset=utf-8" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div style="width: 100% ; height: 100%">

 <c:forEach items="${all_laws }" var="laws" varStatus="st">
 
   <div style="width:210px;; font-size: 18px; text-align: left; margin-left: 150px;margin-top: 10px;">
      ${laws.title } 
   </div>
   <div style="width: 100% ; text-align: left; margin-top: 15px;">
      &nbsp;&nbsp;&nbsp;&nbsp;${laws.content } 
   </div> 
 </c:forEach>

</div>