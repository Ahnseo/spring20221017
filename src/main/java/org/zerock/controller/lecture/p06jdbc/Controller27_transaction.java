package org.zerock.controller.lecture.p06jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("ex27")
public class Controller27_transaction {
	@Autowired
	private DataSource datasource;

	@RequestMapping("sub01")
	public void method1() throws Exception {
		String sql1 = "UPDATE Bank "
				+ "SET balance = balance - 100 "
				+ "WHERE CustomerId = 2 ";
		
		String sql2 = "UPDATE Bank "
				+ "SET balance = balance + 100 "
				+ "WHERE CustomerId = 1 ";
		
		try(Connection con = datasource.getConnection()){
			
			try {
				con.setAutoCommit(false); // autoCommit disabled
				
				Statement stmt1 = con.createStatement();
				stmt1.executeUpdate(sql1);
				
				//int a = 0;
				//int b = 3/a; : ArithmeticException 발생 시켜서 확인해보자. 롤백하나 안하나.
				
				Statement stmt2 = con.createStatement();
				stmt2.executeUpdate(sql2);	
				
				con.commit();
				
			} catch (Exception e) {
				con.rollback();
			}
		}	
	}
	
	@GetMapping("sub02")
	public void method2() {
		// TODO Auto-generated method stub

	}
	
	@PostMapping("sub02")
	public void method3(@RequestParam("firstName") String firstName, 
						@RequestParam() String lastName,
						int salary) {
		// Employee 테이블 INSERT 쿼리 실행
		// Salary 테이블 INSERT 쿼리 실행
		// 두 쿼리 모두 실행 or 모두 실패 코드작성
		
		String sql1 = "INSERT INTO Employees (FirstName, LastName) VALUES(?, ?) ";
		String sql2 = "INSERT INTO Salary (EmployeeId, Salary) VALUES(?, ?) ";
		
		try ( Connection con = datasource.getConnection();){
			con.setAutoCommit(false);
			
			try(
					PreparedStatement ps1 = con.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
					PreparedStatement ps2 = con.prepareStatement(sql2); 
					){
				ps1.setString(1, firstName);
				ps1.setString(2, lastName);
				ps1.executeUpdate();
				
				try(ResultSet rs = ps1.getGeneratedKeys();) {						
					if ( rs.next() ) {
						int key = rs.getInt(1);
						
						ps2.setInt(1, key);
						ps2.setInt(2, salary);
						ps2.executeUpdate();
					}
					/** 커밋 */
					con.commit();
		
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("ResultSet 오류");
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("PrepareStatement 오류");
				/** 롤백 */
				con.rollback();
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Connection 오류");
		}
	}
	
	@GetMapping("sub03")
	public void ProductNameQuantityGet() {
		
	}
	
	@PostMapping("sub03")
	public void ProductNameQuantityPost (String productName, double price, int quantity) {
		String sql1 = "INSERT INTO Products (ProductName, Price) VALUES (?, ?) ";
		String sql2 = "INSERT INTO OrderDetails (ProductId, Quantity) VALUES (?, ?) ";
		
		try(
				Connection con = datasource.getConnection();
				){
			con.setAutoCommit(false);
			
			try(
					PreparedStatement pstmt1 = con.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS); //상품이름을 등록하면, id .PRIMARY KEY를 얻어서 OrderDetails테이블과 연동
					PreparedStatement pstmt2 = con.prepareStatement(sql2);
					){
				pstmt1.setString(1, productName);
				pstmt1.setDouble(2, price);
				pstmt1.executeUpdate();
				
				try(ResultSet rs = pstmt1.getGeneratedKeys(); ){
					if(rs.next()) {
						int key = rs.getInt(1); // pstmt1 과 pstmt2 연동시키려고. ProductId 이용
						pstmt2.setInt(1, key); // jsp param 아니고, 내가 직접 연동중
						pstmt2.setInt(2, quantity);
						pstmt2.executeUpdate();
						
					}
					con.commit(); // 커밋
					
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("rs 오류");
					
					con.rollback(); // 롤백
				}
				
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("pstmt 오류");
				
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("connection 오류");
			
		}
	}
}







