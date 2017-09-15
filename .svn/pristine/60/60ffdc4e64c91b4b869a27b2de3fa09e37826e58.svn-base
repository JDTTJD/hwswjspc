function test() {
	//alert("cilck me!");
	$.messager.alert("编辑提示框","编辑文本需要时间！");
}

//新增任务，包含UEditor富文本编辑器
function openWindow() {
	$("#dlg").dialog("open").dialog('setTitle', '新增任务');
	// $("#fm").form("clear");
	var ue = UE.getEditor('taskmain', {
		elementPathEnabled : false, //删除元素路径
		wordCount : false, //删除字数统计
		zIndex : 9999, //8991-8992可以选择但是不可以顶前显示，8993以上可以顶前显示
		autoFloatEnabled : false, //false默认不全屏显示，true默认全屏显示，会把easyui组件遮挡

		initialFrameWidth : 790,

		initialFrameHeight : 483
	});
}

//删除任务
function deleteTasks() {
	$("#task").datagrid("acceptChanges");
	var ids = "";
	var rows = $("#task").datagrid("getSelections");
	for (i = 0; i < rows.length; i++) {
		ids += rows[i].id + ",";
	}
	ids = ids.substring(0, ids.length - 1);
	if (ids == "") {
		$.messager.alert("提醒", "请至少选择一项", "error");
		return;
	} else {
		$.messager.confirm("操作提示", "确定要删除此任务吗？", function(r) {
			if (r) {
				var param = {
					"ids" : ids
				};
				$.ajax({
					url : basePath + "task/deleteTasks.action",
					type : "post",
					dataType : 'json',
					data : param,
					success : function(data) {
						if (data.deleteTasksSuccess == "2") {
							$.messager.alert("提醒", "删除成功", "info")
							$("#task").datagrid("reload");
							$("#task").datagrid("clearSelections");
							findTaskList();
						}
						if (data.deleteTasksSuccess == "1") {
							$.messager.alert("提醒", "删除失败", "error")
							$("#task").datagrid("reload");
						}
					}
				});
				return true;
			}
		});
	}
}
//新增保存按钮触发事件
function submitForm() {
	var isValid = $('#fm').form('validate');

	if (!isValid) {
		return false;
	}
	$("#fm").form('submit', {
		url : basePath + "/task/addTask.action",
		success : function(data) {
			var data = eval('(' + data + ')');
			if (data == 2) {
				$("#dlg").dialog("close");
				$("#task").datagrid("reload");
				findTaskList();
				$("#task").datagrid("clearSelections")
			} else {
				$.messager.alert("提示信息", "操作失败");
				$("#dlg").dialog("close");
				$("#task").datagrid("reload");
			}
		}
	});
}
//编辑
function editTask() {
	//var id = getSelected();

	$.messager.alert("提醒", "请选择", "warning");
}
//列表显示数据库内容
function editTasks() {
	$("#task").datagrid("acceptChanges");
	var ids = "";
	var rows = $("#task").datagrid("getSelections");
	for (i = 0; i < rows.length; i++) {
		ids += rows[i].id + ",";
	}
	ids = ids.substring(0, ids.length - 1);
	if (ids==""){
		
	}		

}
