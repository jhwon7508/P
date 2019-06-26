package frame.game;

import java.sql.*;
import java.util.ArrayList;

public class Db2DAO {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String url = "jdbc:mysql://localhost:3306/lgtwins";
	String user = "root";
	String password = "1234";

	public Db2DTO select(String s) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		
		System.out.println("1. jdbc 드라이버 로딩 성공");
		con = DriverManager.getConnection(url, user, password);
		
		System.out.println("2. db연결 성공");
		String sql = "select * from db2 where date = ? ";

		ps = con.prepareStatement(sql);
		System.out.println("3. SQL문 객체화 완료");
		ps.setString(1, s);

		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL문 실행 요청");

		Db2DTO dto = null;

		while (rs.next()) {
			dto = new Db2DTO();
			dto.setDate(rs.getString(1));
			dto.setCompetor(rs.getString(2));
			dto.setStadium(rs.getString(3));
			dto.setOffense(rs.getString(4));
			dto.setDefense(rs.getString(5));
			dto.setNote(rs.getString(6));
		}
		
		rs.close();
		ps.close();
		con.close();
		return dto;

	}

	public ArrayList selectAll() throws Exception {

		ArrayList list = new ArrayList();
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. jdbc 드라이버 로딩 성공");
		con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db 연결 성공");
		String sql = "select * from db2 ";
		
		ps = con.prepareStatement(sql);
		System.out.println("3. SQL문 객체화 완료");

		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL문 실행 요청");

		Db2DTO dto = null;

		while (rs.next()) {
			dto = new Db2DTO();
			dto.setDate(rs.getString(1));
			dto.setCompetor(rs.getString(2));
			dto.setStadium(rs.getString(3));
			dto.setOffense(rs.getString(4));
			dto.setDefense(rs.getString(5));
			dto.setNote(rs.getString(6));
			list.add(dto);
		}
		rs.close();
		ps.close();
		con.close();
		return list;

	}

	public void insert(Db2DTO dto) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. jdbc 드라이버 로딩 성공");
		con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db 연결 성공");
		String sql = "insert into db2 values (?,?,?,?,?,?)";

		ps = con.prepareStatement(sql);
		System.out.println("3. SQL문 객체화 완료");
		ps.setString(1, dto.getDate());
		ps.setString(2, dto.getCompetor());
		ps.setString(3, dto.getStadium());
		ps.setString(4, dto.getOffense());
		ps.setString(5, dto.getDefense());
		ps.setString(6, dto.getNote());

		ps.executeUpdate();
		System.out.println("4. SQL문 실행 요청");

		ps.close();
		con.close();

	}

	public void update(Db2DTO dto) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. jdbc 드라이버 로딩 성공");
		con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db 연결 성공");
		String sql = "update db2 set competor = ?, stadium = ?, offense = ?, defense = ?, note = ?  where date = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, dto.getCompetor());
		ps.setString(2, dto.getStadium());
		ps.setString(3, dto.getOffense());
		ps.setString(4, dto.getDefense());
		ps.setString(5, dto.getNote());
		ps.setString(6, dto.getDate());
		ps.executeUpdate();
		System.out.println("SQL문 실행 성공");
		ps.close();
		con.close();

	}

	public void delete(Db2DTO dto) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. jdbc 드라이버 로딩 성공");
		con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db 연결 성공");
		String sql = "delete from db2 where date = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getDate());

		ps.executeUpdate();
		System.out.println("SQL문 실행 성공");


	}

}