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

import com.tp.spring.bean.Marque;
import com.tp.spring.service.fascade.MarqueService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("VenteVoiture/Marque")
public class MarqueRest {
	@Autowired
	public MarqueService marqueService;

	@GetMapping("/idMarq/{idMarq}")
	public Marque findByIdMarq(@PathVariable Long idMarq) {
		return marqueService.findByIdMarq(idMarq);
	}

	@GetMapping("/libelleMarq/{libelleMarq}")
	public Marque findByLibelleMarq(@PathVariable String libelleMarq) {
		return marqueService.findByLibelleMarq(libelleMarq);
	}

	@DeleteMapping("/idMarq/{idMarq}")
	public int deleteByIdMarq(@PathVariable Long idMarq) {
		return marqueService.deleteByIdMarq(idMarq);
	}

	@PostMapping("/")
	public int save(@RequestBody Marque marque) {
		return marqueService.save(marque);
	}

	@PutMapping("/")
	public int update(@RequestBody Marque marque) {
		return marqueService.update(marque);
	}

	@GetMapping("/")
	public List<Marque> findAll() {
		return marqueService.findAll();
	}

}
