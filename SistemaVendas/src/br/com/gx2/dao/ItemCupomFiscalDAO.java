package br.com.gx2.dao;

import java.util.List;

import br.com.gx2.entity.ItemCupomFiscal;

public interface ItemCupomFiscalDAO {
	
	public void insert(ItemCupomFiscal itemCupomFiscal);
	
	public void update(ItemCupomFiscal itemCupomFiscal);
	
	public void deleteById(Integer codigoItemCupomFiscal);
	
	public List<ItemCupomFiscal> findById(Integer codigoItemCupomFiscal);
	
	public List<ItemCupomFiscal> findAll();

}
	
	
