<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'input_hotel.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
	 
	   div{
	     margin:10px;
	   }
	
	</style>
	
	<script type="text/javascript">
	   
	   function preview(picPath){
	     document.getElementById("hotelPreview").src=picPath;
	   }
	  
	</script>

  </head>
  
  <body>
     <h3>新分店信息录入</h3>
     <s:form namespace="/hotel" action="createHotel" method="post" enctype="multipart/form-data">
        <div>
          <label>分店名称:</label>
          <s:textfield name="hotel.hotelName"></s:textfield>
        </div>
        <div>
          <label>分店地址:</label>
          <s:textfield name="hotel.hotelAddr"></s:textfield>
        </div>
        <div>
          <label>分店电话:</label>
          <s:textfield name="hotel.hotelPhone"></s:textfield>
        </div>
        <img id="hotelPreview" style="margin-left:80px;" width="200" height="120" src="<c:url value="/pics/default.jpg"/>">
        <div>
          <label>分店图片:</label>
          <s:file name="hotelPic" size="40" onchange="preview(this.value);"></s:file>
        </div>
        <div>
          <s:submit value="登记"></s:submit>
        </div>                
     </s:form>
  </body>
</html>
