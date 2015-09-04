<%@page contentType="text/html; charset=utf-8" %> 
<div class="footer-inner">
	<div class="footer-text">
		© 2014 
		<strong>中翰</strong> 
	</div>
</div>
</div>
</div>
<!-- Bottom Scripts -->
<script src="<%=request.getContextPath() %>/assets/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath() %>/assets/js/TweenMax.min.js"></script>
<script src="<%=request.getContextPath() %>/assets/js/resizeable.js"></script>
<script src="<%=request.getContextPath() %>/assets/js/joinable.js"></script>
<script src="<%=request.getContextPath() %>/assets/js/xenon-api.js"></script>
<script src="<%=request.getContextPath() %>/assets/js/xenon-toggles.js"></script>


<!-- Imported scripts on this page -->
<script src="<%=request.getContextPath() %>/assets/js/xenon-widgets.js"></script>
<script src="<%=request.getContextPath() %>/assets/js/devexpress-web-14.1/js/globalize.min.js"></script>
<script src="<%=request.getContextPath() %>/assets/js/devexpress-web-14.1/js/dx.chartjs.js"></script>
<script src="<%=request.getContextPath() %>/assets/js/toastr/toastr.min.js"></script>


<!-- JavaScripts initializations and stuff -->
<script src="<%=request.getContextPath() %>/assets/js/xenon-custom.js"></script>
</body>
<div class="modal fade" id="message_success" style="float: none;">
		<div class="modal-dialog">
			<div class="modal-content">
				
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="message_success_title">消息</h4>
				</div>
				
				<div class="modal-body" id="message_success_msg">
				</div>
				
				<div class="modal-footer">
<!-- 					<button type="button" class="btn btn-white" data-dismiss="modal">Close</button> -->
					<button type="button" class="btn btn-info" data-dismiss="modal">确定</button>
				</div>
			</div>
		</div>
	</div>
	
</html>