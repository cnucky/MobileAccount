package com.mobile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mobile.connection.DBConnection;
import com.mobile.model.Mobiles;
import com.mobile.model.ModelInterface;
import com.mobile.model.Operator;

public class MobilesDao implements DaoInterface {

	@Override
	public ArrayList<ModelInterface> getAll() {
		Connection conn = DBConnection.getConnection();
		PreparedStatement smt = null;
		ResultSet rs = null;
		ArrayList<ModelInterface> list = new ArrayList<ModelInterface>();
		
		try {
			smt = conn.prepareStatement("select * from t_mobiles");
			rs = smt.executeQuery();
			while(rs.next()){
				Mobiles m = new Mobiles();
				m.setMobileNum(rs.getString("mobile_number"));
				m.setMobileType(rs.getString("mobile_type"));
				m.setCardNum(rs.getString("card_number"));
				m.setIsAvail(rs.getString("is_available"));
				list.add(m);
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
	
	public ArrayList<ModelInterface> availNum(String prenum, String type){
		Connection conn = DBConnection.getConnection();
		PreparedStatement smt = null;
		ResultSet rs = null;
		ArrayList<ModelInterface> list = new ArrayList<ModelInterface>();
		
		try {
			if(prenum == null){
				prenum = "%";
			}
			
			if(type == null){
				type = "SIM";
			}
			
			smt = conn.prepareStatement("select * from t_mobiles where mobile_number like ? and mobile_type=? and is_available='y' and mobile_number not in(select mobile_number from t_user)");
			smt.setString(1, prenum);
			smt.setString(2, type);
			rs = smt.executeQuery();
			while(rs.next()){
				Mobiles m = new Mobiles();
				m.setMobileNum(rs.getString("mobile_number"));
				m.setMobileType(rs.getString("mobile_type"));
				m.setCardNum(rs.getString("card_number"));
				m.setIsAvail(rs.getString("is_available"));
				list.add(m);
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
		Mobiles m = null;
		try {
			smt = conn.prepareStatement("select * from t_mobiles where mobile_number=?");
			smt.setString(1, id);
			rs = smt.executeQuery();
			m = new Mobiles();
			if(rs.next()){
				m.setMobileNum(rs.getString("mobile_number"));
				m.setMobileType(rs.getString("mobile_type"));
				m.setCardNum(rs.getString("card_number"));
				m.setIsAvail(rs.getString("is_available"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public int add(ModelInterface model) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement smt = null;
		Mobiles m = (Mobiles) model;
		try {
			smt = conn.prepareStatement("insert into t_mobiles(mobile_number,mobile_type,card_number,is_available) values(?,?,?,?)");
			smt.setString(1, m.getMobileNum());
			smt.setString(2, m.getMobileType());
			String cn = m.getCardNum();
			if(cn == null) cn = "0";
			smt.setString(3, cn);
			smt.setString(4, m.getIsAvail());
			return smt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
