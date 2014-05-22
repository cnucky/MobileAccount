package com.mobile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mobile.connection.DBConnection;
import com.mobile.model.BusinessCharge;
import com.mobile.model.Charge;
import com.mobile.model.ModelInterface;

public class BusinessChargeDao implements DaoInterface {

	@Override
	public ArrayList<ModelInterface> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<ModelInterface> getAll(String id) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement smt = null;
		ResultSet rs = null;
		ArrayList<ModelInterface> list = new ArrayList<ModelInterface>();
		
		try {
			smt = conn.prepareStatement("select * from t_charge_rule where business_id=?");
			smt.setInt(1, Integer.parseInt(id));
			rs = smt.executeQuery();
			while(rs.next()){
				Charge c = new Charge();
				c.setChargeId(rs.getString("charge_id"));
//				c.setChargeName(rs.getString("charge_name"));
//				c.setCharge(rs.getString("charge"));
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(ModelInterface model) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement smt = null;
		BusinessCharge bc = (BusinessCharge) model;
		
		try {
			smt = conn.prepareStatement("insert into t_charge_rule(business_id,charge_id) values(?,?)");
			smt.setInt(1, bc.getBusinessID());
			smt.setInt(2, bc.getChargeID());
			return smt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBConnection.closeAll(smt, conn);
		}
		// TODO Auto-generated method stub
		return 0;

	}

	@Override
	public int remove(String id) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement smt = null;
		
		try {
			smt = conn.prepareStatement("delete from t_charge_rule where business_id=?");
			smt.setInt(1, Integer.parseInt(id));
			return smt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBConnection.closeAll(smt, conn);
		}
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
