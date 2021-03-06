package com.yc.crbook.web;

import java.util.List;



import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.yc.crbook.bean.CrBook;
import com.yc.crbook.bean.CrCart;
import com.yc.crbook.bean.CrShow;
import com.yc.crbook.bean.CrUser;
import com.yc.crbook.bean.Result;
import com.yc.crbook.web.remote.IBookAction;
import com.yc.crbook.web.remote.IUserAction;

@Controller
@SessionAttributes("loginedUser")
public class IndexAction {
	
	@Resource
	private IBookAction baction;
	
	@Resource
	private IUserAction uaction;
	
	
	@GetMapping("/")
	public String index(Model model) {
		// 从book 网页获取 最新图书 12本
		// 使用 FeIgn 远程调用 book 的服务
		// 1 定义一个接口,用于访问远程服务
		// 2 调用远程服务
		List<CrBook> newBooks=baction.getNewBooks();
		//推送给页面
		model.addAttribute("newBooks", newBooks);
		//第一个编辑推荐
		List<CrShow> recoml=baction.getRecoml();
		model.addAttribute("recoml", recoml);
		return "index";
	}
	
	@GetMapping(path = {"tologin","login.html"})
	public String tologin() {
		return "login";
	}
	
	@GetMapping(path= {"logout"})
	// SessionStatus 用于终止会话
	public String logout(SessionStatus ss) {
		ss.setComplete();
		return "index";
	}
	
	/**
	 *  @RestController 控制器存会话, 必须获取HttpSession对象
	 *  @Controller 控制器存会话, 使用 @SessionAttributes 
	 */
	@PostMapping("login")
	public String login(@Valid CrUser user,Errors errors,Model model) {
		
		//验证用户输入的数据是否正确
		if(errors.hasFieldErrors("account") || errors.hasFieldErrors("pwd")) {
			// 讲用户填写的数据传回页面
			model.addAttribute("user", user);
			model.addAttribute("errors", errors.getFieldError());
			return "login";
		}
		//发起远程服务调用，传递2个参数（用户名，密码）
		Result<CrUser> res=uaction.login(user);
		//根据返回的结果，如果正确跳转首页
		if(res.getCode()==1) {
			/**
			 * Feign对于Result.data的类型，如果data是Object类型，会将器转为LinkedHashMap
			 *     使用泛型那么feign就能正确转型
			 */
			model.addAttribute("loginedUser", res.getData());
			return index(model);
		}else {
			//如果错误，跳转回登录页defaultMessage
			errors.rejectValue("account", "AccountOrPwdError","用户名或密码错误");
			model.addAttribute("errors", errors.getFieldErrors());
			return "login";
		}
		
	}
	
	@GetMapping(path = {"toreg","register.html"})
	public String toreg() {
		return "register";
	}
	
	@PostMapping("register")
	public String register(@Valid CrUser user,Errors errors,Model model,String repwd) {
		
		
		if(repwd==null || repwd.trim().isEmpty()) {
			errors.rejectValue("pwd", "repwdError", "请输入确认密码");
			
		}
		if(repwd.equals(user.getPwd())==false) {
			errors.rejectValue("pwd", "repwdError", "两次输入的密码不一致");
			
		}
		// 验证用户输入的数据是否正确
		if (errors.hasErrors()) {
			// 讲用户填写的数据传回页面
			model.addAttribute("user", user);
			model.addAttribute("errors", errors.getFieldError());
			return "register";
		}
		// 发起远程服务调用，传递2个参数（用户名，密码）
		Result res = uaction.login(user);
		// 根据返回的结果，如果正确跳转首页
		if (res.getCode() == 1) {
			model.addAttribute("loginedUser", res.getData());
			return index(model);
		} else {
			// 如果错误，跳转回注册页defaultMessage
			model.addAttribute("errors", errors.getFieldErrors());
			return "register";
		}
		
		
	}
	
	
	@GetMapping(path = {"book","book.html"})
	public String tobook(int id,Model model) {
		model.addAttribute("book", baction.getById(id));
		return "book";
	}
	
	@GetMapping("tocart")
	public String toCart(@SessionAttribute CrUser loginedUser,Model model) {
		List<CrCart> carts=uaction.findByUid(loginedUser.getId());
		model.addAttribute("carts", carts);
		return "cart";
	}
	
	
	
	

}
