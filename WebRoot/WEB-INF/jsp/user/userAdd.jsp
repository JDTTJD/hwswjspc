<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path+"/" ;
    request.setAttribute("ctx", basePath);
%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link href="${pageContext.request.contextPath }/css/default.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/themes/icon.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/list.js"></script>
    <script type="text/javascript">
    var basePath = "${ctx}";        
    </script>  
<title>用户信息添加</title>
</head>
<body>
<div style="margin:20px 0;"></div>
<div class="easyui-panel" title="用户信息添加" style="width:600px">
		<div style="padding:20px 100px 20px 60px">
        <form id="ff" action="${pageContext.request.contextPath }/user/userAdd.action" method="post">
	    	<table cellpadding="5">
    		<tr>
	    			<td>userName:</td>
    			<td><input class="easyui-textbox" type="text" id="name" value="1" name="userName" data-options="required:true" style="width:100%;height:32px"></input></td>
    		</tr>
    		<tr>
	    		<td>Email:</td>
    			<td><input class="easyui-textbox" type="text" value="492449061@qq.com" id="email" name="email" data-options="required:true,validType:'email'" style="width:100%;height:32px"></input></td>
	    		</tr>
   		<tr>
   			<td>birthday:</td>
	    			<td><input class="easyui-textbox" type="text" value="1" id="brithday" name="brithday" data-options="required:true" style="width:100%;height:32px"></input></td>
    		</tr>	
    		<tr>
   			<td>sex:</td>
	    			<td>男:<input  type="radio" value="1" id="sex" name="sex" checked style="height:20px">女:<input  type="radio" value="2" id="sex" name="sex" style="height:20px"></td>
    		</tr>
    		<tr>
    			<td>address:</td>
	    			<td>
    				<select class="easyui-combobox" style="height: 20px;width: 80px;" name="address">
    				<option value="cs">Czech</option>
    				<option value="da">Danish</option>
    				<option value="nl">Dutch</option>
    				<option value="en" selected="selected">English</option>
    				</select>
	    			</td>
    		</tr>
    		<!-- <tr>
	    		<td>Message:</td>
    			<td><input class="easyui-textbox" name="message" data-options="multiline:true" style="height:60px"></input></td>
	    		</tr>
	        -->
	    	</table>
    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" style="height: 40px;width:50px;"  onclick="submitForm()">提交</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" style="height: 40px;width:50px;"  onclick="backUserList()">返回</a>
    </div>
	    </div>
</div>
	<script>
		function submitForm(){
        $('#ff').form('submit', {
        success: function(data){
		var data = eval('(' + data + ')'); 
	    if(data==2)
	    {
	    $.messager.alert('提醒', '添加成功', 'info');
	    }else
	    {
	     $.messager.alert('提醒', '添加失败', 'info');
	    }
    }
});
		}
		function clearForm(){
			$('#ff').form('clear');
		}
        function backUserList()
        {
        window.location.href=basePath+'user/redirectUserList.action';
        }
         
$('#brithday').datebox({
    required:true
});  

        
</script>
</body>
</html>