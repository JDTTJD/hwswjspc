<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
	href="${pageContext.request.contextPath }/js/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/themes/icon.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/common/jquery-1.8.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/common/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/logined/role/roleList.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/common/extendValidate.js"></script>
<script type="text/javascript">
	var basePath = "${ctx}";
</script>
<body class="easyui-layout">
 <div class="easyui-panel" data-options="fit:true,border:false" style="background-color: #E1EDFF">
		<div data-options="region:'center'" style="padding: 0px;width: 100%;height:100%;">
			<table id="role" width='100%' class="easyui-datagrid">
			</table>
		</div>
		</div>
		<div id="dlg" class="easyui-dialog" modal="true"
			style="width: 400px; height: 180px;display:none;padding: 10px 20px;"
			closed="true" buttons="#dlg-buttons">
			<form id="fm"
				action="${pageContext.request.contextPath }/role/roleAdd.action"
				method="post">
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					class="inputTable">
					<tr>
						<th>角色名称</th>
						<td colspan="3"><input name="roleName" id="roleName" value="" type="text"
							class="easyui-validatebox"
							style="width:100%;height:20px;border-radius:5px;border:1px solid #888888;"
							maxlength="20" required="true" /></td>
						
					</tr>
					<tr>
						<th>角色描述</th>
						<td colspan="3"><input name="roleDes" id="roleDes" type="text"
							class="easyui-validatebox"
							data-options="required:true,validType:'chinese'"
							style="width:100%;height:20px;border-radius:5px;border:1px solid #888888;"
							maxlength="20" required="true" /></td>
					</tr>
				</table>
				<input type="hidden" name="checkType" id="checkType" /> <input
					type="hidden" name="id" id="id" />
			</form>
		</div>
</div>
		<div id="dlg-buttons" closed="true" style="display:none;">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="submitForm()" iconcls="icon-save">保存</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				onclick="javascript:$('#dlg').dialog('close')" iconcls="icon-cancel">取消</a>
		</div>
</body>
<script type="text/javascript">	
	function submitForm() {
		$('#fm').form('submit', {
			success : function(data) {
				var data = eval('(' + data + ')');
				if (data == 2) {
					$.messager.alert("提示信息", "操作成功");
					$("#dlg").dialog("close");
					$("#role").datagrid("reload");
					$("#role").datagrid("clearSelections");
				} else {
					$.messager.alert("提示信息", "操作失败");
					$("#dlg").dialog("close");
					$("#role").datagrid("reload");
				}
			}
		});
	}
</script>

</html>