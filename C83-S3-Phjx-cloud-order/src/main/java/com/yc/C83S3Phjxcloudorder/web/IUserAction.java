package com.yc.C83S3Phjxcloudorder.web;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "user",fallback = UserActionHytrix.class)    //网元名称  服务名
public interface IUserAction {
	
	@GetMapping("user")  //对应是action的地址
	public String user();

}
