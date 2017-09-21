<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>分店信息列表</title>
    
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
	   
	   td,th{
	     text-align:center;
	   }
	
	</style>
	
	<script type="text/javascript">
	  
	    function removeHotel(hotelNo,hotelName){
	      
	      if(confirm("您真的要删除分店 ["+hotelName+"] 的信息吗?")){
	         location.href="<s:url namespace="/hotel" action="removeHotel"/>?hotel.hotelNo="+hotelNo;
	      }
	      
	    }
	    
	    function updateHotel(hotelNo){
	       location.href="<s:url namespace="/hotel" action="preUpdate"/>?hotel.hotelNo="+hotelNo;
	    }
	
	</script>

  </head>
  
  <body>
     <h3>分店信息列表</h3>
     <table border="1" cellspacing="0" cellpadding="8" style="width:100%">
       <tr>
         <th>编号</th>
         <th>名称</th>
         <th>地址</th>
         <th>电话</th>
         <th>房间数量</th>
         <th>操作</th>
       </tr>
       <s:iterator value="hotelList">
       <tr>
         <td><s:property value="hotelNo"/></td>
         <td>
           <img width="160" height="90"src="<s:url namespace="/hotel" action="loadHotelPic"/>?hotel.hotelNo=<s:property value="hotelNo"/>">
           <span><s:property value="hotelName"/></span>
         </td>
         <td><s:property value="hotelAddr"/></td>
         <td><s:property value="hotelPhone"/></td>
         <td><s:property value="hotelRoomCnt"/></td>
         <td>
           <button onclick="removeHotel(<s:property value="hotelNo"/>,'<s:property value="hotelName"/>');">删除</button>
           <button onclick="updateHotel(<s:property value="hotelNo"/>);">修改</button>
         </td>
       </tr>
       </s:iterator>
     </table>
     
  </body>
</html>
