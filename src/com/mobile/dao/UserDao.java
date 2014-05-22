package com.mobile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mobile.connection.DBConnection;
import com.mobile.model.ModelInterface;
import com.mobile.model.Operator;
import com.mobile.model.User;

public class UserDao implements DaoInterface {

	@Override
	public ArrayList<ModelInterface> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<ModelInterface> selectCusId(String id) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement smt = null;
		ResultSet rs = null;
		ArrayList<ModelInterface> list = new ArrayList<ModelInterface>();
		
		try {
			smt = conn.prepareStatement("select * from t_user where customer_id=?");
			smt.setString(1, id);
			rs = smt.executeQuery();
			
			while(rs.next()){
				User u = new User();
				u.setUserId(rs.getInt("user_id"));
				u.setAccountId(rs.getInt("account_id"));
				u.setComLevel(rs.getString("com_level"));
				u.setCustomerId(rs.getInt("customer_id"));
				u.setMobileNumber(rs.getString("mobile_number"));
				u.setRoamingStatus(rs.getString("roaming_status"));
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBConnection.closeAll(rs, smt, conn);
		}
		
		return list;
	}
	
	public ArrayList<ModelInterface> selectAccId(String id) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement smt = null;
		ResultSet rs = null;
		ArrayList<ModelInterface> list = new ArrayList<ModelInterface>();
		
		try {
			smt = conn.prepareStatement("select * from t_user where account_id=?");
			smt.setString(1, id);
			rs = smt.executeQuery();
			
			while(rs.next()){
				User u = new User();
				u.setUserId(rs.getInt("user_id"));
				u.setAccountId(rs.getInt("account_id"));
				u.setComLevel(rs.getString("com_level"));
				u.setCustomerId(rs.getInt("customer_id"));
				u.setMobileNumber(rs.getString("mobile_number"));
				u.setRoamingStatus(rs.getString("roaming_status"));
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBConnection.closeAll(rs, smt, conn);
		}
		
		return list;
	}

	@Override
	public ModelInterface getObjectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(ModelInterface model) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement smt = null;
		
		User u = (User) model;
		
		try {
			smt = conn.prepareStatement("insert into t_user(mobile_number,roaming_status,com_level,customer_id,account_id) values(?,?,?,?,?)");
			smt.setString(1, u.getMobileNumber());
			smt.setString(2, u.getRoamingStatus());
			smt.setString(3, u.getComLevel());
			smt.setInt(4, u.getCustomerId());
			smt.setInt(5, u.getAccountId());
			return smt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBConnection.closeAll(smt, conn);
		}
		return 0;
	}

	@Override
	public int remove(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ModelInterface model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ModelInterface getObjectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int remove(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
