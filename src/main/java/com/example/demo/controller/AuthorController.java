package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;

@RestController
public class AuthorController 
{

	@Autowired
	AuthorRepository authorRepository;
	
	@RequestMapping(value="/allAuthorList", method = RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)

	public List<Author> getAllauthor()
	{
		return authorRepository.findAll();
			
	}
	
	@RequestMapping( value= "/addAuthor" , method=RequestMethod.POST)
	public String createSuerDtls(@RequestBody Author autherRequest)
	{
		authorRepository.save(autherRequest);
		return 	"Author inserted";
	}
	
	
}
