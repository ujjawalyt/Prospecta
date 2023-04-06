package com.prospecta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;

import com.prospecta.exception.EntryNotFoundException;
import com.prospecta.model.Entry;
import com.prospecta.model.EntryDto;
import com.prospecta.service.EntryService;

@RestController
//@RequestMapping("/")
public class EntryController {

	@Autowired
	private EntryService entryService;
	
	@GetMapping
	public ResponseEntity<String>myWelcomeHandler(){
		return new ResponseEntity<String>("Welcome to Prospecta Assignment.",HttpStatus.CREATED);
	}
	
	@PostMapping("/entries")
	public ResponseEntity<Entry> saveNewEntryHandler()throws EntryNotFoundException{
		
		Entry entry = entryService.saveNewEntry();
		return new ResponseEntity<Entry>(entry, HttpStatus.CREATED);
	}
	
	@GetMapping("/entries/{categories}")
	public ResponseEntity<List<EntryDto>> getByCategoriesHandler(@PathVariable("categories") String categories)throws EntryNotFoundException{
		
		List<EntryDto> entryDto = entryService.getEntryByCategory(categories);
		return new ResponseEntity<List<EntryDto>>(entryDto,HttpStatus.OK);
		
	}
	
}
