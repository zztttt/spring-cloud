/**
 * 1.实现HealthIndicator接口
 * 2.类名要求 xxxHealthIndicator xxx将会是你自定义得健康指标名称
 * 3.@Component注入到容器内
 * 4.重写health()方法
 * @author Administrator
 *
 */
package com.pack;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyAppHealthIndicator implements HealthIndicator{
 
	@Override
	public Health health() {
	    if(check()!=0){
	    	return Health.up().build();
	    }
		return Health.down().withDetail("error", "出错了").build();
	}
 
	private int check(){
		// 检测是否健康的自定义逻辑
		return 0;
	}
}
