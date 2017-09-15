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
	<div id="task" style="width:500px;height:200px">

		<div style="margin-top: 5px">
			<a href="#" class="easyui-linkbutton" iconcls="icon-add" plain="true"
				onclick="javascript:openWindow();"> 新增</a>&nbsp;<a href="#"
				class="easyui-linkbutton" iconcls="icon-edit" plain="true"
				onclick="javascript:editTask();"> 编辑</a>&nbsp;<a href="#"
				class="easyui-linkbutton" iconcls="icon-cancel" plain="true"
				onclick="javascript:deleteTask();"> 删除</a>
		</div>
		<!-- 隐藏着的div -->
		<div id="dlg" class="easyui-window" modal="false"
			style="width: 600px; height: 280px;" closed="true"
			buttons="#dlg-buttons">
			<a class="easyui-linkbutton"
				data-options="iconCls:'icon-ok',plain:true," style="width:70px;">确认</a>
			<a class="easyui-linkbutton"
				data-options="iconCls:'icon-cancel',plain:true" style="width:70px;"
				onclick="tang()">取消</a>
		</div>

		<!-- http://localhost:8080/hwswjs/js/logined/task/jsp/controller.jsp,json路径 -->
		<!-- 测试窗口 -->
		<!-- <div class="easyui-window" style="width:400px;height:200px;"
			title="新窗口" id="testWindow1">
			<div class="easyui-layout" data-options="fit:true,">
				<div data-options="region:'west',split:true" style="width:100px">左边</div>
				<div data-options="region:'center'">内容</div>
				<div data-options="region:'south',border:false"
					style="height:40px;text-align:right;padding:6px 6px 0 0;">
					<a class="easyui-linkbutton"
						data-options="iconCls:'icon-ok',plain:true," style="width:70px;">确认</a>
					<a class="easyui-linkbutton"
						data-options="iconCls:'icon-cancel',plain:true"
						style="width:70px;" onclick="tang()">取消</a>
				</div>
			</div>
		</div> -->
		<!-- <a class="easyui-splitbutton" id="edit" href="javascript:void(0)"
			data-options="iconCls:'icon-edit',menu:'#tang',duration:5000000,plain:false">编辑</a>
		<div id="tang" style="width:150px;">
			<div>剪切</div>
			<div>复制</div>
			<div>粘贴</div>
			<div class="menu-sep"></div>
			<div>删除</div>
		</div> -->
		<!-- <script id="container" name="content" type="text/javascript">这里写你的初始化内容
		</script> -->
		<div class="easyui-window" style="width:400px;height:200px;"
			title="新窗口" id="container" closed="true"
			data-options="left:'500px',bottom:'100px'">
			<!-- <script type="text/javascript">
			 var ue = UE.getEditor('container', {
				elementPathEnabled : false, //删除元素路径
				wordCount : false, //删除字数统计
		
				autoFloatEnabled : false, //false默认不全屏显示，true默认全屏显示，会把easyui组件遮挡
		
				initialFrameWidth : 790,
		
				initialFrameHeight : 483 
				
			});
			
		</script> -->
		</div>

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
		
			var ue = UE.getEditor('dlg', {
				elementPathEnabled : false, //删除元素路径
				wordCount : false, //删除字数统计
		
				autoFloatEnabled : false, //false默认不全屏显示，true默认全屏显示，会把easyui组件遮挡
		
				initialFrameWidth : 790,
		
				initialFrameHeight : 483
			});
		
			function openWindow() {
				
				$("#dlg").dialog("open").dialog('setTitle', '新增用户');
				// $("#fm").form("clear");
				
			}
		</script>
</body>


</html>