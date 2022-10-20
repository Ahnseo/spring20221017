package org.zerock.controller.lecture.p06jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.lecture.Customer;

@Controller
@RequestMapping("ex23")
public class Controller23 {

	@Autowired
	private DataSource dataSource;
	
//  /ex23/sub01
	@RequestMapping("sub01")
	public String method1(RedirectAttributes rttr) {//RedirectAttributes  rttr.addFlashAttribute
		String sql = "SELECT CustomerID, CustomerName FROM Customers";

		try (	Connection con = dataSource.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql); 
			)
		{
			List<Customer> list = new ArrayList<>();
			while(rs.next()) {
				Customer c = new Customer();
				c.setCustomerID(rs.getInt("CustomerID"));
				c.setCustomerName(rs.getString("CustomerName"));
				
				list.add(c);
			
				rttr.addFlashAttribute("customer", list);		
			}			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/ex23/sub02";
	}
	
	//콘솔 출력 보려고 만든 메소드2.. 마지막만 나오네 .. 잘 안되네..
	@RequestMapping("sub02")
	public void method2(@ModelAttribute("customer") Customer customer) {
		
		System.out.println(customer);
		
	}
}
