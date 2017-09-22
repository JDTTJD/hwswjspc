<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>webuploader组件上传</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<!-- 1.添加js文件等等  -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/Content/js/webuploader.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/Content/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/Content/js/webuploader.js"></script>
</head>

<body>
	<!-- 2.写界面 -->
	<div id="uploader">
		<div id="filePicker">点击选择文件</div>
	</div>

	<!-- 3.使用webuploader渲染 -->
	<script type="text/javascript">
		var uploader = WebUploader.create({
			//flash地址
			swf : "${pageContext.request.contextPath}/Content/js/Uploader.swf",
			//设置提交的服务器地址
			server : "${pageContext.request.contextPath}/UploadServlet",
			//渲染文件上传元素
			pick : "#filePicker",
			//自动上传
			auto : true
		});
	</script>
</body>
</html>
