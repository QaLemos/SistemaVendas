package br.com.gx2.testes;

import br.com.gx2.dao.DAOFactory;
import br.com.gx2.dao.GrupoDAO;
import br.com.gx2.entity.Grupo;

public class TesteGrupo {

	public static void main(String[] args) {
		
		Grupo grupo = new Grupo(9, "Teste JUnit");
		GrupoDAO dao = DAOFactory.createGrupoDAO();
		dao.findById(9);
		
		Grupo g1 = dao.findById(8);
		System.out.println(g1.getDescricaoGrupo());
		

	}

}
