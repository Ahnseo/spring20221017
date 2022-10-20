package org.zerock.controller.lecture.p06jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.lecture.Customer;

@Controller
@RequestMapping("ex24")
public class Controller24_jdbc {

	@Autowired
	private DataSource dataSource;

	@GetMapping("sub01")
	public void listAllCustomers(@ModelAttribute("customerList") ArrayList<Customer> list) throws Exception {
		String sql = "SELECT CustomerID, CustomerName AS name, ContactName, Address, PostalCode, City, Country "
				+ "FROM Customers ORDER BY CustomerID DESC";

		try (Connection con = dataSource.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {

			while (rs.next()) {
				Customer customer = new Customer();

				customer.setCustomerID(rs.getInt("CustomerID"));
				customer.setCustomerName(rs.getString("name"));
				customer.setContactName(rs.getString("ContactName"));
				customer.setAddress(rs.getString("Address"));
				customer.setCity(rs.getString("City"));
				customer.setPostalCode(rs.getString("PostalCode"));
				customer.setCountry(rs.getString("Country"));

				list.add(customer);
			}
		}
	}

	@GetMapping("sub02")
	public String listCustomers(@RequestParam(name = "page", defaultValue = "1") int page,
			@ModelAttribute("customerList") ArrayList<Customer> list,
			@ModelAttribute("pageInfo") HashMap<String, Object> pageInfo) throws SQLException {

		String sql = "SELECT CustomerID, CustomerName AS name, ContactName, Address, PostalCode, City, Country FROM Customers "
				+ "ORDER BY CustomerID DESC " + "LIMIT ?, ?";

		try (Connection con = dataSource.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, (10 * (page - 1)));
			pstmt.setInt(2, 10);

			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					Customer customer = new Customer();

					customer.setCustomerID(rs.getInt("CustomerID"));
					customer.setCustomerName(rs.getString("name"));
					customer.setContactName(rs.getString("ContactName"));
					customer.setAddress(rs.getString("Address"));
					customer.setCity(rs.getString("City"));
					customer.setPostalCode(rs.getString("PostalCode"));
					customer.setCountry(rs.getString("Country"));

					list.add(customer);
				}
			}
		}
		// 총 고객 수
		sql = "SELECT COUNT(*) FROM Customers";

		int cnt = 1; //기본설정 1
		try (Connection con = dataSource.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {

			if (rs.next()) {
				cnt = rs.getInt(1);
			}
		}
		
		int lastPage = (cnt - 1) / 10 + 1; //고객 정보 10개 마다 페이지 갯수
		// leftPage 와 rightPage를 설정하는이유 : 10개 선택을 만들기 위해.
		int leftPage = Math.max(page - 5, 1); // current page 기준으로, 둘중 큰 숫자로 선택. 무조선 1이거나 1보다 크거나 해야지.
		pageInfo.put("total", cnt);
		
		pageInfo.put("firstPage", 1 );
		pageInfo.put("lastPage", lastPage);
		
		pageInfo.put("current", page);
		
		pageInfo.put("leftPage", leftPage);
		pageInfo.put("rightPage", Math.min(leftPage + 9, lastPage));//둘중 작은 숫자로 선택 , 
																	//많은 고객 정보로 lastPage가 10보다 커졌었잖아? 
																	//그러니까 계속 10만큼 설정되다가, 마지막으로 가면 페이지 갯수가 10 아래로 줄어들지. 

		return "ex24/sub01";
	}
}
