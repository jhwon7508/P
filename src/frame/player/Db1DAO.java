package frame.player;

import java.sql.*;
import java.util.ArrayList;

public class Db1DAO {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String url = "jdbc:mysql://localhost:3306/lgtwins";
	String user = "root";
	String password = "1234";

	public Db1DTO select(String s) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. jdbc 드라이버 로딩 성공");
		con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db연결 성공");
		String sql = "select * from db1 where num = ? ";

		ps = con.prepareStatement(sql);
		System.out.println("3. SQL문 객체화 완료");
		ps.setString(1, s);

		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL문 실행 요청");

		Db1DTO dto = null;

		while (rs.next()) {
			dto = new Db1DTO();
			dto.setNum(rs.getString(1));
			dto.setName(rs.getString(2));
			dto.setPosition(rs.getString(3));
			dto.setRdate(rs.getString(4));
			dto.setGame(rs.getString(5));
			dto.setScore(rs.getString(6));
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
		String sql = "select * from db1 ";
		
		ps = con.prepareStatement(sql);
		System.out.println("3. SQL문 객체화 완료");

		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL문 실행 요청");

		Db1DTO dto = null;

		while (rs.next()) {
			dto = new Db1DTO();
			dto.setNum(rs.getString(1));
			dto.setName(rs.getString(2));
			dto.setPosition(rs.getString(3));
			dto.setRdate(rs.getString(4));
			dto.setGame(rs.getString(5));
			dto.setScore(rs.getString(6));
			list.add(dto);
		}
		rs.close();
		ps.close();
		con.close();
		return list;

	}

	public void insert(Db1DTO dto) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. jdbc 드라이버 로딩 성공");
		con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db 연결 성공");
		String sql = "insert into db1 values (?,?,?,?,?,?)";

		ps = con.prepareStatement(sql);
		System.out.println("3. SQL문 객체화 완료");
		ps.setString(1, dto.getNum());
		ps.setString(2, dto.getName());
		ps.setString(3, dto.getPosition());
		ps.setString(4, dto.getRdate());
		ps.setString(5, dto.getGame());
		ps.setString(6, dto.getScore());

		ps.executeUpdate();
		System.out.println("4. SQL문 실행 요청");

		ps.close();
		con.close();

	}

	public void update(Db1DTO dto) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. jdbc 드라이버 로딩 성공");
		con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db 연결 성공");
		String sql = "update db1 set name = ?, position = ?, rdate = ?, game = ?, score = ?  where num = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getName());
		ps.setString(2, dto.getPosition());
		ps.setString(3, dto.getRdate());
		ps.setString(4, dto.getGame());
		ps.setString(5, dto.getScore());
		ps.setString(6, dto.getNum());
		ps.executeUpdate();
		System.out.println("SQL문 실행 성공");
		ps.close();
		con.close();

	}

	public void delete(Db1DTO dto) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. jdbc 드라이버 로딩 성공");
		con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db 연결 성공");
		String sql = "delete from db1 where num = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getNum());

		ps.executeUpdate();
		System.out.println("SQL문 실행 성공");


	}

}