package com.springboot.appbanco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.appbanco.model.AtmInfo;
import com.springboot.appbanco.repo.IAtmInfoRepo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class AtmInfoImpl implements IAtmInfoService{

	@Autowired
	private IAtmInfoRepo repo;
	
	@Override
	public Mono<AtmInfo> create(AtmInfo accD) {
		return repo.save(accD);
	}


	@Override
	public Flux<AtmInfo> findAll() {
		return repo.findAll();
	}

	@Override
	public Mono<AtmInfo> findById(String id) {
		return repo.findById(id);
	}

	@Override
	public Mono<AtmInfo> update(AtmInfo accDueD, String id) {
		// TODO Auto-generated method stub
		return repo.findById(id).flatMap(ac-> {
			ac.setBankName(accDueD.getBankName());
			return Mono.just(ac);
		});
	}

	@Override
	public Mono<Void> delete(String id) {
		 return repo.findById(id).flatMap(client -> repo.delete(client));
	}


	@Override
	public Mono<AtmInfo> getAtmByNameBankAndRed(String bankName, String red) {
		
		return repo.findByBankNameAndNameRedATM(bankName, red);
	}

}
