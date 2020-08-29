package com.yc.C83S3PhjxcloudServer.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestAction {

	@GetMapping("test/test")
	public String test() {
		return "test";
	}
}
