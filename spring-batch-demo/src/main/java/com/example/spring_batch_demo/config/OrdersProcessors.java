package com.example.spring_batch_demo.config;

import org.springframework.batch.item.ItemProcessor;

import com.example.spring_batch_demo.entity.Orders;

public class OrdersProcessors implements ItemProcessor<Orders, Orders>{

	@Override
	public Orders process(Orders item) throws Exception {
		item.setSales(Math.round(item.getSales()));

		return item;
	}

}