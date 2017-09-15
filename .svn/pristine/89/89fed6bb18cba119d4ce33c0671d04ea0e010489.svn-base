<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setAttribute("ctx", basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理系统</title>
<link href="${pageContext.request.contextPath }/css/default.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/themes/icon.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/common/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/common/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/main.js"> </script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/tang.js"> </script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/common/waitDialog.js"></script>
<script type="text/javascript">
	var basePath = "${ctx}";
</script>
</head>
<body class="easyui-layout" style="overflow-y: hidden" scroll="no">
	<noscript>
		<div
			style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
			<img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' />
		</div>
	</noscript>
	<div region="north" split="true" border="false"
		style="overflow: hidden; height: 50px;
        background: url(images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%;
        line-height: 40px;color: #fff; font-family: Verdana, 微软雅黑,黑体">
		<span style="float:right; padding-right:20px;" class="head">欢迎
			${username}<a href="#" id="editpass">修改密码</a> <a href="#"
			id="loginOut">安全退出</a>
		</span> <span style="padding-left:10px; font-size: 16px; "><img
			src="images/blocks.gif" width="20" height="40" align="absmiddle" />水文工程影像管理系统</span>
	</div>
	<div region="south" split="true"
		style="height: 30px; background: #D2E0F2; "></div>
	<div region="west" hide="true" modal="true" split="true" title="导航菜单"
		style="width:180px;" id="west">
		<div id="nav" class="easyui-accordion" fit="true" border="false">
			<!--  导航内容 -->

		</div>

	</div>
	<div id="mainPanle" region="center"
		style="background: #eee; overflow-y:hidden">
		<div id="tabs" class="easyui-tabs" fit="true" border="false">
			<div title="欢迎使用" style="padding:20px;overflow:hidden; color:red; ">

				后台管理</div>
		</div>
	</div>

	<!--修改密码窗口-->
	<div id="w" class="easyui-window" title="修改密码" collapsible="false"
		minimizable="false" maximizable="false" icon="icon-save"
		style="width: 400px; height: 300px; padding: 5px;
        background: #fafafa;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc;">
				<form id="fm" action="">
					<table cellpadding=3>
						<tr>
							<td>原密码：</td>
							<td><input id="oldPass" name="oldPass" type="text"
								class="easyui-validatebox" data-options="required:true" /></td>
						</tr>
						<tr>
							<td>新密码：</td>
							<td><input id="newPass" name="newPass" type="text"
								class="easyui-validatebox" data-options="required:true" /></td>
						</tr>
						<tr>
							<td>确认密码：</td>
							<td><input id="reNewPass" name="reNewPass" type="text"
								class="easyui-validatebox" data-options="required:true" /></td>
						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false"
				style="text-align: right; height: 30px; line-height: 30px;">
				<a class="easyui-linkbutton" icon="icon-ok" onclick="submitForm()">
					确定</font>
				</a> <a id="btnCancel" class="easyui-linkbutton" icon="icon-cancel"
					href="javascript:void(0)">取消</a>
			</div>
		</div>
	</div>

	<div id="mm" class="easyui-menu" style="width:150px;">
		<div id="mm-tabupdate">刷新</div>
		<div class="menu-sep"></div>
		<div id="mm-tabclose">关闭</div>
		<div id="mm-tabcloseall">全部关闭</div>
		<div id="mm-tabcloseother">除此之外全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-tabcloseright">当前页右侧全部关闭</div>
		<div id="mm-tabcloseleft">当前页左侧全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-exit">退出</div>
	</div>
</body>
<script type="text/javascript">
	function submitForm() {
		var isValid = $('#fm').form('validate');
		if (!isValid) {
			return false;
		}
		var newPass = $("#newPass").val();
		var oldPass = $("#oldPass").val();
		var reNewPass = $("#reNewPass").val();
		if (newPass != reNewPass) {
			$.messager.alert("提示信息", "两次密码输入不一致");
			return false;
		}
		var param = {
			'newPass' : newPass,
			'reNewPass' : reNewPass,
			'oldPass' : oldPass
		};
		$.ajax({
			url : basePath + "/user/updatePass.action",
			dataType : 'json',
			data : param,
			success : function(data) {
				var data = data.success;
				if (data == 3) {
					$.messager.alert("提示信息", "操作成功", "确定", function() {
						window.location.href = "rediectLoginPage.action";
					});

				} else if (data == 2) {
					$.messager.alert("提示信息", "原密码输入错误");
				} else {
					$.messager.alert("提示信息", "操作成功");
				}
			}
		});
	}
</script>
</html>