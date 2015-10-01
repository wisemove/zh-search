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
				
				


				<table style="width: 100%; line-height: 11px;" class="form-horizontal">
				<tr>
				  <td align="left">用户名:</td>
				  <td>
				  <input type="text"id="userName"  name="userName" placeholder="输入用户名" class="form-control">
				    <input type="hidden"  name="id" id="id">
				  </td>
				  </tr>
				  <tr><td>&nbsp;</td></tr>
				 <tr>
				  <td>密码:</td>
				  <td><input type="password" name="password" id ="password" placeholder="输入密码" class="form-control"></td> 
				</tr>
				  <tr><td>&nbsp;</td></tr>
				 <tr>
				  <td>确认密码:</td>
				  <td><input type="password" name="password" id ="password2" placeholder="请再次输入密码" class="form-control"></td> 
				</tr>
				  <tr><td>&nbsp;</td></tr>
				   <tr>
				  <td>年龄:</td>
				  <td><input type="text" name="age" id ="age" placeholder="请输入年龄" class="form-control"></td> 
				</tr>
				 
				  <tr><td>&nbsp;</td></tr>
				   <tr>
				  <td>电子邮件:</td>
				  <td><input type="email"  name="email" id="email"  placeholder="请输入电子邮件" class="form-control" /></td>
				</tr>
				
				 <tr><td>&nbsp;</td></tr>
				  <tr>
				  <td>性别:</td>
				  <td>
				  <select  name="sex"  class="easyui-combobox" style="width:200px;">
				  <option value="1">男</option><option value="0">女</option></select>
				  </td> 
				</tr>
				 <tr><td>&nbsp;</td></tr>
				   <tr>
				  <td>所在部门:</td>
				  <td>
				<select id="state" class="easyui-combobox" name="state" style="width:200px;">
		<option value="AL">Alabama</option>
		<option value="AK">Alaska</option>
		<option value="AZ">Arizona</option>
		<option value="AR">Arkansas</option>
		<option value="CA">California</option>
		<option value="CO">Colorado</option>
		<option value="CT">Connecticut</option>
		<option value="DE">Delaware</option>
		<option value="FL">Florida</option>
		<option value="GA">Georgia</option>
		<option value="HI">Hawaii</option>
		<option value="ID">Idaho</option>
		<option value="IL">Illinois</option>
		<option value="IN">Indiana</option>
		<option value="IA">Iowa</option>
		<option value="KS">Kansas</option>
		<option value="KY">Kentucky</option>
		<option value="LA">Louisiana</option>
		<option value="ME">Maine</option>
		<option value="MD">Maryland</option>
		<option value="MA">Massachusetts</option>
		<option value="MI">Michigan</option>
		<option value="MN">Minnesota</option>
		<option value="MS">Mississippi</option>
		<option value="MO">Missouri</option>
		<option value="MT">Montana</option>
		<option value="NE">Nebraska</option>
		<option value="NV">Nevada</option>
		<option value="NH">New Hampshire</option>
		
	</select>
				  </td>
				</tr>
				  <tr><td>&nbsp;</td></tr>
				   <tr>
				  <td>是否启用:</td>
				  <td>
				   <select  name="isValid"  class="easyui-combobox" style="width:200px;">
				 <option value="1">启用</option><option value="0">禁用</option></select></td> 
				</tr>
				</table>
				</div>
				
				<div class="modal-footer">
				    <button id="add_update_x" type="button" class="btn btn-info" >确定</button>
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