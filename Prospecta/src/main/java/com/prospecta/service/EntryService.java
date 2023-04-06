package com.prospecta.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prospecta.exception.EntryNotFoundException;
import com.prospecta.model.Entry;
import com.prospecta.model.EntryDto;

@Service
public interface EntryService {

	public Entry saveNewEntry() throws EntryNotFoundException;
	public List<EntryDto> getEntryByCategory(String category)throws EntryNotFoundException;
}
