$(function() {
	function FSubmit(e) {
		if (e == 13) {
			jQuery("#searchBtn").trigger("click");
			e.returnValue = false;
		}
	}
	document.onkeydown = function(e) {
		var theEvent = e || window.event;
		var code = theEvent.keyCode || theEvent.which || theEvent.charCode;
		if (code == 13) {
			findPhotoList();
		}
	}
	$("#searchBtn").click(function() {
		findPhotoList();
		return false;
	});
	findPhotoList();
	// 用于汉化页码信息
	$('#photo').datagrid('getPager').pagination({
		pageSize : 15,
		beforePageText : "转到",
		afterPageText : "共{pages}页",
		displayMsg : '当前显示从{from}到{to}共{total}记录',
		onBeforeRefresh : function(pageNumber, pageSize) {
			$(this).pagination('loading');
			$(this).pagination('loaded');
		}
	});
});
// 获取选中行
function getSelected() {
	var selected = $('#user').datagrid('getSelected');
	if (selected) {
		return selected.id;
	}
}
// 获取多个选中行
function getSelections() {
	var ids = [];
	var rows = $('#user').datagrid('getSelections');
	for (var i = 0; i < rows.length; i++) {
		ids.push(rows[i].id);
	}
	return ids.join(',');
}
/**
 * 得到用户列表
 */
function findPhotoList() {
	$('#photo').datagrid({
		title : '照片管理',
		iconCls : 'icon-save',
      	fit : true,
		pageSize : 15,
		pageList : [ 15, 20, 50, 100 ],
		nowrap : true,
		autoRowHeight : true,
		striped : false,
		pageposition:'bottom',
		collapsible : true,
		queryParams : {
			photoTime : $("#photoTime").val(),
			photoNo : $("#photoNo").val(),
		},
		url : basePath + 'photo/findPhotoList.action',
		sortOrder : 'desc',
		remoteSort : false,
		fitColumns : true,
		idField : "id",
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		}, ] ],
		columns : [ [ {
			field : 'photoNo',
			title : '拍摄编号',
			width:'10%',
		}, {
			field : 'userName',
			title : '用户名',
			width:'10%',
		}, {
			field : 'photoTime',
			title : '拍摄时间',
			width:'20%',
		}, {
			field : 'photoAddr',
			title : '拍摄地址',
			width:'30%',
			
		}, {
			field : 'remark',
			title : '备注',
			width:'20%',
			
		},{
			field : 'photoId',
			title : '操作',
			width:'8%',
			formatter:function(value)
			{
			   var detain="<font style='font-weight:bold;color:blue'>照片详情</font>";
			   return "<a  href='javascript:void(0)' onclick=redirectPhotos('"+value+"')>"+detain+"</a>";
			}
			
		},] ],
		pagination : true,
		rownumbers : true,
		onLoadSuccess : function(data) {
		//	$("#user").datagrid("hideColumn", "id"); // 设置隐藏列
		//	$("#user").datagrid("hideColumn", "id"); // 设置隐藏列
		},
	});
}
function redirectPhotos(photoNo)
{
	window.location.href=basePath+'photoDetains/redirectPhotoDetainsList.action?photoNo='+photoNo
}
function addTab(title, url) {
	var icon = "icon ";
	var jq = top.jQuery;
	if (jq("#tabs").tabs('exists', title)) {
		jq("#tabs").tabs('select', title);
	} else {
		var content = '<iframe scrolling="auto" frameborder="0"  src="' + url
				+ '" style="width:100%;height:100%;"></iframe>';
		jq("#tabs").tabs('add', {
			title : title,
			content : content,
			closable : true,
			icon : icon
		});
	}
}
function outUser() {
	var userName = $("#userName").val();
	var date = $("#date").val();
	window.location.href = basePath + "outUser/outUserList.action?userName="
			+ userName + "&date=" + date;
}

//添加用户
function addUser()
{
	$('#btnsave').linkbutton('enable');
	$("#dlg").dialog("open").dialog('setTitle', '新增用户');
	// $("#fm").form("clear");
	$('#checkType').val(1);
}
//编辑用户
function editUser()
{
	$('#btnsave').linkbutton('enable');
	var id = getSelected();
	if (id == "" || !id) {
		$.messager.alert('提醒', '请选择一项', 'warning');
		return;
	}
	$('#checkType').val(2);
	var row = $("#user").datagrid("getSelected");
	if (row) {
		$("#dlg").dialog("open").dialog('setTitle', '编辑用户');
		$("#fm").form("load", row);
		var str = row.roleId; // 后台的角色字符串
		if (str != null && str != "") {
			var strs = new Array(); // 定义角色数组
			strs = str.split(","); // 字符分割
			$("[name = roleId]:checkbox").each(function() {
				for (i = 0; i < strs.length; i++) {
					if (strs[i] == $(this).val()) {
						$(this).attr("checked", true);
					}
				}
			});
		}
	}
}

//删除用户
function deleteUser()
{
	$("#user").datagrid("acceptChanges");
	$('#btnsave').linkbutton('enable');
	var ids = "";
	var rows = $('#user').datagrid('getSelections');
	for (var i = 0; i < rows.length; i++) {
		ids += rows[i].id + ",";
	}
	ids = ids.substring(0, ids.length - 1);
	if (ids == "") {
		$.messager.alert('提醒', '请至少选择一项', 'warning');
		return;
	} else {
		$.messager.confirm("确认", "确认要删除吗?", function(r) {
			if (r) {
				var param = {
					"ids" : ids
				};
				$.ajax({
					url : basePath + "user/deleteUsers.action",
					type : "post",
					dataType : 'json',
					data : param,
					success : function(data) {
						if (data.deleteUserSuccess == 2) {
							$.messager.alert('提醒', '删除成功', 'info');
							$("#user").datagrid("reload");
							$('#user').datagrid('clearSelections');
							findUserList();
						}
						if (data.deleteUserSuccess == 1) {
							$.messager.alert('提醒', '删除失败', 'info');
							$("#user").datagrid("reload");
						}
					}
				});
				return true;
			}
		});
	}

}

//导入用户
function importUser(){
	$("#importData").dialog("open").dialog('setTitle', '导入用户');
}