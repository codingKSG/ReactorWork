package com.cos.mybatisex01.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cos.mybatisex01.model.beans.PaymentBean;
import com.cos.mybatisex01.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PaymentController {

	private final PaymentRepository paymentRepository;
	
	@GetMapping("/payment/{id}")
	public PaymentBean findById(@PathVariable int id) {
		return paymentRepository.findByIdAndJoin(id);
	}
}
