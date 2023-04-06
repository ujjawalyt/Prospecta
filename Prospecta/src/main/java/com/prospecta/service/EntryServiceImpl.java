package com.prospecta.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prospecta.exception.EntryNotFoundException;
import com.prospecta.model.AllEntryDto;
import com.prospecta.model.Entry;
import com.prospecta.model.EntryDto;
import com.prospecta.repository.EntryRepository;

@Service
public class EntryServiceImpl implements EntryService {

	@Autowired
	private EntryRepository entryRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	

	@Override
	public Entry saveNewEntry() throws EntryNotFoundException {
		
		String url ="https://api.publicapis.org/random";
		ResponseEntity<AllEntryDto> res = restTemplate.getForEntity(url, AllEntryDto.class);
		
		Entry entry = res.getBody().getAllentries().get(0);
		entryRepository.save(entry);
		
		return entry;
	}

	@Override
	public List<EntryDto> getEntryByCategory(String category) throws EntryNotFoundException {
		
		String url = "https://api.publicapis.org/entries";
		  
		  ResponseEntity<AllEntryDto> res = restTemplate.getForEntity(url, AllEntryDto.class);
		  
		  List<EntryDto> entryDto = res.getBody().getAllentries()
				  .stream()
				  .filter(c-> category.equals(c.getCategory()))
				  .map(m-> new EntryDto(m.getTitle(),m.getDescription()))
				  .collect(Collectors.toList());
		
		  if(entryDto.size()==0) {
			  throw new  EntryNotFoundException("Entry with this category not found -"+ category);
		  }
		  
		  
			return entryDto;
	}
	
	
	
}
