<%@page contentType="text/html; charset=utf-8" %> 


<style>
.textbox  {
  border-radius : 0 ;
}

.combo-p {
padding: 0;
}
.textbox-text{
 font-size: 14px;
}

</style>
<div class="modal fade" id="add_insti_dialog" style="float: none; z-index: 10000">
		<div class="modal-dialog">
			<div class="modal-content" >
				
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="add_dialog_title"></h4>
				</div>
				
				<div class="modal-body" id="add_dialog" style="padding: 18px;">
				
				

				<table style="width: 100%; line-height: 11px;" class="">
				<tr id="userName_model" >
				  <td align="left">机构名称:</td>
				  <td>
				  <input type="text"id="ins_name"  name="ins_name" maxlength="32" placeholder="请输入机构名称" class="form-control " >
				    <input type="hidden"  name="id" id="user_d_id">
				  </td>
				  </tr>
				  <tr><td>&nbsp;</td></tr>
				<tr>
				  <td align="left">机构描述</td>
				  <td>
				  <input type="text"id="ins_desc"  name="ins_desc" maxlength="64" placeholder="请输入机构描述" class="form-control " >
				  </td>
				  </tr>
				  <tr><td>&nbsp;</td></tr>
				   <tr>
				  <td>是否启用:</td>
				  <td>
				   <select  name="isValid"  id ="isValid" class=" form-control">
				 <option value="1">启用</option><option value="0">禁用</option></select></td> 
				</tr>
				</table>
				</div>
				
				<div class="modal-footer">
				    <button id="add_update_x"  type="button" class="btn btn-info" >确定</button>
 					<button type="button" class="btn btn-white" data-dismiss="modal">取消</button> 
				</div>
			</div>
		</div>
	</div>
