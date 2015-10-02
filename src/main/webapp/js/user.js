
//刷新dataTable 数据
//$('#user-data').DataTable().ajax.reload();
jQuery(document).ready(function($){
	load_once_users();
});


function add_user(){
	hide_show_common('show');
	$("#add_dialog_title").html('添加用户');
	jQuery('#add_user_dialog').modal('show');
	clearInput();
	$("#add_update_x").attr('onclick','add_userx()');
}
function add_userx(){
	 params = validInputBox();
	if(params){
		//保存用户
		$.post('save-user.htm',params,function(r){
			//重新刷新数据
			$("#add_user_dialog").modal('hide');
			$('#user-data').DataTable().ajax.reload();
		});
	}
	
}

function update_user(_id){
	if(!_id){
		alert('发生错误.请稍刷新后后再试...');
		return;
	}
	//clearInput();
	hide_show_common('hide');
	$.post('query-user-byid.htm',{'_id':_id},function(json){
		$("#add_dialog_title").html('修改:'+json.userName);
	    $("#realName").val(json.realName);
		$("#age").val(json.age);
		$("#email").val(json.email);
		$("#phone").val(json.phone);
		$("#sex").combobox('setValue',json.sex).combobox('setText',json.sex==0?'女':'男');
		$("#isValid").combobox('setValue',json.isValid).combobox('setText',json.isValid==0?'禁用':'启用');
		$("#insti_state").combobox('setValue',json.instiId).combobox('setText',json.insti_name);
	},'json');
	$("#add_user_dialog").modal('show');
}

function clearInput(){
	$("#add_user_dialog input").val('');
}

function validInputBox(){
	
	userName = $("#userName").val();
	password =$("#password").val();
	password2=$("#password2").val();
	realName = $("#realName").val();
	age =$("#age").val();
	email = $("#email").val();
	phone = $("#phone").val();
	sex =  $("#sex").combobox('getValue');
	isValid = $("#isValid").combobox('getValue');
	instiId = $("#insti_state").combobox('getValue');
	
	if(!userName){alert('请输入用户名');return ;	}
	if(!password){alert('请输入密码');return ;	}
	if(!password2){alert('请再次输入密码');return ;	}
	if(password!=password2){alert('两次输入的密码不一致');return ;}
	if(!password2){alert('请再次输入密码'); return ;	}
	if(!realName){alert('请输入真实姓名'); return ;	}
	if(!age){alert('请输入年龄'); return ;	}
	if(!age.match(/^[0-9].*$/)){alert('请输入正确的年龄'); return ;	}
	if(!email){alert('请输入电子邮箱'); return ;	}
	if(!email.match(/[_a-zA-Z\d\-\.]+@[_a-zA-Z\d\-]+(\.[_a-zA-Z\d\-]+)+$/)){alert('请输入正确的邮箱') ; return ;}
	if(!phone){alert('请输入电话'); return ;	}
	if(!phone.match(/^[0-9].*$/) ||  phone.length!=11 ){alert('请输入正确手机'); return ;	}
	if(!sex){alert('请选择性别'); return ;	}
	if(!instiId){alert('请选择所在的机构'); return ;	}
	if(!isValid){alert('请选择是否有效'); return ;	}
	params ={
			"userName":userName,'password':password,'realName':realName,'age':age,'email':email,'phone':phone,'sex':sex,'isValid':isValid,'instiId':instiId
	};
	return params;
}


/**
 * 加载用户 (只能加载一次)
 */
function load_once_users(){
	$("#user-datas-body").html("<tr><td colspan='20'><div style='width:100%; height:100%; margin-top:100px; text-align:center;'><img alt='' src='../images/loading.gif'></div></td></tr>");
	//现请求用户数据 
		$("#user-data").dataTable(
				  {
					aLengthMenu: [
						[5,10, 25, 50, 100, -1], [5, 10,25, 50, 100, "全部"]
					],
					"ajax": "query-users-json.htm",
					"bProcessing": true,
					'bStateSave': true,
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
	
}

function  hide_show_common(op){
	if(op=='hide'){
		$("#userName_model").attr('hidden','hidden')
		$("#password_model").attr('hidden','hidden')
		$("#password2_model").attr('hidden','hidden')
	}else if (op=='show'){
		$("#userName_model").removeAttr('hidden')
		$("#password_model").removeAttr('hidden')
		$("#password2_model").removeAttr('hidden')
	}
			
}

