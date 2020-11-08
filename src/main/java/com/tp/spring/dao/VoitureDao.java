package com.tp.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tp.spring.bean.Voiture;

@Repository
public interface VoitureDao extends JpaRepository<Voiture, Long> {
	
	public Voiture findByIdVoit(Long idVoit);
	
	public List<Voiture> findByMarqueLibelleMarq(String libelleMarq);
	
}
