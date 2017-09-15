$(function() {
	$("#groupSel").click(function() {
		showGroup();
		return false;
	});
	initMenuTree();
	findMenuList();
	//用于汉化页码信息
	$('#menu').datagrid('getPager').pagination({
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
//获取选中行
function getSelected() {
	var selected = $('#menu').datagrid('getSelected');
	if (selected) {
		return selected.id;
	}
}
//获取多个选中行
function getSelections() {
	var ids = [];
	var rows = $('#menu').datagrid('getSelections');
	for (var i = 0; i < rows.length; i++) {
		ids.push(rows[i].id);
	}
	return ids.join(',');
}
/**
 * 得到菜单列表
 */
function findMenuList() {
	$('#menu').datagrid({
		title : '菜单管理',
		iconCls : 'icon-save',
		/*width : '100%',
		height : '100%',*/
		fit : true,
		pageSize : 15,
		pageList : [ 15, 20, 50, 100 ],
		nowrap : true,
		autoRowHeight : true,
		striped : true,
		collapsible : true,
		url : basePath + 'menu/findMenuPageList.action',
		sortName : 'id',
		sortOrder : 'desc',
		remoteSort : false,
		fitColumns : true,
		idField : "id",
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		}, ] ],
		columns : [ [ {
			field : 'id',
			title : '用户编号',
			width : 100
		}, {
			field : 'pid',
			title : '父节点id',
			width : 100
		}, {
			field : 'parentName',
			title : '父节点名称',
			width : 100
		}, {
			field : 'menuName',
			title : '菜单名称',
			width : 150
		}, {
			field : 'icon',
			title : '菜单图标',
			width : 150
		}, {
			field : 'url',
			title : '菜单url',
			width : 150
		}, ] ],
		pagination : true,
		rownumbers : true,
		onLoadSuccess : function(data) {
			$("#menu").datagrid("hideColumn", "id"); // 设置隐藏列
			$("#menu").datagrid("hideColumn", "pid"); // 设置隐藏列    
			$("#menu").datagrid("hideColumn", "parentName"); // 设置隐藏列    
		},
		toolbar : [ {
			id : 'btnadd',
			text : '新增',
			iconCls : 'icon-add',
			handler : function() {
				$('#btnsave').linkbutton('enable');
				$("#dlg").dialog("open").dialog('setTitle', '新增菜单');
				$("#groupSel").val("");
				$("#menuName").val("");
				$("#id").val("");
				$("#pid").val("");
				$("#icon").val("");
				$("#url").val("");
				$('#checkType').val(1);
			}
		}, {
			id : 'btnedit',
			text : '编辑',
			iconCls : 'icon-edit',
			handler : function() {
				$('#btnsave').linkbutton('enable');
				var id = getSelected();
				if (id == "" || !id) {
					$.messager.alert('提醒', '请选择一项', 'warning');
					return;
				}
				$('#checkType').val(2);
				var row = $("#menu").datagrid("getSelected");
				if (row) {
					$("#dlg").dialog("open").dialog('setTitle', '编辑菜单');
					$("#fm").form("load", row);
				}
			}
		}, {
			id : 'btndelete',
			text : '删除',
			iconCls : 'icon-cancel',
			handler : function() {
				$("#menu").datagrid("acceptChanges");
				$('#btnsave').linkbutton('enable');
				var ids = "";
				var rows = $('#menu').datagrid('getSelections');
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
								url : basePath + "menu/deleteMenus.action",
								type : "post",
								dataType : 'json',
								data : param,
								success : function(data) {
									if (data.deleteMenuSuccess == 2) {
										$.messager.alert('提醒', '删除成功', 'info');
										$("#menu").datagrid("reload");
										$('#menu').datagrid('clearSelections');
										findMenuList();
									}
									if (data.deleteMenuSuccess == 1) {
										$.messager.alert('提醒', '删除失败', 'info');
										$("#menu").datagrid("reload");
									}
								}
							});
							return true;
						}
					});
				}

			}
		} ]
	});
}

/**
 * 打开新的标签页
 * @param title
 * @param url
 */
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

/**
 * 初始化树形结构
 */
function initMenuTree() {
	$("#menuContent").hide();
	// 参数设置
	var setting = {
		view : {
			dblClickExpand : false

		},
		data : {
			simpleData : {
				enable : true
			}
		},
		callback : {
			onClick : onTreeNodeClick
		}
	};
	var url = basePath + "menu/ztree.action";
	jQuery.ajax({
		url : url,
		type : 'post',
		dataType : 'json',
		success : function(data) {
			jQuery.fn.zTree.init(jQuery("#menuTree"), setting, data);
			//加载完数据后，自动展开所有节点
			var treeObj = $.fn.zTree.getZTreeObj("menuTree");
			treeObj.expandAll(true);
		}
	});

}
/**
 * 得到属性节点的值，进而进行其他权限
 * 
 * @param e
 * @param treeId
 * @param treeNode
 */
function onTreeNodeClick(e, treeId, treeNode) {
	var zTree = jQuery.fn.zTree.getZTreeObj("menuTree");
	var nodes = zTree.getSelectedNodes();
	if (nodes.length > 0) {
		var name = nodes[nodes.length - 1].name;// 得到点击树节点的名字
		var id = nodes[nodes.length - 1].id;// 得到点击树节点的id
		var pId = nodes[nodes.length - 1].pId;// 得到点击数节点的pid
		var moduleUrl = nodes[nodes.length - 1].moduleUrl;// 得到点击数节点的pid
		$("#groupSel").val(name);
		$("#pid").val(id);
		$("#menuContent").hide();
	}

}

/**
 * 群组树调用群组树
 */
var showOrHide = true;
function showGroup() {
	$('#menuContent').toggle(showOrHide);
	//相当于
	if (showOrHide) {
		showOrHide = false;
		var groupObj = $("#groupSel");
		var groupOffset = $("#groupSel").position();
		$("#menuContent").css({
			left : groupOffset.left + "px",
			top : groupOffset.top + groupObj.outerHeight() - 1 + "px"
		}).show();
		$("#treeContent").one("mouseleave", function() {
			$("#menuContent").hide();
			showOrHide = true;
			return false;
		});
	} else {
		$("#menuContent").hide();
		showOrHide = true;
	}
}


/**
 * 提交保存和修改信息
 * @returns {Boolean}
 */
function submitForm() {
	var isValid = $('#fm').form('validate');
	if (!isValid) {
		return false;
	}
    var parentName=$.trim($("#groupSel").val());
	if(parentName=="")
	{
		$.messager.alert("提示信息", "上级模块不能为空");
		return false;
	}
	var param = {
			'checkType' : $.trim($("#checkType").val()),
			'id' : $.trim($("#id").val()),
			'pid' : $.trim($("#pid").val()),
			'parentName' :$.trim($("#groupSel").val()),
			'menuName' :$.trim($("#menuName").val()),
			'icon' :$.trim($("#icon").val()),
			'url' :$.trim($("#url").val())
		};
		$.ajax({
			url : basePath + "menu/menuAdd.action",
			type : "post",
			dataType : 'json',
			data : param,
			success : function(data) {
				if (data == 2) {
					$.messager.alert("提示信息", "操作成功");
					$("#dlg").dialog("close");
					$("#menu").datagrid("reload");
					$("#menu").datagrid("clearSelections");
				} else {
					$.messager.alert("提示信息", "操作失败");
					$("#dlg").dialog("close");
					$("#menu").datagrid("reload");
				}
			}
		});
	
}