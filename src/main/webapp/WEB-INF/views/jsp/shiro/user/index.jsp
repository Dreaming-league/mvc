<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <%@ include file="/WEB-INF/views/include/head.jsp"%>
</head>
<body>

    	用户管理
  <div id="getAllUser">获取用户数据</div>
  
  <script type="text/javascript" src="${ctxStatic}/js/lib/jquery.js"></script>
  <script type="text/javascript">
  	$(function(){
  	  	$.get("${ctx}/a/all",function(data){
  	  	$("#getAllUser").html(data);
  	  	});
  	});
  	
  </script>
</body>
</html>


