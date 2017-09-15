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
                <th field="REGIONNM" align="center" width="15%">
                    监测站编码
                </th>
                <th field="STNM" align="center" width="10%">
                  年份
                </th>
                      <th field="STNM1" align="center" width="10%">
                  月份
                </th>
                   <th field="STNM2" width="10%" align="center">
                  月平均水位
                </th>
                
             
                <th field="JSSJ" width="25%" align="center">
                   月平均水位注解符号
                </th>
         <th field="JSSJ1" width="20%" align="center">
                   月最高水位注解符号
                </th>
                    
                  <th field="JSSJ3" width="10%" align="center">
                   月最高水位
                </th>
            </tr>
           
        </thead>
         <tr>
             <td>63000001</td>
             <td>2016</td>
             <td>09</td>
               <td>19</td>
           
           
             <td></td>
             <td></td>
           
             <td>31</td>
            </tr>
               <tr>
             <td>63000002</td>
             <td>2016</td>
             <td>09</td>
               <td>20</td>
          
           
             <td></td>
             <td></td>
          
             <td>30</td>
            </tr>      <tr>
             <td>63000003</td>
             <td>2016</td>
             <td>09</td>
             <td>18</td>
            
             <td></td>
             <td></td>
           
             <td>32</td>
            </tr>      <tr>
             <td>63000004</td>
             <td>2016</td>
             <td>09</td>
             <td>20</td>
           
             
             <td></td>
             <td></td>
          
             <td>29</td>
            </tr>      
            <tr>
             <td>63000005</td>
             <td>2016</td>
             <td>09</td>
              <td>19</td>
            
            
             <td></td>
             <td></td>
            
             <td>28</td>
            </tr>      
            <tr>
             <td>63000006</td>
             <td>2016</td>
             <td>09</td>
             <td>21</td>
             <td></td>
             <td></td>   
             <td>30</td>
            </tr>
             <tr>
             <td>63000007</td>
             <td>2016</td>
             <td>09</td>
             <td>21</td>
             <td></td>
             <td></td>   
             <td>31</td>
            </tr>
             <tr>
             <td>63000008</td>
             <td>2016</td>
             <td>09</td>
             <td>19</td>
             <td></td>
             <td></td>   
             <td>29</td>
            </tr>
             <tr>
             <td>63000009</td>
             <td>2016</td>
             <td>09</td>
             <td>20</td>
             <td></td>
             <td></td>   
             <td>30</td>
            </tr>
             <tr>
             <td>63000010</td>
             <td>2016</td>
             <td>09</td>
             <td>21</td>
             <td></td>
             <td></td>   
             <td>31</td>
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
                           观测时间：
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