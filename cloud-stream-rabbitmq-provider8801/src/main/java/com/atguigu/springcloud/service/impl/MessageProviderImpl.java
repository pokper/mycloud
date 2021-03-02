package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author weihc
 * @date 2021/2/23
 */
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {

	@Resource
	private MessageChannel output;
	@Override
	public String send() {
		String string = UUID.randomUUID().toString();
		output.send(MessageBuilder.withPayload(string).build());
		return string;
	}
}
