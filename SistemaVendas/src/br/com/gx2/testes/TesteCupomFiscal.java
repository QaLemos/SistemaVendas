package br.com.gx2.testes;

import java.util.List;

import br.com.gx2.dao.CupomFiscalDAO;
import br.com.gx2.dao.DAOFactory;
import br.com.gx2.dao.ItemCupomFiscalDAO;
import br.com.gx2.entity.CupomFiscal;
import br.com.gx2.entity.ItemCupomFiscal;

public class TesteCupomFiscal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CupomFiscalDAO dao = DAOFactory.createCupomFiscalDAO();
		ItemCupomFiscalDAO itensDao = DAOFactory.createItemCupomFiscalDAO();
		List<CupomFiscal> cupons = dao.findAll();
		
		for (CupomFiscal c1 : cupons) {
			System.out.print(c1.getCodigoCupom() + " - ");
			System.out.print(c1.getEmissao() + " - ");
			System.out.print(c1.getLoja().getNomeLoja() + " - ");
			System.out.print(c1.getVendedor().getNomeVendedor() + " - ");
			System.out.print(c1.getCliente().getNomeCliente() + " - ");
			System.out.println(c1.getCliente().getCpf());
		}
		
		CupomFiscal c1 = dao.findById(23);
		System.out.print(c1.getCodigoCupom() + " - ");
		System.out.print(c1.getEmissao() + " - ");
		System.out.print(c1.getValorTotal() + " - ");
		System.out.print(c1.getLoja().getNomeLoja() + " - ");
		System.out.print(c1.getVendedor().getNomeVendedor() + " - ");
		System.out.print(c1.getCliente().getNomeCliente() + " - ");
		System.out.println(c1.getCliente().getCpf());
		
		c1.setValorTotal(10000.0);
		//dao.update(c1);
		Integer codigo = 3;
		CupomFiscal cp = dao.findById(codigo);
		
		
		System.out.print(cp.getCodigoCupom() + " - ");
		System.out.print(cp.getEmissao() + " - ");
		System.out.print(cp.getValorTotal() + " - ");
		System.out.print(cp.getLoja().getNomeLoja() + " - ");
		System.out.print(cp.getVendedor().getNomeVendedor() + " - ");
		System.out.print(cp.getCliente().getNomeCliente() + " - ");
		System.out.println(cp.getCliente().getCpf());
		
		
		List<ItemCupomFiscal> itens = (List<ItemCupomFiscal>) cp.getItemCupomFiscal();
		for (ItemCupomFiscal its : itens) {
			System.out.print(its.getProduto().getCodigoProduto() + " - ");
			System.out.print(its.getProduto().getDescricaoProduto() + " - ");
			System.out.print(its.getQuantidade() + " - ");
			System.out.print(its.getValorUnitario()+ " - ");
			System.out.println(its.getProduto().getGrupo().getDescricaoGrupo());
		}
		
	}

}
