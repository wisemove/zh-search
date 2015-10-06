<!DOCTYPE html><%@page contentType="text/html; charset=utf-8" %> <%String path = request.getContextPath(); %>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta name="description" content="Xenon Boostrap Admin Panel" />
	<meta name="author" content="" />
	<%String titleName = request.getParameter("titleName"); if(titleName ==null ) titleName ="";%>
	<title>中翰搜索后台管理系统-<%=titleName %></title>
<!-- 	<link rel="stylesheet" href="http://fonts.useso.com/css?family=Arimo:400,700,400italic"> -->
	<link rel="stylesheet" href="<%=path %>/assets/css/fonts/linecons/css/linecons.css">
	<link rel="stylesheet" href="<%=path %>/assets/css/fonts/fontawesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="<%=path %>/assets/css/bootstrap.css">
	<link rel="stylesheet" href="<%=path %>/assets/css/xenon-core.css">
	<link rel="stylesheet" href="<%=path %>/assets/css/xenon-forms.css">
	<link rel="stylesheet" href="<%=path %>/assets/css/xenon-components.css">
	<link rel="stylesheet" href="<%=path %>/assets/css/xenon-skins.css">
	<link rel="stylesheet" href="<%=path %>/assets/css/custom.css">

<%--     <link href="<%=path %>/assets/js/wysihtml5/src/bootstrap-wysihtml5.css" rel="stylesheet">
    <link href="<%=path %>/assets/js/uikit/vendor/codemirror/codemirror.css" rel="stylesheet">
    <link href="<%=path %>/assets/js/uikit/uikit.css" rel="stylesheet">
    <link href="<%=path %>/assets/js/uikit/css/addons/uikit.almost-flat.addons.min.css" rel="stylesheet"> --%>
	<script src="<%=path %>/assets/js/jquery-1.11.1.min.js"></script>
 
	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
		<script src="assets/js/html5shiv.min.js"></script>
		<script src="<%=path %>/assets/js/respond.min.js"></script>
	<![endif]-->
</head>



<body class="page-body" >
	<div class="settings-pane">
		<a href="#" data-toggle="settings-pane" data-animate="true">
			&times;
		</a>
	</div>
	<div class="page-container"><!-- add class "sidebar-collapsed" to close sidebar by default, "chat-visible" to make chat appear always -->
		<div class="sidebar-menu toggle-others fixed">
			<div class="sidebar-menu-inner">	
				<header class="logo-env">
					
					<!-- logo -->
					<div class="logo">
						<a href="<%=path %>/index.htm" class="logo-expanded">
							<img src="<%=path %>/assets/images/logo@2x.png" width="200" alt="" />
						</a>
						
						<a href="dashboard-1.html" class="logo-collapsed">
							<img src="<%=path %>/assets/images/logo-collapsed@2x.png" width="40" alt="" />
						</a>
					</div>
					
					<!-- This will toggle the mobile menu and will be visible only on mobile devices -->
					<div class="mobile-menu-toggle visible-xs">
						<a href="#" data-toggle="user-info-menu">
							<i class="fa-bell-o"></i>
							<span class="badge badge-success">7</span>
						</a>
						
						<a href="#" data-toggle="mobile-menu">
							<i class="fa-bars"></i>
						</a>
					</div>
					
					<!-- This will open the popup with user profile settings, you can use for any purpose, just be creative -->
					<!-- <div class="settings-icon">
						<a href="#" data-toggle="settings-pane" data-animate="true">
							<i class="linecons-cog"></i>
						</a>
					</div> -->
					
								
				</header>
						
				
						
				<ul id="main-menu" class="main-menu">
					<!-- add class "multiple-expanded" to allow multiple submenus to open -->
					<!-- class "auto-inherit-active-class" will automatically add "active" class for parent elements who are marked already with class "active" -->
					<li class="active opened active">
						<a href="<%=request.getContextPath()%>/index.htm">
							<i class="linecons-desktop"></i>
							<span class="title">首页</span>
						</a>
					</li>
					<li>
						<a href="layout-variants.html">
							<i class="fa fa-book"></i>
							<span class="title">法规管理</span>
						</a>
						<ul>
							<li>
								<a href="layout-variants.html">
									<span class="title">法规审查</span>
								</a>
							</li>
							<li>
								<a href="<%=request.getContextPath() %>/laws/index.htm">
									<span class="title">法规录入</span>
								</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="ui-panels.html">
							<i class="fa-question-circle"></i>
							<span class="title">问题管理</span>
						</a>
						<ul>
							<li>
								<a href="ui-panels.html">
									<span class="title">问题录入</span>
								</a>
							</li>
							<li>
								<a href="ui-buttons.html">
									<span class="title">问题审核</span>
								</a>
							</li>
							
						</ul>
					</li>
					<li>
						<a href="ui-widgets.html">
							<i class=" fa-unlock-alt"></i>
							<span class="title">权限管理</span>
						</a>
					</li>
					<li>
						<a href="<%=path %>/user/index.htm">
							<i class="fa-user"></i>
							<span class="title">用户管理</span>
