package com.mobile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mobile.connection.DBConnection;
import com.mobile.model.Customer;
import com.mobile.model.ModelInterface;
import com.mobile.model.Operator;
import com.mobile.utils.Tools;
import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

public class CustomerDao implements DaoInterface {

	@Override
	public ArrayList<ModelInterface> getAll() {
		Connection conn = DBConnection.getConnection();
		PreparedStatement smt = null;
		ResultSet rs = null;
		ArrayList<ModelInterface> list = new ArrayList<ModelInterface>();
		
		try {
			smt = conn.prepareStatement("select * from t_customer");
			rs = smt.executeQuery();
			while(rs.next()){
				Customer c = new Customer();
				c.setCustomerAddress(rs.getString("customer_address"));
				c.setCustomerBirthday(rs.getString("customer_birthday"));
				c.setCustomerId(rs.getString("customer_id"));
				c.setCustomerName(rs.getString("customer_name"));
				c.setCustomerSex(rs.getString("customer_sex"));
				c.setIdNumber(rs.getString("id_number"));
				c.setIdType(rs.getString("id_type"));
				list.add(c);
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
			smt = conn.prepareStatement("select * from t_customer where customer_id=? or customer_name=?");
			smt.setString(1, id);
			smt.setString(2, name);
			rs = smt.executeQuery();
			
			while(rs.next()){
				Customer c = new Customer();
				c.setCustomerAddress(rs.getString("customer_address"));
				c.setCustomerBirthday(rs.getString("customer_birthday"));
				c.setCustomerId(rs.getString("customer_id"));
				c.setCustomerName(rs.getString("customer_name"));
				c.setCustomerSex(rs.getString("customer_sex"));
				c.setIdNumber(rs.getString("id_number"));
				c.setIdType(rs.getString("id_type"));
				list.add(c);
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
			smt = conn.prepareStatement("select * from t_customer limit ?,?");
			smt.setInt(1, --page*size);
			smt.setInt(2, size);
			rs = smt.executeQuery();
			
			while(rs.next()){
				Customer c = new Customer();
				c.setCustomerAddress(rs.getString("customer_address"));
				c.setCustomerBirthday(rs.getString("customer_birthday"));
				c.setCustomerId(rs.getString("customer_id"));
				c.setCustomerName(rs.getString("customer_name"));
				c.setCustomerSex(rs.getString("customer_sex"));
				c.setIdNumber(rs.getString("id_number"));
				c.setIdType(rs.getString("id_type"));
				list.add(c);
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
		Customer c = new Customer();
		
		try {
			smt = conn.prepareStatement("select * from t_customer where customer_id=?");
			smt.setString(1, id);
			rs = smt.executeQuery();
			rs.next();
			c.setCustomerAddress(rs.getString("customer_address"));
			c.setCustomerBirthday(rs.getString("customer_birthday"));
			c.setCustomerId(rs.getString("customer_id"));
			c.setCustomerName(rs.getString("customer_name"));
			c.setCustomerSex(rs.getString("customer_sex"));
			c.setIdNumber(rs.getString("id_number"));
			c.setIdType(rs.getString("id_type"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBConnection.closeAll(rs, smt, conn);
		}
		return c;
	}

	@Override
	public int add(ModelInterface model) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement smt = null;
		
		Customer c = (Customer) model;
		
		try {
			smt = conn.prepareStatement("insert into t_customer(id_type,id_number,customer_name,customer_birthday,customer_Sex,customer_Address) values(?,?,?,?,?,?)");
			smt.setString(1, c.getIdType());
			smt.setString(2, c.getIdNumber());
			smt.setString(3, c.getCustomerName());
			smt.setString(4, c.getCustomerBirthday());
			smt.setString(5, c.getCustomerSex());
			smt.setString(6, c.getCustomerAddress());
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
		
		Customer c = (Customer) model;
		
		try {
			smt = conn.prepareStatement("update t_customer set id_type=?,id_number=?,customer_name=?,customer_birthday=?,customer_Sex=?,customer_Address=? where customer_id=?");
			
			smt.setString(1, c.getIdType());
			smt.setString(2, c.getIdNumber());
			smt.setString(3, c.getCustomerName());
			smt.setString(4, c.getCustomerBirthday());
			smt.setString(5, c.getCustomerSex());
			smt.setString(6, c.getCustomerAddress());
			smt.setString(7, c.getCustomerId());
			
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

}
