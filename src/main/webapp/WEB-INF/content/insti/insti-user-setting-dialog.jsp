<%@page contentType="text/html; charset=utf-8" %> 
<div class="modal fade" id="user-setting" >
		<div class="modal-dialog" style="width:55%">
			<div class="modal-content" >
				
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="user-setting-title">人员设置</h4>
				</div>
				
				<div class="modal-body" style="height: 350px;">
				 <div style="width: %100%; text-align: left;">
				 </div>
				  <div style="float: left; width: 40%" >
				   <div>
				    &nbsp;
				     <span style="float: left; " >&nbsp;该部门下人员</span> 
				     <span style="float: right; margin-right: 20px;">&nbsp;
				     <button class="btn btn-success btn-xs btn-icon">
								<i class="fa-pencil"></i>
								<span>设置为部门审核人</span>
					</button>
				     </span>
				   </div>
				    <select id="select-instis-users" multiple="multiple"   style="width: 100%;  height:280px;  margin-top: 18px;" class="form-control">
				    </select>
				  </div>
				
				
				   <!-- 中间操作按钮 -->
				  <div style="float: left; width: 10%;margin-top: 128px; margin-left: 26px;" >
				   <div><button onclick="btn_add_user()" class="btn btn-blue btn-xs">&lt;&lt;添加人员</button></div>
				   <div style="margin-top: 5px;"><button onclick="btn_delete_user()" class="btn btn-red btn-xs">&gt;&gt;删除人员</button></div>
				  </div>
				   
				   
				  <div style="float: right; margin-right:10px; width: 40%" >
				   <div>
				   &nbsp;
				     <span style="float: left; " >&nbsp;人员列表</span> 
				     <span style="float: right; margin-right: 20px;">&nbsp;所属机构</span>
				   </div>
				    <select id="select-nan-instis-users" multiple="multiple"   style="width: 100%; height:280px;  margin-top: 18px;" class="form-control">
				    </select>
				  </div>
				  
				</div>
				
				<div class="modal-footer">
				    <button  type="button" data-dismiss="modal" class="btn btn-info" >确定</button>
				</div>
			</div>
		</div>
	</div>
