package com.sist.web.service;

import java.util.List;


import com.sist.web.entity.FoodEntity;
import com.sist.web.vo.FoodListVO;

public interface FoodService {

	public List<FoodListVO> foodListData(int start, int end);
	public FoodEntity foodDetailData(int fno);
	public int FoodTotalpage();
	
}
