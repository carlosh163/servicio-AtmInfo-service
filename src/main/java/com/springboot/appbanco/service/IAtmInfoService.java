package com.springboot.appbanco.service;

import com.springboot.appbanco.model.AtmInfo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IAtmInfoService {

	public Flux<AtmInfo> findAll();

	public Mono<AtmInfo> findById(String id);

	public Mono<AtmInfo> update(AtmInfo perso, String id);

	public Mono<Void> delete(String id);

	public Mono<AtmInfo> create(AtmInfo accD);

	
	public Mono<AtmInfo> getAtmByNameBankAndRed(String bankName,String red);
}
