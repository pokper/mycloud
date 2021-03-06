package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.concurrent.locks.Lock;

/**
 * @author weihc
 * @date 2021/2/11
 */
@RestController
@Slf4j
public class OrderController {
	private static final String PAYMENT_URL = "http://cloud-payment-service";
	@Resource
	private RestTemplate restTemplate;

	@GetMapping(value = "/consumer/payment/create")
	public CommonResult<Payment> create (Payment payment) {
		return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
	}

	@GetMapping(value = "/consumer/payment/get/{id}")
	public CommonResult<Payment> getPaymentById (@PathVariable Long id) {
		return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
	}

	// ====================> zipkin+sleuth
	@GetMapping("/consumer/payment/zipkin")
	public String paymentZipkin()
	{
		String result = restTemplate.getForObject("http://localhost:8001"+"/payment/zipkin", String.class);
		return result;
	}
}
