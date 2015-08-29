<%@page contentType="text/html;charset=utf-8"%>
<%@include file="../commons/taglibs.jsp"  %>
<div class="pageturn">
     <c:if test="${page.pageNo>1 }">
	<a href="javascript:void(0)" onclick="changePage(1)">首页</a>
	  </c:if>
	  <c:if test="${page.pageNo<2 }">首页 </c:if>
  <c:if test="${page.hasPre }">
	<a href="javascript:void(0)" onclick="changePage(${page.pageNo-1})">上一页</a>
  </c:if>
  <c:set var="startPage" value="1" scope="request" ></c:set>
  <c:set var="endPage" value="${page.totalPages}" scope="request"></c:set>
  <c:set var="distinctPage" value="4" scope="request"></c:set>
  <c:if test="${page.totalPages>2*requestScope.distinctPage }">
	<c:choose>
<c:when test="${page.pageNo<requestScope.distinctPage }">
<c:set var="endPage" value="${2*requestScope.distinctPage }" scope="request"></c:set>
</c:when>
<c:when test="${page.totalPages-page.pageNo<requestScope.distinctPage }">
<c:set var="startPage" value="${page.totalPages-2*requestScope.distinctPage }" scope="request"></c:set>
</c:when>
<c:otherwise>
<c:set var="startPage" value="${page.pageNo-4 }" scope="request"></c:set>
<c:set var="endPage" value="${page.pageNo+3 }" scope="request"></c:set>
</c:otherwise>
</c:choose>
</c:if>
<c:if test="${endPage==0 }">
<c:set var="endPage" value="1" scope="request"></c:set>
</c:if>
<c:forEach var="step" begin="${requestScope.startPage }"  end="${requestScope.endPage }">
<c:if test="${step==page.pageNo }">
	<span id="currentPage" class="dqwz bold">${step}</span>
</c:if>
<c:if test="${step!=page.pageNo }">
	<a href="javascript:void(0)" onclick="changePage('${step}')">${step }</a>
</c:if>
</c:forEach>
<c:if test="${page.hasNext }">
	<a href="javascript:void(0)" onclick="changePage('${page.pageNo+1}')">下一页</a>
</c:if>
<c:if test="${page.pageNo!=page.totalPages&&page.totalPages>1}">
   	<a href="javascript:void(0)" onclick="changePage('${page.totalPages}')">尾页</a>
</c:if>
<c:if test="${page.totalPages==page.pageNo}">尾页</c:if>
共<span class="color_red">${page.totalCount }</span>条/共<span
						class="color_red">${page.totalPages }</span>页
</div>