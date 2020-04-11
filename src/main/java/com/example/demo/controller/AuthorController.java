package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;

@RestController
public class AuthorController 
{

	@Autowired
	AuthorRepository authorRepository;
	
	
	
	/*@RequestMapping( value= "/addAuthor" , method=RequestMethod.POST)
	public String createSuerDtls(@RequestBody Author autherRequest)
	{
		authorRepository.save(autherRequest);
		return 	"Author inserted";
	}*/
	
	@RequestMapping( value= "/addAuthor" , method=RequestMethod.POST)
	public ResponseEntity<Author> createAuther(@RequestBody Author autherRequest)
	{
		Author resp=authorRepository.save(autherRequest);
		ResponseEntity response=new ResponseEntity<Author>(resp, HttpStatus.CREATED);
		return response;
	}
	
	@RequestMapping(value="/allAuthorList", method = RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Author> getAllauthor()
	{
		return authorRepository.findAll();
			
	}
	
	@RequestMapping( value= "/updateAuthorById/{id}" , method=RequestMethod.PATCH)
	public ResponseEntity<Author> updateAuthor(@PathVariable (name = "id") Long id,@RequestBody Author autherRequest)
	{
		if(authorRepository.existsById(id))
		{
			autherRequest.setId(id);
			Author updteAuthor = authorRepository.save(autherRequest);
			ResponseEntity resp=new ResponseEntity<Author>(updteAuthor,HttpStatus.CREATED);
			return resp;
		}
		
		else
		{
			ResponseEntity resp = new ResponseEntity<Author>(autherRequest, HttpStatus.NOT_FOUND);
			return resp;
		}
		
	}
	
	
	@RequestMapping( value= "/deleteAuthorById/{id}" , method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteAuther(@PathVariable (name = "id") Long id)
	{
		if(authorRepository.existsById(id))
		{
			
			 authorRepository.deleteById(id);
			ResponseEntity resp=new ResponseEntity<String>("author deleted Successfully",HttpStatus.CREATED);
			return resp;
		}
		
		else
		{
			ResponseEntity resp = new ResponseEntity<String>("author not deleted ", HttpStatus.NOT_FOUND);
			return resp;
		}
		
	}
	
	
}
