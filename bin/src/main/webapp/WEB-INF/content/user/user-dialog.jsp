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
<div class="modal fade" id="add_user_dialog" style="float: none; z-index: 10000">
		<div class="modal-dialog">
			<div class="modal-content" >
				
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="add_dialog_title"></h4>
				</div>
				
				<div class="modal-body" id="add_dialog" style="padding: 18px;">
				
				

           <form id="from1">
				<table style="width: 100%; line-height: 11px;" class="">
				<tr id="userName_model" >
				  <td align="left">用户名:</td>
				  <td>
				  <input type="text"id="userName"  name="userName" maxlength="32" placeholder="输入用户名" class="form-control " >
				    <input type="hidden"  name="id" id="user_d_id">
				  </td>
				  </tr>
				  <tr><td>&nbsp;</td></tr>
				 <tr id="password_model">
				  <td>密码:</td>
				  <td><input type="password" name="password" id ="password" maxlength="32" placeholder="输入密码" class="form-control"></td> 
				</tr>
				  <tr><td>&nbsp;</td></tr>
				 <tr id="password2_model">
				  <td>确认密码:</td>
				  <td><input type="password" name="password2" id ="password2" maxlength="32" placeholder="请再次输入密码" class="form-control"></td> 
				</tr>
				 <tr><td>&nbsp;</td></tr>
				<tr>
				  <td align="left">真实姓名:</td>
				  <td>
				  <input type="text"id="realName"  name="realName" maxlength="32" placeholder="输入用户名" class="form-control " >
				  </td>
				  </tr>
				  <tr><td>&nbsp;</td></tr>
				 <tr>
				   <tr>
				  <td>年龄:</td>
				  <td><input type="text" name="age" id ="age" placeholder="请输入年龄" maxlength="2" class="form-control"></td> 
				</tr>
				 
				  <tr><td>&nbsp;</td></tr>
				   <tr>
				  <td>电子邮件:</td>
				  <td><input type="email"  name="email" id="email" maxlength="24"  placeholder="请输入电子邮件" class="form-control" /></td>
				</tr>
				  <tr><td>&nbsp;</td></tr>
				   <tr>
				  <td>手机:</td>
				  <td><input type="email"  name="phone" id="phone" maxlength="11"  placeholder="请输入移动电话" class="form-control" /></td>
				</tr>
				
				 <tr><td>&nbsp;</td></tr>
				  <tr>
				  <td>性别:</td>
				  <td>
				  <select  name="sex" id="sex"  class="easyui-combobox" style="width:200px;">
				  <option value="1">男</option><option value="0">女</option></select>
				  </td> 
				</tr>
				 <tr><td>&nbsp;</td></tr>
				   <tr>
				  <td>所在机构:</td>
				  <td>
				<select id="insti_state" data-options="
				url: '../insti/query-select-option-insti.htm' , valueField: 'id',
				textField: 'text'," class="easyui-combobox" name="state" style="width:200px;">
		
	            </select>
				  </td>
				</tr>
				  <tr><td>&nbsp;</td></tr>
				   <tr>
				  <td>是否启用:</td>
				  <td>
				   <select  name="isValid"  id ="isValid" class="easyui-combobox" style="width:200px;">
				 <option value="1">启用</option><option value="0">禁用</option></select></td> 
				</tr>
				</table>
				</form>
				</div>
				
				<div class="modal-footer">
				    <button id="add_update_x"  type="button" class="btn btn-info" >确定</button>
 					<button type="button" class="btn btn-white" data-dismiss="modal">取消</button> 
				</div>
			</div>
		</div>
	</div>
	<script>

	$(function(){
		//改变easyui combox 的样式问题
		
	});
	</script>