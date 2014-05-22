package com.mobile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mobile.connection.DBConnection;
import com.mobile.model.ModelInterface;
import com.mobile.model.Operator;
import com.mobile.utils.MD5;


public class OperatorDao implements DaoInterface {

	public Operator login(String id, String pwd){
		Connection conn = DBConnection.getConnection();
		PreparedStatement smt = null;
		ResultSet rs = null;
		
		try {
			smt = conn.prepareStatement("select * from t_operator where operator_id=? and operator_pwd=?");
			smt.setString(1, id);
			smt.setString(2, pwd);
			
			rs = smt.executeQuery();
			
			if(rs.next()==true)	{
				Operator oper = new Operator();
				oper.setOperatorId(rs.getString("operator_id"));
				oper.setOperatorName(rs.getString("operator_name"));
				oper.setOperatorPwd(rs.getString("operator_pwd"));
				oper.setIsAdmin(rs.getString("is_admin"));
				
				return oper;
			}
			else{
				return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBConnection.closeAll(rs, smt, conn);
		}
		return null;
	}
	
	public ArrayList<ModelInterface> query(String id, String name){
			
			Connection conn = DBConnection.getConnection();
			PreparedStatement smt = null;
			ResultSet rs = null;
			ArrayList<ModelInterface> list = new ArrayList<ModelInterface>();
			
			try {
				smt = conn.prepareStatement("select * from t_operator where operator_id=? or operator_name=?");
				smt.setString(1, id);
				smt.setString(2, name);
				
				rs = smt.executeQuery();
				
				while(rs.next()){
					Operator o = new Operator();
					o.setOperatorId(rs.getString("operator_id"));
					o.setOperatorName(rs.getString("operator_name"));
					o.setOperatorPwd(rs.getString("operator_pwd"));
					o.setIsAdmin(rs.getString("is_admin"));
					
					list.add(o);
					
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

	public ArrayList<ModelInterface> query(int page, int size){
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement smt = null;
		ResultSet rs = null;
		ArrayList<ModelInterface> list = new ArrayList<ModelInterface>();
		
		try {
			smt = conn.prepareStatement("select * from t_operator limit ?, ? ;");
			smt.setInt(1,  (page-1)*size );
			smt.setInt(2,  size);
			
			rs = smt.executeQuery();
			
			while(rs.next()){
				Operator o = new Operator();
				o.setOperatorId(rs.getString("operator_id"));
				o.setOperatorName(rs.getString("operator_name"));
				o.setOperatorPwd(rs.getString("operator_pwd"));
				o.setIsAdmin(rs.getString("is_admin"));
				
				list.add(o);
				
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
	
	@Override
	public ArrayList<ModelInterface> getAll() {
		Connection conn = DBConnection.getConnection();
		Statement smt = DBConnection.getStatement(conn);
		ResultSet rs = null;
		ArrayList<ModelInterface> list = new ArrayList<ModelInterface>();
		
		try {
			rs = smt.executeQuery("select * from t_operator");
			while(rs.next()){
				Operator o = new Operator();
				o.setOperatorId(rs.getString("operator_id"));
				o.setOperatorName(rs.getString("operator_name"));
				o.setOperatorPwd(rs.getString("operator_pwd"));
				o.setIsAdmin(rs.getString("is_admin"));
				
				list.add(o);
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

	@Override
	public ModelInterface getObjectById(int id) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement smt = null;
		ResultSet rs = null;
		
		try {
			smt = conn.prepareStatement("select * from t_operator where operator_id= ?");
			smt.setString(1, id+"");
			rs = smt.executeQuery();
			
			if(rs.next()==true)	{
				Operator oper = new Operator();
				oper.setOperatorId(rs.getString("operator_id"));
				oper.setOperatorName(rs.getString("operator_name"));
				oper.setOperatorPwd(rs.getString("operator_pwd"));
				oper.setIsAdmin(rs.getString("is_admin"));
				
				return oper;
			}
			else return null;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DBConnection.closeAll(rs, smt, conn);
		}
		return null;
	}

	@Override
	public int add(ModelInterface model) {
		Operator o = (Operator)model;
		Connection conn = DBConnection.getConnection();
		PreparedStatement smt = null; 
		
		try {
			smt = conn.prepareStatement("insert into t_operator values(?, ?, ?, ?);");
			smt.setString(1, o.getOperatorId());
			smt.setString(2, o.getOperatorName());
			smt.setString(3, o.getOperatorPwd());
			//smt.setString(3, MD5.md5(o.getOperatorPwd()));
			smt.setString(4, o.getIsAdmin());
			
			return smt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBConnection.closeAll(smt, conn);
		}
		
		return 0;
	}

	@Override
	public int remove(int id) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement smt = null;
		
		try {
			smt = conn.prepareStatement("delete from t_operator where operator_id= ?");
			smt.setString(1, id+"");
			return smt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DBConnection.closeAll(smt, conn);
		}
		return 0;
	}

	@Override
	public int update(ModelInterface model) {
		Operator o = (Operator)model;
		Connection conn = DBConnection.getConnection();
		PreparedStatement smt = null; 
		
		try {
			smt = conn.prepareStatement("update t_operator set operator_name=?,opetator_pwd=?,is_admin=? where operator_id=?");
			smt.setString(1, o.getOperatorName());
			smt.setString(2, o.getOperatorPwd());
			smt.setString(3, o.getIsAdmin());
			smt.setString(4, o.getOperatorId());
			
			return smt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBConnection.closeAll(smt, conn);
		}
		
		return 0;
	}

	@Override
	public ModelInterface getObjectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int remove(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
