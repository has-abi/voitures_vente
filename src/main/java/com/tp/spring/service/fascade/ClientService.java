package com.tp.spring.service.fascade;

import java.util.List;

import com.tp.spring.bean.Client;
import com.tp.spring.bean.Voiture;

public interface ClientService {

	public Client findByIdCl(Long idCl);

	public int deleteByIdCl(Long idCl);

	public int save(Client client);

	public int update(Client client);

	public List<Client> findAll();

}
