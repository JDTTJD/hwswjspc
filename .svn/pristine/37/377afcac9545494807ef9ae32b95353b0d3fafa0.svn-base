/* 上传安装包：ajax上传插件使用 */
//首先上传文件
function ajaxFileUpload() {
	var fileupload = $("#fileupload").val();
	if (fileupload == null || fileupload == "" || fileupload == undefined) {
		$.messager.alert("提示", "请选择导入的文件","info");
		return;
	}
	if (fileupload.endWith("xls") || fileupload.endWith("xlsx")) {
	} else {
		$.messager.alert("提示", "导入的文件必须是excel","info");
		return;
	}
	$.ajaxFileUpload({
		url : basePath + 'upload/uploadFile.action', // 用于文件上传的服务器端请求地址
		secureuri : false, // 是否需要安全协议，一般设置为false
		fileElementId : 'fileupload', // 文件上传域的ID
		dataType : 'json', // 返回值类型 一般设置为json
		type : 'post',
		success : function(data, status) // 服务器成功响应处理函数
		{
			$.messager.alert("提示", "导入成功", "info", function() {
				window.location.href = basePath
						+ "user/redirectUserList.action";
			});
		},
		error : function(data, status, e)// 服务器响应失败处理函数
		{
			$.messager.alert("提示", "上传失败");
		}

	})
	return false;
}
//自定义endWith方法
String.prototype.endWith = function(s) {
	if (s == null || s == "" || this.length == 0 || s.length > this.length)
		return false;
	if (this.substring(this.length - s.length) == s)
		return true;
	else
		return false;
	return true;
}
//自定义startWith方法
String.prototype.startWith = function(s) {
	if (s == null || s == "" || this.length == 0 || s.length > this.length)
		return false;
	if (this.substr(0, s.length) == s)
		return true;
	else
		return false;
	return true;
}





















