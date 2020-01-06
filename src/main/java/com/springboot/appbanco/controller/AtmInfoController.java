package com.springboot.appbanco.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.appbanco.model.AtmInfo;
import com.springboot.appbanco.service.IAtmInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Api(tags = "ATMInfo")
@RestController
public class AtmInfoController {

	@Autowired
	IAtmInfoService service;
	
	@PostMapping("/Create")
	private Mono<AtmInfo> add (@RequestBody AtmInfo accD){
		
		return service.create(accD);
	}
	
	@ApiOperation(value = "Search all AccountDue", notes = "Returning AccountDues.")
	  @GetMapping("/SearchAll")
	  public Flux<AtmInfo> findAll() {
	    return service.findAll();
	  }

	  @GetMapping("/SearchById/{id}")
	  public Mono<AtmInfo> findById(@PathVariable String id) {
	    return service.findById(id);
	    
	  }

	  @PutMapping("/Edit/{id}")
	  public Mono<AtmInfo> update(@RequestBody AtmInfo accD, @PathVariable String id) {
	    return service.update(accD, id);
	  }

	  @DeleteMapping("/Remove/{id}")
	  public Mono<Void> delete(@PathVariable String id) {
	    return service.delete(id);
	  }
	
	  
	  @ApiOperation(value = "Search all AccountDue", notes = "Returning AccountDues.")
	  @GetMapping("/getAtmByNameBankAndRed/{bankName}/{red}")
	  public Mono<AtmInfo> getAtmByNameBankAndRed(@PathVariable String bankName,@PathVariable String red) {
	    return service.getAtmByNameBankAndRed(bankName, red);
	  }
}
