package com.tp.spring.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Voiture {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long idVoit ;
	private Double prix;
	private Double kilometrage;
	private String couleur;	
	
	@ManyToOne
	private Marque marque;
	

	@ManyToOne
	private Client client;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public Long getIdVoit() {
		return idVoit;
	}
	public void setIdVoit(Long idVoit) {
		this.idVoit = idVoit;
	}
	
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public Double getKilometrage() {
		return kilometrage;
	}
	public void setKilometrage(Double kilometrage) {
		this.kilometrage = kilometrage;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
	public Marque getMarque() {
		return marque;
	}
	public void setMarque(Marque marque) {
		this.marque = marque;
	}
	
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	
	public Voiture() {
		super();
		// TODO Auto-generated constructor stub
	}

}
