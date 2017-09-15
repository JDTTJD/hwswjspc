<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!-- <!DOCTYPE html> -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>水文工程影像管理系统</title>
<meta name="viewport" co ntent="initial-scale=1.0, user-scalable=no" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
<style type="text/css">
html {
	height: 100%
}

body {
	height: 100%;
	margin: 0px;
	padding: 0px
}

#container {
	height: 100%
}
</style>
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=Q825sXuURZyetUcPLB0GmDqSj2xZGcRd">
//v2.0版本的引用方式：src="http://api.map.baidu.com/api?v=2.0&ak=您的密钥"
//v1.4版本及以前版本的引用方式：src="http://api.map.baidu.com/api?v=1.4&key=您的密钥&callback=initialize"
</script>
</head>

<body>
<header class="bar bar-nav">
    <h1 class="title">正在定位</h1>
    <a href="javascript:;" onclick="javascript:history.back(-1);" class="icon pull-left"><i class="iconfont icon-fanhui"></i></a>
    <a href="mine.jsp" class="icon pull-right"><i class="iconfont icon-wode"></i></a>
</header>
	<div id="container">
		<input type="button" value="开启" onclick="myDis.open()" /> <input
			type="button" value="关闭" onclick="myDis.close()" />
	</div>

	<script type="text/javascript">
	/* var map = new BMap.Map("container");
	var point = new BMap.Point(116.404, 39.915);
	map.centerAndZoom(point, 15);
	window.setTimeout(function() {
		map.panTo(new BMap.Point(116.409, 39.918));
	}, 2000); */
	
		/* var map = new BMap.Map("container");
		map.centerAndZoom(new BMap.Point(116.404, 39.915), 11); */
	
		//map.centerAndZoom(point, 15);
	/* var marker = new BMap.Marker(point); // 创建标注    
	map.addOverlay(marker); // 将标注添加到地图中
	map.addControl(new BMap.NavigationControl()); */
	
		/* map.addEventListener("click", function(e) {
			alert(e.point.lng + ", " + e.point.lat);
		});
		map.addEventListener("zoomend", function() {
			alert("地图缩放至：" + this.getZoom() + "级");
		}); */
	
		/* var map = new BMap.Map("container");
		map.centerAndZoom(new BMap.Point(116.404, 39.915), 15);
		var myPushpin = new BMap.PushpinTool(map); // 创建标注工具实例    
		myPushpin.addEventListener("markend", function(e) { // 监听事件，提示
	
	标注点坐标信息   
			alert("您标注的位置：" +
				e.marker.getPoint().lng + ", " +
				e.marker.getPoint().lat);
		});
		myPushpin.open(); // 开启标注工具 */
	
		var map = new BMap.Map("container");
		map.centerAndZoom(new BMap.Point(113.64964385,34.75661006), 11);
		var local = new BMap.LocalSearch(map, {
			renderOptions : {
				map : map
			}
		});
		local.search("店门");
	
		/* map.addControl(new BMap.NavigationControl());
		map.addControl(new BMap.ScaleControl());
		map.addControl(new BMap.OverviewMapControl());
		map.addControl(new BMap.MapTypeControl());
		map.setCurrentCity("北京"); // 仅当设置城市信息时，MapTypeControl的切
	
	换功能才能可用 */
	</script>
</body>
</html>