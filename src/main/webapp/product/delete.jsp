<%--
  Created by IntelliJ IDEA.
  User: nguyendangtuananh
  Date: 08/10/2021
  Time: 09:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

</head>
<body>

<div class="card-header">
    <button class="btn btn-primary"><a href="/product" style="color: white;text-decoration:none">Back to Product List</a></button>

</div>
<h1 style="text-align: center">Delete product </h1>
<div style="text-align: center">

    <form method="post">
        <h2>Bạn chắc chắn muốn xóa sản phẩm ${requestScope["product"].getName()} ?</h2>
        <button style="padding: 10px;background-color: red;border-radius: 15px"><p style="color: white;font-weight: 600">Delete</p></button>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>

</body>
</html>
