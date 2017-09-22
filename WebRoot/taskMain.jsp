<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	href="${pageContext.request.contextPath }/css/common.css" />
<link href="${pageContext.request.contextPath }/css/ueditor.css"
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
	src="${pageContext.request.contextPath }/js/logined/user/userList.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/common/waitDialog.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/logined/task/ueditor.config.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/logined/task/ueditor.all.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/logined/task/zh-cn.js"></script>
<script type="text/javascript">
	var basePath = "${ctx}";
</script>

</head>
<body class="easyui-layout">
<a href="javascript:;" onclick="javascript:history.back(-1);" class="icon pull-left"><i class="iconfont icon-fanhui"></i></a>
	<!-- fit:true,border:false -->
	<div class="easyui-panel" data-options="fit:true,border:false"
		style="background-color: #E1EDFF;">

		<div data-options="region:'center'"
			style="padding: 0px;width: 100%;height:100%;border:false">
			<!-- toolbar="merInfGridTB" -->
			<table id="task" toolbar="#tb" width='100%' height='100%'
				toolbar="merInfGridTB" fit='true' class="easyui-datagrid">

			</table>

			<div id="tb">
				<div style="margin-top: 5px">
					<a href="#" class="easyui-linkbutton" iconcls="icon-add"
						plain="true" onclick="javascript:openWindow();"> 新增</a>&nbsp;<a
						href="#" class="easyui-linkbutton" iconcls="icon-edit"
						plain="true" onclick="javascript:test();"> 编辑</a>&nbsp;<a href="#"
						class="easyui-linkbutton" iconcls="icon-cancel" plain="true"
						onclick="javascript:deleteTasks();"> 删除</a>
						<a href="#"
						class="easyui-linkbutton" iconcls="icon-back" plain="true"
						onclick="javascript:history.back(-1);"> 返回</a>
				</div>
			</div>

			<div>
				<!-- 	<div> -->
				<!-- 隐藏着的添加用户div,点击添加用户时,触发js中addUser(); -->
				<div id="dlg" class="easyui-dialog" modal="true"
					style="width: 600px; height: 280px;display:none;padding: 10px 20px;"
					closed="true" buttons="#dlg-buttons"
					data-options="minimizable:'ture',collapsible:'ture',maximizable:'ture'">
					<form id="fm" method="post">
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="inputTable">
							<tr>
								<th>任务主题:</th>
								<td><input name="taskname" value="" type="text"
									class="easyui-validatebox"
									style="width:100%;height:20px;border-radius:5px;border:1px solid #888888;"
									maxlength="20" required="true" /></td>
							</tr>
							<tr>
								<th>任务详情:</th>
								<td><script id="taskmain" name="taskmain"
										type="text/javascript">
						</script></td>
							</tr>
						</table>
						<input type="hidden" name="checkType" id="checkType" /> <input
							type="hidden" name="id" id="id" /> <input type="hidden"
							name="username" value="${username }" />
					</form>
				</div>
				<div id="dlg-buttons" closed="true" style="display:none;">
					<a href="javascript:void(0)" class="easyui-linkbutton"
						onclick="submitForm()" iconcls="icon-save">保存</a> <a
						href="javascript:void(0)" class="easyui-linkbutton"
						onclick="javascript:$('#dlg').dialog('close')"
						iconcls="icon-cancel">取消</a>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$('#task').datagrid({
		title : '任务分配',
		iconCls : 'icon-save',
		border : false,
		fit : true,
		fitColumns : true,
		pageSize : 15,
		pageList : [ 15, 20, 50, 100 ],
		nowrap : false,
		autoRowHeight : true,
		striped : false,
		pageposition : 'bottom',
		collapsible : true,
		queryParams : {
			userName : $("#taskName").val(),
			date : $("#date").val(),
		},
		url : basePath + 'task/findTaskList.action',
		sortName : 'createTime',
		sortOrder : 'desc',
		//multiSort : true,
		//remoteSort : true, //这个是按照服务器排序

		idField : "id",
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		}, ] ],
		columns : [ [ /* {
			field : 'id',
			title : '用户编号',
			width : 100
		}, */ {
			field : 'taskName',
			title : '任务主题',
			width : 160
		}, /* {
			field : 'roleId',
			title : '角色ID',
			width : 40,
			}, */
			/* formatter : function(value) {
				if (value == 1) {
					var sex = "男";
					return "<span title='" + sex + "'>" + sex + "</span>";
				}
				if (value == 2) {
					var sex = "女";
					return "<span title='" + sex + "'>" + sex + "</span>";

				}
			} */
			{
				field : 'taskContent',
				title : '任务详情',
				width : 200,
				sortable : true,

			/* formatter : function(value) {
				if (value == 1) {
					var speciality = "体育";
					return "<span title='" + speciality + "'>" + speciality + "</span>";
				}
				if (value == 2) {
					var speciality = "美术";
					return "<span title='" + speciality + "'>" + speciality + "</span>";

				}
				if (value == 3) {
					var speciality = "音乐";
					return "<span title='" + speciality + "'>" + speciality + "</span>";

				}
			} */
			}, {
				field : 'createTime',
				title : '发布时间',
				width : 160,
				sortable : true,
			/* formatter : function(value) {
				return "<span title='" + value + "'>" + value + "</span>";
			} */
			}, {
				field : 'createUserId',
				title : '发布人',
				width : 160
			}, /*  {
			field : 'brithday',
			title : '日期',
			width : 150,
			sortable : true
		}, {
			field : 'createTime',
			title : '创建时间',
			width : 150,
			sortable : true
		},  */ ] ],
		pagination : true,
		rownumbers : true,
		onLoadSuccess : function(data) {
			$("#task").datagrid("hideColumn", "id"); // 设置隐藏列
		//	$("#user").datagrid("hideColumn", "id"); // 设置隐藏列
		},
		/* onLoadSuccess : function(data) {
			$('#task').datagrid('collapseGroup');
		}, */

	});
</script>
</html>