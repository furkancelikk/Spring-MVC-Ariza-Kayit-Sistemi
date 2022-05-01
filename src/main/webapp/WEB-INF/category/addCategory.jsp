<%--
  Created by IntelliJ IDEA.
  User: Alperen
  Date: 28.04.2022
  Time: 04:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--    KATEGORİ EKLEME--%>
<div>
    <%@include file='../../template.jsp' %>
</div>


<div style="margin-left:20%; padding: 10px;">

    <div class="w3-col">

        <div class="w3-row-padding">
            <div class="w3-col m12">
                <div class="w3-card w3-round w3-white">
                    <div class="w3-container">

                        <%--                        KATEGORİ EKLEME--%>
                        <form id="formCategory" action="${pageContext.request.contextPath}/category/create" method="post">
                            <div>
                                <input required style="width: 100%; margin: 10px 0;" class="w3-border w3-padding"
                                       type="text" placeholder="Başlık" id="categoryName">
                            </div>
                            <div>
                                <textarea required style="width: 100%; margin: 10px 0;" class="w3-border w3-padding"
                                          rows="5" placeholder="Detay" id="categoryDescription"></textarea>
                            </div>
                            <button type="submit" class="w3-button w3-theme"><i class="fa fa-pencil"></i> &nbsp;Post
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <div id="categoryContainer">

        </div>

        <script>

            $(document).ready(function () {
                getAllCategories();

                $.get("${pageContext.request.contextPath}/category/getAll", function (data) {
                    var result = JSON.parse(data);
                    if (result.success == true) {
                        var list = result.data;

                        list.map(item =>
                            $('#category').append('<option value="' + item.id + '">' + item.name + '</option>')
                        );
                    }
                });
            });

            $("#formCategory").submit(function (event) {
                event.preventDefault();
                $.post("${pageContext.request.contextPath}/category/create", {
                    "name": $("#categoryName").val(),
                    "description": $("#categoryDescription").val()
                }, function (data, status, xhr) {
                    var result = JSON.parse(data);
                    if (status == "success" && result.success == true) {
                        $("#categoryName").val("");
                        $("#categoryDescription").val("");
                        getAllCategories();
                    }
                });

            });

            function getAllCategories() {
                $('#categoryContainer').empty();

                $.get("${pageContext.request.contextPath}/category/getAll", function (data) {
                    var result = JSON.parse(data)
                    if (result.success == true){
                        var categories = result.data;
                        categories.map(category =>
                            $('#categoryContainer').append(
                                '<div class="w3-container w3-card w3-white w3-round w3-margin"><br>' +
                                '<h4>' + category.name + '</h4><br>' +
                                '<hr class="w3-clear">' +
                                '<p>' + (category.description?.length > 400 ? category.description.substr(0, 397) + '...': category.description) + '</p>' +
                                '<div class="w3-row-padding" style="margin:0 -16px">' +
                                '<div class="w3-half">' + '</div><div class="w3-half">' +
                                '</div></div>' +
                                '<a href="${pageContext.request.contextPath}/category/detay/' + category.id + '"><button type="button" class="w3-button w3-theme-d1 w3-margin-bottom"><i class="fa fa-thumbs-up"></i> &nbsp;Detay</button></a>' +
                                '</div>'
                            )
                        )
                    }

                });
            }
        </script>

    </div>

</div>
</body>
</html>
