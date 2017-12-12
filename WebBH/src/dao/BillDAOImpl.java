package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import connect.DBConnect;
import model.Bill;
import model.Users;

public class BillDAOImpl implements BillDAO {

	@Override
	public void AddBill(Bill hd) {
		Connection conn = DBConnect.getConnection();
		String sql = "insert into bill value (?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, hd.getBill_id());
			ps.setString(2, hd.getUsers().getUserID());
			ps.setString(3, hd.getAddress());
			ps.setString(4, hd.getPayment());
			ps.setTimestamp(5, hd.getDate_buy());
			ps.setInt(6, hd.getBill_status());
			ps.executeUpdate();
			conn.close();

		} catch (Exception ex) {
			Logger.getLogger(UsersDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
	
	public ArrayList<Bill> getListBill() {
        try {
            Connection connection = DBConnect.getConnection();
            String sql = "SELECT * FROM bill";
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Bill> list = new ArrayList<>();
            while (rs.next()) {
                Bill bill = new Bill();
                Users tk = new Users();
                bill.setBill_id(rs.getString("bill_id"));
                bill.setUserID(rs.getString("user_id"));
                bill.setAddress(rs.getString("address"));
                bill.setPayment(rs.getString("payment"));
                bill.setBill_status(rs.getInt("bill_status"));
                bill.setDate_buy(rs.getTimestamp("date"));
                list.add(bill);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
