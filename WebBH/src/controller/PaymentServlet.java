package controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BillDAOImpl;
import dao.BillDetailsDAOImpl;
import dao.UsersDAOImpl;
import model.Bill;
import model.BillDetails;
import model.Cart;
import model.Product;
import model.Users;

public class PaymentServlet extends HttpServlet {
	private BillDAOImpl hdDAO = new BillDAOImpl();
	private BillDetailsDAOImpl cthdDAO = new BillDetailsDAOImpl();
	private UsersDAOImpl tkDAO = new UsersDAOImpl();
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String address = request.getParameter("address");
		String payment = request.getParameter("payment");
		String users = request.getParameter("users");
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		try {

			Date date = new Date();
			String mhd = "" + date.getTime();
			Users tk = new Users();
			tk.setUserID(tkDAO.getUsers(users).getUserID());
			Bill hd = new Bill(mhd, tk, address, 
					payment, new Timestamp(new Date().getTime()), 0);
			hd.setBill_id(mhd);
			hdDAO.AddBill(hd);
			
			TreeMap<Product, Integer> list = cart.getList();
			for(Map.Entry<Product, Integer> ds : list.entrySet()) {
				Product sp = new Product();
				sp.setProduct_id(ds.getKey().getProduct_id());
				cthdDAO.AddBillDetails(new BillDetails(0, hd, sp, ds.getValue(),
						ds.getKey().getProduct_price()));
			}
//			SendMail sm = new SendMail();
//			sm.sendMail(users.getUserEmail(), "Đạt ngu", "Hello, " +users.getUserEmail()+"\nTotal:"+(getValue() * getKey().getProduct_price())+"");
			response.sendRedirect ("/WebBH/index.jsp");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}


}
