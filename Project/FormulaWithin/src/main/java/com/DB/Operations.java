package com.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

public class Operations {
	//get,add,check,update,delete  add,
	
	public void addFormula(String formulaName , String formulaExp) throws Exception {
		try(Connection con = JDBCUtils.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into formulas(formula_name,formula_expression,created_at,modified_at,user_id) values(?,?,?,?,?)")){
			LocalDateTime ld = LocalDateTime.now();
			ps.setString(1, formulaName);
			ps.setString(2, formulaExp);
			ps.setString(3, ld.toString());
			ps.setString(4, ld.toString());
			ps.setInt(5,1);
			ps.execute();
		}
	}
	
	public void updateFormula(String formulaName , String formulaExp) throws Exception {
		try(Connection con = JDBCUtils.getConnection();
			PreparedStatement ps = con.prepareStatement("update formulas set formula_expression = ? , modified_at = ? where formula_name = ?")){
			LocalDateTime ld = LocalDateTime.now();
			ps.setString(1,formulaExp);
			ps.setString(2, ld.toString());
			ps.setString(3, formulaName);
			ps.executeUpdate();
		}
	}
	
	public void deleteFormula(String formulaName) throws Exception {
		try(Connection con = JDBCUtils.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from formulas where formula_name like ?")){
			ps.setString(1,formulaName);
			ps.executeUpdate();
		}
	}
	
	public Map<String,String> getFormulas() throws Exception {
		return getFormulas(false);
	}
	
	public Map<String,String> getFormulas(boolean orderingNeeded) throws Exception {
		Map<String, String> expressions = new LinkedHashMap<>();
		try(Connection con = JDBCUtils.getConnection();
			PreparedStatement ps = con.prepareStatement("select formula_name,formula_expression from formulas order by ?")){
			if(orderingNeeded) {
				ps.setString(1, "order_id");
			}
			else {
				ps.setString(1, "formula_name");
			}
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String name = rs.getString("formula_name");
				String exp = rs.getString("formula_expression");
				expressions.put(name, exp);
			}
		}
		return expressions;
	}
	
	public int getId(String formula_name) throws SQLException {
		try(Connection con = JDBCUtils.getConnection();
			PreparedStatement ps = con.prepareStatement("select formula_id from formulas where formula_name = ?");){
			ps.setString(1, formula_name);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			return -1;
		}		
	}
	
	public void addResult(String formula_name , float num) throws Exception{
		int id = getId(formula_name);
		LocalDateTime ld = LocalDateTime.now();
		try(Connection con = JDBCUtils.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into result(formula_id,formula_result,executed_at,executed_by) values(?,?,?,?)")){
			ps.setInt(1, id);
			ps.setFloat(2, num);
			ps.setString(3, ld.toString());
			ps.setInt(4, 1);
			ps.execute();
		}
	}
	
	
}
