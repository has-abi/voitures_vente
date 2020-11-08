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

import com.tp.spring.bean.Adresse;
import com.tp.spring.service.fascade.AdresseService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("VenteVoiture/Adresse")
public class AdresseRest {

	@Autowired
	public AdresseService adresseService;

	@GetMapping("/idAdr/{idAdr}")
	public Adresse findByIdAdr(@PathVariable Long idAdr) {
		return adresseService.findByIdAdr(idAdr);
	}

	@DeleteMapping("/idAdr/{idAdr}")
	public int deleteByIdAdr(@PathVariable Long idAdr) {
		return adresseService.deleteByIdAdr(idAdr);
	}

	@PostMapping("/")
	public int save(@RequestBody Adresse marque) {
		return adresseService.save(marque);
	}

	// i replace the id by the address object
	@PutMapping("/")
	public int update(@RequestBody Adresse adresse) {
		return adresseService.update(adresse);
	}

	@GetMapping("/")
	public List<Adresse> findAll() {
		return adresseService.findAll();
	}

}
