package com.cos.mybatisex01.repository;

import org.apache.ibatis.annotations.Mapper;

import com.cos.mybatisex01.model.beans.PaymentBean;

@Mapper
public interface PaymentRepository {
	
	public PaymentBean findByIdAndJoin(int id);
	
}
