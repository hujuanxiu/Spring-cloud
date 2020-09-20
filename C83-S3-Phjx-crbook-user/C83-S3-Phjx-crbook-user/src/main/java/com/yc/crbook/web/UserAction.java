package com.yc.crbook.web;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.crbook.bean.CrUser;
import com.yc.crbook.bean.CrUserExample;
import com.yc.crbook.bean.Result;
import com.yc.crbook.dao.CrUserMapper;

@RestController
@RequestMapping("user")
public class UserAction {
	
	@Resource
	private CrUserMapper uMapper;
	
	@GetMapping("login")
	public Result<CrUser> login(@RequestBody CrUser user) {
		CrUserExample cue=new CrUserExample();
		cue.createCriteria().andAccountEqualTo(user.getAccount()).andPwdEqualTo(user.getPwd());
		
		List<CrUser> list=uMapper.selectByExample(cue);
		
		if(list.isEmpty()) {
			return new Result<CrUser>(0,"用户名或密码错误");
		}else {
			
			return new Result<CrUser>(1, "登录成功", list.get(0));
		}
		
	}
	
	
	@GetMapping("register")
	public Result register(@RequestBody CrUser user) {
		/**
		 * insertSelective是指动态的生成字段，非null字段才会参与insert
		 * insert所有的字段值
		 */
		uMapper.insertSelective(user);
		return new Result(1, "注册成功", user);
		
	}

}
