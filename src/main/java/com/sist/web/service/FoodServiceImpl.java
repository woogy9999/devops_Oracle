package com.sist.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.dao.FoodRepository;
import com.sist.web.entity.FoodEntity;
import com.sist.web.vo.FoodListVO;

@Service
public class FoodServiceImpl implements FoodService{
	
	@Autowired
	private FoodRepository fDao;
	@Override
	public List<FoodListVO> foodListData(int start, int end) {
		// TODO Auto-generated method stub
		return fDao.foodListData(start, end);
	}

	@Override
	public FoodEntity foodDetailData(int fno) {
		// TODO Auto-generated method stub
		return fDao.findByFno(fno);
	}

	@Override
	public int FoodTotalpage() {
		// TODO Auto-generated method stub
		int count=(int)fDao.count();
		return (int)(Math.ceil(count/12.0));
	}
	
}
