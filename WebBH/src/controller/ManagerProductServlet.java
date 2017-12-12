package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAOImpl;
import model.Product;

@WebServlet("/ManagerProductServlet")
public class ManagerProductServlet extends HttpServlet {


	ProductDAOImpl productDAO = new ProductDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String command = request.getParameter("command");
        String product_id = request.getParameter("product_id");

        String url = "";
        try {
            switch (command) {

                case "delete":
                	productDAO.deleteProduct(product_id);
                    url = "/admin/manager_product.jsp";
                    break;
            }
        } catch (Exception e) {
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String command = request.getParameter("command");
        String tenProd = request.getParameter("tenProd");
        String product_id = request.getParameter("product_id");

        String url = "", error = "";
        if (tenProd.equals("")) {
            error = "Vui long nhap ten san pham!";
            request.setAttribute("error", error);
        }

        try {
            if (error.length() == 0) {
                switch (command) {
                    case "insert":
                    	ProductDAOImpl.insertProduct();
                        url = "/admin/manager_product.jsp";
                        break;
                    case "update":
                    	String product_name = request.getParameter("product_name");
                    	String product_image = request.getParameter("product_image");
                    	String product_quantity = request.getParameter("product_quantity");
                    	String product_description = request.getParameter("product_description");
                    	String product_price = request.getParameter("pro_price");
                    	Product p = new Product(product_name, product_image, product_quantity, product_description, product_price);
                    	ProductDAOImpl.updateProduct(p);
                        url = "/admin/manager_product.jsp";
                        break;
                }
            } else {
                url = "/admin/insert_product.jsp";
            }
        } catch (Exception e) {
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);

    }

}
