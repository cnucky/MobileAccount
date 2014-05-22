package com.mobile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mobile.connection.DBConnection;
import com.mobile.model.Business;
import com.mobile.model.Charge;
import com.mobile.model.ModelInterface;
import com.mobile.model.Operator;
import com.mobile.utils.Tools;

public class BusinessDao implements DaoInterface {

	@Override
	public ArrayList<ModelInterface> getAll() {
		Connection conn = DBConnection.getConnection();
		PreparedStatement smt = null;
		ResultSet rs = null;
		ArrayList<ModelInterface> list = new ArrayList<ModelInterface>();
		
		try {
			smt = conn.prepareStatement("select * from t_business");
			rs = smt.executeQuery();
			while(rs.next()){
				Business b = new Business();
				b.setBusinessId(rs.getString("business_id"));
				b.setBusinessName(rs.getString("business_name"));
				b.setInstruction(rs.getString("business_detail"));
				list.add(b);
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
		Business b = new Business();
		
		try {
			smt = conn.prepareStatement("select * from t_business where business_id=?");
			smt.setInt(1, Integer.parseInt(id));
			rs = smt.executeQuery();
			if(rs.next()){
				b.setBusinessId(rs.getString("business_id"));
				b.setBusinessName(rs.getString("business_name"));
				b.setInstruction(rs.getString("business_detail"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public int add(ModelInterface model) {
		// TODO Auto-generated method stub
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

	public List<ModelInterface> query(String bid, String bname) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement smt = null;
		ResultSet rs = null;
		ArrayList<ModelInterface> list = new ArrayList<ModelInterface>();
		
		try {
			smt = conn.prepareStatement("select * from t_business where business_id=? or business_name=?");
			smt.setString(1, bid);
			smt.setString(2, bname);
			
			rs = smt.executeQuery();
			
			while(rs.next()){
				Business c = new Business();
				c.setBusinessId(rs.getString("business_id"));
				c.setBusinessName(rs.getString("business_name"));
				c.setInstruction(rs.getString("instruction"));
				
				list.add(c);
				
			}
			
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBConnection.closeAll(rs, smt, conn);
		}
		return null;
	}

	public List<ModelInterface> query(int page, int size) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement smt = null;
		ResultSet rs = null;
		ArrayList<ModelInterface> list = new ArrayList<ModelInterface>();
		
		try {
			smt = conn.prepareStatement("select * from t_business limit ?, ? ;");
			smt.setInt(1,  (page-1)*size );
			smt.setInt(2,  size);
			
			rs = smt.executeQuery();
			
			while(rs.next()){
				Business c = new Business();
				c.setBusinessId(rs.getString("business_id"));
				c.setBusinessName(rs.getString("business_name"));
				c.setInstruction(rs.getString("instruction"));
				
				list.add(c);
				
			}
			
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBConnection.closeAll(rs, smt, conn);
		}
		return null;
	}

}
