package com.ahgoune.service.facad;

import java.util.List;
import java.util.Optional;

import com.ahgoune.bean.Client;

public interface IClientService {
public   List<Client>  findAll();
public   Client  save (Client  client);
public    Client  find(Long id);
public void Delete (Long  id);
  public  Client  find(String  name  );

 
}
