package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.web.service.FoodService;
import java.util.*;

import com.sist.web.entity.FoodEntity;
import com.sist.web.service.*;
import com.sist.web.vo.*;
@Controller
public class FoodController {
	@Autowired
	private FoodService fService;
	
	@GetMapping("/")  // 파일명 / redirect => 파일에 출력할 데이터 , 파일명 전송
	public String food_main(@RequestParam(name="page",required = false) String page,Model model)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=(rowSize*curpage);
		
		List<FoodListVO> list=fService.foodListData(start, end);
		int totalpage=fService.FoodTotalpage();
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		 
		model.addAttribute("list",list);
		model.addAttribute("curpage",curpage);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		model.addAttribute("totalpage",totalpage);
		
		return "index";
	}
	
	@GetMapping("/detail")
	public String food_detail(@RequestParam("fno") int fno, Model model)
	{
		FoodEntity vo=fService.foodDetailData(fno);
		model.addAttribute("vo",vo);
		return "detail"; 
	}
}
