package com.tp.spring.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp.spring.bean.Marque;
import com.tp.spring.bean.Voiture;
import com.tp.spring.dao.MarqueDao;
import com.tp.spring.service.fascade.MarqueService;
import com.tp.spring.service.fascade.VoitureService;

@Service
public class MarqueServiceImpl implements MarqueService {

	@Autowired
	private MarqueDao marqueDao;
	@Autowired
	private VoitureService voitureService;

	@Override
	public Marque findByIdMarq(Long idMarq) {
		return marqueDao.findByIdMarq(idMarq);
	}

	@Override
	public Marque findByLibelleMarq(String libelleMarq) {
		return marqueDao.findByLibelleMarq(libelleMarq);
	}
	@Transactional
	@Override
	public int deleteByIdMarq(Long idMarq) {
		Marque foundedMarque = findByIdMarq(idMarq);
		if(foundedMarque == null) {
			return -1;
		}else {
			List<Voiture> voitures = voitureService.findByMarqueLibelleMarq(foundedMarque.getLibelleMarq());
			for(Voiture v : voitures) {
				voitureService.deleteByIdVoit(v.getIdVoit());
			}
			marqueDao.delete(foundedMarque);
			return 1;
		}
	}

	@Override
	public int save(Marque marque) {
		Marque foundedMarque = findByLibelleMarq(marque.getLibelleMarq());
		if (foundedMarque != null) {
			return -1;
		} else if (marque.getLibelleMarq() == "" || marque.getLibelleMarq() == null) {
			return -2;
		} else {
			marqueDao.save(marque);
			return 1;
		}
	}

	@Override
	public int update(Marque marque) {
		Marque foundedMarque = findByIdMarq(marque.getIdMarq());
		if (foundedMarque == null) {
			return -1;
		} else if (marque.getLibelleMarq() == "" || marque.getLibelleMarq() == null) {
			return -2;
		} else {
			marque.setId(foundedMarque.getId());
			marqueDao.save(foundedMarque);
			return 1;
		}
	}

	@Override
	public List<Marque> findAll() {
		return marqueDao.findAll();
	}

}
