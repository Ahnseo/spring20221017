package org.zerock.domain.stock;

import lombok.Data;

@Data
public class Stock {
	private int id;
	private String categoryId;
	private String brand;
	private String name;
	private int quantity;
	private int unit;
	private double price;
	private String storage;
}
