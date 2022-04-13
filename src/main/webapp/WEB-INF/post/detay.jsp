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
    <link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</head>
<body style="background: #ececec;">

<div>
    <%@include file='../../template.jsp' %>
</div>


<div style="margin-left:20%; padding: 10px;">

    <div class="w3-col">

        <div class="w3-row-padding">

            <%--            POST GÜNCELLEME         --%>
            <div class="w3-col m12">
                <div class="w3-card w3-round w3-white w3-margin-top">
                    <input type="hidden" id="faultRecord" value='${faultRecord}'/>

                    <div class="w3-container">
                        <script>
                            var faultrecord = $('#faultRecord').val();
                            faultrecord = JSON.parse(faultrecord);
                        </script>
                        <form id="form" action="${pageContext.request.contextPath}/post/update" method="post">
                            <div>
                                <input onkeyup="handleChangePost(this)" id="title" required
                                       style="width: 100%; margin: 10px 0;" class="w3-border w3-padding" type="text"
                                       placeholder="Başlık">
                            </div>
                            <div>
                                <textarea onkeyup="handleChangePost(this)" id="context" required
                                          style="width: 100%; margin: 10px 0;" class="w3-border w3-padding" rows="10"
                                          placeholder="İçerik"></textarea>
                            </div>
                            <div class="form-check w3-margin-top w3-margin-bottom">
                                <input class="form-check-input" onchange="handleChangePostIsResolved(this)" type="checkbox" id="isResolved" />
                                <label class="form-check-label" for="isResolved">Çözüldü</label>
                            </div>
                            <button type="submit" class="w3-button w3-theme"><i class="fa fa-pencil"></i> &nbsp;Güncelle
                            </button>
                        </form>

                        <script>
                            $("#title").val(faultrecord.title);
                            $("#context").val(faultrecord.context);
                            $('#isResolved').prop('checked', faultrecord.isResolved);
                        </script>
                    </div>
                </div>
            </div>


            <%--            YORUMLAR VE YORUM YAPMA ALANI           --%>
            <div class="w3-col m12" id="commentContainer">
                <%--                <div class="w3-card w3-round w3-white w3-margin-top w3-margin-left">--%>
                <%--                    <div class="w3-container">--%>
                <%--                        <div>--%>
                <%--                            <textarea disabled required style="width: 100%; margin: 10px 0;"--%>
                <%--                                      class="w3-border w3-padding" rows="3">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque sodales ligula tortor, ut finibus velit tempor eu. Cras eleifend pellentesque odio a placerat. Aliquam volutpat ligula sollicitudin lacus consectetur, at tempor sem iaculis. Quisque lacus erat, venenatis id congue at, pulvinar non lorem. Curabitur vel ullamcorper metus. Pellentesque a sagittis eros, non vehicula elit. Aenean varius consequat lacinia.</textarea>--%>
                <%--                        </div>--%>
                <%--                        <div>--%>
                <%--                            <p>Ad Soyad</p>--%>
                <%--                        </div>--%>
                <%--                    </div>--%>
                <%--                </div>--%>
            </div>

            <div class="w3-col m12">
                <%--                YORUM YAPMA ALANI           --%>
                <div class="w3-card w3-round w3-white w3-margin-top w3-margin-left w3-margin-bottom">
                    <div class="w3-container">
                        <form id="formComment">
                            <div>
                                <textarea id="commentContext" required style="width: 100%; margin: 10px 0;"
                                          class="w3-border w3-padding" rows="3" placeholder="Yorum Yaz..."></textarea>
                            </div>
                            <button type="submit" class="w3-button w3-theme"><i class="fa fa-pencil"></i> &nbsp;Yorum
                                Yap
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>


    </div>


</div>

<script>

    $(document).ready(function () {
        getThisPostComments();
        if (faultrecord.isResolved){
            $("#formComment").hide();
            $("#form input, #form button, #form textarea").prop("disabled", true);
        }
    })

    $("#form").submit(function (event) {
        event.preventDefault();
        var strObj = JSON.stringify(faultrecord);
        $.post("${pageContext.request.contextPath}/post/update", {"strFaultRecord": strObj}, function (data, status, xhr) {
            data = JSON.parse(data);
            if (status == "success" && data.success == true) {
                alert("GÜNCELLEME BAŞARILI");
                window.location.href = "${pageContext.request.contextPath}/user/home";
            }
        });

    });

    $("#formComment").submit(function (event) {
        event.preventDefault();
        $.post("${pageContext.request.contextPath}/comment/save", {
            "commentContext": $("#commentContext").val(),
            "faultRecordID": faultrecord.id
        }, function (data, status, xhr) {
            data = JSON.parse(data);
            if (status == "success" && data.success == true) {
                $("#commentContext").val("")
                getThisPostComments()
            }
        });

    });

    function handleChangePost(event) {
        faultrecord[event.id] = event.value;
    }

    function handleChangePostIsResolved(event) {
        faultrecord["isResolved"] = event.checked;
    }

    function getThisPostComments() {

        $('#commentContainer').empty()

        $.get("${pageContext.request.contextPath}/comment/getByPost?postID=" + faultrecord.id, function (result) {
            var r = JSON.parse(result);
            var data = r.data;
            console.log(r, data);
            data.map(item =>
                $('#commentContainer').append(
                    '<div class="w3-card w3-round w3-white w3-margin-top w3-margin-left">' +
                    '<div class="w3-container">' +
                    '<div>' +
                    '<p style="width: 100%; margin: 10px 0;" class="w3-padding" rows="3"> ' + item.context + ' </p>' +
                    '</div>' +
                    ' <div>' +
                    ' <hr>' +
                    ' <p class="w3-right-align"> ' + item.user.ad + ' ' + item.user.soyad + ' </p>' +
                    ' <p class="w3-right-align"><small> ' + item.creationTime + ' </small></p>' +
                    '</div>' +
                    '</div> ' +
                    '</div>'
                )
            )
        });
    }
</script>
</body>


</html>
