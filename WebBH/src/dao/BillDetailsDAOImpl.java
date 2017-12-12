package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

import connect.DBConnect;
import model.BillDetails;

public class BillDetailsDAOImpl implements BillDetailsDAO {

	@Override
	public void AddBillDetails(BillDetails cthd) {
		Connection conn = DBConnect.getConnection();
		String sql = "insert into bill_details value (?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cthd.getBill_detail_id());
			ps.setString(2, cthd.getBill().getBill_id());
			ps.setString(3, cthd.getProduct().getProduct_id());
			ps.setInt(4, cthd.getProduct_quantity());
			ps.setDouble(5, cthd.getProduct_price());
			ps.executeUpdate();
			conn.close();

		} catch (Exception ex) {
			Logger.getLogger(UsersDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

}
