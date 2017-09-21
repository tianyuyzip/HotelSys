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
	   
	   td,th{
	     text-align:center;
	   }
	   
	   .highLight{
	     background-color:#999;
	     color:white;
	   }
	   
		#pageInfo{
		  text-align:right;
		  padding-right:10px;
		  font-family:verdana;
		  margin-top:3px;
		}
		
		.linkspan{
		   color:blue;
		   text-decoration:underline;
		   cursor:pointer; 
		}
	
	</style>
	
	<script type="text/javascript">
	
	   function $(id){
	     return document.getElementById(id);
	   }
	
	   function updateRoom(roomId){
	     location.href = "<s:url namespace="/room" action="preUpdate"/>?room.roomId="+roomId;
	   }
	   
	   function removeRoom(roomId,roomNo,hotelName){
	   
	     if(confirm("您确认要删除 "+hotelName+"-"+roomNo+" 房间吗?")){
	        location.href = "<s:url namespace="/room" action="removeRoom"/>?room.roomId="+roomId;
	     }
	   
	   }
	   
       function doQuery(pageno)
       {
           if(pageno<1 || pageno><s:property value="page.totalPageNum"/>)
           {
              alert("页号超出范围，有效范围：[1-<s:property value="page.totalPageNum"/>]!");
              $('pageNo').select();
              return;
           }
           
            var f=document.forms[0];
            f.action=f.action+"?page.pageNo="+pageno;
            f.submit();
       }	   
	  
	</script>

  </head>
  
  <body>
     <h3>房间信息列表</h3>
     <s:form namespace="/room" action="loadRooms" style="text-align:center">
                 房号:<s:textfield name="helper.qryRoomNo" size="6"></s:textfield>&nbsp;&nbsp;
                所属分店：<s:select name="helper.qryHotelNo" list="hotelList" listKey="hotelNo" listValue="hotelName" headerKey="" headerValue="=请选择="></s:select>&nbsp;&nbsp;
                房间类型:<s:select name="helper.qryRoomType" list="#{'a':'普单人间','b':'普双人间','c':'三人间','d':'商务套房','e':'贵宾套房'}" headerKey="" headerValue="=请选择="></s:select>&nbsp;&nbsp;
                房间状态:<s:select name="helper.qryRoomStatus" list="#{'a':'未入住','b':'有住客','c':'已预订','d':'保洁中','e':'已退房未保洁','f':'维修中'}"  headerKey="" headerValue="=请选择="></s:select>
       &nbsp;&nbsp;
       <s:submit value="查  询"></s:submit>
     </s:form>
     <s:if test="page.pageContent.size()>0">
     <table style="width:100%;" border="1" cellspacing="0" cellpadding="3">
        <tr>
          <th>序号</th>
          <th>房号</th>
          <th>所属分店</th>
          <th>类型</th>
          <th>屋内设施</th>
          <th>状态</th>
          <th>操作</th> 	
        </tr>
        <s:iterator var="room" value="page.pageContent">
        <tr onmouseover="this.className='highLight';" onmouseout="this.className='';">
          <td><s:property value="#room.roomId"/></td>
          <td><s:property value="#room.roomNo"/></td>
          <td><s:property value="#room.hotel.hotelName"/></td>
          <td>
            <s:if test="#room.roomType==\"a\"">普单人间</s:if>
            <s:elseif test="#room.roomType==\"b\"">普双人间</s:elseif>
            <s:elseif test="#room.roomType==\"c\"">三人间</s:elseif>
            <s:elseif test="#room.roomType==\"d\"">商务套房</s:elseif>
            <s:elseif test="#room.roomType==\"e\"">贵宾套房</s:elseif>
          </td>
          <td>
            <s:iterator var="equip" value="#room.roomEquipment">
              <s:if test="#equip == \"a\"">平面液晶电视 </s:if>
              <s:elseif test="#equip == \"b\"">冰箱 </s:elseif>
              <s:elseif test="#equip == \"c\"">空调 </s:elseif>
              <s:elseif test="#equip == \"d\"">卫星电视 </s:elseif>
              <s:elseif test="#equip == \"e\"">互联网接入 </s:elseif>
              <s:elseif test="#equip == \"f\"">冲浪浴缸 </s:elseif>
              <s:elseif test="#equip == \"g\"">观海景 </s:elseif>
            </s:iterator>
          </td>
          <td>
            <s:if test="#room.roomStatus==\"a\"">未入住</s:if>
            <s:elseif test="#room.roomStatus==\"b\"">有住客</s:elseif>
            <s:elseif test="#room.roomStatus==\"c\"">已预订</s:elseif>
            <s:elseif test="#room.roomStatus==\"d\"">保洁中</s:elseif>
            <s:elseif test="#room.roomStatus==\"e\"">已退房未保洁</s:elseif>  
            <s:elseif test="#room.roomStatus==\"f\"">维修中</s:elseif>        
          </td>
          <td>
            <button onclick="removeRoom(<s:property value="#room.roomId"/>,'<s:property value="#room.roomNo"/>','<s:property value="#room.hotel.hotelName"/>');">删除</button>
            <button onclick="updateRoom(<s:property value="#room.roomId"/>);">修改</button>
          </td>
        </tr>
        </s:iterator>
     </table>
     <div id="pageinfo">
	            共<s:property value="page.totalRecNum"/>条, 当前显示<s:property value="page.startIndex+1"/>-<s:property value="page.endIndex"/>条,
	             第<s:property value="page.pageNo"/>/<s:property value="page.totalPageNum"/>页
	           |
	           <s:if test="page.pageNo>1">
	             <span class="linkspan" onclick="doQuery(1)">首页</span>&nbsp;
	           </s:if>
	           <s:if test="page.prePage">
	             <span class="linkspan" onclick="doQuery(<s:property value="page.pageNo"/>-1)">上一页</span>&nbsp;
	           </s:if>
	           <s:if test="page.nextPage">
	             <span class="linkspan" onclick="doQuery(<s:property value="page.pageNo"/>+1)">下一页</span>&nbsp;
	           </s:if>
	           <s:if test="page.pageNo!=page.totalPageNum">
	             <span class="linkspan" onclick="doQuery(<s:property value="page.totalPageNum"/>)">末页</span>&nbsp;
	           </s:if>
	           |
	            到<input type="text" id="pageNo" size=4 style="text-align:right;" onkeypress="onlynumber();"/> 页
	           <button onclick="doQuery($('pageNo').value);"> 跳 转 </button>		           		           	           	              
	   </div>     
     </s:if>
     <s:if test="page.pageContent.size()==0">
        <div style="padding:30px;text-align:center;color:red;font-size：12px;">
          没有符合您的查询条件的房间信息被找到!
        </div>
     </s:if>
  </body>
</html>
