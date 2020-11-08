package com.tp.spring.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tp.spring.bean.Marque;


@Repository
public interface MarqueDao extends JpaRepository<Marque, Long> {
	
	public Marque findByIdMarq(Long idMarq);
	
	public Marque findByLibelleMarq(String libelleMarq);
	
}
