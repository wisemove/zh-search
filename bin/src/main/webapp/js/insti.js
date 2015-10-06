
//刷新dataTable 数据
//$('#insti-data').DataTable().ajax.reload();
jQuery(document).ready(function($){
	load_once_instis();
});


function add_insti(){
	$("#add_dialog_title").html('添加机构');
	jQuery('#add_insti_dialog').modal('show');
	clearInput();
	$("#add_update_x").attr('onclick','add_instix()');
}
function add_instix(){
	 params = validInputBox('insert');
	if(params){
		//保存用户
		$.post('save-instis.htm',params,function(r){
			//重新刷新数据
			$("#add_insti_dialog").modal('hide');
			$('#insti-data').DataTable().ajax.reload();
		});
	}
	
}

function update_insti(_id){
	if(!_id){
		alert('发生错误.请稍刷新后后再试...');
		return;
	}

	//clearInput();
	$.post('query-insti-byid.htm',{'_id':_id},function(json){
		$("#add_dialog_title").html('修改:'+json.ins_name);
	    $("#ins_name").val(json.ins_name);
		$("#ins_desc").val(json.ins_desc);
		var option ="<option value=1> 启用</option><option value=0> 禁用</option>";
		if(json.isValid==0){
			option ="<option value=0> 禁用</option><option value=1> 启用</option>";
		}
		$("#isValid").html(option);
		
		$("#add_insti_dialog").modal('show');
		$("#add_update_x").attr('onclick','update_instix('+_id+')');
	},'json');
	
}

function update_instix(id){
	var params = validInputBox();
	if(params){
		params['id']=id;
		$.post('update-insti.htm',params,function(res){
			$("#add_insti_dialog").modal('hide');
			$('#insti-data').DataTable().ajax.reload();
		});
		
	}
}

function delete_insti(_id){
	
	if(window.confirm("确认要删除该机构吗?")){
		
		$.post('delete-insti.htm',{'_id':_id} ,function(result){
			if(result=='SUCCESS'){
				
				//$('#insti-data').dataTable().fnDraw(false);
				$('#insti-data').DataTable().ajax.reload();
			}
		});
	}
	
};


function clearInput(){
	$("#add_insti_dialog input").val('');
}

function validInputBox(){
	
	ins_name = $("#ins_name").val();
	ins_desc =$("#ins_desc").val();
	isValid=$("#isValid").val();
	if(!ins_name){alert('请输入机构名称'); return ;	}
	params ={
		'ins_name':ins_name,
		'ins_desc':ins_desc,
		'isValid':isValid
	};
	return params;
}


/**
 * 加载用户 (只能加载一次)
 */
function load_once_instis(){
	$("#user-datas-body").html("<tr><td colspan='20'><div style='width:100%; height:100%; margin-top:100px; text-align:center;'><img alt='' src='../images/loading.gif'></div></td></tr>");
	//现请求用户数据 
		$("#insti-data").dataTable(
				  {
					aLengthMenu: [
						[5,10, 25, 50, 100, -1], [5, 10,25, 50, 100, "全部"]
					],
					"ajax": "query-instis-json.htm",
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

		$("#insti-data_filter").css('text-align','right');
		$("#insti-data_paginate").css('text-align','right');
	
}

//人员设置
function setting_user(_id,_ins_name){
	$("#user-setting-title").html("<font color=green>"+_ins_name +"</font>->人员设置");
	
	//在此机构下的人员
	$.post('query-users-byInsId.htm',{"_instiId":_id},function(result){
		$("#select-instis-users").html(result);
		
		//不在此机构下的人员
		$.post('query-nan-users-byInsId.htm',{"_instiId":_id},function(result){
			$("#select-nan-instis-users").html(result);
		});
		
	});
	
	
	$("#user-setting").modal('show');
};


//添加人员 

function btn_add_user(){
	select_user=$("#select-nan-instis-users").val();
	if(!select_user){
		alert('请选择人员列表进行添加.');
		return;
	}
	alert(select_user);
	
	//$("#select-nan-instis-users ")
	
}
