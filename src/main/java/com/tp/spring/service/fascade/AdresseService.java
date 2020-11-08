package com.tp.spring.service.fascade;

import java.util.List;

import com.tp.spring.bean.Adresse;

public interface AdresseService {
	
public Adresse findByIdAdr(Long idAdr);
	
	public int deleteByIdAdr(Long idAdr);
	
	public int save(Adresse adresse);
	
	public int update(Adresse adresse);
	
	public List<Adresse> findAll();

}
