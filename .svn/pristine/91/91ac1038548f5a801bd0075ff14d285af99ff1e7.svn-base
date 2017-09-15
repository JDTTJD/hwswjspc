<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setAttribute("ctx", basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理系统</title>
<link href="${pageContext.request.contextPath }/css/default.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/common.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/themes/icon.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/themes/default/easyui.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/common/jquery-1.8.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/common/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/locale/easyui-lang-zh_CN.js"></script>
<%-- <script type="text/javascript"
	src="${pageContext.request.contextPath }/js/logined/user/userList.js"></script> --%>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/common/extendValidate.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/common/waitDialog.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/common/jsloading.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/logined/upload/ajaxfileupload.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/logined/upload/ajaxupload.js"></script>
<script type="text/javascript">
	var basePath = "${ctx}";
</script>
<body>
	<div class="easyui-panel" data-options="fit:true,border:false">
    <table id="table_list" class="easyui-datagrid" iconcls="icon-save" rownumbers="true"
        singleselect="true" pagination="true" fitcolumns="true" toolbar="#tb" pageposition="bottom"
        style="width: 100%; height: 100%;">
        <thead>
            <tr>
                <th field="REGIONNM" align="center" width="5%">
                    监测站编码
                </th>
                <th field="STNM" align="center" width="5%">
                 监测站名称
                </th>
                <th field="KSSJ" width="5%" align="center">
                  监测站位置
                </th>
                <th field="JSSJ" width="5%" align="center">
                   东经
                </th>
                <th field="SSJD" width="5%" align="center">
                 北纬
                </th>
                <th field="WYTS" width="5%" align="center">
                 原井深
                </th>
                <th field="HQDJ3" width="5%" align="center">
                   绝对基面名称
                </th>
           <th field="HQDJ1" width="5%" align="center">
                   冷冻基面名称
                </th>
                  <th field="HQDJ4" width="5%" align="center">
        检测站类别
                </th>  
                              <th field="HQDJ5" width="5%" align="center">
        检测井类别
                </th>  
                 <th field="HQDJ6" width="10%" align="center">
        地下水按埋藏条件分类编码
                </th>    
               <th field="HQDJ7" width="10%" align="center">
        地下水按含水介质分类
                </th>  
                 <th field="HQDJ8" width="10%" align="center">
        设站日期
                </th>  
                <th field="HQDJ9" width="10%" align="center">
        产权单位
                </th> 
                <th field="HQDJ10" width="10%" align="center">
        管理单位
                </th>       
            </tr>
           
        </thead>
         <tr>
             <td>001001</td>
                 <td>0101</td>
                  <td>20170605</td>
                   <td>19</td>
                    <td>50</td>
                     <td>60</td>
                     <td>100</td>  
                      <td>30</td>
                     <td>20</td> 
                     <td>20</td> 
                     <td>20</td> 
                     <td>20</td> 
                     <td>20010101</td> 
                     <td>20</td> 
                     <td>20</td> 
            </tr>
             <tr>
            <td>001002</td>
                 <td>0102</td>
                  <td>20170605</td>
                   <td>19</td>
                    <td>50</td>
                     <td>60</td>
                     <td>100</td>  
                      <td>30</td>
                     <td>20</td> 
                     <td>20</td> 
                     <td>20</td> 
                     <td>20</td> 
                     <td>20010101</td> 
                     <td>20</td> 
                     <td>20</td> 
            </tr>
                 <tr>
            <td>001003</td>
                 <td>0103</td>
                  <td>20170605</td>
                   <td>19</td>
                    <td>50</td>
                     <td>60</td>
                     <td>100</td>  
                      <td>30</td>
                     <td>20</td> 
                     <td>20</td> 
                     <td>20</td> 
                     <td>20</td> 
                     <td>20010101</td> 
                     <td>20</td> 
                     <td>20</td> 
            </tr>
                  <tr>
            <td>001004</td>
                 <td>0104</td>
                  <td>20170605</td>
                   <td>19</td>
                    <td>50</td>
                     <td>60</td>
                     <td>100</td>  
                      <td>30</td>
                     <td>20</td> 
                     <td>20</td> 
                     <td>20</td> 
                     <td>20</td> 
                     <td>20010101</td> 
                     <td>20</td> 
                     <td>20</td> 
            </tr>
                  <tr>
            <td>001005</td>
                 <td>0105</td>
                  <td>20170605</td>
                   <td>19</td>
                    <td>50</td>
                     <td>60</td>
                     <td>100</td>  
                      <td>30</td>
                     <td>20</td> 
                     <td>20</td> 
                     <td>20</td> 
                     <td>20</td> 
                     <td>20010101</td> 
                     <td>20</td> 
                     <td>20</td> 
            </tr>
                  <tr>
            <td>001006</td>
                 <td>0106</td>
                  <td>20170605</td>
                   <td>19</td>
                    <td>50</td>
                     <td>60</td>
                     <td>100</td>  
                      <td>30</td>
                     <td>20</td> 
                     <td>20</td> 
                     <td>20</td> 
                     <td>20</td> 
                     <td>20010101</td> 
                     <td>20</td> 
                     <td>20</td> 
            </tr> 
    </table>
    <div id="tb">
        <div>
            <table>
                <tr>
                    <td>
                        监测站编码：
                    </td>
                   <td>
                        <input class="easyui-textbox" id="NameS" style="width: 150px; height: 25px;" />
                    </td>
                    <td>
                               检查站名称：
                    </td>
                    <td>
                        <input class="easyui-textbox" id="NameS" style="width: 150px; height: 25px;" />
                    </td>
                    <td>
                        <a href="#" class="easyui-linkbutton" iconcls="icon-search" onclick="list_Search();">
                            查 询 </a>
                    </td>
                </tr>
            </table>
        </div>
        	<div style="margin-top: 5px">
					<a href="#" class="easyui-linkbutton" iconcls="icon-add"
						plain="true" onclick="javascript:addUser();"> 新增</a>&nbsp;<a
						href="#" class="easyui-linkbutton" iconcls="icon-edit"
						plain="true" onclick="javascript:editUser();"> 编辑</a>&nbsp;<a
						href="#" class="easyui-linkbutton" iconcls="icon-remove"
						plain="true" onclick="javascript:deleteUser();"> 删除</a>&nbsp;<a
						href="#" class="easyui-linkbutton" iconcls="icon-out" plain="true"
						onclick="javascript:importUser();"> 导入</a>&nbsp;<a href="#"
						class="easyui-linkbutton" iconcls="icon-down" plain="true"
						onclick="javascript:outUser();"> 导出</a>
				</div>
    </div>
    
</div>

</html>