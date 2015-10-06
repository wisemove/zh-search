<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE div PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- <%@include file="commons/header.jsp"%> --%>
<head>
<%@include file="../commons/taglibs.jsp"%>
<%@include file="../commons/scripts.jsp"%>
<title>登录中翰搜索后台管理系统</title>

<link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/signin.css">
</head>
<html>
<!--内容部分开始-->
<div class="container" style="margin-top: 40px;">
	<form class="form-signin"
		action="<%=request.getContextPath()%>/loginx.htm" role="form"
		method="post">
		<h2 id="msg" class="form-signin-heading">输入你的通行证</h2>
		<input type="text" class="form-control" name="userName"
			placeholder="请输入用户名" required autofocus> <input
			type="password" class="form-control" name="password"
			placeholder="请输入密码" required> <label> <a href="">忘记密码?</a>
		</label>
		<button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
	</form>
</div>

<%-- <jsp:include page="../commons/footer.jsp"></jsp:include> --%>
<script type="text/javascript">
	$(function() {
		if ("${msg}" != "") {
			$("#msg").html("<font color=red>${msg}</font>");
		}
	});
</script>
</html>