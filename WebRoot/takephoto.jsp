<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.io.*" errorPage="index.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setAttribute("ctx", basePath);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
	rel="stylesheet" />

</head>
<body ontouchstart>

	<header class="bar bar-nav">
	<h1 class="title">添加问题</h1>
	<a href="javascript:;" onclick="javascript:history.back(-1);"
		class="icon pull-left"><i class="iconfont icon-fanhui"></i></a> <a
		href="/UCenter/Index" class="icon pull-right"><i
		class="iconfont icon-wode"></i></a> </header>

	<div class="content">
		<form action="" method="post" id="formyz">
			<input type="hidden" id="hf_imgpath" name="FilePath" /> <input
				type="hidden" id="hf_imgmax" value="0" /> <input type="hidden"
				id="hf_PID" name="PID" value="49" /> <input type="hidden"
				id="hf_DamName" name="DamName" /> <input type="hidden"
				id="hf_AddressName" name="AddressName" />
			<div class="weui-cells weui-cells_form">
				<div class="weui-cell">
					<div class="weui-cell__bd">
						<textarea id="PContent" name="PContent" class="weui-textarea"
							placeholder="问题描述" rows="3"></textarea>

					</div>
				</div>
				<div class="weui-cell">
					<div class="weui-cell__bd">
						<div class="weui-uploader">
							<div class="weui-uploader__hd">
								<p class="weui-uploader__title">图片上传</p>
							</div>
							<div class="weui-uploader__bd">
								<ul class="weui-uploader__files" id="phoneContent"></ul>
								<div class="weui-uploader__input-box" title="拍照"
									onclick="openphone();"></div>
							</div>
						</div>
					</div>
				</div>
				<div class="weui-cell">
					<div class="weui-cell__hd">
						<i class="sstfont sst-dizhi"></i>
					</div>
					<div class="weui-cell__hd">
						<label for="home-city" class="weui-label">所在位置</label>
					</div>
					<div class="weui-cell__bd">
						<input class="weui-input" id="home-city" type="text" />
					</div>
				</div>
			</div>
			<div class="weui-btn-area weui-btn-area_inline">
				<a href="javascript:;"
					class="weui-btn weui-btn_mini weui-btn_primary" onclick="save();">确认</a>
				<a href="javascript:;" class="weui-btn weui-btn_mini weui-btn_blue2"
					onclick="history.go(-1);">返回</a>
			</div>
		</form>
	</div>
	<div class="weui-gallery" id="showimg">
		<span class="weui-gallery__img" data-id=""></span>
		<div class="weui-gallery__opr">
			<a href="javascript:" class="weui-gallery__del" onclick="delimg();">
				<i class="weui-icon-delete weui-icon_gallery-delete"></i>
			</a>
		</div>
	</div>
	<div class="weui-tabbar">
		<a href="main.jsp" class="weui-tabbar__item ">
			<div class="weui-tabbar__icon">
				<i class="iconfont icon-shouye"></i>
			</div>
			<p class="weui-tabbar__label">首 页</p>
		</a> <a href="search.jsp" class="weui-tabbar__item ">
			<div class="weui-tabbar__icon">
				<i class="iconfont icon-sousuo"></i>
			</div>
			<p class="weui-tabbar__label">巡 查</p>
		</a> <a href="message.jsp"
			class="weui-tabbar__item weui-bar__item--on"> <!-- <span
			class="weui-badge" style="position: absolute;right: 2em;"
			id="message">0</span> -->
			<div class="weui-tabbar__icon">
				<i class="iconfont icon-xiaoxi"></i>
			</div>
			<p class="weui-tabbar__label">消息</p>
		</a> <a href="mine.jsp" class="weui-tabbar__item ">
			<div class="weui-tabbar__icon">
				<i class="iconfont icon-wode"></i>
			</div>
			<p class="weui-tabbar__label">我 的</p>
		</a>
	</div>
	<div id="ringbell" style="display:none"></div>

	<div class="weui-loadmore" id="loadmore">
		<i class="weui-loading"></i> <span class="weui-loadmore__tips">正在加载</span>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath }/Content/lib/jquery-2.1.4.js"></script>
	<script src="${pageContext.request.contextPath }/Content/lib/fastclick.js"></script>
	<script type="text/javascript">
		$(function() {
			FastClick.attach(document.body);
		});
		$(document).ready(function() {
			$("#loadmore").hide();
		});
	</script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/Content/js/jquery-weui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/Content/js/mian.js?v=22"></script>

	<script src="${pageContext.request.contextPath }/Content/js/mobileclientdata.js"></script>
	<script src="${pageContext.request.contextPath }/Content/js/cyadd-picker.js"></script>
	<script type="text/javascript">
		$(function() {
			initControl();
		});
		function initControl() {
			$.projectNameItems = top.clients.projectNameItems;
			$.damItems = top.clients.damItems;
			$("#home-city").cyaddPicker({
				title : "选择位置",
				onChange : function(picker, values, displayValues) {
					//console.log(values, displayValues);
				}
			});
		}
		function show(that) {
			var id = $(that).attr("id");
			var fileName = $(that).attr("data-url");
			var arr = fileName.split('|');
			var url = fileName;
			if (arr.length > 2) {
				url = arr[2];
			}
			$("#showimg").find('span').attr("data-id", id);
			$("#showimg").find('span').css("background-image", "url('" + url + "')");
			$("#showimg").show();
		}
		function delimg() {
			var span = $("#showimg").find('span');
			var id = span.attr("data-id");
			var fileList = $("#hf_imgpath").val();
			var fileName = $("#" + id).attr('data-url');
			$("#hf_imgpath").val(fileList.replace(fileName + ",", ""));
	
			$("#" + id).remove();
			span.removeAttr("data-id");
			span.css("background-image", "");
			$("#showimg").hide();
		}
		//处理删除
		function deletephone(obj) {
			var fileName = $(obj).attr('tag');
			var fileList = $("#hf_imgpath").val();
			$("#hf_imgpath").val(fileList.replace(fileName + ",", ""));
	
			$(obj).parent().parent().parent().parent().hide();
		}
	
		//打开相机拍照上传
		function openphone() {
			try {
				window.demo.clickOnAndroid('openphone');
			} catch (e) {
				$.alert(e);
			}
		}
		function getImgHtml(fileName) {
			var n = parseInt($("#hf_imgmax").val());
			n++;
			$("#hf_imgmax").val(n);
			var url = fileName;
			var arr = fileName.split('|');
			if (arr.length > 2) {
				url = arr[2];
			}
			var imgHtml = '<li id="img_:imgnum" data-url=":filename" class="weui-uploader__file" style="background-image: url(:url)" onclick="show(this);"></li>';
			imgHtml = imgHtml.replace(":imgnum", n).replace(":filename", fileName).replace(":url", url);
			return imgHtml;
		}
		//上传后处理图片路径
		function phonecallback(fileName) {
			if (fileName.indexOf("error") > -1) {
				loadURL = null;
				$.alert(fileName);
			} else {
				//$.alert(fileName);
				var imgHtml = getImgHtml(fileName);
				var fileList = $("#hf_imgpath").val();
				$("#hf_imgpath").val(fileList += fileName + ",");
				var html = $("#phoneContent").html();
				$("#phoneContent").html(html + imgHtml);
			}
		}
		function save() {
			var addcode = $('#home-city').attr("data-codes");
			var pcontent = $('#PContent').val();
			if (!pcontent) {
				$.toptip('请填写问题内容');
			} else if (!addcode) {
				$.toptip('请选择位置');
			} else {
				var arr = addcode.split(',');
				if (!arr || arr.length != 2) {
					$.toptip('请选择位置');
				} else {
					var pcode = arr[0];
					var ccode = arr[1];
					$("#hf_AddressName").val(pcode);
					$("#hf_DamName").val(ccode);
					var vars = $("#formyz").serialize();
					alert($("#hf_imgpath").val());
	
				//$.post("/Patrol/PatrolAdd", vars, function (data) {
				//    if (data.result == "success") {
				//        $.toptip('提交成功', 'success');
				//        location.href = "/Patrol/Index";
				//    } else {
				//        $.toptip(data.msg, 'error');
				//    }
				//});
				}
			}
		}
	</script>

</body>
</html>
