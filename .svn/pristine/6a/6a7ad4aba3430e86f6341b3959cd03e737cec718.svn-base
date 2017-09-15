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
<body>
	<div id="task">
		<!--  class="easyui-panel" data-options="fit:true,border:false"
		style="background-color: #E1EDFF;" -->
		<div>
			<table id="user" class="easyui-datagrid" toolbar="#tb">
				<!--  toolbar="#tb" width='100%' height='100%'
				toolbar="merInfGridTB" fit='true'  -->

			</table>
			${task.getTaskName() }
			<div id="tb">
				<div>
					<div style="margin-top: 5px">
						<a href="#" class="easyui-linkbutton" iconcls="icon-add"
							plain="true" onclick="javascript:openWindow();"> 新增</a>&nbsp;<a
							href="#" class="easyui-linkbutton" iconcls="icon-edit"
							plain="true" onclick="javascript:editTask();"> 编辑</a>&nbsp;<a
							href="#" class="easyui-linkbutton" iconcls="icon-cancel"
							plain="true" onclick="javascript:deleteTask();"> 删除</a>
					</div>

				</div>
				<div>
					<!-- 	<div> -->
					<!-- 隐藏着的添加用户div,点击添加用户时,触发js中addUser(); -->
					<div id="dlg" class="easyui-dialog" modal="true"
						style="width: 600px; height: 280px;display:none;padding: 10px 20px;"
						closed="true" buttons="#dlg-buttons">
						<form id="fm" method="post">
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="inputTable">
								<tr>
									<th>消息主题:</th>
									<td><input name="username" value="" type="text"
										class="easyui-validatebox"
										style="width:100%;height:20px;border-radius:5px;border:1px solid #888888;"
										maxlength="20" required="true" /></td>
								</tr>
								<tr>
									<th>消息内容:</th>
									<td><script id="container" name="container"
											type="text/javascript">
						</script></td>
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
							onclick="javascript:$('#dlg').dialog('close')"
							iconcls="icon-cancel">取消</a>
					</div>


				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$('#task').panel({
		title : '任务分配',
		iconCls : 'icon-save',
		fit : true,
		collapsible : true,
		border : false,
		nowrap : true,
		autoRowHeight : true,
		striped : false,
		fitColumns : true,
		remoteSort : false,
		pagination : true,
		rownumbers : true,
	});
	function openWindow() {
		$("#dlg").dialog("open").dialog('setTitle', '新增任务');
		// $("#fm").form("clear");
		var ue = UE.getEditor('container', {
			elementPathEnabled : false, //删除元素路径
			wordCount : false, //删除字数统计

			autoFloatEnabled : false, //false默认不全屏显示，true默认全屏显示，会把easyui组件遮挡

			initialFrameWidth : 790,

			initialFrameHeight : 483
		});
	}
	
	
	$('#user').datagrid({
		//title : '任务分配',
		//iconCls : 'icon-save',
		//fit : true,
		pageSize : 15,
		pageList : [ 15, 20, 50, 100 ],
		nowrap : true,
		autoRowHeight : true,
		striped : false,
		pageposition : 'bottom',
		collapsible : true,
		queryParams : {
			userName : $("#userName").val(),
			date : $("#date").val(),
		},
		url : basePath + 'task/findTaskList.action',
		sortName : 'createTime',
		sortOrder : 'desc',
		remoteSort : false,
		fitColumns : true,
		idField : "id",
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		}, ] ],
		columns : [ [ {
			field : 'id',
			title : '用户编号',
			width : 100
		}, {
			field : 'taskName',
			title : '任务主题',
			width : 160
		}, {
			field : 'roleId',
			title : '角色ID',
			width : 160,
			formatter : function(value) {
				if (value == 1) {
					var sex = "男";
					return "<span title='" + sex + "'>" + sex + "</span>";
				}
				if (value == 2) {
					var sex = "女";
					return "<span title='" + sex + "'>" + sex + "</span>";

				}
			}
		}, {
			field : 'taskContent',
			title : '任务详情',
			width : 200,
			formatter : function(value) {
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
			}
		}, {
			field : 'createTime',
			title : '创建时间',
			width : 160,
			formatter : function(value) {
				return "<span title='" + value + "'>" + value + "</span>";
			}
		}, {
			field : 'createUserId',
			title : '创建用户ID',
			width : 160
		},/*  {
			field : 'brithday',
			title : '日期',
			width : 150,
			sortable : true
		}, {
			field : 'createTime',
			title : '创建时间',
			width : 150,
			sortable : true
		},  */] ],
		pagination : true,
		rownumbers : true,
		onLoadSuccess : function(data) {
			$("#user").datagrid("hideColumn", "id"); // 设置隐藏列
		//	$("#user").datagrid("hideColumn", "id"); // 设置隐藏列
		},
	});
</script>

</html>