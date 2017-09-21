<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/application.css"></c:url>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/form.css"></c:url>">
    
    <style>
      .error{
        border:1px solid yellow;
        color:red;
        width:250px;
        padding:8px;
        margin:5px;
      }  
      
      .errorMessage{
        color:red;
        list-style-type:none;
        margin:5px;
        border:1px solid orange;
        padding:5px;
        width:200px;
       
      }
    </style>
    

    
  </head>
  
  <body>
    <div id="wrapper">
	    <div id="f_title">用户登录</div>
	    <s:form namespace="/security" action="login" method="post">
	        <div class="f_row">
	          <span>用户编号:</span>
	          <s:textfield name="user.userNo"></s:textfield>
	        </div>	    
	        <div class="f_row">
	          <span>登录密码:</span>
	          <s:password name="user.userPwd"></s:password>        
	        </div>
	        <s:actionerror/>
	        <div class="f_row">
	          <s:submit value=" 登 录 "></s:submit>  
	        </div>  	        	    
	    </s:form>
    </div>
    <%@ include file="/jsps/footer.jsp"%>
  </body>
</html>
