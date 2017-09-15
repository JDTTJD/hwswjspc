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
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/logined/task/ueditor.all.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/logined/task/ueditor.config.js"></script>
<script type="text/javascript">
	var basePath = "${ctx}";
</script>
</head>
<body>
	<div class="easyui-layout" id="box" style="width: 600px;height: 400px"
		fit="true">
		<div data-options="region:'north',title:'上北'" style="height: 100px"></div>
		<div data-options="region:'south',title:'下南'" style="height: 100px"></div>
		<div data-options="region:'west',title:'左西'" style="width: 100px"></div>
		<div data-options="region:'east',title:'右东'" style="width: 100px"></div>
		<div data-options="region:'center',title:'中神通'" style="height: 100px"></div>
	</div>
</body>
</html>