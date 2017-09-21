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
	  
	</script>

  </head>
  
  <body>
     <h3><s:property value="room.hotel.hotelName"/>-<s:property value="room.roomNo"/>房间信息修改</h3>
     <s:form namespace="/room" action="updateRoom" method="post">
        <s:hidden name="room.roomId"></s:hidden>
        <div>
          <label>房间房号:</label>
          <s:textfield name="room.roomNo"></s:textfield>
        </div>
        <div>
          <label>房间类型:</label>
          <!-- OGNL #表示构建一个hashmap -->
          <s:radio name="room.roomType" list="#{'a':'普单人间','b':'普双人间','c':'三人间','d':'商务套房','e':'贵宾套房'}"></s:radio>
        </div>
        <div>
          <label>所属分店:</label>
          <s:select name="room.hotel.hotelNo" list="hotelList" listKey="hotelNo" listValue="hotelName" headerKey="0" headerValue="=请选择="></s:select>
        </div> 
        <div>
          <label>房间设施:</label>
          <s:checkboxlist  name="room.roomEquipment" list="#{\"a\":'平面液晶电视',\"b\":'冰箱',\"c\":'空调',\"d\":'卫星电视',\"e\":'互联网接入',\"f\":'冲浪浴缸',\"g\":'观海景'}"></s:checkboxlist>
        </div> 
        <div>
          <label>房间状态:</label>
          <s:select name="room.roomStatus" list="#{\"a\":'未入住',\"b\":'有住客',\"c\":'已预订',\"d\":'保洁中',\"e\":'已退房未保洁',\"f\":'维修中'}"></s:select>
        </div>
        <div>
          <label>备注说明:</label>
          <s:textarea name="room.roomMemo" rows="6" cols="80"></s:textarea>
        </div>                         
        <div>
          <s:submit value="信息修改"></s:submit>
        </div>                
     </s:form>
  </body>
</html>
