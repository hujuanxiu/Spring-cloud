package com.yc.crbook.web.remote;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yc.crbook.bean.CrBook;
import com.yc.crbook.bean.CrBookWithBLOBs;
import com.yc.crbook.bean.CrShow;
import com.yc.crbook.bean.CrUser;
import com.yc.crbook.bean.Result;

@FeignClient("crbook")
public interface IBookAction {

	@GetMapping("book/getNewBooks")
	List<CrBook> getNewBooks();
	
	@GetMapping("book/getRecoml")
	List<CrShow> getRecoml();
	
	@GetMapping("book/getById")
	CrBookWithBLOBs getById(@RequestParam int id);
}
