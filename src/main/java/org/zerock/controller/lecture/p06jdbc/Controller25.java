package org.zerock.controller.lecture.p06jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Instant;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex25")
public class Controller25 {
	@Autowired
	private DataSource dataSource;
	
	@RequestMapping("sub01")
	public void method1(){
		String sql = "INSERT INTO myTable09(col1, col2, col3, col4, col5, col6)VALUES(?,?,?,?,?,?)";
		
		try(
				Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				) {
			pstmt.setInt(1, 99999);
			pstmt.setDouble(2, 9999.99);
			pstmt.setString(3, "hello world");
			pstmt.setString(4, "hihihi");
			pstmt.setString(5, "2022-10-21");
			pstmt.setString(6, "2022-10-21 11:15:59");
			
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개 레코드 입력 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("sub02")
	public void insertMyTable10() {

		String sql = "INSERT INTO myTable10 (name, age, score, address, birthdate, inserted) VALUES(?,?,?,?,?,?) ";
		
		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				) {
			pstmt.setString(1, "AHN HYO JUN");
			pstmt.setInt(2, 32);
			pstmt.setDouble(3, 99.0);
			pstmt.setString(4, "Seoul");
			pstmt.setDate(5, java.sql.Date.valueOf("1989-10-08"));
			pstmt.setTimestamp(6, java.sql.Timestamp.from(Instant.now()));
			
			int cnt = 
			pstmt.executeUpdate();
			
			System.out.println(cnt + "개 레코드 저장됨");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("sub03")
	public void getData() {
		String sql = "SELECT * FROM myTable10 ";
		
		try(Connection con =dataSource.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs =stmt.executeQuery(sql);
				) {
			
			while (rs.next()) {
				String col1 = rs.getString(1);
				int col2 = rs.getInt(2);
				double col3 = rs.getDouble(3);
				String col4 = rs.getString(4);
				java.sql.Date col5 = rs.getDate(5);
				java.sql.Timestamp col6 = rs.getTimestamp(6);
				
				System.out.println(col1);
				System.out.println(col2);
				System.out.println(col3);
				System.out.println(col4);
				System.out.println(col5);
				System.out.println(col6);
				System.out.println("######################");
			}
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}
	
	//연습) database에서 데이터 얻어오기
	//myTable08 조회 코드 작성
	@RequestMapping("sub04")
	public void getdataMyTable09(){
		String sql = "SELECT * FROM myTable09";
		
		try(
			Connection con = dataSource.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
				) {
			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getDouble(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getDate(5));
				System.out.println(rs.getTime(6));
				System.out.println("#######################");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
