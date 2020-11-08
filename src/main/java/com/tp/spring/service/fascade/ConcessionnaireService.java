package com.tp.spring.service.fascade;

import java.util.List;

import com.tp.spring.bean.Concessionnaire;

public interface ConcessionnaireService {
	
	public Concessionnaire findByIdCons(Long idCons);
	
    public Concessionnaire findByLibelleCons(String libelleCons);
	
	public int deleteByLibelleCons(String libelleCons);
	
	public int save(Concessionnaire concessionnaire);
	
	public int update(Concessionnaire concessionnaire);
	
	public List<Concessionnaire> findAll();

}
