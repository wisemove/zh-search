<%@page contentType="text/html; charset=utf-8" %> 
<jsp:include page="../../commons/header.jsp">
<jsp:param value="修改密码" name="titleName"/>
</jsp:include>
<div class="panel">
<div class="">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">修改密码</h3>
							<div class="panel-options">
								<a href="#" data-toggle="panel">
<!-- 									<span class="collapse-icon">&ndash;</span> -->
									<span class="expand-icon">+</span>
								</a>
<!-- 								<a href="#" data-toggle="remove">&times;</a> -->
							</div>
						</div>
						<div class="panel-body" style="margin: 100px">
							
							<form role="form">
								
								<div class="form-group">
									<label for="email-1">输入旧密码:</label>
									<input type="password" class="form-control" id="password0" placeholder="Enter your old password"  data-message-required="This is custom message for required field." required>
								    <label style="display: none; color: red" id="msg_password0"></label>
								</div>
								
								<div class="form-group">
									<label for="password-1">输入新密码:</label>
									<input type="password" class="form-control" id="password1" placeholder="Enter your password">
								<label style="display: none; color: red" id="msg_password1"></label>
								</div>
								<div class="form-group">
									<label for="password-1">输入新密码:</label>
									<input type="password" class="form-control" id="password2" placeholder="Enter your new  password">
								  <label style="display: none; color: red" id="msg_password2"></label>
								</div>
								
								<div class="form-group">
									<button type="button" id="reset_btn" class="btn btn-info btn-single pull-right">修改</button>
								</div>
								
							</form>
							
						</div>
					</div>
				</div>
</div>

<script type="text/javascript">
  $("#reset_btn").click(function(){
	  var password0 = $("#password0");
	  if(!password0.val()){
		  password0.focus(); 
		  $("#msg_password0").html("请输入旧密码");
		  $("#msg_password0").show();
		  setTimeout(function(){
			  $("#msg_password0").hide();
		  },3000);
		  return ;
	  }
	  var password1 = $("#password1");
	  if(!password1.val()){
		  password1.focus(); 
		  $("#msg_password1").html("请输入新密码");
		  $("#msg_password1").show();
		  setTimeout(function(){
			  $("#msg_password1").hide();
		  },3000);
		  return ;
	  }
	  var password2 = $("#password2");
	  if(!password2.val()){
		  password2.focus(); 
		  $("#msg_password2").html("请再次输入新密码");
		  $("#msg_password2").show();
		  setTimeout(function(){
			  $("#msg_password2").hide();
		  },3000);
		  return ;
	  }
	  
	  if(password2.val()!=password1.val()){
		  $("#msg_password2").html("两次输入的密码不一致");
		  $("#msg_password2").show();
		  setTimeout(function(){
			  $("#msg_password2").hide();
		  },3000);
		  return ;
	  }
	  
	  var param = {};
	  param['password0']=password0.val();
	  param['password1']=password1.val();
	  param['password2']=password2.val();
	  
	  $.post('resetpassx.htm',param,function(resp){
		  $("#message_success_msg").html(resp);
		  jQuery('#message_success').modal('show');
	   });
	  
  });
  
</script>



	
<%@include file="../../commons/footer.jsp" %>