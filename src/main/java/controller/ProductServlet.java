package controller;

import model.Product;
import service.IProductService;
import service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    private IProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            case "delete":
                showDeleteForm(request,response);
                break;
            case "edit":
                showUpdateForm(request,response);
                break;
            default:
                showProductList(request,response);
                break;


        }


    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if(product == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else{
            request.setAttribute("product",product);
            dispatcher = request.getRequestDispatcher("product/edit.jsp");
        }
        dispatcher.forward(request,response);



    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product oldProduct = productService.findById(id);
        RequestDispatcher dispatcher;
        if(oldProduct == null){
            dispatcher = request.getRequestDispatcher("error-404");
        }else{
            dispatcher = request.getRequestDispatcher("/product/delete.jsp");
            request.setAttribute("product",oldProduct);
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/create.jsp");

        try {
            List<Product> products = productService.getAll();
            request.setAttribute("products",products);
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showProductList(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = this.productService.getAll();
        request.setAttribute("products",products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request,response);
                break;
            case "delete":
                deleteProduct(request,response);
                break;
            case "edit":
                updateProduct(request,response);
            case "search":
                searchProduct(request,response);
                break;

        }
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) {

        String name = request.getParameter("search");
        List<Product> products =  null;
        if (name == null || name.equals("")) {
            products = productService.getAll();
        } else {
            products = productService.findProductByName(name);
        }


        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }


    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
    int id = Integer.parseInt(request.getParameter("id"));
    String name = request.getParameter("name");
    String price = request.getParameter("price");
    String quantity = request.getParameter("quantity");
    String color = request.getParameter("color");
    String note = request.getParameter("note");
    String category = request.getParameter("category");
    Product product = this.productService.findById(id);
    RequestDispatcher dispatcher;
    if(product == null){
        dispatcher = request.getRequestDispatcher("error-404.jsp");
    }else{
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setColor(color);
        product.setNote(note);
        product.setCategory(category);
        this.productService.update(id,product);
        request.setAttribute("product",product);
        request.setAttribute("message","product updated!!");
        dispatcher = request.getRequestDispatcher("product/edit.jsp");

        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.delete(id);
        try {
            response.sendRedirect("/product");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String color = request.getParameter("color");
        String note = request.getParameter("note");
        String category = request.getParameter("category");
        int id = (int)(Math.random()*1000);
        Product product = new Product(id,name,price,quantity,color,note,category);
        boolean isCreated = productService.save(product);
        String message="";
        if(isCreated){
            message="Created new product!!!";
        }else{
            message="created fail!";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/create.jsp");
        request.setAttribute("message",message);
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
