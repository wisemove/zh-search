<%@page contentType="text/html; charset=utf-8" %> 
<jsp:include page="../../commons/header.jsp">
<jsp:param value="法规管理" name="titleName"/>
</jsp:include>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/default/easyui.css">
	 <script src="<%=request.getContextPath() %>/assets/js/jquery.easyui.min.js"></script>
<div class="panel" style="min-height: 500px; overflow: auto;">


<div style="float: left; width: 40% ; height: 460px; border-right: 1px solid #ccc;">
<div style="float: left;">
  <div id="tt">
  </div>
 </div>
</div>
 <div style="float: right; width: 56% ; margin-left: 20px; ">
  <div style="padding: 10px; margin-top: 10px;" >
    <div style="width:100%; line-height: 23px; letter-spacing: 1px; font-size: 13px;" readonly="readonly">&nbsp;&nbsp;&nbsp;&nbsp;树数据的格式（Tree data format）
每个节点可以包含下列特性：
id：节点的 id，它对于加载远程数据很重要。
text：显示的节点文字。
state：节点状态， 'open' 或 'closed'，默认是 'open'。当设为 'closed' 时，此节点有子节点，并且将从远程站点加载它们。
checked：指示节点是否被选中。 Indicate whether the node is checked selected.
attributes：给一个节点追加的自定义属性。
children：定义了一些子节点的节点数组。
示例： </div>
  </div>
 </div>   
    <script type="text/javascript">
    
    $('#tt').tree({
    	url:'<%=request.getContextPath()%>/tree.json'
    	}); 
    
    </script>
    </div>
<%@include file="../../commons/footer.jsp" %>