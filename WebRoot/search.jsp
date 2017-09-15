<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>水文工程影像管理系统</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <meta name="applicable-device" content="mobile">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <meta http-equiv="Cache-Control" content="no-transform" />
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath }/Content/i/favicon.png" />
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath }/Content/i/app-icon72x72@2x.png" />
    <link href="${pageContext.request.contextPath }/Content/lib/weui.min.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath }/Content/css/jquery-weui.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath }/Content/css/style.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath }/Content/font/iconfont.css" rel="stylesheet" />
    
</head>
<body ontouchstart>    
    
<header class="bar bar-nav">
    <h1 class="title">暂无巡查任务</h1>
    <a href="javascript:;" onclick="javascript:history.back(-1);" class="icon pull-left"><i class="iconfont icon-fanhui"></i></a>
    <a href="mine.jsp" class="icon pull-right"><i class="iconfont icon-wode"></i></a>
</header>

<div class="content">
</div>
<div class="weui-tabbar">
		<a href="main.jsp" class="weui-tabbar__item ">
			<div class="weui-tabbar__icon">
				<i class="iconfont icon-shouye"></i>
			</div>
			<p class="weui-tabbar__label">首 页</p>
		</a> 
		<a href="search.jsp" class="weui-tabbar__item ">
			<div class="weui-tabbar__icon">
				<i class="iconfont icon-sousuo"></i>
			</div>
			<p class="weui-tabbar__label">巡 查</p>
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
 
    <script type="text/javascript" src="/Content/lib/jquery-2.1.4.js"></script>
    <script src="/Content/lib/fastclick.js"></script>
    <script type="text/javascript">
        $(function () {
            FastClick.attach(document.body);
        });
        $(document).ready(function () {
            $("#loadmore").hide();
        });
    </script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/Content/js/jquery-weui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/Content/js/mian.js?v=22"></script>
    
    <script src="${pageContext.request.contextPath }/Content/js/mobileclientdata.js"></script>
    <script type="text/javascript">
        function start(id) {
            $.post("/Patrol/PatrolStart", { pid: id }, function (data) {
                if (data.result == "success") {
                    $.alert("开始巡查!", function () {
                        location.reload(true);
                    });
                } else {
                    $.alert(data.msg);

                }
            }, 'json');
        }
        function end(id) {
            $.post("/Patrol/PatrolEnd", { pid: id }, function (data) {
                if (data.result == "success") {
                    $.alert("开始巡查!", function () {
                        location.href = "/";
                    });
                } else {
                    $.alert(data.msg);
                }
            }, 'json');
        }
        $(function () {
            //初始化列表
            $("#list .addvcd").each(function (node) {
                var row = $(this);
                var name = "";
                var AddressName = $(row).attr("data-pcode");
                var DamName = $(row).attr("data-code");
                AddressName = $.trim(AddressName);
                DamName = $.trim(DamName);
                if (AddressName.length > 0) {
                    AddressName = clients.projectNameItems[AddressName].fullname;
                    name += AddressName;
                }
                if (DamName.length > 0) {
                    DamName = clients.damItems[DamName].fullname;
                    name += " " + DamName;
                }
                $(row).text(name);
            });

        });
    </script>

</body>
</html>