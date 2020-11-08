package com.tp.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tp.spring.bean.Adresse;

@Repository
public interface AdresseDao extends JpaRepository<Adresse, Long> {

	public Adresse findByIdAdr(Long idAdr);

}
