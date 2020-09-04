package com.edgarMoura.stockQuoteManager.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.edgarMoura.stockQuoteManager.Services.QuoteService;
import com.edgarMoura.stockQuoteManager.models.Quote;

@RestController
@RequestMapping("/quotes")
public class QuoteResource {

	
	@Autowired
	private QuoteService quoteService;
	

	@GetMapping(produces = "application/json")
	@ResponseBody
	public ResponseEntity<?> findAll(){
		 List<Quote> quote = this.quoteService.findAll(); 
		 return new ResponseEntity<List>(quote, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<?> find(@PathVariable(value = "id") Long id) {
		 Quote quote = this.quoteService.find(id);
		 return new ResponseEntity<Quote>(quote, HttpStatus.OK);
	}
	
	@PostMapping("/{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	@ResponseBody
	public ResponseEntity<?> create(@PathVariable(value = "id") String id, @RequestBody Quote quote, Errors errors) {
		if(!errors.hasErrors()) {			

			Quote QuoteCreated = this.quoteService.create(quote, id);
			
			return new ResponseEntity<Quote>(QuoteCreated, HttpStatus.CREATED);
		}
		
		
		return ResponseEntity
					.badRequest()
					.body(errors.getAllErrors()
							  .stream()
							  .map(msg -> msg.getDefaultMessage())
							  .collect(Collectors.joining(",")));
	}
	
	@PutMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Quote quote, Errors errors) {
		if(!errors.hasErrors()) {
			Quote quoteUpdated = this.quoteService.update(id, quote);
			return new ResponseEntity<Quote>(quoteUpdated, HttpStatus.OK);
		}
		
		return ResponseEntity
				.badRequest()
				.body(errors.getAllErrors()
						  .stream()
						  .map(msg -> msg.getDefaultMessage())
						  .collect(Collectors.joining(",")));
			
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(value = "id") Long id) {
		this.quoteService.delete(id);
	}
}
