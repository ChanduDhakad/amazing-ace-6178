package com.foodwala.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foodwala.exception.ResturentException;
import com.foodwala.model.Restaurant;
import com.foodwala.service.ResturentService;

@RestController
public class ResturentController {
	@Autowired
	public ResturentService rService;
	
	@PostMapping("/resturent")
	public ResponseEntity<Restaurant> SaveResturentObject(@RequestBody Restaurant resturent){
	Restaurant savedResturent=	rService.SaveResturent(resturent);
	
	return new ResponseEntity<Restaurant>(savedResturent,HttpStatus.OK);
		
		
	}
	
	@PutMapping("/resturent")
	public ResponseEntity<Restaurant> UpdateResturent(@RequestBody Restaurant returent) throws ResturentException{
		
		Restaurant updatedResturent=rService.UpdateResturent(returent);
		
		return new ResponseEntity<>(updatedResturent,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/resturent")
	public ResponseEntity<String> delateResturent(@RequestBody Restaurant resturent) throws ResturentException{
		
		String result=rService.DelateResturent(resturent);
		
		return new ResponseEntity<String>(result,HttpStatus.OK);
		
	}
	
	@GetMapping("/resturent")
	public ResponseEntity<Restaurant> ShowResturent(@RequestBody Restaurant resturent) throws Exception{
		
	Restaurant res=rService.viewResturent(resturent);
	
	return new ResponseEntity<Restaurant>(res,HttpStatus.OK);
	
		
	}

}
