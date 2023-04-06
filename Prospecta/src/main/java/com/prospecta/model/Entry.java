package com.prospecta.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entry {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer entryId;
	
	@JsonProperty("API")
	private String title;
	@JsonProperty("Description")
	private String description;
	@JsonProperty("Auth")
	private String auth;
	@JsonProperty("HTTPS")
	private boolean https;
	@JsonProperty("Cors")
	private String cors;
	@JsonProperty("Category")
	private String category;
	
}
