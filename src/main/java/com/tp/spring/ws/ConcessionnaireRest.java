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

import com.tp.spring.bean.Concessionnaire;
import com.tp.spring.service.fascade.ConcessionnaireService;

@RestController
@CrossOrigin(origins =  { "http://localhost:4200" })
@RequestMapping("VenteVoiture/Concessionnaire")
public class ConcessionnaireRest {
	
	@Autowired
	public ConcessionnaireService concessionnaireService;
	
	@GetMapping("/idCons/{idCons}")
	public Concessionnaire findByIdCons(@PathVariable Long idCons) {
		return concessionnaireService.findByIdCons(idCons);
	}
	
	// err here @GetMapping("/idCons/{idCons}") you should replace idCons with libelleCons
	@GetMapping("/libbeleCons/{libelleCons}")
	public Concessionnaire findByLibelleCons(@PathVariable String libelleCons) {
		return concessionnaireService.findByLibelleCons(libelleCons);
	}
	

	@DeleteMapping("/libelleCons/{libelleCons}")
	public int deleteByLibelleCons(@PathVariable String libelleCons) {
		return concessionnaireService.deleteByLibelleCons(libelleCons);
	}


	@PostMapping("/")
	public int save(@RequestBody Concessionnaire concessionnaire) {
		return concessionnaireService.save(concessionnaire);
	}

	@PutMapping("/")
	public int update(@RequestBody Concessionnaire concessionnaire) {
		return concessionnaireService.update(concessionnaire);
	}

	@GetMapping("/")
	public List<Concessionnaire> findAll() {
		return concessionnaireService.findAll();
	}

}
