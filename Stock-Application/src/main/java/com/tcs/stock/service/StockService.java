package com.tcs.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tcs.stock.dao.StockDao;
import com.tcs.stock.model.StockModel;

@Service
public class StockService {
	
	@Autowired
	StockDao stockDao;

	public List<StockModel> getAllStock() {
		// TODO Auto-generated method stub
		
		List<StockModel> entry = null;
		
		entry = (List<StockModel>) stockDao.findAll();
		
		return entry;
	}

	public StockModel getEntryById(long id) {
		// TODO Auto-generated method stub
		
		StockModel entry = null;
		entry = stockDao.findById(id).get();
		
		return entry;
	}

	public StockModel save(StockModel stockModel) {
		// TODO Auto-generated method stub
		StockModel entry = null;
		entry = stockDao.save(stockModel);
		return entry;
	}

	public StockModel editEntryById(long id, StockModel stockModel) {
		// TODO Auto-generated method stub
		StockModel entry = null;
		
		entry = stockDao.findById(id).get();
		stockModel.setId(entry.getId());
		entry = stockDao.save(stockModel);
		
		return entry;
	}

	public String deleteStock(long id) {
		// TODO Auto-generated method stub
		StockModel entry = null;
		
		entry = stockDao.findById(id).get();
		
		stockDao.deleteById(id);
		
		return "Deleted";
	}

}
