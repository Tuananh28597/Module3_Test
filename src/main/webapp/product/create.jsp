<%--
  Created by IntelliJ IDEA.
  User: nguyendangtuananh
  Date: 08/10/2021
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

</head>
<body>
<div>
<h1 style="text-align: center">Create New Product</h1>

<div class="container">
    <form action="/product?action=create" method="post" class="card">
        <div class="card-header">
            <button class="btn btn-primary"><a href="/product" style="color: white;text-decoration:none">Back to Product List</a></button>

        </div>
        <div class="card-body">
            <c:if test="${message != null}">
                <p>${message}</p>
            </c:if>
            <div>
                <div class="mb-4">
                    <label for="name" class="form-label">Name</label>
                    <input id="name" type="text" placeholder="product name" name="name">
                </div>
                <div class="mb-4">
                    <label for="price" class="form-label">Price</label>
                    <input id="price" type="text" placeholder="product price" name="price" value="0">
                </div>
                <div class="mb-4">
                    <label for="quantity" class="form-label">Quantity</label>
                    <input id="quantity" type="text" placeholder="product quantity" name="quantity" >
                </div>
                <div class="mb-4">
                    <label for="color" class="form-label">Color</label>
                    <input id="color" type="text" placeholder="product color" name="color" >
                </div>
                <div class="mb-4">
                    <label for="note" class="form-label">Note</label>
                    <input id="note" type="text" placeholder="product note" name="note" >
                </div>
                <div class="mb-4">
                    <label for="category" class="category">Category</label>
                    <input id="category" type="text" placeholder="product category" name="category" >
                </div>

            </div>
        </div>
        <div class="card-footer">
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </form>
</div>





<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
</div>
</body>
</html>
