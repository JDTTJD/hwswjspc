$(document).ready(function() {
	function FSubmit(e) {
		if (e == 13) {
			jQuery("#loginUser").trigger("click");
			e.returnValue = false;
		}
	}
	document.onkeydown = function(e) {
		var theEvent = e || window.event;
		var code = theEvent.keyCode || theEvent.which || theEvent.charCode;
		if (code == 13) {
			loginUser();
		}
	}
	// 用户登陆
	$("#loginUser").click(function() {
		loginUser();
		return false;
	});

})
/** 登陆用户 */
function loginUser() {
	var username = $("#username").val();
	if (username == "") {
		art.dialog.tips("登陆账号不能为空!");
		return;
	}
	var password = $("#password").val();
	if (password == "") {
		art.dialog.tips("登陆密码不能为空!");
		return;
	}
	var param = {
		'username' :username,
		'password' :password
	};
//	MaskUtil.mask("正在登录，请稍等......");
	$.ajax({
		url : basePath + "findUserByUserNameAndPass.action",
		type : "post",
		dataType : 'json',
		data : param,
		success : function(data) {
		//	MaskUtil.unmask();
			if (data.success== 2) {
				window.location.href = basePath + "rediectMainPage.action";
			}else{
				art.dialog.tips("用户名或密码不正确!",3);			
			}
		}
	});
}