<!-- 							<span class="label label-success pull-right">5</span> -->
						</a>
					</li>
					<li>
						<a href="javascript:void(0)">
							<i class="fa-certificate"></i>
							<span class="title">机构管理</span>
						</a>
						<ul>
							<li>
								<a href="<%=path %>/insti/index.htm">
									<span class="title">机构列表</span>
								</a>
							</li>
							<li>
								<a href="tables-responsive.html">
									<span class="title">Responsive Table</span>
								</a>
							</li>
							<li>
								<a href="tables-datatables.html">
									<span class="title">Data Tables</span>
								</a>
							</li>
						</ul>
					</li>
					
					
					
					<li>
						<a href="#">
							<i class="linecons-cloud"></i>
							<span class="title">Menu Levels</span>
						</a>
						<ul>
							<li>
								<a href="#">
									<i class="entypo-flow-line"></i>
									<span class="title">Menu Level 1.1</span>
								</a>
								<ul>
									<li>
										<a href="#">
											<i class="entypo-flow-parallel"></i>
											<span class="title">Menu Level 2.1</span>
										</a>
									</li>
									<li>
										<a href="#">
											<i class="entypo-flow-parallel"></i>
											<span class="title">Menu Level 2.2</span>
										</a>
										<ul>
											<li>
												<a href="#">
													<i class="entypo-flow-cascade"></i>
													<span class="title">Menu Level 3.1</span>
												</a>
											</li>
											<li>
												<a href="#">
													<i class="entypo-flow-cascade"></i>
													<span class="title">Menu Level 3.2</span>
												</a>
												<ul>
													<li>
														<a href="#">
															<i class="entypo-flow-branch"></i>
															<span class="title">Menu Level 4.1</span>
														</a>
													</li>
												</ul>
											</li>
										</ul>
									</li>
									<li>
										<a href="#">
											<i class="entypo-flow-parallel"></i>
											<span class="title">Menu Level 2.3</span>
										</a>
									</li>
								</ul>
							</li>
							<li>
								<a href="#">
									<i class="entypo-flow-line"></i>
									<span class="title">Menu Level 1.2</span>
								</a>
							</li>
							<li>
								<a href="#">
									<i class="entypo-flow-line"></i>
									<span class="title">Menu Level 1.3</span>
								</a>
							</li>
						</ul>
					</li>
				</ul>
						
			</div>
			
		</div>
		
		<div class="main-content">
		
					<nav class="navbar user-info-navbar" role="navigation">
				
				<!-- Left links for user info navbar -->
				<ul class="user-info-menu left-links list-inline list-unstyled">
					
					<li class="hidden-sm hidden-xs">
						<a href="#" data-toggle="sidebar">
							<i class="fa-bars"></i>
						</a>
					</li>
					
					<li class="dropdown hover-line">
						<a href="#" data-toggle="dropdown">
							<i class="fa-envelope-o"></i>
							<span class="badge badge-green">15</span>
						</a>
							
						<ul class="dropdown-menu messages">
							<li>
									
								<ul class="dropdown-menu-list list-unstyled ps-scrollbar">
								
									<li class="active"><!-- "active" class means message is unread -->
										<a href="#">
											<span class="line">
												<strong>Luc Chartier</strong>
												<span class="light small">- yesterday</span>
											</span>
											
											<span class="line desc small">
												This ain’t our first item, it is the best of the rest.
											</span>
										</a>
									</li>
									
									<li class="active">
										<a href="#">
											<span class="line">
												<strong>Salma Nyberg</strong>
												<span class="light small">- 2 days ago</span>
											</span>
											
											<span class="line desc small">
												Oh he decisively impression attachment friendship so if everything. 
											</span>
										</a>
									</li>
									
									<li>
										<a href="#">
											<span class="line">
												Hayden Cartwright
												<span class="light small">- a week ago</span>
											</span>
											
											<span class="line desc small">
												Whose her enjoy chief new young. Felicity if ye required likewise so doubtful.
											</span>
										</a>
									</li>
									
									<li>
										<a href="#">
											<span class="line">
												Sandra Eberhardt
												<span class="light small">- 16 days ago</span>
											</span>
											
											<span class="line desc small">
												On so attention necessary at by provision otherwise existence direction.
											</span>
										</a>
									</li>
									
									<!-- Repeated -->
									
									<li class="active"><!-- "active" class means message is unread -->
										<a href="#">
											<span class="line">
												<strong>Luc Chartier</strong>
												<span class="light small">- yesterday</span>
											</span>
											
											<span class="line desc small">
												This ain’t our first item, it is the best of the rest.
											</span>
										</a>
									</li>
									
									<li class="active">
										<a href="#">
											<span class="line">
												<strong>Salma Nyberg</strong>
												<span class="light small">- 2 days ago</span>
											</span>
											
											<span class="line desc small">
												Oh he decisively impression attachment friendship so if everything. 
											</span>
										</a>
									</li>
									
									<li>
										<a href="#">
											<span class="line">
												Hayden Cartwright
												<span class="light small">- a week ago</span>
											</span>
											
											<span class="line desc small">
												Whose her enjoy chief new young. Felicity if ye required likewise so doubtful.
											</span>
										</a>
									</li>
									
									<li>
										<a href="#">
											<span class="line">
												Sandra Eberhardt
												<span class="light small">- 16 days ago</span>
											</span>
											
											<span class="line desc small">
												On so attention necessary at by provision otherwise existence direction.
											</span>
										</a>
									</li>
									
								</ul>
								
							</li>
							
							<li class="external">
								<a href="blank-sidebar.html">
									<span>All Messages</span>
									<i class="fa-link-ext"></i>
								</a>
							</li>
						</ul>
					</li>
					
					<li class="dropdown hover-line">
						<a href="#" data-toggle="dropdown">
							<i class="fa-bell-o"></i>
							<span class="badge badge-purple">7</span>
						</a>
							
						<ul class="dropdown-menu notifications">
							<li class="top">
								<p class="small">
									<a href="#" class="pull-right">Mark all Read</a>
									You have <strong>3</strong> new notifications.
								</p>
							</li>
							
							<li>
								<ul class="dropdown-menu-list list-unstyled ps-scrollbar">
									<li class="active notification-success">
										<a href="#">
											<i class="fa-user"></i>
											
											<span class="line">
												<strong>New user registered</strong>
											</span>
											
											<span class="line small time">
												30 seconds ago
											</span>
										</a>
									</li>
									
									<li class="active notification-secondary">
										<a href="#">
											<i class="fa-lock"></i>
											
											<span class="line">
												<strong>Privacy settings have been changed</strong>
											</span>
											
											<span class="line small time">
												3 hours ago
											</span>
										</a>
									</li>
									
									<li class="notification-primary">
										<a href="#">
											<i class="fa-thumbs-up"></i>
											
											<span class="line">
												<strong>Someone special liked this</strong>
											</span>
											
											<span class="line small time">
												2 minutes ago
											</span>
										</a>
									</li>
									
									<li class="notification-danger">
										<a href="#">
											<i class="fa-calendar"></i>
											
											<span class="line">
												John cancelled the event
											</span>
											
											<span class="line small time">
												9 hours ago
											</span>
										</a>
									</li>
									
									<li class="notification-info">
										<a href="#">
											<i class="fa-database"></i>
											
											<span class="line">
												The server is status is stable
											</span>
											
											<span class="line small time">
												yesterday at 10:30am
											</span>
										</a>
									</li>
									
									<li class="notification-warning">
										<a href="#">
											<i class="fa-envelope-o"></i>
											
											<span class="line">
												New comments waiting approval
											</span>
											
											<span class="line small time">
												last week
											</span>
										</a>
									</li>
								</ul>
							</li>
							
							<li class="external">
								<a href="#">
									<span>View all notifications</span>
									<i class="fa-link-ext"></i>
								</a>
							</li>
						</ul>
					</li>
					
				</ul>
				
				
				<!-- Right links for user info navbar -->
				<ul class="user-info-menu right-links list-inline list-unstyled">
					
					<li class="search-form"><!-- You can add "always-visible" to show make the search input visible -->
						
						<form method="get" action="extra-search.html">
							<input type="text" name="s" class="form-control search-field" placeholder="Type to search..." />
							
							<button type="submit" class="btn btn-link">
								<i class="linecons-search"></i>
							</button>
						</form>
						
					</li>
					
					<li class="dropdown user-profile">
						<a href="#" data-toggle="dropdown">
							<img src="<%=path %>/assets/images/user-4.png" alt="user-image" class="img-circle img-inline userpic-32" width="28" />
							<span>
								${USER_SESSION_ATTR.realName }
								<i class="fa-angle-down"></i>
							</span>
						</a>
						
						<ul class="dropdown-menu user-profile-menu list-unstyled">
							<!-- <li>
								<a href="#edit-profile">
									<i class="fa-edit"></i>
									New Post
								</a>
							</li> -->
							<li>
								<a href="<%=request.getContextPath() %>/ques/question-audit.htm">
									<i class="fa-question"></i>
									问题审核
								</a>
							</li>
							
							<li>
								<a href="<%=request.getContextPath() %>/user/resetpass.htm">
									<i class="fa-wrench"></i>
									修改密码
								</a>
							</li>
							<li>
								<a href="<%=request.getContextPath() %>/user/persion-info.htm">
									<i class="fa-user"></i>
									 个人信息
								</a>
							</li>
							<li>
								<a href="<%=request.getContextPath() %>/sys/help.htm">
									<i class="fa-info"></i>
									 帮助
								</a>
							</li>
							<li class="last">
								<a href="<%=request.getContextPath() %>/logout.htm">
									<i class="fa-lock"></i>
									注销
								</a>
							</li>
						</ul>
					</li>
					
					<li>
						<a href="#" data-toggle="chat">
							<i class="fa-comments-o"></i>
						</a>
					</li>
					
				</ul>
				
			</nav>
			