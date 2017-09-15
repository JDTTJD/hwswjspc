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
<title>菜单管理</title>
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
	src="${pageContext.request.contextPath }/js/tree/ztree/jquery.ztree.all-3.5.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/js/tree/ztree/zTreeStyle/zTreeStyle.css"
	type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/common/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/logined/menu/menuList.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/common/extendValidate.js"></script>

<script type="text/javascript">
	var basePath = "${ctx}";
</script>
<body>
<div class="easyui-panel" data-options="fit:true,border:false" style="background-color: #E1EDFF">
	<div data-options="region:'center'" style="width:100%;height:100%;">
		<table id="menu">
		
		</table>
	</div>
</div>
	<div id="dlg" class="easyui-dialog" modal="true"
		style="width: 600px; height: 300px;display:none;padding: 10px 20px;"
		closed="true" buttons="#dlg-buttons">
		<form id="fm"
			action="${pageContext.request.contextPath }/menu/menuAdd.action"
			method="post">
			<table width="100%" border="0" cellpadding="0" cellspacing="0"
				class="inputTable">
				<tr>
					<th>上级部门
					</th>
					<input type="hidden" id="pid" name="pid"/>
						<td colspan="3">
							<div id="treeContent" style="z-index:66;position:relative">
								<input id="groupSel" name="parentName"  type="text" readonly="readonly"  style="width:45%" class="formText iconTree"  required="true" />
								<div id="menuContent" style="position: absolute;display: none;">
									<ul id="menuTree" class="ztree" style="position: absolute; margin-top: 0; width: 186px;height:150px;overflow:auto; background: #ffffff;  border: 1px solid #8a9ba5"></ul>
								</div>
							</div>
						</td>
				</tr>
				<tr>
					<th>菜单名称</th>
					<td colspan="3"><input name="menuName" id="menuName" value=""
						type="text" class="easyui-validatebox"
						style="width:100%;height:20px;border-radius:5px;border:1px solid #888888;"
						maxlength="20" required="true" /></td>

				</tr>
				<tr>
					<th>菜单图标</th>
					<td colspan="3"><input name="icon" id="icon" type="text"
						class="easyui-validatebox" data-options="required:true"
						style="width:100%;height:20px;border-radius:5px;border:1px solid #888888;"
						maxlength="20" required="true" /></td>
				</tr>
				<tr>
					<th>菜单url</th>
					<td colspan="3"><input name="url" id="url" type="text"
						class="easyui-validatebox" data-options="required:true"
						style="width:100%;height:20px;border-radius:5px;border:1px solid #888888;"
						maxlength="20" required="true" /></td>
				</tr>
			</table>
			<input type="hidden" name="checkType" id="checkType" /> <input
				type="hidden" name="id" id="id" />
		</form>
	</div>

	<div id="dlg-buttons" closed="true" style="display:none;">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="submitForm()" iconcls="icon-save">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			onclick="javascript:$('#dlg').dialog('close')" iconcls="icon-cancel">取消</a>
	</div>
</body>
<script type="text/javascript">
	/* function submitForm() {
		$('#fm').form('submit', {
			success : function(data) {
				var data = eval('(' + data + ')');
				if (data == 2) {
					$.messager.alert("提示信息", "操作成功");
					$("#dlg").dialog("close");
					$("#menu").datagrid("reload");
					$("#menu").datagrid("clearSelections");
				} else {
					$.messager.alert("提示信息", "操作失败");
					$("#dlg").dialog("close");
					$("#menu").datagrid("reload");
				}
			}
		});
	} */
</script>

</html>