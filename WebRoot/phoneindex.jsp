<%-- <%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.io.*" errorPage="index.jsp"%> --%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setAttribute("ctx", basePath);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	var basePath = "${ctx}";
</script>
<%-- <link href="${pageContext.request.contextPath }/css/default.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/common.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/themes/icon.css" /> --%>
<!-- <meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no">
<meta name="applicable-device" content="mobile">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<meta http-equiv="Cache-Control" content="no-transform" /> -->
<link rel="icon" type="image/png" href="Content/i/favicon.png" />
<link rel="apple-touch-icon-precomposed"
	href="Content/i/app-icon72x72@2x.png" />
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
<%-- <link href="${pageContext.request.contextPath }/Content/js/login.js"
	rel="stylesheet"> --%>

</head>

<body ontouchstart>

	<header style="padding: 35px 0 0 0;">
	<h1
		style="text-align: center; font-size: 34px; color: #3cc51f; font-weight: 400; margin: 0 15%; ">水文工程影像系统登录</h1>
	</header>
	<div class="content">
	
		<div class="content-block">
			<form method="post" data-url="phoneindex.jsp" id="formlogin">
				<input id="imei" name="imei" type="hidden" value="" />
				<div class="weui-cells weui-cells_form">
					<div class="weui-cell">
						<div class="weui-cell__hd">
							<label class="weui-label">用户名</label>
						</div>
						<div class="weui-cell__bd weui-cell_primary">
							<input class="weui-input" type="text" placeholder="请输入用户名"
								name="username" id="username">
						</div>
					</div>
					<div class="weui-cell">
						<div class="weui-cell__hd">
							<label class="weui-label">密码</label>
						</div>
						<div class="weui-cell__bd weui-cell_primary">
							<input class="weui-input" placeholder="请输入密码" type="password"
								name="password" id="password">
						</div>
					</div>
				</div>
			</form>

			<div class="weui-btn-area">
				<input class="weui-btn weui-btn_primary" id="loginUser"
					type="button" value="登录"></input>
			</div>
			<!-- <div style="padding-left:50px;margin-top:20px;">
								<input type="button" id="loginUser" value="登 录"
									style="width:150px;" class="button_blue" />
							</div> -->
		</div>
	</div>

	<!-- <div class="weui-loadmore"  id="loadmore">
    <i class="weui-loading"></i>
    <span class="weui-loadmore__tips">正在加载</span>
    weui-loadmore__tips
</div> -->
	<script type="text/javascript" src="Content/lib/jquery-2.1.4.js"></script>
	<script src="Content/lib/fastclick.js"></script>
	<script type="text/javascript">
		$(function() {
			FastClick.attach(document.body);
		});
		$(document).ready(function() {
			$("#loadmore").hide();
		});
	</script>
	<script type="text/javascript" src="Content/js/jquery-weui.js"></script>
	<script type="text/javascript" src="Content/js/mian.js"></script>

	<!-- art.dialog.tips("登陆账号不能为空!"); -->
	<!-- art.dialog.tips("登陆密码不能为空!"); -->
	<script type="text/javascript">
		$("#loginUser").click(function() {
			var username = $("#username").val();
			if (username == "") {
				alert("登陆账号不能为空!");
				return;
			}
			var password = $("#password").val();
			if (password == "") {
				alert("登陆密码不能为空!");
				return;
			}
			var param = {
				'username' : username,
				'password' : password
			};
			//	MaskUtil.mask("正在登录，请稍等......");
			//  basePath + "rediectMainPage.action"
			//  "main.jsp"
			$.ajax({
				url : basePath + "user/findUserByUserNameAndPass.action",
				type : "post",
				dataType : 'json',
				data : param,
				success : function(data) {
					//	MaskUtil.unmask();
					if (data.success == 2) {
						window.location.href = "http://192.168.1.103:8080/hwswjs/main.jsp";
					} else {
						alert("用户名或密码不正确!");
					}
				}
			});
		})
	</script>

	<%-- <script type="text/javascript" src="${ctx }/js/login.js"></script> --%>
</body>
</html>
