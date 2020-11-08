package com.tp.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp.spring.bean.Client;
import com.tp.spring.bean.Marque;
import com.tp.spring.bean.Voiture;
import com.tp.spring.dao.VoitureDao;
import com.tp.spring.service.fascade.ClientService;
import com.tp.spring.service.fascade.MarqueService;
import com.tp.spring.service.fascade.VoitureService;

@Service
public class VoitureServiceImpl implements VoitureService {

	@Autowired
	public VoitureDao voitureDao;
	@Autowired
	public MarqueService marqueService;
	@Autowired
	public ClientService clientService;
	
	@Override
	public Voiture findByIdVoit(Long idVoit) {
		return voitureDao.findByIdVoit(idVoit);
	}

	
	@Override
	public int deleteByIdVoit(Long idVoit) {
		Voiture foundedVoiture = findByIdVoit(idVoit);
		if(foundedVoiture == null) {
			return -1;
		}else {
			voitureDao.delete(foundedVoiture);
			return 1;
		}
	}

	@Override
	public List<Voiture> findByMarqueLibelleMarq(String libelleMarq) {
		return voitureDao.findByMarqueLibelleMarq(libelleMarq);
	}

	@Override
	public int save(Voiture voiture) {
		Voiture foundedVoiture = findByIdVoit(voiture.getIdVoit());
		Marque marque = marqueService.findByIdMarq(voiture.getMarque().getIdMarq());
		Client client = clientService.findByIdCl(voiture.getClient().getId());
		if (foundedVoiture != null || marque == null || client == null) {
			return -1;
		} else if (voiture.getPrix() == 0.0 || voiture.getKilometrage() == 0.0 || voiture.getCouleur() == ""
				|| voiture.getCouleur() == null || voiture.getMarque().getLibelleMarq() == ""
				|| voiture.getMarque().getLibelleMarq() == null || voiture.getClient().getIdCl() == 0) {
			return -2;
		} else {
			voiture.setClient(client);
			voiture.setMarque(marque);
			voitureDao.save(voiture);
			return 1;
		}
	}

	@Override
	public int update(Voiture voiture) {
		Voiture foundedVoiture = findByIdVoit(voiture.getIdVoit());
		if (foundedVoiture == null) {
			return -1;
		} else if (voiture.getPrix() == 0.0 || voiture.getKilometrage() == 0.0
				|| voiture.getCouleur() == "" || voiture.getCouleur() == null
				|| voiture.getMarque().getLibelleMarq() == ""
				|| voiture.getMarque().getLibelleMarq() == null || voiture.getClient().getIdCl() == 0) {
			return -2;
		} else {
			voiture.setClient(clientService.findByIdCl(voiture.getClient().getIdCl()));
			voiture.setMarque(marqueService.findByIdMarq(voiture.getMarque().getIdMarq()));
			voiture.setId(foundedVoiture.getId());
			voitureDao.save(voiture);
			return 1;
		}
	}

	@Override
	public List<Voiture> findAll() {
		return voitureDao.findAll();
	}

}
