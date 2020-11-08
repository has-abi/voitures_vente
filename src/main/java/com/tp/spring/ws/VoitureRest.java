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

import com.tp.spring.bean.Voiture;
import com.tp.spring.service.fascade.VoitureService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("VenteVoiture/Voiture")
public class VoitureRest {
	
	@Autowired
	public VoitureService VoitureService;
	
	@GetMapping("/idVoit/{idVoit}")
	public Voiture findByIdVoit(@PathVariable Long idVoit) {
		return VoitureService.findByIdVoit(idVoit);
	}
	

	@DeleteMapping("/idVoit/{idVoit}")
	public int deleteByIdVoit(@PathVariable Long idVoit) {
		return VoitureService.deleteByIdVoit(idVoit);
	}


	@PostMapping("/")
	public int save(@RequestBody Voiture client) {
		return VoitureService.save(client);
	}

	@PutMapping("/")
	public int update(@RequestBody Voiture voiture) {
		return VoitureService.update(voiture);
	}

	@GetMapping("/")
	public List<Voiture> findAll() {
		return VoitureService.findAll();
	}

}
