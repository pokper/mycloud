package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author weihc
 * @date 2021/2/18
 */
@Configuration
public class MySelfRule {
	@Bean
	public IRule myRule() {
		return new RandomRule();
	}
}
