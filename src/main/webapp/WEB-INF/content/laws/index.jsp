<%@page contentType="text/html; charset=utf-8" %> 
<jsp:include page="../../commons/header.jsp">
<jsp:param value="法规管理" name="titleName"/>
</jsp:include>
<div class="panel">



<div style="float: left; width: 40%">
  <div id="tt">
    </div>
    
    
    
    </div>
    
    
    <script type="text/javascript">
    
    $('#tt').tree({
    	url:'<%=request.getContextPath()%>/tree.json'
    	}); 
    
    </script>
    </div>
<%@include file="../../commons/footer.jsp" %>