package com.tp.spring.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Long idCl;
	private String PrenomCl;
	private String nomCl;
	private String phoneCl;
	private String mailCl;
	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToMany(mappedBy = "client")
	private List<Voiture> voitures;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCl() {
		return idCl;
	}

	public void setIdCl(Long idCl) {
		this.idCl = idCl;
	}

	public String getPrenomCl() {
		return PrenomCl;
	}

	public void setPrenomCl(String PrenomCl) {
		this.PrenomCl = PrenomCl;
	}

	public String getNomCl() {
		return nomCl;
	}

	public void setNomCl(String nomCl) {
		this.nomCl = nomCl;
	}

	public String getPhoneCl() {
		return phoneCl;
	}

	public void setPhoneCl(String phoneCl) {
		this.phoneCl = phoneCl;
	}

	public String getMailCl() {
		return mailCl;
	}

	public void setMailCl(String mailCl) {
		this.mailCl = mailCl;
	}

	public List<Voiture> getVoitures() {
		return voitures;
	}

	public void setVoitures(List<Voiture> voitures) {
		this.voitures = voitures;
	}

	public Client() {
		super();
	}

}
