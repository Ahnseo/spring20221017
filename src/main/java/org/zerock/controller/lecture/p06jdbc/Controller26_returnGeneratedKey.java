package org.zerock.controller.lecture.p06jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex26")
public class Controller26_returnGeneratedKey {

	@Autowired
	private DataSource datasource;
	
	@RequestMapping("sub01")
	public void method1() {
		String sql = "INSERT INTO Customers (CustomerName) VALUES(?) ";
		
		try(Connection con = datasource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // = 1
		   ){
			pstmt.setString(1, "ahnseoj");
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				int newKey = rs.getInt(1);
				System.out.println(newKey + "번 클라이언트가 입력함");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//연습) returnGeneratedKey 메소드 만들기
	// DB 저장도 하고, 콘솔 출력 returnGeneratedKey
	@RequestMapping("sub02")
	public void returnGeneratedKey() {
		String sql = "INSERT INTO Customers (CustomerName) VALUES(?) ";
		
		try (Connection con = datasource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql, 1);
				){
			pstmt.setString(1, "CHOI");
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next()) {
				
					int newKey = rs.getInt(1);
					System.out.println( newKey + "번째 고객이 게시물을 작성함");
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
