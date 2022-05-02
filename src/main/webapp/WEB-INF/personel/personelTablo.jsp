<%--
  Created by IntelliJ IDEA.
  User: furkancelik
  Date: 2.05.2022
  Time: 05:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Arıza Kayıt Sistemi</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/personelTablo/css/style.css">
</head>
<body>
<section class="ftco-section">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6 text-center mb-2 mt-5">
                <h2 class="heading-section">Personel Tablosu</h2>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="table-wrap">
                    <table class="table table-responsive-xl">
                        <thead>
                        <tr>
                            <th>&nbsp;</th>
                            <th>Email</th>
                            <th>Username</th>
                            <th>Status</th>
                            <th>&nbsp;</th>
                        </tr>
                        </thead>
                        <tbody id="personelTableBody">
<%--                        <tr class="alert" role="alert">--%>
<%--                            <td>--%>
<%--                                <label class="checkbox-wrap checkbox-primary">--%>
<%--                                    <input type="checkbox" checked>--%>
<%--                                    <span class="checkmark"></span>--%>
<%--                                </label>--%>
<%--                            </td>--%>
<%--                            <td class="d-flex align-items-center">--%>
<%--                                <div class="pl-3 email">--%>
<%--                                    <span>markotto@email.com</span>--%>
<%--                                    <span>Added: 01/03/2020</span>--%>
<%--                                </div>--%>
<%--                            </td>--%>
<%--                            <td>Markotto89</td>--%>
<%--                            <td class="status"><span class="active">Active</span></td>--%>
<%--                            <td>--%>
<%--                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">--%>
<%--                                    <span aria-hidden="true"><i class="fa fa-close"></i></span>--%>
<%--                                </button>--%>
<%--                            </td>--%>
<%--                        </tr>--%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>

<script src="${pageContext.request.contextPath}/resources/personelTablo/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/personelTablo/js/popper.js"></script>
<script src="${pageContext.request.contextPath}/resources/personelTablo/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/personelTablo/js/main.js"></script>

<script>

    $(document).ready(function () {
        getAllPersonel();

    });


    function getAllPersonel() {
        $('#personelTableBody').empty();

        $.get("${pageContext.request.contextPath}/personel/getAll", function (data) {
            var result = JSON.parse(data);
            if (result.success == true) {
                var personelList = result.data;
                personelList.map(personel =>
                    $('#personelTableBody').append(
                        '<tr class="alert" role="alert">' +
                        '<td>' +
                        '<label class="checkbox-wrap checkbox-primary">' +
                        '<input type="checkbox" checked>' +
                        '<span class="checkmark"></span>' +
                        '</label>' +
                        '</td>' +
                        '<td class="d-flex align-items-center">' +
                        '<div class="pl-3 email">' +
                        '<span>'+personel.user.email+'</span>' +
                        '<span></span>' +
                        '</div>' +
                        '</td>' +
                        '<td>'+personel.user.ad + ' ' + personel.user.soyad +'</td>' +
                        '<td class="status"><span class="active">Active</span></td>' +
                        '<td>' +
                        '<button type="button" class="close" data-dismiss="alert" aria-label="Close">' +
                        '<span aria-hidden="true"><i class="fa fa-close"></i></span>' +
                        '</button>' +
                        '</td>' +
                        '</tr>'
                    )
                )
            }

        });
    }
</script>

</body>
</html>
