package com.tp.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tp.spring.bean.Client;

@Repository
public interface ClientDao extends JpaRepository<Client, Long>{

	public Client findByIdCl(Long idCl);
			
}
