<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE html>
<html>
<head>
<title>水文工程影像管理系统</title>
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
	rel="stylesheet" type="text/css" />

</head>
<body ontouchstart>

	<header class="bar bar-nav">
		<h1 class="title">黄河水文工程影像管理系统</h1>
		<a href="phoneindex.jsp" class="icon pull-left"><i 
		class="iconfont icon-fanhui"></i></a>
		<a href="mine.jsp" class="icon pull-right"><i
			class="iconfont icon-wode"></i></a>
	</header>

	<div class="content">
		<div class="swiper-container">
			<!-- Additional required wrapper -->
			<div class="swiper-wrapper">
				<!-- Slides -->

				<div class="swiper-slide">
					<img
						src="${pageContext.request.contextPath }/Content/images/indexbg11.png" />
				</div>
			</div>
		</div>
		<div class="weui-grids whitebg"
			style="margin-top:-5px; padding-top:-5px;">
			<a href="location.jsp" class="weui-grid js_grid" data-id="button">
				<div class="weui-grid__icon">
					<img src="Content/icon/icon_nav_city.png" alt="工程巡查" />
				</div>
				<p class="weui-grid__label">定位</p>
			</a>
			 <a href="search.jsp" class="weui-grid js_grid" data-id="button">
				<div class="weui-grid__icon">
					<img src="Content/icon/patrol_icon.png" alt="工程进度" />
				</div>
				<p class="weui-grid__label">任务</p>
			</a>
			 <a href="takephoto.jsp" class="weui-grid js_grid" data-id="button">
				<div class="weui-grid__icon">
					<img src="Content/icon/patrolend.png" alt="实时水情" />
				</div>
				<p class="weui-grid__label">拍摄</p>
			</a> 
			
			<a href="task.jsp" class="weui-grid js_grid" data-id="button">
            <div class="weui-grid__icon">
                <img src="Content/icon/duty_icon.png" alt="发布任务" />
            </div>
            <p class="weui-grid__label">发布任务</p>
        </a>
        <a href="recorde.jsp" class="weui-grid js_grid" data-id="button">
            <div class="weui-grid__icon">
                <img src="Content/icon/progress_icon.png" alt="现场录音" />
            </div>
            <p class="weui-grid__label">现场录音</p>
        </a>
        
        <a href="mine.jsp" class="weui-grid js_grid" data-id="button">
				<div class="weui-grid__icon">
					<img
						src="Content/icon/fang_icon.png"/>
				</div>
				<p class="weui-grid__label">我的</p>
				<!-- default_avatar_128_128.jpg -->
			</a>
        <!-- <a href="/RainRiver/Index" class="weui-grid js_grid" data-id="button">
            <div class="weui-grid__icon">
                <img src="Content/icon/fang_icon.png" alt="防汛队伍" />
            </div>
            <p class="weui-grid__label">防汛队伍</p>
        </a>
        <a href="/RainRiver/Index" class="weui-grid js_grid" data-id="button">
            <div class="weui-grid__icon">
                <img src="Content/icon/qiang_icon.png" alt="抢险救护" />
            </div>
            <p class="weui-grid__label">抢险救护</p>
        </a> -->
		</div>
	</div>
	<div class="weui-tabbar">
		<a href="main.jsp" class="weui-tabbar__item ">
			<div class="weui-tabbar__icon">
				<i class="iconfont icon-shouye"></i>
			</div>
			<p class="weui-tabbar__label">首 页</p>
		</a> 
		<a href="uploadDemo.jsp" class="weui-tabbar__item ">
			<div class="weui-tabbar__icon">
				<i class="iconfont icon-sousuo"></i>
			</div>
			<p class="weui-tabbar__label">提交</p>
		</a>
		 <a href="message.jsp"
			class="weui-tabbar__item weui-bar__item--on"> <!-- <span
			class="weui-badge" style="position: absolute;right: 2em;"
			id="message">0</span> -->
			<div class="weui-tabbar__icon">
				<i class="iconfont icon-xiaoxi"></i>
			</div>
			<p class="weui-tabbar__label">消息</p>
		</a> 
		<a href="mine.jsp" class="weui-tabbar__item ">
			<div class="weui-tabbar__icon">
				<i class="iconfont icon-wode"></i>
			</div>
			<p class="weui-tabbar__label">我 的</p>
		</a>
	</div>
	<div id="ringbell" style="display:none"></div>

	<!-- <div class="weui-loadmore" id="loadmore">
		<i class="weui-loading"></i> <span class="weui-loadmore__tips">正在加载</span>
	</div> -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/Content/lib/jquery-2.1.4.js"></script>
	<script src="${pageContext.request.contextPath }/Content/lib/fastclick.js"></script>
	<script type="text/javascript">
		$(function() {
			FastClick.attach(document.body);
		});
		$(document).ready(function() {
			$("#loadmore").hide();
		});
	</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/Content/js/jquery-weui.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/Content/js/mian.js"></script>

	<script src="${pageContext.request.contextPath }/Content/js/swiper.js"></script>
	<script type="text/javascript">
		$(".swiper-container").swiper();
	</script>

</body>
</html>