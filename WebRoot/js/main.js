jQuery(document).ready(function() {
	openPwd();
	$('#editpass').click(function() {
		$('#w').window('open');
	});

	$('#btnEp').click(function() {
		serverLogin();
	});

	$('#btnCancel').click(function() {
		closePwd();
	});
	$('#loginOut').click(function() {
		$.messager.confirm('系统提示', '您确定要退出本次登录吗?', function(r) {
			if (r) {
				location.href = basePath+"rediectLoginPage.action";
			}
		});
	});
	InitLeftMenu();
	tabClose();
	tabCloseEven();
	getIcon(menuid);
	$('#tabs').tabs('add', {
		title : 'test',
		content : createFrame('http://hxling.cnblogs.com')
	}).tabs({
		onSelect : function(title) {
			var currTab = $('#tabs').tabs('getTab', title);
			var iframe = $(currTab.panel('options').content);
			var src = iframe.attr('src');
			if (src)
				$('#tabs').tabs('update', {
					tab : currTab,
					options : {
						content : createFrame(src)
					}
				});

		}
	});

});

//初始化左侧
function InitLeftMenu() {
	$("#nav").accordion({
		animate : true
	});
	$.ajax({
		url : basePath + "menu/findCheckedModuleList.action",
		type : "post",
		dataType : 'json',
		success : function(data) {
			$.each(data.menus, function(i, n) {
				var menulist = '';
				menulist += '<ul>';
				$.each(n.menus, function(j, o) {
					var url = basePath + o.url;
					menulist += '<li><div><a ref="' + o.menuId
							+ '" href="#" rel="' + basePath + o.url
							+ '" ><span class="icon ' + o.icon
							+ '" >&nbsp;</span><span class="nav">' + o.menuname
							+ '</span></a></div></li> ';
				})
				menulist += '</ul>';
				$('#nav').accordion('add', {
					title : n.menuname,
					content : menulist,
					iconCls : 'icon ' + n.icon
				});
				//选中第一个
				var panels = $('#nav').accordion('panels');
				var t = panels[0].panel('options').title;
				$('#nav').accordion('select', t);
				$('.easyui-accordion li a').click(function() {
				
					var tabTitle = $(this).children('.nav').text();
					var url = $(this).attr("rel");	
					var menuid = $(this).attr("ref");
					var icon = getIcon(menuid,icon);
				//	var icon='icon ';
					addTab(tabTitle, url, icon);
				//	MaskUtil.mask("请稍等,正在为你加载......."); 
					$('.easyui-accordion li div').removeClass("selected");
					$(this).parent().addClass("selected");
				}).hover(function() {
					$(this).parent().addClass("hover");
				}, function() {
					$(this).parent().removeClass("hover");
				});
			});
		
		}
	});
}

function addTab(subtitle, url, icon) {
	if (!$('#tabs').tabs('exists', subtitle)) {
		$('#tabs').tabs('add', {
			title : subtitle,
			content : createFrame(url),
			closable : true,
			icon : icon
		});
	} else {
		$('#tabs').tabs('select', subtitle);
		$('#mm-tabupdate').click();
	}
	tabClose();
}

