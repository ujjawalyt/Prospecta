package com.prospecta.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllEntryDto {

	@JsonProperty("count")
	private Integer count;
	@JsonProperty("entries")
	private List<Entry> allentries;
}
