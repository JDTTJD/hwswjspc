jQuery(document).ready(function(){
	initModuleTree();
	 $('#dlg').dialog({  
         onClose:function(){  
      	   window.location.href = basePath
				+ '/role/redirectRoleList.action';   
          }  
      }); 
});
/**
 * 修改角色
 * 
 */
function submitForm() {
	//验证
	var isValid = $('#fm').form('validate');
	if (!isValid) {
		return false;
	}
	var roleId=$("#roleId").val();
	var roleDes=$("#roleDes").val();
	//加入树形结构
	var zTree = $.fn.zTree.getZTreeObj("moduleTree"); 
	var moduleIds=''; 
	var selLen = 0;
	var nodes=zTree.getNodes();
	var nodes_array = zTree.transformToArray (nodes);   
	for(var i=0;i<nodes_array.length;i++){  
	var checked = nodes_array[i].checked; //检查每一个节点的选中状态
	if(checked){
		moduleIds += nodes_array[i].id +',';  
		selLen++;  	   
	           }
	}
	// 加入树形结构
	if (selLen == 0) {
		$.messager.alert("操作提醒", "没有选择任何模块", 'info');
		return;
	}
	moduleIds=moduleIds.substring(0, moduleIds.length-1);
	//参数传递
	var param={
			'roleId':roleId,
			'checkType':2,
			'roleName':$.trim($("#roleName").val()),
			'roleDes':$.trim($("#roleDes").val()),
			'moduleIds':moduleIds
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
			}else if(data==3){
				$.messager.alert("提醒", '角色名称已存在,请选择别的名称', 'info');
			}else
			{
				$.messager.alert("提醒", '添加失败', 'info');
			}
		}
	});
}

//获得选中节点
function getSelectModule()
{
	var roleId=$("#roleId").val();
	//参数传递
	var param={
			'roleId':roleId
	};
	$.ajax({
		url : basePath + "menu/getSelectModule.action",
		type : "post",
		dataType : 'json',
		data : param,
		success : function(data) {
		var treeObj = $.fn.zTree.getZTreeObj("moduleTree"); 
		for(var i=0;i<data.roleModuleList.length;i++)
		{
		if(data.roleModuleList[i].moduleParentId==0)
		{
		}else{
		var node = treeObj.getNodeByParam("id",data.roleModuleList[i].menuId);
        treeObj.expandNode(node, true, true, true);  
        treeObj.checkNode(node, true, true);
        treeObj.updateNode(node);  
		}
		}
		}
	});
}
//初始化
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
	jQuery.ajax({
		url : url,
		type : 'post',
		dataType : 'json',
		success : function(data) {
			jQuery.fn.zTree.init(jQuery("#moduleTree"), setting, data);
			//加载完数据后，自动展开所有节点
			var treeObj = $.fn.zTree.getZTreeObj("moduleTree"); 
			treeObj.expandAll(true);
			getSelectModule();
		}
	});

}