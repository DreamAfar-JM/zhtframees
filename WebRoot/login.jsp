<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>shirodemo login page</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src='<c:url value="/resources/jquery/juqery1.11/jquery.min.js"/>'></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery/md5-min.js"></script>
    <script type="text/javascript">
    function reloadValidateCode(){
        $("#validateCodeImg").hide().attr("src","${ctx}/jcaptcha/jcaptcha.jpg?" + Math.floor(Math.random()*100)).fadeIn();
    }
    function convertPassword(username,password){
    	//pwxwT1d6SMiYXYZ0ARGFhg+_94DABGioQOq2tTUO0AXYow
    	var salt=username+"@zhtframework_94DABGioQOq2tTUO0AXYow";
    //	var salt=username;
		//return hex_md5(password+"{"+salt+"}");
		return hex_md5(salt+password);
	}
    function dologin(){
    	var username = $("#username");
		var password = $("#password");
		if(username.val().length < 1){
			alert("请输入帐号");
			username.focus();
			return;
		}
		if(password.val().length < 2){
			password.focus();
			alert("密码至少2位");
			return;
		}
		$("#password").val(convertPassword(username.val().trim(),password.val().trim()));
		$("#loginForm").submit();
		$("#password").prop('disabled', true);
    }
    </script>
  </head>
  
  <body>
    <form id="loginForm" action="<%=basePath%>/rbac/user/login" method="post">
    <ul>
        <li>姓　名：<input type="text" id="username" name="userName" /> </li>
        <li>密　码：<input type="password"  id="password" name="password" /> </li>
        <li>验证码：<input type="text" id="jcaptchaCode"  name="jcaptchaCode" />&nbsp;&nbsp;
        <img border="0" width="95" height="30" id="validateCodeImg" src="${pageContext.request.contextPath}/jcaptcha/jcaptcha.jpg" />&nbsp;&nbsp;
        <a href="javascript:void(0);" onclick="javascript:reloadValidateCode();">看不清？</a></li>
        <li><input type="button" onclick="dologin()" value="确认" /> </li>
    </ul>
    </form>
  </body>
</html>