package com.tcs.stock.dao;

import org.springframework.data.repository.CrudRepository;

import com.tcs.stock.model.StockModel;

public interface StockDao extends CrudRepository<StockModel, Long>
{
	

}