function createFrame(url) {
	var s = '<iframe scrolling="auto" frameborder="0"  src="' + url
			+ '" style="width:100%;height:100%;"></iframe>';
	return s;
}
/*function tabclose() {
	$(".tabs-inner").dbclick(function () {
	var subtitle=$(this).children(".tab-closable").text();
	})
}*/
function tabClose() {
	/*双击关闭TAB选项卡*/
	$(".tabs-inner").dblclick(function() {
		var subtitle = $(this).children(".tabs-closable").text();
		$('#tabs').tabs('close', subtitle);
	})
	/*为选项卡绑定右键*/
	$(".tabs-inner").bind('contextmenu', function(e) {
		$('#mm').menu('show', {
			left : e.pageX,
			top : e.pageY
		});

		var subtitle = $(this).children(".tabs-closable").text();

		$('#mm').data("currtab", subtitle);
		$('#tabs').tabs('select', subtitle);
		return false;
	});
}
//绑定右键菜单事件
function tabCloseEven() {
	//刷新
	$('#mm-tabupdate').click(function() {
		var currTab = $('#tabs').tabs('getSelected');
		var url = $(currTab.panel('options').content).attr('src');
		$('#tabs').tabs('update', {
			tab : currTab,
			options : {
				content : createFrame(url)
			}
		})
	})
	//关闭当前
	$('#mm-tabclose').click(function() {
		var currtab_title = $('#mm').data("currtab");
		$('#tabs').tabs('close', currtab_title);
	})
	//全部关闭
	$('#mm-tabcloseall').click(function() {
		$('.tabs-inner span').each(function(i, n) {
			var t = $(n).text();
			$('#tabs').tabs('close', t);
		});
	});
	//关闭除当前之外的TAB
	$('#mm-tabcloseother').click(function() {
		$('#mm-tabcloseright').click();
		$('#mm-tabcloseleft').click();
	});
	//关闭当前右侧的TAB
	$('#mm-tabcloseright').click(function() {
		var nextall = $('.tabs-selected').nextAll();
		if (nextall.length == 0) {
			//msgShow('系统提示','后边没有啦~~','error');
			alert('后边没有啦~~');
			return false;
		}
		nextall.each(function(i, n) {
			var t = $('a:eq(0) span', $(n)).text();
			$('#tabs').tabs('close', t);
		});
		return false;
	});
	//关闭当前左侧的TAB
	$('#mm-tabcloseleft').click(function() {
		var prevall = $('.tabs-selected').prevAll();
		if (prevall.length == 0) {
			alert('到头了，前边没有啦~~');
			return false;
		}
		prevall.each(function(i, n) {
			var t = $('a:eq(0) span', $(n)).text();
			$('#tabs').tabs('close', t);
		});
		return false;
	});

	//退出
	$("#mm-exit").click(function() {
		$('#mm').menu('hide');
	})
}

//弹出信息窗口 title:标题 msgString:提示信息 msgType:信息类型 [error,info,question,warning]
function msgShow(title, msgString, msgType) {
	$.messager.alert(title, msgString, msgType);
}

//设置登录窗口
function openPwd() {
	$('#w').window({
		title : '修改密码',
		width : 300,
		modal : true,
		shadow : true,
		closed : true,
		height : 200,
		resizable : false
	});
}
//关闭登录窗口
function closePwd() {
	$('#w').window('close');
}

//修改密码
function serverLogin() {
	var $newpass = $('#txtNewPass');
	var $rePass = $('#txtRePass');
	if ($newpass.val() == '') {
		msgShow('系统提示', '请输入密码！', 'warning');
		return false;
	}
	if ($rePass.val() == '') {
		msgShow('系统提示', '请再一次输入密码！', 'warning');
		return false;
	}
	if ($newpass.val() != $rePass.val()) {
		msgShow('系统提示', '两次密码不一致！请重新输入', 'warning');
		return false;
	}

	$.post('/ajax/editpassword.ashx?newpass=' + $newpass.val(), function(msg) {
		msgShow('系统提示', '恭喜，密码修改成功！<br>您的新密码为：' + msg, 'info');
		$newpass.val('');
		$rePass.val('');
		close();
	})

}

//获取左侧导航的图标
function getIcon(menuid,icon) {
	var icon = 'icon ';
	$.ajax({
		url : basePath + "menu/findMenuList.action",
		type : "post",
		dataType : 'json',
		async : false,
		success : function(data) {
			$.each(data.menus, function(i, n) {
				if(n.menus==undefined)
					{
					icon = 'icon ';
					}else{
				$.each(n.menus, function(j, o) {
					if (o.menuId == menuid) {
						icon += o.icon;
					}
				})}
			})
		}
	});
	return icon;
}
var callback = function() {
	alert(icon);
}
//---------------------------------------------------------------

















