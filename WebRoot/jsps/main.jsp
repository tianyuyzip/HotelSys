<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>酒店房间管理系统</title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/application.css"></c:url>">
    
    <script type="text/javascript">
	      function logout(){
	         if(confirm('尊敬的${loginedUser.userName},您真的要离开系统吗？')){
	            location.href='<s:url namespace="/security" action="logout"/>';	            
	         }
	      }
	</script>    
	
	<style type="text/css">
	
	#content{
		float:left;
	}
	
	</style>
    	
  </head>
  
  <body>
     <div id="header">
        <div id="productName">酒店房间管理</div>
        <div></div>
        <div style="float:right; margin:10px;">
                 操作员:${loginedUser.userName}&nbsp;
             <span class="linkspan" onclick="logout();" title="点击离开系统">离开系统</span>
        </div>        
     </div>
     <div>
        <div id="navigator">
            <div class="menuitem">
               <!-- target属性决定了这个连接的打开位置 ，默认是_blank -->
               <a href="<s:url namespace="/hotel" action="toInput"/>" target="contentFrame">开设分店</a>
            </div>
            <div class="menuitem">
               <a href="<s:url namespace="/hotel" action="loadHotels"/>"  target="contentFrame">分店管理</a>
            </div>
            <div class="seperator"></div>
            <div class="menuitem">
               <a href="<s:url namespace="/room" action="toInput"/>"  target="contentFrame">开设房间</a>
            </div>
            <div class="menuitem">
               <a href="<s:url namespace="/room" action="loadRooms"/>" target="contentFrame">房间查询</a>
            </div>                        
        </div>
        <div id="content">
          <!-- iframe : inner frame(window)-->
          <iframe id="contentFrame" width="99%" scrolling="no" height="530px" frameborder="0" name="contentFrame" allowtransparency="true" src='<c:url value="/welcome.jsp"/>'> 
          </iframe>           
        </div>
     </div>
     <div style="clear:both"></div> 
     <%@ include file="/jsps/footer.jsp"%> 
  </body>
</html>
