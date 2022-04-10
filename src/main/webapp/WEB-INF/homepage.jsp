<%@ page import="com.ileriJava.model.FaultRecords" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %>
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
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <script type = "text/javascript" src = "https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js">
    </script>
</head>
<body>

<div><%@include file='../template.jsp'%></div>


<div style="margin-left:20%; padding: 10px;">

    <c:if test="${list != null}">
        <h1>LIST ITEMS</h1>
        <c:forEach items="${list}" var="item">
            <div>
                <h2>
                    <c:out value="${item.getAd()} ${item.getSoyad()}"/>
                </h2>
            </div>
        </c:forEach>
    </c:if>


    <h1><c:out value="${karsilama}"/></h1>
    <h2>${kisiKarsilama}</h2>
    <h2><spring:message code="aciklama"/></h2>
    <p> Dil Tercihi: <a href="?lang=tr_TR">Türkçe</a> | <a
            href="?lang=en_US">İngilizce</a></p>
    <p>Mevcut Locale: ${pageContext.response.locale} / ${locale} </p>

    <div class="w3-col">

        <div class="w3-row-padding">
            <div class="w3-col m12">
                <div class="w3-card w3-round w3-white">
                    <div class="w3-container">
                        <form action="${pageContext.request.contextPath}/post/create" method="post">
                            <div>
                                <input required style="width: 100%; margin: 10px 0;" class="w3-border w3-padding" type="text" placeholder="Başlık" name="title">
                            </div>
                            <div>
                                <textarea required style="width: 100%; margin: 10px 0;" class="w3-border w3-padding" rows="10" placeholder="İçerik" name="context"></textarea>
                            </div>
                            <button type="submit" class="w3-button w3-theme"><i class="fa fa-pencil"></i> &nbsp;Post</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <div id="recordListContainer">

        </div>

        <script>
            $.get("${pageContext.request.contextPath}/post/getByCurrentUser", function (data){
                var recordList = JSON.parse(data)
                recordList.map(record =>
                    $('#recordListContainer').append(
                        '<div class="w3-container w3-card w3-white w3-round w3-margin"><br>'+
                        '<span class="w3-right w3-opacity">'+ record.creationtime +'</span>' +
                        '<h4>'+ record.faulttitle +'</h4><br>'+
                        '<hr class="w3-clear">'+
                        '<p>'+ record.context +'</p>'+
                        '<div class="w3-row-padding" style="margin:0 -16px">'+
                        '<div class="w3-half">'+'</div><div class="w3-half">'+
                        '</div></div>'+
                        '<a href="${pageContext.request.contextPath}/post/detay/'+record.faultid+'"><button type="button" class="w3-button w3-theme-d1 w3-margin-bottom"><i class="fa fa-thumbs-up"></i> &nbsp;Detay</button></a>'+
                        // '<button type="button" class="w3-button w3-theme-d2 w3-margin-bottom"><i class="fa fa-comment"></i> &nbsp;Düzenle</button>' +
                        '</div>'
                    )
                )
            });
        </script>


<%--        <div class="w3-container w3-card w3-white w3-round w3-margin"><br>--%>
<%--            <span class="w3-right w3-opacity">1 min</span>--%>
<%--            <h4>John Doe</h4><br>--%>
<%--            <hr class="w3-clear">--%>
<%--            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>--%>
<%--            <div class="w3-row-padding" style="margin:0 -16px">--%>
<%--                <div class="w3-half">--%>
<%--                </div>--%>
<%--                <div class="w3-half">--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <button type="button" class="w3-button w3-theme-d1 w3-margin-bottom"><i class="fa fa-thumbs-up"></i> &nbsp;Like</button>--%>
<%--            <button type="button" class="w3-button w3-theme-d2 w3-margin-bottom"><i class="fa fa-comment"></i> &nbsp;Comment</button>--%>
<%--        </div>--%>


    </div>


</div>




</body>
</html>
