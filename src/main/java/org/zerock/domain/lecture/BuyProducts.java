package org.zerock.domain.lecture;

import java.util.List;

import lombok.Data;

@Data
public class BuyProducts {
	private int id;
	private String name;
	private List<Orders> orderIds;

}
