package com.mobile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mobile.connection.DBConnection;
import com.mobile.model.Account;
import com.mobile.model.Customer;
import com.mobile.model.ModelInterface;

public class AccountDao implements DaoInterface {

	@Override
	public ArrayList<ModelInterface> getAll() {
		Connection conn = DBConnection.getConnection();
		PreparedStatement smt = null;
		ResultSet rs = null;
		ArrayList<ModelInterface> list = new ArrayList<ModelInterface>();
		
		try {
			smt = conn.prepareStatement("select * from t_account");
			rs = smt.executeQuery();
			while(rs.next()){
				Account a = new Account();
				a.setAccountAddress(rs.getString("contact_address"));
				a.setAccountBalance(rs.getDouble("account_balance"));
				a.setAccountId(rs.getInt("account_id"));
				a.setAccountName(rs.getString("contact_person"));
				list.add(a);
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
	
	public ArrayList<ModelInterface> select(String id, String name) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement smt = null;
		ResultSet rs = null;
		ArrayList<ModelInterface> list = new ArrayList<ModelInterface>();
		
		try {
			smt = conn.prepareStatement("select * from t_account where account_id=? or account_name=?");
			smt.setString(1, id);
			smt.setString(2, name);
			rs = smt.executeQuery();
			
			while(rs.next()){
				Account a = new Account();
				a.setAccountAddress(rs.getString("contact_address"));
				a.setAccountBalance(rs.getDouble("account_balance"));
				a.setAccountId(rs.getInt("account_id"));
				a.setAccountName(rs.getString("contact_person"));
				list.add(a);
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
	
	public ArrayList<ModelInterface> select(int page, int size) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement smt = null;
		ResultSet rs = null;
		ArrayList<ModelInterface> list = new ArrayList<ModelInterface>();
		
		try {
			smt = conn.prepareStatement("select * from t_account limit ?,?");
			smt.setInt(1, --page*size);
			smt.setInt(2, size);
			rs = smt.executeQuery();
			
			while(rs.next()){
				Account a = new Account();
				a.setAccountAddress(rs.getString("contact_address"));
				a.setAccountBalance(rs.getDouble("account_balance"));
				a.setAccountId(rs.getInt("account_id"));
				a.setAccountName(rs.getString("contact_person"));
				list.add(a);
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
		Connection conn = DBConnection.getConnection();
		PreparedStatement smt = null;
		ResultSet rs = null;
		Account a = new Account();
		
		try {
			smt = conn.prepareStatement("select * from t_account where account_id=?");
			smt.setString(1, id);
			rs = smt.executeQuery();
			
			if(rs.next()){
				a.setAccountAddress(rs.getString("contact_address"));
				a.setAccountBalance(rs.getDouble("account_balance"));
				a.setAccountId(rs.getInt("account_id"));
				a.setAccountName(rs.getString("contact_person"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBConnection.closeAll(rs, smt, conn);
		}
		
		return a;
	}

	@Override
	public int add(ModelInterface model) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement smt = null;
		
		Account a = (Account) model;
		
		try {
			smt = conn.prepareStatement("insert into t_account(contact_person,contact_address,account_balance) values(?,?,?)");
			smt.setString(1, a.getAccountName());
			smt.setString(2, a.getAccountAddress());
			smt.setDouble(3, a.getAccountBalance());
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
		Connection conn = DBConnection.getConnection();
		PreparedStatement smt = null;
		
		Account a = (Account) model;
		
		try {
			smt = conn.prepareStatement("update t_account set contact_person=?,contact_address=?,account_balance=? where account_id=?");
			smt.setString(1, a.getAccountName());
			smt.setString(2, a.getAccountAddress());
			smt.setDouble(3, a.getAccountBalance());
			smt.setInt(4, a.getAccountId());
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
	public ModelInterface getObjectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int remove(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<ModelInterface> query(int account_id, String contact_person) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ModelInterface> query(int parseInt, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
