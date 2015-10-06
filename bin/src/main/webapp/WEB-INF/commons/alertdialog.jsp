<%@page contentType="text/html; charset=utf-8"%>
<div id="info_dialog" style="display: none; position: absolute; width: 400px;" class="alert alert-success">
	<div style="width: 100%; text-align: left;">
		<h2 style="margin: 0; padding: 0">消息</h2>
	</div>
	<div style="padding: 10px;" id="info_content"></div>
	<div style="width: 100%; text-align: right; margin-top: 15px;">
		<button class="btn btn-info" onclick="closeframe('info_dialog');" type="button">关闭</button>
	</div>
</div>

<div id="warning_dialog" style="display: none; position: absolute; width: 400px;" class="alert alert-warning">
	<div style="width: 100%; text-align: left;">
		<h2 style="margin: 0; padding: 0">警告</h2>
	</div>
	<div id="warning_content" style="padding: 8px;"></div>
	<div style="width: 100%; text-align: right; margin-top: 15px;">
		<button class="btn btn-danger" id="warning_dialog_ok_button"  type="button">确定</button>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<button class="btn btn-info" onclick="closeframe('warning_dialog');" type="button">关闭</button>
	</div>
</div>

<div id="danger_dialog" style="display: none; position: absolute;width: 400px;" class="alert alert-danger">
	<div style="width: 100%; text-align: left;">
		<h2 style="margin: 0; padding: 0">警告</h2>
	</div>
	<div id="danger_content" style="padding: 8px;"></div>
	<div style="width: 100%; text-align: right; margin-top: 15px;">
		<button class="btn btn-danger" id="danger_dialog_ok_button" type="button">确定</button>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<button class="btn btn-info" id="danger_dialog_ok_cancel" onclick="closeframe('danger_dialog');" type="button">关闭</button>
	</div>
</div>
