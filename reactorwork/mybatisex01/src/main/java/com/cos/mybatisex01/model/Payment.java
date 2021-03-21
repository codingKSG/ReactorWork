package com.cos.mybatisex01.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment{
	private int id;
	private int productId;
	private String username;
}

