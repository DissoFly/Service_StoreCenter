package org.everyday2point5.fivestore.service;


import java.util.List;

import org.everyday2point5.fivestore.entity.Goods;
import org.everyday2point5.fivestore.entity.GoodsList;
import org.everyday2point5.fivestore.entity.InboxList;
import org.everyday2point5.fivestore.repository.IGoodsListRepository;
import org.everyday2point5.fivestore.repository.IGoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Component
@Service
@Transactional
public class DefaultGoodsListService implements IGoodsListService{
	
	@Autowired
	IGoodsListRepository goodsListRepo;
	@Autowired
	IGoodsRepository goodsRepo;
	
	@Override
	public GoodsList save(GoodsList goods) {
		return goodsListRepo.save(goods);
	}
	
	@Override
	public Page<GoodsList> findAllGoodsList(int page) {
		Sort sort = new Sort(Direction.DESC, "createTime");
		PageRequest request = new PageRequest(page, 10, sort);
		return goodsListRepo.findAll(request);
	}
	
	@Override
	public Page<GoodsList> findSellerGoodsList(String user_name, int page) {
		Sort sort = new Sort(Direction.DESC, "createTime");
		PageRequest request = new PageRequest(page, 10, sort);
		return goodsListRepo.findSellerGoodsList(user_name, request);
	}

	@Override
	public GoodsList findGoodsListById(int id) {
		
		return goodsListRepo.findGoodsListById(id);
	}

	@Override
	public List<Goods> findGoodsInList(int[] id, int page) {
		Sort sort = new Sort(Direction.DESC, "createDate");
		PageRequest request = new PageRequest(page, 10, sort);
		return goodsRepo.findGoodsInList(id, request);
	}



}
