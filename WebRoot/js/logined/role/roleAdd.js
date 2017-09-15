jQuery(document).ready(function() {
	initModuleTree();// 初始化树型结构
	 $('#dlg').dialog({  
	           onClose:function(){  
	        	   window.location.href = basePath
					+ '/role/redirectRoleList.action';   
	            }  
	        });  

});
/**
 * 添加角色
 * 
 */
function submitForm() {
	var isValid = $('#fm').form('validate');
	if (!isValid) {
		return false;
	}
	var roleName = $("#roleName").val();
	var zTree = $.fn.zTree.getZTreeObj("moduleTree");
	var moduleIds = '';
	var selLen = 0;
	var nodes = zTree.getNodes();
	var nodes_array = zTree.transformToArray(nodes);
	for (var i = 0; i < nodes_array.length; i++) {
		var checked = nodes_array[i].checked; // 检查每一个节点的选中状态
		if (checked) {
			moduleIds += nodes_array[i].id + ',';
			selLen++;
		}
	}
	// 加入树形结构
	if (selLen == 0) {
		$.messager.alert("操作提醒", "没有选择任何模块", 'info');
		return;
	}
	moduleIds = moduleIds.substring(0, moduleIds.length - 1);
	// 参数传递
	var param = {
		'roleName' : $.trim($("#roleName").val()),
		'roleDes' : $.trim($("#roleDes").val()),
		'checkType' : 1,
		'moduleIds' : moduleIds
	};
	$.ajax({
		url : basePath + "role/roleAdd.action",
		type : "post",
		dataType : 'json',
		data : param,
		success : function(data) {
			if (data == 2) {
				window.location.href = basePath
						+ '/role/redirectRoleList.action';
			} else if(data==3){
				$.messager.alert("提醒", '角色名称已存在,请选择别的名称', 'info');
			}else
			{
				$.messager.alert("提醒", '添加失败', 'info');
			}
		}
	});

}
function initModuleTree() {
	// 参数设置
	var setting = {
		check : {
			enable : true,
			nocheckInherit : false
		},

		view : {
			dblClickExpand : false

		},
		data : {
			simpleData : {
				enable : true
			}
		},
		callback : {
			onClick : submitForm
		}
	};
	var url = basePath + "menu/ztree.action";
	$.ajax({
		url : url,
		type : 'post',
		dataType : 'json',
		success : function(data) {
			jQuery.fn.zTree.init(jQuery("#moduleTree"), setting, data);
			// 加载完数据后，自动展开所有节点
			var treeObj = $.fn.zTree.getZTreeObj("moduleTree");
			treeObj.expandAll(true);
		}
	});

}