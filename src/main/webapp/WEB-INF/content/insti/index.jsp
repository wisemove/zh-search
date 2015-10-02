<%@page contentType="text/html; charset=utf-8" %> 
<jsp:include page="../../commons/header.jsp">
<jsp:param value="机构列表" name="titleName"/>
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
					
					
					<table id="insti-data" class="table table-striped table-bordered" cellspacing="0" width="100%">
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
						<tbody id="insti-datas-body">
						
						</tbody>
					</table>
					
				</div>
			</div>

</div>

	
<%@include file="../../commons/footer.jsp" %>