<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 405fu
  Date: 8.03.2022
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<%@ page pageEncoding="UTF-8" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div><%@include file='../template.jsp'%></div>


<div style="margin-left:20%; padding: 10px;">

    <c:if test="${list != null}">
        <h1>LIST ITEMS</h1>
        <c:forEach items="${list}" var="item">
            <div>
                <h2>
                    <c:out value="${item}"/>
                </h2>
            </div>
        </c:forEach>
    </c:if>

    <div>
        <h2>
            <c:out value="${user.getEmail()}"/>
        </h2>
    </div>

    <h1><c:out value="${karsilama}"/></h1>
    <h2>${kisiKarsilama}</h2>
    <h2><spring:message code="aciklama"/></h2>
    <p> Dil Tercihi: <a href="?lang=tr_TR">Türkçe</a> | <a
            href="?lang=en_US">İngilizce</a></p>
    <p>Mevcut Locale: ${pageContext.response.locale} / ${locale} </p>


</div>




</body>
</html>
