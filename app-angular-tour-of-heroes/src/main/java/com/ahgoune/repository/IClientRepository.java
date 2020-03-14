package com.ahgoune.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ahgoune.bean.Client;

@Repository
public interface IClientRepository extends CrudRepository<Client, Long> {
	  public   Client  findByName(String  name  );
	
    
}
