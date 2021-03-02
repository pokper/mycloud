package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author weihc
 * @date 2021/2/10
 */
@RestController
@Slf4j
public class PaymentController {
	@Resource
	private PaymentService paymentService;

	@Value("${server.port}")
	private String serverPort;

	@PostMapping(value = "/payment/create")
	public CommonResult create(@RequestBody(required=false) Payment payment){
		int result = paymentService.create(payment);
		log.info("******插入结果" + result);
		if (result > 0) {
			return new CommonResult(200, "插入成功,serverPort:" + serverPort , result);
		} else {
			return new CommonResult(444, "插入失败");
		}
	}

	@GetMapping(value = "/payment/get/{id}")
	public CommonResult getPaymentById (@PathVariable Long id) {
		Payment payment = paymentService.getPaymentById(id);
		log.info("******查询结果" + payment);
		if (payment != null) {
			return new CommonResult(200, "查询成功,serverPort:" + serverPort , payment);
		} else {
			return new CommonResult(444, "查询失败");
		}
	}
}
