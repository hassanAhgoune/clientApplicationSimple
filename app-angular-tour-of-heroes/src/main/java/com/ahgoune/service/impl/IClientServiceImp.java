package com.ahgoune.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahgoune.bean.Client;
import com.ahgoune.repository.IClientRepository;
import com.ahgoune.service.facad.IClientService;

@Service
public class IClientServiceImp implements IClientService {

	@Autowired
	private   IClientRepository  iClientRepository;
	@Override
	@Transactional
	public List<Client> findAll() {
		
		return (List<Client>) iClientRepository.findAll() ;
	}
	@Override
	public Client save(Client client) {
		
		return iClientRepository.save(client);
	}
	
	@Override
	public void Delete (Long  id) {
		Client  client  =  find(id);
		iClientRepository.deleteById(id);
		
	}
	@Override
	 public  Client  find(Long  id ) {
		 return  iClientRepository.findById(id).orElse(null);
	 }
	@Override
	public Client find(String name) {
		return iClientRepository.findByName(name);
	}
	
	
	

}
