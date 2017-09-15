<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setAttribute("ctx", basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	src="${pageContext.request.contextPath }/js/common/extendValidate.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/dialog/artDialog4.1.6/jquery.artDialog.js?skin=blue"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/dialog/artDialog4.1.6/iframeTools.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/dialog/artDialog.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/dialog/artDialog_alert.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/common/waitDialog.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/common/jsloading.js"></script>
<script type="text/javascript">
	var basePath = "${ctx}";
</script>
<link href="${pageContext.request.contextPath }/css/login.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/js/login.js"></script>
<script type="text/javascript">
	if (window != top)
		top.location.href = location.href;
</script>
</head>
<body>
	<h1>&nbsp;&nbsp;&nbsp;水文工程影像管理系统</h1>
	<div class="login" style="margin-top:50px;">
		<div class="web_qr_login" id="web_qr_login"
			style="display: block; height: 235px;">

			<!--登录-->
			<div class="web_login" id="web_login">
				<div class="login-box">
					<div class="login_form">
						<form name="loginform" accept-charset="utf-8" id="login_form"
							class="loginForm" method="post">
							<input type="hidden" name="did" value="0" /> <input
								type="hidden" name="to" value="log" />
							<div class="uinArea" id="uinArea">
								<label class="input-tips" for="u">帐号：</label>
								<div class="inputOuter" id="uArea">
									<input type="text" id="username" name="username"
										class="inputstyle" />
								</div>
							</div>
							<div class="pwdArea" id="pwdArea">
								<label class="input-tips" for="p">密码：</label>
								<div class="inputOuter" id="pArea">
									<input type="password" id="password" name="password"
										class="inputstyle" />
								</div>
							</div>

							<div style="padding-left:50px;margin-top:20px;">
								<input type="button" id="loginUser" value="登 录"
									style="width:150px;" class="button_blue" />
							</div>
						</form>
					</div>

				</div>

			</div>
			<!--登录end-->
		</div>
	</div>
	<div class="jianyi">亿水泰科(北京)信息技术有限公司提供技术支持</div>
</body>
</html>