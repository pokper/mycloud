package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author weihc
 * @date 2021/2/23
 */
@RestController
public class MessageController {

	@Resource
	private IMessageProvider iMessageProvider;

	@GetMapping(value = "/sendMessage")
	public String send() {
		return iMessageProvider.send();
	}
}
