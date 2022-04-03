<%--
  Created by IntelliJ IDEA.
  User: 405fu
  Date: 27.03.2022
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
  <style>

    .linear{
      background-image: linear-gradient(to top, rgba(0,0,0), rgba(128,128,128));
    }

  </style>

</head>
<body>



<div class="w3-sidebar bg-dark text-center" style="width:20%">


  <a href="/user/home" class="d-block text-decoration-none text-white text-uppercase mt-4 mb-5">
    <h3>Name Surname</h3>
  </a>

  <div class="text-left px-2">

    <ul class="list-group list-unstyled">

      <li> <a href="/user/personal" class="list-group-item bg-dark text-white border-0">Personal</a> </li>
      <li>  <a href="/user/edu" class="list-group-item bg-dark text-white border-0">Education</a> </li>
      <li>   <a href="/user/experience" class="list-group-item bg-dark text-white border-0">Experience</a></li>
      <li>   <a href="/user/reference" class="list-group-item bg-dark text-white border-0">Reference</a></li>
      <li>  <a href="/user/hobi" class="list-group-item bg-dark text-white border-0">Hobbies</a> </li>
      <li>  <a href="/user/skill" class="list-group-item bg-dark text-white border-0">Skills</a> </li>
      <li>   <a href="/logout" class="list-group-item bg-dark text-white border-0">Log Out</a></li>

    </ul>

  </div>

</div>

</body>
</html>
