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

<title>基本文件上传</title>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no">
<meta name="applicable-device" content="mobile">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<meta http-equiv="Cache-Control" content="no-transform" />
<link rel="icon" type="image/png"
	href="${pageContext.request.contextPath }/Content/i/favicon.png" />
<link rel="apple-touch-icon-precomposed"
	href="${pageContext.request.contextPath }/Content/i/app-icon72x72@2x.png" />
<link
	href="${pageContext.request.contextPath }/Content/lib/weui.min.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath }/Content/css/jquery-weui.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath }/Content/css/style.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath }/Content/font/iconfont.css"
	rel="stylesheet" />
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<header class="bar bar-nav">
	<h1 class="title">上传文件</h1>
	<a href="javascript:;" onclick="javascript:history.back(-1);"
		class="icon pull-left"><i class="iconfont icon-fanhui"></i></a> <a
		href="mine.jsp" class="icon pull-right"><i
		class="iconfont icon-wode"></i></a> </header>

	<form action="${pageContext.request.contextPath}/UploadServlet"
		method="post" enctype="multipart/form-data">
		<br/><br/>选择文件：<input type="file" name="upload" /><br> 文件描述信息：<input
			type="text" name="info" /> <input type="submit" value="提交" />
	</form>
</body>
</html>
