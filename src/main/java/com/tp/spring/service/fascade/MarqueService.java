package com.tp.spring.service.fascade;

import java.util.List;

import com.tp.spring.bean.Marque;

public interface MarqueService {

public Marque findByIdMarq(Long idMarq);

    public Marque findByLibelleMarq(String libelleMarq);
	
	public int  deleteByIdMarq(Long idMarq);
	
	public int save(Marque marque);
	
	public int update(Marque marque);
	
	public List<Marque> findAll();

}
