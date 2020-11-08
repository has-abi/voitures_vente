package com.tp.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp.spring.bean.Adresse;
import com.tp.spring.bean.Concessionnaire;
import com.tp.spring.bean.Marque;
import com.tp.spring.dao.ConcessionnaireDao;
import com.tp.spring.service.fascade.AdresseService;
import com.tp.spring.service.fascade.ConcessionnaireService;
import com.tp.spring.service.fascade.MarqueService;

//you forgot @service in all services impl
@Service
public class ConcessionnaireServiceImpl implements ConcessionnaireService {

	@Autowired
	public ConcessionnaireDao concessionnaireDao;

	@Autowired
	public AdresseService adresseService;

	@Autowired
	public MarqueService marqueService;

	@Override
	public Concessionnaire findByIdCons(Long idCons) {
		return concessionnaireDao.findByIdCons(idCons);
	}

	@Override
	public Concessionnaire findByLibelleCons(String libelleCons) {
		return concessionnaireDao.findByLibelleCons(libelleCons);
	}
	@Transactional
	@Override
	public int deleteByLibelleCons(String libelleCons) {
		Concessionnaire foundedConcessionnaire = findByLibelleCons(libelleCons);
		if(foundedConcessionnaire == null) {
			return -1;
		}else {
			for(Adresse ad:foundedConcessionnaire.getAdresses()) {
				adresseService.deleteByIdAdr(ad.getIdAdr());
			}
			concessionnaireDao.delete(foundedConcessionnaire);
			return 1;
		}
	}

	@Transactional
	@Override
	public int save(Concessionnaire concessionnaire) {
		Concessionnaire foundedConcessionnaire = findByLibelleCons(concessionnaire.getLibelleCons());
		if (foundedConcessionnaire != null) {
			return -1;
		} else if (concessionnaire.getLibelleCons() == "" || concessionnaire.getLibelleCons() == null
				|| concessionnaire.getPhoneCons() == "" || concessionnaire.getPhoneCons() == null
				|| concessionnaire.getAdresses() == null) {
			return -2;
		} else {
			
			if (concessionnaire.getAdresses().size() > 0) {
				for (Adresse ad : concessionnaire.getAdresses()) {
					adresseService.save(ad);
				}
			}
			if(concessionnaire.getMarques().size()>0) {
				List<Marque> marques = new ArrayList<Marque>();
				for(Marque m : concessionnaire.getMarques()) {
					Marque foundedM = marqueService.findByIdMarq(m.getIdMarq()); 
					if(foundedM != null) {
						marques.add(foundedM);
					}
				}
				concessionnaire.setMarques(marques);
			}
			concessionnaireDao.save(concessionnaire);
			return 1;
		}
	}

	@Transactional
	@Override
	public int update(Concessionnaire concessionnaire) {
		Concessionnaire foundedConcessionnaire = findByIdCons(concessionnaire.getIdCons());
		if (foundedConcessionnaire == null) {
			return -1;
		} else if (concessionnaire.getLibelleCons() == "" || concessionnaire.getLibelleCons() == null
				|| concessionnaire.getPhoneCons() == "" || concessionnaire.getPhoneCons() == null
				|| concessionnaire.getAdresses() == null) {
			return -2;
		} else {
			for (Adresse adresse : foundedConcessionnaire.getAdresses()) {
				adresseService.update(adresse);
			}
			for (Marque marque : concessionnaire.getMarques()) {
				marqueService.update(marque);
			}
			concessionnaire.setId(foundedConcessionnaire.getId());
			concessionnaireDao.save(concessionnaire);
			return 1;
		}
	}

	@Override
	public List<Concessionnaire> findAll() {
		return concessionnaireDao.findAll();
	}

}
