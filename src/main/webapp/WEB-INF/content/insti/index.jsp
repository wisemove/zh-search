<%@page contentType="text/html; charset=utf-8" %> 
<jsp:include page="../../commons/header.jsp">
<jsp:param value="机构管理" name="titleName"/>
</jsp:include>
	<script src="<%=request.getContextPath() %>/assets/js/datatables/js/jquery.dataTables.min.js"></script>
	<script src="<%=request.getContextPath() %>/assets/js/datatables/dataTables.bootstrap.js"></script>
	<script src="<%=request.getContextPath() %>/assets/js/datatables/yadcf/jquery.dataTables.yadcf.js"></script>
	<script src="<%=request.getContextPath() %>/assets/js/datatables/tabletools/dataTables.tableTools.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/user.js"></script>
<div style="width: 100%; text-align: left;">
<div class="panel panel-default" >
				<div class="panel-heading">
					<h3 class="panel-title">机构数据</h3>
					
					 <div class="panel-options">
						<!-- <a href="#" data-toggle="panel">
							<span class="collapse-icon">&ndash;</span>
							<span class="expand-icon">+</span>
						</a> -->
						<a href="javascript:add_user();" style="color: #FFF" class="btn btn-warning" >
							添加机构
						</a>
					</div> 
				</div>
				<div class="panel-body">
					
					<script type="text/javascript">
					jQuery(document).ready(function($)
					{
						$("#user-datas-body").html("<tr><td colspan='20'><div style='width:100%; height:100%; margin-top:100px; text-align:center;'><img alt='' src='<%=request.getContextPath()%>/images/loading.gif'></div></td></tr>");
						//现请求用户数据 
						$.post('query-users.htm',null ,function(res){
							$("#user-datas-body").html(res);
							
							
							$("#user-data").dataTable(
									  {
										aLengthMenu: [
											[5,10, 25, 50, 100, -1], [5, 10,25, 50, 100, "全部"]
										],
										"oLanguage": {
											"sUrl": "cn.txt"
											},
											
										"oLanguage": {
											"sLengthMenu": "每页显示 _MENU_ 条记录",
											"sZeroRecords": "抱歉， 没有找到",
											"sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
											"sInfoEmpty": "没有数据",
											"sInfoFiltered": "(从 _MAX_ 条数据中检索)",
											"oPaginate": {
											"sFirst": "首页",
											"sPrevious": "前一页",
											"sNext": "后一页",
											"sLast": "尾页",
											"sSearch": "尾页"
											},
									  }
									  });

							$("#user-data_filter").css('text-align','right');
							$("#user-data_paginate").css('text-align','right');
							
						});
						
						
						
						
					});
					</script>
					
					<table id="user-data" class="table table-striped table-bordered" cellspacing="0" width="100%">
						<thead>
							<tr>
								<th>用户名</th>
								<th>姓名</th>
								<th>性别</th>
								<th>年龄</th>
								<th>邮件</th>
								<th width="10">电话</th>
								<th>部门</th>
								<th>状态</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody id="user-datas-body">
						
						</tbody>
					</table>
					
				</div>
			</div>

</div>

	
<%@include file="../../commons/footer.jsp" %>