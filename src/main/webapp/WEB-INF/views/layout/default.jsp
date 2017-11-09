<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title><sitemesh:title/></title>
    <sitemesh:head/>
</head>
<body>
    <%@ include file="common/header.jsp"%>

    <div id="content">
        <sitemesh:body/>
    </div>

    <%@ include file="common/footer.jsp"%>
</body>
</html> 