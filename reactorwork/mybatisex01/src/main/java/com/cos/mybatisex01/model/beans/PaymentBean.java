package com.cos.mybatisex01.model.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentBean {
	private int id; // payment
	private String username; // payment
	private String name; //product
	private String code; //product
}
