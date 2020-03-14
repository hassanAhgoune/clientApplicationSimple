package com.ahgoune.ws;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ahgoune.bean.Client;
import com.ahgoune.service.facad.IClientService;
import com.ahgoune.service.impl.IClientServiceImp;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class IClientRestController {
	@Autowired
	private IClientService iClientService;

	@GetMapping("/clientes")
	public List<Client> findAll() {
		return iClientService.findAll();

	}

	@PostMapping("/clientes")
	public ResponseEntity<?> create(@RequestBody Client client) {
		Client newClient = null;
		Map<String, Object> response = new HashMap<>();
		try {
			newClient = iClientService.save(client);
		} catch (DataAccessException e) {
			response.put("messge", " ERROR 404 ");
			response.put("messge", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("messge", " create   of   your  client  has   been succssed ");
		response.put("client", newClient);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
    //find  by  Id  
	@GetMapping("/clientes/{id}")

	public ResponseEntity<?> show(@PathVariable Long id) {
		Client client = null;
		Map<String, Object> response = new HashMap<>();
		try {
			client = iClientService.find(id);
		} catch (DataAccessException e) {
			response.put("messge", " ERROR 404 ");
			response.put("messge", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (client == null) {
			response.put("messge", " id  client ".concat(id.toString().concat(" not   found!! ")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}

	
	//find   by  name   sucharge 
	 
	@GetMapping("/clientes/name/{name}")
    public ResponseEntity<?> show(@PathVariable String  name) {
		Client client = null;
		Map<String, Object> response = new HashMap<>();
		try {
			client = iClientService.find(name);
		} catch (DataAccessException e) {
			response.put("messge", " ERROR 404 ");
			response.put("messge", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (client == null) {
			response.put("messge", " name client ".concat(name.toString().concat(" not   found!! ")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}

	
	
	@PutMapping("/clientes/{id}")

	public ResponseEntity<?> update(@RequestBody Client client, @PathVariable Long id) {
		Client currentClient = iClientService.find(id);
		Client updateClient = null;
		Map<String, Object> response = new HashMap<>();
		if (currentClient == null) {
			response.put("messge", " id  client ".concat(id.toString().concat(" not   found!! ")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			currentClient.setEmail(client.getEmail());
			currentClient.setName(client.getName());
			currentClient.setPrenom(client.getPrenom());
			updateClient = iClientService.save(currentClient);
		} catch (DataAccessException e) {
			response.put("messge", " ERROR 404 ");
			response.put("messge", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("messge", " update   of   your  client  has   been succssed ");
		response.put("client", updateClient);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			iClientService.Delete(id);
		} catch (DataAccessException e) {
			response.put("messge", " ERROR 404 ");
			response.put("messge", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("messge", " deleted   of  your  client  has   been succssed ");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
