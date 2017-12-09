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
//  	  	    $("#getAllUser").html(data);
            console.log(data);
            console.log(typeof data);
            var datas = JSON.parse(data);
            var total = datas.total;
            var size = datas.size;
            var list = datas.data;

            console.log(total);
            if(total < 1)return;
            var html_users = "<ul>";
  	  	    $.each(list,function(i,e){
                $("#getAllUser").html(e.account);
                html_users += "<li data-user='" + e.id + "'>" + e.nickName + ";" + e.updatedTime + "</li>"
            });

            $("#getAllUser").html(html_users + "</ul>");
  	  	});
  	});
  	
  </script>
</body>
</html>


