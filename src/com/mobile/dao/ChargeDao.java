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

public class ChargeDao implements DaoInterface {

	@Override
	public ArrayList<ModelInterface> getAll() {
		Connection conn = DBConnection.getConnection();
		PreparedStatement smt = null;
		ResultSet rs = null;
		ArrayList<ModelInterface> list = new ArrayList<ModelInterface>();
		
		try {
			smt = conn.prepareStatement("select * from t_charge");
			rs = smt.executeQuery();
			while(rs.next()){
				Charge c = new Charge();
				c.setChargeId(rs.getString("charge_id"));
				c.setChargeName(rs.getString("charge_name"));
				c.setCharge(rs.getString("charge"));
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
		Charge c = new Charge();
		
		try {
			smt = conn.prepareStatement("select * from t_charge where charge_id=?");
			smt.setString(1, id);
			rs = smt.executeQuery();
			while(rs.next()){
				c.setChargeId(rs.getString("charge_id"));
				c.setChargeName(rs.getString("charge_name"));
				c.setCharge(rs.getString("charge"));
			}
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

	public List<ModelInterface> query(String id, String name) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement smt = null;
		ResultSet rs = null;
		ArrayList<ModelInterface> list = new ArrayList<ModelInterface>();
		
		try {
			smt = conn.prepareStatement("select * from t_charge where charge_id=? or charge_name=?");
			smt.setString(1, id);
			smt.setString(2, name);
			
			rs = smt.executeQuery();
			
			while(rs.next()){
				Charge c = new Charge();
				c.setChargeId(rs.getString("Charge_id"));
				c.setChargeName(rs.getString("Charge_name"));
				c.setCharge(rs.getString("Charge"));
				
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
			smt = conn.prepareStatement("select * from t_charge limit ?, ? ;");
			smt.setInt(1,  (page-1)*size );
			smt.setInt(2,  size);
			
			rs = smt.executeQuery();
			
			while(rs.next()){
				Charge c = new Charge();
				c.setChargeId(rs.getString("Charge_id"));
				c.setChargeName(rs.getString("Charge_name"));
				c.setCharge(rs.getString("Charge"));
				
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
