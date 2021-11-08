package com.intern.gunshop.dto;

import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderDTO {

	private int order_id;
	private String user_name;
	private Timestamp ordered_date;
	private int total_price;
	private String order_status;
}
