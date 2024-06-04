package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import jp.co.aforce.bean.MemberBean;

public class MemberDAO extends DAO{
	public void search(MemberBean member)throws Exception {
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement
				("select * from member_info where login_id =?");
		st.setString(1, member.getLogin_id());
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			member.setMember_id(rs.getString("member_id"));
			member.setLast_name(rs.getString("last_name"));
			member.setFirst_name(rs.getString("first_name"));
			member.setGender(rs.getString("gender"));
			member.setBirth_year(rs.getInt("birth_year"));
			member.setBirth_month(rs.getInt("birth_month"));
			member.setBirth_day(rs.getInt("birth_day"));
			member.setJob(rs.getString("job"));
			member.setPhone_number(rs.getString("phone_number"));
			member.setMail_address(rs.getString("mail_address"));
		}
		
		st.close();
		con.close();
	}
	
	public void insert
	(MemberBean member, String last_name, String first_name, String gender, int birth_year, 
	int birth_month, int birth_day, String phone_number, String mail_address, String job)
	throws Exception{
		Connection con =getConnection();
		
		Date date = new Date();
		SimpleDateFormat str = new SimpleDateFormat("yyMMddHHmmss");
		String member_number="A"+str.format(date);
		
		PreparedStatement st= con.prepareStatement
			("insert into member_info(member_id, login_id, last_name, first_name, gender, "
			+ "birth_year, birth_month, birth_day, job, phone_number, mail_address)"
			+ "values(?,?,?,?,?,?,?,?,?,?,?)");
		st.setString(1, member_number);
		st.setString(2, member.getLogin_id());
		st.setString(3, last_name);
		st.setString(4, first_name);
		st.setString(5, gender);
		st.setInt(6, birth_year);
		st.setInt(7, birth_month);
		st.setInt(8, birth_day);
		st.setString(9, job);
		st.setString(10, phone_number);
		st.setString(11, mail_address);
		
		
		st.executeUpdate();
		
		st.close();
		con.close();
	}
	
	public void delete(String login_id) throws Exception{
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement
				("delete from member_info where login_id = ?");
		st.setString(1, login_id);
		st.executeUpdate();
		
		st.close();
		con.close();
	}
	
	public void update
		(String last_name, String first_name, String gender, int birth_year, int birth_month,
		int birth_day, String job, String phone_number, String mail_address, String login_id)
		throws Exception{
		Connection con = getConnection();
		PreparedStatement st= con.prepareStatement
				("update member_info set last_name=?,first_name=?, gender=?, birth_year=?,"
				+ "birth_month=?, birth_day=?, job=?, phone_number=?, mail_address=?"
				+ "where login_id=?  ");
		st.setString(1, last_name);
		st.setString(2, first_name);
		st.setString(3, gender);
		st.setInt(4, birth_year);
		st.setInt(5, birth_month);
		st.setInt(6, birth_day);
		st.setString(7, job);
		st.setString(8, phone_number);
		st.setString(9, mail_address);
		st.setString(10, login_id);
		
		st.executeUpdate();
		
		st.close();
		con.close();
	}
}
