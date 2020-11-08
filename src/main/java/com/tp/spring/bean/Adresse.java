package com.tp.spring.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adresse {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long idAdr;
	private int numero;
	private String libelleAdr;
	private String ville;
	private String pays;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getIdAdr() {
		return idAdr;
	}
	public void setIdAdr(Long idAdr) {
		this.idAdr = idAdr;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getLibelleAdr() {
		return libelleAdr;
	}
	public void setLibelleAdr(String libelleAdr) {
		this.libelleAdr = libelleAdr;
	}
	
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public Adresse() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	

}
