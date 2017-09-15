$(function () {
	findRoleList();
            //用于汉化页码信息
            $('#role').datagrid('getPager').pagination({
                pageSize: 15,
                beforePageText: "转到",
                afterPageText: "共{pages}页",
                displayMsg: '当前显示从{from}到{to}共{total}记录',
                onBeforeRefresh: function (pageNumber, pageSize) {
                    $(this).pagination('loading');
                    $(this).pagination('loaded');
                }
            });
        });
        //获取选中行
        function getSelected() {
            var selected = $('#role').datagrid('getSelected');
            if (selected) {
                return selected.id;
            }
        }
        //获取多个选中行
        function getSelections() {
            var ids = [];
            var rows = $('#role').datagrid('getSelections');
            for (var i = 0; i < rows.length; i++) {
                ids.push(rows[i].id);
            }
            return ids.join(',');
        }
        /**
         * 得到用户列表
         */
        function findRoleList()
        {
        	   $('#role').datagrid({
                   title: '角色管理',
                   iconCls: 'icon-save',
                   /*width: 1150,
                   height: 540,*/
                   fit:true,
                   pageSize:15,
                   pageList:[15,20,50,100],
                   nowrap: true,
                   autoRowHeight: true,
                   striped: true,
                   collapsible: true,
                   url: basePath+'role/findRoleList.action',
                   sortName: 'id',
                   sortOrder: 'desc',
                   remoteSort: false,
                   fitColumns:true,
                   idField: "id",
                   frozenColumns: [[
                       { field: 'ck', checkbox: true },
                   ]],
                   columns: [[
                       { field: 'id', title: '用户编号', width: 100 },
                       { field: 'roleName', title: '角色名称', width: 150 },
                       { field: 'roleDes', title: '角色描述', width: 150 },
                   ]],
                   pagination: true,
                   rownumbers: true,
                   onLoadSuccess:function(data){    
                	           $("#role").datagrid("hideColumn", "id"); // 设置隐藏列    
                   },  
                   toolbar: [
                   {
                       id: 'btnadd',
                       text: '新增',
                       iconCls: 'icon-add',
                       handler: function () {
                           $('#btnsave').linkbutton('enable');
                           window.location.href=basePath+'/role/redirectRoleAdd.action';
                       }
                   },
                   {
                       id: 'btnedit',
                       text: '编辑',
                       iconCls: 'icon-edit',
                       handler: function () {
                           $('#btnsave').linkbutton('enable');
                           var id = getSelected();
                           if (id == "" || !id) {
                        	   $.messager.alert('提醒','请选择一项','warning');
                               return;
                           }
                           var row = $("#role").datagrid("getSelected");
                           window.location.href=basePath+'/role/redirectRoleUpdate.action?roleId='+row.id;  
                       }
                   }, {
                       id: 'btndelete',
                       text: '删除',
                       iconCls: 'icon-cancel',
                       handler: function () {
                    	   $("#role").datagrid("acceptChanges");
                           $('#btnsave').linkbutton('enable');
                           var ids="";
                           var rows = $('#role').datagrid('getSelections');
                           for (var i = 0; i < rows.length; i++) {
                               ids+=rows[i].id+",";
                           }
                           ids=ids.substring(0, ids.length-1);
                           if (ids == "") {
                        		$.messager.alert('提醒','请至少选择一项','warning');
                               return;   
                           }else
                           {
                        	   $.messager.confirm("确认", "确认要删除吗?", function (r) {  
                        		           if (r) {  
                        		        	   var param={"ids":ids};
                                            	$.ajax({
                                         		url : basePath + "role/deleteRoles.action",
                                         		type : "post",
                                         		dataType : 'json',
                                         		data : param,
                                         		success : function(data) {
                                         		    if(data.deleteRoleSuccess==2){
                                         			$.messager.alert('提醒', '删除成功', 'info');
                                         			 $("#role").datagrid("reload");
                                         			 $('#role').datagrid('clearSelections');
                                         			 findRoleList();             			 
                                         			}
                                         			if(data.deleteUserSuccess==1)
                                         			{
                                         			$.messager.alert('提醒', '删除失败', 'info');
                                         			$("#role").datagrid("reload");
                                         			}
                                         		}});
                        		              return true;      
                        		           }  
                        		    });    
                            }
                          
                       }
                   }
                   ]
               });
        }
        
        
        function addTab(title,url){  
        	             var icon="icon ";
        	             var jq = top.jQuery;    
        	             if (jq("#tabs").tabs('exists', title)){    
        	                jq("#tabs").tabs('select', title);    
        	             } else {  
                          var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';     
        	                   jq("#tabs").tabs('add',{    
        	                                       title:title,    
        	                                       content:content,    
        	                                       closable:true,
        	                                       icon:icon
        	                                     });    
        	             }    
        	       }   
