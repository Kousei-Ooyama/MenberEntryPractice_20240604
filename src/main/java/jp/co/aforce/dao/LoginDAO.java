package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.bean.MemberBean;

public class LoginDAO extends DAO{
	public MemberBean search(String login_name, String password) throws Exception{
		MemberBean member = null;
		
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement
			("SELECT * FROM login WHERE login_name=? AND password=?");
		st.setString(1, login_name);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			member= new MemberBean();
			member.setLogin_id(rs.getString("login_id"));
			member.setLogin_name(rs.getString("login_name"));
			member.setPassword(rs.getString("password"));
		}
		
		st.close();
		con.close();
		return member;
	}
	
	public MemberBean search(String login_name) throws Exception{
		MemberBean member = null;
		
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement
			("SELECT * FROM login WHERE login_name=?");
		st.setString(1, login_name);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			member= new MemberBean();
			member.setLogin_id(rs.getString("login_id"));
			member.setLogin_name(rs.getString("login_name"));
			member.setPassword(rs.getString("password"));
		}
		
		st.close();
		con.close();
		return member;
	}
	
	public void insert(String login_name, String password)throws Exception{
		Connection con = getConnection();
		
		int count = count() + 1;
		String login_id=null;
		if(String.valueOf(count).length() < 6) {
			login_id ="L"+String.format("%06d", count);
		}else {
			login_id="L"+count;
		}
		
		
		PreparedStatement st= con.prepareStatement
				("INSERT INTO login(login_id, login_name, password) values(?,?,?)");
		st.setString(1, login_id);
		st.setString(2, login_name);
		st.setString(3, password);
		st.executeUpdate();
		
		st.close();
		con.close();
	}
	
	public int count() throws Exception{
		Connection con = getConnection();
		PreparedStatement st= con.prepareStatement("select * from login");
		ResultSet rs=st.executeQuery();
		
		int count = 0;
		while(rs.next()) {
			count++;
		}
		
		st.close();
		con.close();
		return count;
	}
	
	public void delete(String login_id) throws Exception{
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement
				("delete from login where login_id = ?");
		st.setString(1, login_id);
		st.executeUpdate();
		
		st.close();
		con.close();
	}
	
}
