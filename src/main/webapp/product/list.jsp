<%--
  Created by IntelliJ IDEA.
  User: nguyendangtuananh
  Date: 08/10/2021
  Time: 08:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">

    <link rel="stylesheet" href="../tenplate/css/plugins/fontawesome-free/css/all.min.css">
    <link rel="stylesheet" href="../tenplate/css/plugins/fontawesome-free/css/adminlte.min.css">



  </head>
  <body>
  <h1 style="text-align: center">Show List Product</h1>




    <div class="card">
      <div class="card-header">
        <h3 class="card-title"><button style="padding: 15px;border-radius: 20px;background-color: blue "><a style="color: #ffffff;font-weight: 600" href="product?action=create">Create New Product</a></button></h3>

        <div class="card-tools">


          <form action="product?action=search" method="post">
          <div class="input-group input-group-sm" style="width: 150px;">
            <input type="text" name="search" value="" class="form-control float-right" placeholder="Search">

            <div class="input-group-append">
              <button type="submit" class="btn btn-default">
                <i class="fas fa-search"></i>
              </button>
            </div>
          </div>
          </form>


        </div>
      </div>
      <!-- /.card-header -->
      <div class="card-body table-responsive p-0" style="height: 300px;">
        <table class="table table-head-fixed text-nowrap">
          <thead>
          <tr>
            <td>id</td>
            <td>name</td>
            <td>price</td>
            <td>quantity</td>
            <td>color</td>
            <td>note</td>
            <td>category</td>
          </tr>
          </thead>
          <tbody>
          <c:forEach items="${requestScope['products']}" var="product" >
            <tr>
              <td>${product.getId()}</td>
              <td>${product.getName()}</td>
              <td>${product.getPrice()}</td>
              <td>${product.getQuantity()}</td>
              <td>${product.getColor()}</td>
              <td>${product.getNote()}</td>
              <td>${product.getCategory()}</td>
              <td><a href="/product?action=delete&id=${product.id}"><button class="btn btn-primary">Delete</button></a></td>
              <td><a href="/product?action=edit&id=${product.id}"><button class="btn btn-primary">Edit</button></a></td>

            </tr>
          </c:forEach>

          </tbody>
        </table>
      </div>
      <!-- /.card-body -->
    </div>


  </table>








  <script src="../tenplate/js/plugins/jquery/jquery.min.js"></script>
  <script src="../tenplate/js/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="../tenplate/js/dist/js/adminlte.min.js"></script>
  <script src="../tenplate/js/dist/js/demo.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>

  </body>
</html>
