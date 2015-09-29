<%@page contentType="text/html; charset=utf-8" %> 
<jsp:include page="../../commons/header.jsp">
<jsp:param value="法规管理" name="titleName"/>
</jsp:include>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/default/easyui.css">
	 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/assets/css/icon.css">
 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/assets/css/demo.css">
	 <script src="<%=request.getContextPath() %>/assets/js/jquery.easyui.min.js"></script>
 
<div class="panel" style="min-height: 500px; overflow: auto;">


<div style="float: left; width: 40% ; height: 460px; border-right: 1px solid #ccc;">
<div style="float: left;">
  <div id="tt">
  </div>
      <div id="mm" class="easyui-menu" style="width:120px; display: none;">
        <div onclick="append()" data-options="iconCls:'icon-add'">Append</div>
        <div onclick="removeit()" data-options="iconCls:'icon-remove'">Remove</div>
        <div class="menu-sep"></div>
        <div onclick="expand()">Expand</div>
        <div onclick="collapse()">Collapse</div>
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
    $(function(){
        load_laws_tree();
    });
    var nodeId;
    function load_laws_tree(){
    	$("#tt").tree({
			url:'load-laws-tree.htm?pid=0',
			animate:true,
			state:"closed",
			checkbox:false,
            //在此根据id 查询子ID的名称
            onBeforeExpand:function(node1){
                $('#tt').tree('options').url = "load-laws-tree.htm?pid="+node1.id;
            },
	        onClick:function(node){
	        	nodeId =node.id;
	        	alert(node.id)
	        },
	        onContextMenu: function(e,node){
                e.preventDefault();
                $("#tt").tree('select',node.target);
                $('#mm').menu('show',{
                    left: e.pageX,
                    top: e.pageY
                });
	        }
                
		});
	}
    function append(){
        var t = $('#tt');
        var node = t.tree('getSelected');
        t.tree('append', {
            parent: (node?node.target:null),
            data: [{
                text: 'new item1'
            },{
                text: 'new item2'
            }]
        });
    }
    function removeit(){
        var node = $('#tt').tree('getSelected');
        $('#tt').tree('remove', node.target);
    }
    function collapse(){
        var node = $('#tt').tree('getSelected');
        $('#tt').tree('collapse',node.target);
    }
    function expand(){
        var node = $('#tt').tree('getSelected');
        $('#tt').tree('expand',node.target);
    }
   
     
    </script>
    </div>
<%@include file="../../commons/footer.jsp" %>