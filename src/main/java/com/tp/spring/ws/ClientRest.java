package com.tp.spring.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tp.spring.bean.Client;
import com.tp.spring.service.fascade.ClientService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("VenteVoiture/Client")
public class ClientRest {
	@Autowired
	public ClientService clientService;
	
	@GetMapping("/idCl/{idCl}")
	public Client findByIdCl(@PathVariable Long idCl) {
		return clientService.findByIdCl(idCl);
	}
	

	@DeleteMapping("/idCl/{idCl}")
	public int deleteByIdCl(@PathVariable Long idCl) {
		return clientService.deleteByIdCl(idCl);
	}


	@PostMapping("/")
	public int save(@RequestBody Client client) {
		return clientService.save(client);
	}

	@PutMapping("/")
	public int update(@RequestBody Client client) {
		return clientService.update(client);
	}

	@GetMapping("/")
	public List<Client> findAll() {
		return clientService.findAll();
	}

}