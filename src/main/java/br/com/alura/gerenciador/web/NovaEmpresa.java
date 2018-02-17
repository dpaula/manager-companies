package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

public class NovaEmpresa implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {

		String nome = req.getParameter("nome");
		Empresa novaEmpresa = new Empresa(nome);

		new EmpresaDAO().adiciona(novaEmpresa);
		// incluindo atributo no request para ser acessado na tela
		req.setAttribute("empresa", novaEmpresa);

		return "/WEB-INF/paginas/novaEmpresa.jsp";
	}

}
