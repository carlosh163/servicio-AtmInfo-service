package com.springboot.appbanco.repo;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.springboot.appbanco.model.AtmInfo;

import reactor.core.publisher.Mono;

@Repository
public interface IAtmInfoRepo extends ReactiveMongoRepository<AtmInfo,String>{

	public Mono<AtmInfo> findByBankNameAndNameRedATM(String bankName,String nameRed);
	
}
