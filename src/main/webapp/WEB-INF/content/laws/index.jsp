<%@page contentType="text/html; charset=utf-8" %> 
<jsp:include page="../../commons/header.jsp">
<jsp:param value="法规管理" name="titleName"/>
</jsp:include>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/default/easyui.css">
	 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/assets/css/icon.css">
	 <script src="<%=request.getContextPath() %>/assets/js/jquery.easyui.min.js"></script>
 
<div class="panel" style="min-height: 500px; overflow: auto;">


<div style="float: left; width: 40% ; height: 460px; border-right: 1px solid #ccc;">
<div style="float: left;">
  <div id="tt">
  </div>
      <div id="mm" class="easyui-menu" style="width:120px; display: none;">
        <div onclick="append()" data-options="iconCls:'icon-add'">添加</div>
        <div onclick="update()" data-options="iconCls:'icon-remove'">修改</div>
        <div onclick="removeit()" data-options="iconCls:'icon-cancel'">删除</div>
        <div class="menu-sep"></div>
        <div onclick="refresh()" data-options="iconCls:'icon-reload'">刷新</div>
    </div>  
 </div>
</div>
 <div style="float: right; width: 56% ; margin-left: 20px; ">
  <div style="padding: 10px; margin-top: 10px;" >
    <div id="all_laws" style="width:100%; line-height: 23px; letter-spacing: 1px; font-size: 13px;" readonly="readonly">
     
      <div id="laws_title"style="width: 100%; text-align: center; font-size: 17px;"></div>
      <div id="laws_content"style="width: 100%; text-align: left; font: 13px;margin-top: 12px;"></div>
   </div>
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
	        	//单个
	        	/* $.post('show-laws.htm',{'_id':node.id},function(resp){
	        		$("#laws_title").html(resp.title);
	        		$("#laws_content").html("&nbsp;&nbsp;&nbsp;&nbsp;"+resp.content);
	        	},'json'); */
	        	$("#all_laws").html("<div style='width:100%; height:100%; margin-top:100px; text-align:center;'><img alt='' src='<%=request.getContextPath()%>/images/loading.gif'></div>");
	        	  $.post('show-all-laws.htm',{'_id':node.id},function(resp){
	        		$("#all_laws").html(resp);
	        	});
	        	
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
        /* t.tree('append', {
            parent: (node?node.target:null),
            data: [{
                text: 'new item1'
            },{
                text: 'new item2'
            }]
        }); */
     	$("#title").val('');
        $("#content").val('');
        $("#parentId").val(node.id);
        $("#add_dialog_title").html('添加法规');
        jQuery('#add_dialog').modal('show');
    }
    function appendx (){
         pid  = $("#parentId").val();
    	 title = $("#title").val();
    	 content = $("#content").val();
    	 if(!title){
    		 alert('标题不能为空');
    		 return
    	 }
    	 $.post('save-laws.htm',{'title':title,'content':content,'parentId':pid},function(resp){
    		alert(resp) ;
    	 },'text');
    	 jQuery('#add_dialog').modal('hide');
    }
    function removeit(){
        var node = $('#tt').tree('getSelected');
        if(node.id==1){
        	alert("操作不允许!");
        	return;
        }
        if(confirm("确定要删除这条法规吗?")){
             $.post('delete-laws.htm',{'_id':node.id},function(res){
            	 if(res=='SUCCESS'){
            		 $('#tt').tree('remove', node.target);
            	 }else{
            		 alert('删除失败 请稍候再试!');
            	 }
             });
        }
        
      // 
    }
    function update(){
        var node = $('#tt').tree('getSelected');
        $('#tt').tree('collapse',node.target);
    }
    function refresh(){
     //   var node = $('#tt').tree('getSelected');
        $('#tt').tree('options').url = "load-laws-tree.htm?pid=0";
        $("#all_laws").html('');
        $('#tt').tree('reload');
       
    }
   
     
    </script>
    </div>
<%@include file="../../commons/footer.jsp" %>
<div class="modal fade" id="add_dialog" style="float: none;">
		<div class="modal-dialog">
			<div class="modal-content">
				
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="add_dialog_title"></h4>
				</div>
				
				<div class="modal-body" id="add_dialog">
				<table style="width: 100%; line-height: 25px;">
				<tr>
				  <td align="left">法规标题:</td>
				  <td>
				    <input id="title" type=text style="width: 100%" name="title">
				    <input type="hidden"  name="parentId" id="parentId">
				  </td>
				  </tr>
				  <tr><td>&nbsp;</td></tr>
				  <tr>
				  <td align="left">法规内容:</td>
				  <td><textarea id="content"  style="width: 100% ; height:170px;"  name="content"></textarea></td>
				</tr>
				</table>
				</div>
				
				<div class="modal-footer">
				    <button type="button" onclick="appendx()" class="btn btn-info" >确定</button>
 					<button type="button" class="btn btn-white" data-dismiss="modal">取消</button> 
				</div>
			</div>
		</div>
	</div>