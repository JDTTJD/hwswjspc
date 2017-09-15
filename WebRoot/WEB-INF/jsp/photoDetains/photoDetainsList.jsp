<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
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
	href="${pageContext.request.contextPath }/css/common.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/themes/icon.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/themes/default/easyui.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/common/jquery-1.8.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/common/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/logined/photodetains/photoDetains.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/common/extendValidate.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/common/waitDialog.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/common/jsloading.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/logined/upload/ajaxfileupload.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/logined/upload/ajaxupload.js"></script>
<script type="text/javascript">
	var basePath = "${ctx}";
</script>
<body class="easyui-layout">
<input type="hidden" id="photoNo" value="${photoNo}"  />
	<div class="easyui-panel" data-options="fit:true,border:false"
		style="background-color: #E1EDFF;">
		<div data-options="region:'center'"
			style="padding: 0px;width: 100%;height:100%;border:false">
			<table id="photoDetains" toolbar="#tb" width='100%' height='100%'
				toolbar="photoDetainsInfGridTB" fit='true' class="easyui-datagrid">
				
			</table>
			<div id="dlg-buttons" closed="true" style="display:none;">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					onclick="submitForm()" iconcls="icon-save">保存</a> <a
					href="javascript:void(0)" class="easyui-linkbutton"
					onclick="javascript:$('#dlg').dialog('close')"
					iconcls="icon-cancel">取消</a>
			</div>
		</div>
</body>
<script type="text/javascript">
	$('#brithday').datebox({
		required : true
	});
	$('#date').datebox({});

	/* function submitForm() {
		$('#fm').form('submit', {
			success : function(data) {
				var data = eval('(' + data + ')');
				if (data == 2) {
					$.messager.alert("提示信息", "操作成功");
					$("#dlg").dialog("close");
					$("#user").datagrid("reload");
					$("#user").datagrid("clearSelections");
				} else {
					$.messager.alert("提示信息", "操作失败");
					$("#dlg").dialog("close");
					$("#user").datagrid("reload");
				}
			}
		});
	} */
	function submitForm() {
		var isValid = $('#fm').form('validate');
		if (!isValid) {
			return false;
		}
		var chkbox = document.getElementsByName("roleId");
		var roleIds = "";
		var selLen = 0;
		for (var i = 0; i < chkbox.length; i++) {
			if (chkbox[i].checked) {
				roleIds += chkbox[i].value + ",";
				selLen++;
			}
		}
		if (selLen == 0) {
			$.messager.alert("操作提示", "角色没有选择!", "info");
			return false;
		}
		$('#fm').form('submit', {
			url : basePath + "/user/userAdd.action?roleIds=" + roleIds,
			success : function(data) {
				var data = eval('(' + data + ')');
				if (data == 2) {
					//	$.messager.alert("提示信息", "操作成功");
					$("#dlg").dialog("close");
					$("#user").datagrid("reload");
					findUserList();
					//	window.location.href=basePath+"user/redirectUserList.action";
					$("#user").datagrid("clearSelections");
				} else {
					$.messager.alert("提示信息", "操作失败");
					$("#dlg").dialog("close");
					$("#user").datagrid("reload");
				}
			}
		});
	}
	function down() {
		window.location.href = basePath + "down/downFile.action";
	}
</script>

</html>