package org.zerock.domain.lecture;

import lombok.Data;

@Data
public class Orders {

	private int orderId;
	private int customerId;
	private int employeeId;
	private int supplierId;
}
