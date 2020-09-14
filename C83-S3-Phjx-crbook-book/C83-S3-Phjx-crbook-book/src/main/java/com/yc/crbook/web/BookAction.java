package com.yc.crbook.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.yc.crbook.bean.CrBook;
import com.yc.crbook.bean.CrBookExample;
import com.yc.crbook.bean.CrShow;
import com.yc.crbook.bean.CrShowExample;
import com.yc.crbook.dao.CrBookMapper;
import com.yc.crbook.dao.CrShowMapper;

@RestController
@RequestMapping("book")
public class BookAction {

	@Resource
	private CrBookMapper bm;
	
	@Resource
	private CrShowMapper csm;
	
	//最新上架
	@GetMapping("getNewBooks")
	public List<CrBook> getNewBooks(){
		//构建图书的查询条件以及排序
		CrBookExample be=new CrBookExample();
		be.setOrderByClause("id desc");
		//分页查询出前12本书
		PageHelper.startPage(1, 12);
		System.out.println(be);
		return bm.selectByExample(be);
	}
	
	
	//查首页的第一个编辑推荐
	@GetMapping("getRecoml")
	public List<CrShow> getRecoml(){
		//构建图书的查询条件以及排序
		CrShowExample cse=new CrShowExample();
		cse.createCriteria().andPageEqualTo("index").andBoardEqualTo("编辑推荐");
		//分页查询出前12本书
		PageHelper.startPage(1, 12);
		return csm.selectByExample(cse);
	}
	
	
}
