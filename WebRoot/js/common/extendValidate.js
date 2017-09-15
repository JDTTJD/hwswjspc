    /* easyUI自带的校验 */
    /* 
	    email: Match email regex rule.
	    url: Match URL regex rule.
	    length[0,100]: Between x and x characters allowed.
	    remote['http://.../action.do','paramName']: Send ajax request to do validate value, return 'true' when successfully. 
    */
    
    $.extend($.fn.validatebox.defaults.rules, {
    	phone : {//手机号码校验
           validator: function(value, param){
               return checkPhone(value);
           },
           message: '请输入正确的手机号码。'
       },
       myEmail : {//邮箱校验，避免使用email和默认的冲突
           validator: function(value, param){
               return checkEmail(value);
           },
           message: '请输入正确的邮箱'
       },
       loginName : {//登录名，数字、英文字母或者下划线
           validator: function(value, param){
               return checkLoginName(value);
           },
           message: '只能输入数字、英文字母或者下划线'
       },
       telePhone : {//座机，区号及分机号可有可无
           validator: function(value, param){
               return checkTelePhone(value);
           },
           message: '请输入正确的座机号码'
       },
       mobile : {//移动电话号码
           validator: function(value, param){
               return isMobile(value);
           },
           message: '请输入正确的电话号码'
       },
       chinese : {//
           validator: function(value, param){
               return checkChinese(value);
           },
           message: '只能输入中文汉字'
       },
       number : {//正整数，包括0（00，01非数字）
           validator: function(value, param){
               return isNumber(value);
           },
           message: '只能输入数字（01非数字）'
       },
       numberText : {//数字组成的字符串，如000222，22220000，00000
           validator: function(value, param){
               return isNumberText(value);
           },
           message: '只能输入数字字符串'
       },
       idCardNo : {//身份证
           validator: function(value, param){
               return isIdCardNo(value);
           },
           message: '请输入正确的身份证号码'
       },
       money : {//金额
           validator: function(value, param){
               return isFloat(value);
           },
           message: '请输入正确的数字'
       },
       floatNumber : {//数字（包括正整数、0、浮点数）
           validator: function(value, param){
               return isFloat(value);
           },
           message: '请输入正确的数字'
       },
       minLength: {
           validator: function(value, param){
               return value.length >= param[0];
           },
           message: '请输入至少 {0}个字符。'
       },
       maxLength: {
           validator: function(value, param){
               return value.length <= param[0];
           },
           message: '不能输入超过{0}个字符。'
       }
   });
    
    
    /**
    * 去掉字符串头尾空格
    * @param str 传入的字符串值
    * @author lqy
    * @since 2015-08-21
    */
    function trim(str) {
    	if(str == null){
    		return "";
    	}
        return str.replace(/(^\s*)|(\s*$)/g, "");
    };

    /** 
     * 是否为Null 
     * @param object 
     * @returns {Boolean} 
     */  
    function isNull(object){  
        if(object == null || typeof object == "undefined"){  
            return true;  
        }  
        return false;  
    }; 

    /** 
     * 是否为空字符串，有空格不是空字符串 
     * @param str 
     * @returns {Boolean} 
     */  
    function isEmpty(str){  
        if(str == null || typeof str == "undefined" ||   
                str == ""){  
            return true;  
        }  
        return false;  
    };

    /** 
     * 是否为空字符串，全空格也是空字符串 
     * @param str 
     * @returns {Boolean} 
     */  
    function isBlank(str){  
        if(str == null || typeof str == "undefined" ||   
                str == "" || trim(str) == ""){  
            return true;  
        }  
        return false;  
    };
    /**
     * 检查手机号码
     * @param z_check_value 要检查的值
     * @return 符合返回true，否false
     * @since 2015-08-21
    */
    function checkPhone(z_check_value) {
    	if(isEmpty(z_check_value) || z_check_value.length != 11){
    		return false;
    	}
    	var z_reg = /^13[0-9]{9}|15[012356789][0-9]{8}|18[0-9]{9}|(14[57][0-9]{8})|(17[015678][0-9]{8})$/;
    	return z_reg.test(z_check_value);
    };
    /**
     * 检查电子邮箱
     * @param z_check_value 要检查的值
     * @return 符合返回true，否false
     * @since 2015-08-21
    */
    function checkEmail(z_check_value){
    	//var emailReg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
    	var z_reg =  /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
    	return z_reg.test($.trim(z_check_value));
    };
    /**
     * 检查登录名（由数字、26个英文字母或者下划线组成的字符串）
     * @param z_check_value 要检查的值
     * @return 符合返回true，否false
     * @since 2015-12-29
    */
    function checkLoginName(z_check_value){
    	var z_reg = /^\w+$/;
    	return z_reg.test($.trim(z_check_value));
    };
    /**
     * 检查电话号码
     * @param z_check_value 要检查的值
     * @return 符合返回true，否false
     * @since 2015-08-21
    */
    function checkTelePhone(z_check_value){
    	var z_reg = /^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,4}))?$/;
    	return z_reg.test($.trim(z_check_value));
    };
    /**
     * 检查仅中文
     * @param z_check_value 要检查的值
     * @return 符合返回true，否false
     * @since 2015-08-21
    */
    function checkChinese(z_check_value){
    	var z_reg = /^[\u4E00-\u9FA5\uF900-\uFA2D]+$/;
    	return z_reg.test($.trim(z_check_value));
    };
    /**
     * 是否为数字
     * @param z_check_value 要检查的值
     * @return 符合返回true，否false
     * @since 2016-10-31
    */
    function isNumber(z_check_value){
    	var z_reg = /^(([0-9])|([1-9]([0-9]+)))$/;
    	return z_reg.test($.trim(z_check_value));
    };
    /**
     * 是否为数字组成的字符串，01也符合规则
     * @param z_check_value 要检查的值
     * @return 符合返回true，否false
     * @since 2017-01-07
    */
    function isNumberText(z_check_value){
    	var z_reg = /^([0-9]+)$/;
    	return z_reg.test($.trim(z_check_value));
    };
    /**
     * 可以判断是否为数字、金额、浮点数
     * @param z_check_value 要检查的值
     * @return 符合返回true，否false
     * @author lqy
     * @since 2017-01-07
    */
    function isFloat(z_check_value){
    	var z_reg = /^((([0-9])|([1-9][0-9]+))(\.([0-9]+))?)$/;//.是特殊字符，需要转义
    	return z_reg.test($.trim(z_check_value));
    };
    /**
     * 可以判断是否是正确的电话号码
     * @param z_check_value
     * @returns
     */
    function isMobile(z_check_value)
    {
    	var z_reg =/^(13|15|17|18)\d{9}$/;
    	return z_reg.test($.trim(z_check_value));
    }
