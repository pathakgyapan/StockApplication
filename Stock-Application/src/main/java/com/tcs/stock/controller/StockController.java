package com.tcs.stock.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.stock.common.ApiResponse;
import com.tcs.stock.model.StockModel;
import com.tcs.stock.service.StockService;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 4800, allowCredentials = "false", methods = {
		RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })

@RestController
@RequestMapping("/StockController")
public class StockController {
	
	@Autowired
	StockService stockService;
	
	@RequestMapping(method = RequestMethod.GET, value="/getAll")
	public ResponseEntity<List<StockModel>> getAll() 
	{
		
		ResponseEntity<List<StockModel>> responseEntity  = null;
		

			List<StockModel> listOfEntries;
			try {
				listOfEntries = stockService.getAllStock();

				if (listOfEntries != null) {
					responseEntity = new ResponseEntity<List<StockModel>>(listOfEntries, HttpStatus.OK);
				} else {
					responseEntity = new ResponseEntity<List<StockModel>>(HttpStatus.NOT_FOUND);
				}
			} catch (Exception e) {
				e.getStackTrace();
			}

		return responseEntity;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/stock/{id}")
	public ResponseEntity<StockModel> getEntryById(@PathVariable(value = "id") String id,
			HttpServletRequest request) {
		System.out.println("StockController :: getEntryById:" + "Entering getEntryById method: ID:" + id);

		StockModel stockModel = null;
		ResponseEntity<StockModel> responseEntity = null;

		try {
			stockModel = stockService.getEntryById(Long.parseLong(id));

			if (stockModel != null) {
				responseEntity = new ResponseEntity<StockModel>(stockModel, HttpStatus.OK);
			} else {
				responseEntity = new ResponseEntity<StockModel>(stockModel, HttpStatus.NOT_FOUND);
			}

		} catch (NumberFormatException e) {
			responseEntity = new ResponseEntity<StockModel>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("StockController :: getEntryById:: Exiting");
		return responseEntity;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/stock")
	public ResponseEntity<ApiResponse> save(@RequestBody StockModel stockModel,
			HttpServletRequest request) {
		System.out.println("StockModelController:: save:: Entering");
		System.out.println("StockModelController:: save:: " + stockModel);

		
		ApiResponse apiResponse = null;
		ResponseEntity<ApiResponse> responseEntity = null;
		

			StockModel resultVo = stockService.save(stockModel);
			
			 if (resultVo != null) {
				try {

					apiResponse = new ApiResponse(200, "Success", "StockModel details saved successfully", "");
					responseEntity = new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);

				} catch (Exception exp) {
					apiResponse = new ApiResponse(200, "StockModel_Details_Saving_Success", ".",
							"");
					responseEntity = new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
				}
			} else {
				apiResponse = new ApiResponse(401, "ERROR", "Error while saving details.");
				responseEntity = new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);
			}
		// End Of Validation If

		System.out.println("StockModelController:: save:: Exiting");
		return responseEntity;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/stock/{id}")
	public ResponseEntity<StockModel> editEntryById(@PathVariable(value = "id") String id,
			HttpServletRequest request, @RequestBody StockModel stockModel) {
		System.out.println("StockModelController :: editEntryById:" + "Entering editEntryById method: ID:" + id);

		ResponseEntity<StockModel> responseEntity = null;

		try {
			stockModel = stockService.editEntryById(Long.parseLong(id), stockModel);

			if (stockModel != null) {
				responseEntity = new ResponseEntity<StockModel>(stockModel, HttpStatus.OK);
			} else {
				responseEntity = new ResponseEntity<StockModel>(stockModel, HttpStatus.NOT_FOUND);
			}

		} catch (NumberFormatException e) {
			responseEntity = new ResponseEntity<StockModel>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("StockModelController :: editEntryById:: Exiting");
		return responseEntity;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/stock/{id}")
	public ResponseEntity<ApiResponse> deleteStock(@PathVariable(value = "id") String id,
			HttpServletRequest request) {
		System.out.println("StockModelController:: delete:: Entering");
//		System.out.println("StockModelController:: save:: " + stockModel);

		
		ApiResponse apiResponse = null;
		ResponseEntity<ApiResponse> responseEntity = null;
		

			String resultVo = stockService.deleteStock(Long.parseLong(id));
			
			 if (resultVo != null) {
				try {

					apiResponse = new ApiResponse(200, "Success", "StockModel details deleted successfully", "");
					responseEntity = new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);

				} catch (Exception exp) {
					apiResponse = new ApiResponse(200, "StockModel_Details_Deleting_Success", ".",
							"");
					responseEntity = new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
				}
			} else {
				apiResponse = new ApiResponse(401, "ERROR", "Error while deleting details.");
				responseEntity = new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);
			}
		// End Of Validation If

		System.out.println("StockModelController:: delete:: Exiting");
		return responseEntity;
	}

}
