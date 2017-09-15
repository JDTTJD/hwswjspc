var MaskUtil = (function() {
	var $mask, $maskMsg;
	var defMsg = '正在处理，请稍待。。。';
	function init() {
		if (!$mask) {
			$mask = $("<div class=\"datagrid-mask mymask\"></div>").appendTo(
					"body");
		}
		if (!$maskMsg) {
			$maskMsg = $(
					"<div class=\"datagrid-mask-msg mymask\">" + defMsg
							+ "</div>").appendTo("body").css({
				'font-size' : '12px'
			});
		}
		$mask.css({
			width : "100%",
			height : $(document).height()
		});
		var scrollTop = $(document.body).scrollTop();
		$maskMsg.css({
			left : ($(document.body).outerWidth(true) - 190) / 2,
			top : (($(window).height() - 45) / 2) + scrollTop
		});
	}
	return {
		mask : function(msg) {
			init();
			$mask.show();
			$maskMsg.html(msg || defMsg).show();
		},
		unmask : function() {
			$mask.hide();
			$maskMsg.hide();
		}
	}
}());
// 方法
// MaskUtil.mask("请稍等,正在为你加载.......");
// MaskUtil.unmask("请稍等,正在为你加载.......");

$.ajaxSetup({
	error : function(XMLHttpRequest, textStatus, errorThrown) {
		if (XMLHttpRequest.status == 403) {
			alert('您没有权限访问此资源或进行此操作');
			return false;
		}
	},
	complete : function(XMLHttpRequest, textStatus) {
		var sessionstatus = XMLHttpRequest.getResponseHeader("sessionstatus"); // 通过XMLHttpRequest取得响应头,sessionstatus，
		if (sessionstatus == 'timeout') {
			alert();
			// 如果超时就处理 ，指定要跳转的页面
			var top = getTopWinow(); // 获取当前页面的顶层窗口对象
			alert('登录超时, 请重新登录.');
			top.location.href = path + "/login.jsp"; // 跳转到登陆页面
		}
	}
});
