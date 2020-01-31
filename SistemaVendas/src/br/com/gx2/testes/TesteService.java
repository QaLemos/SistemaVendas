package br.com.gx2.testes;

import java.util.List;

import br.com.gx2.entity.CupomFiscal;
import br.com.gx2.service.CupomFiscalService;
import br.com.gx2.service.ServiceFactory;

public class TesteService {

	public static void main(String[] args) {
		
		CupomFiscalService service =  ServiceFactory.createCupomFiscalService();
		
		List<CupomFiscal> cupons = service.exibirTodosCuponsFiscais();
		for (CupomFiscal c1 : cupons) {
			System.out.print(c1.getCodigoCupom() + " \r \n Data: ");
			System.out.print(c1.getEmissao() + " \r \n Loja: ");
			System.out.print(c1.getLoja().getNomeLoja() + " \r \n Vendedor: ");
			System.out.print(c1.getVendedor().getNomeVendedor() + " \r \n Cliente ");
			System.out.print(c1.getCliente().getNomeCliente() + " \r \n CPF: ");
			System.out.println(c1.getCliente().getCpf());
		}
		
		
	}

}
