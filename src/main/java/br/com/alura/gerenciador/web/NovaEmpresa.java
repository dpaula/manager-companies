package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns = "/novaEmpresa")
public class NovaEmpresa extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nome = req.getParameter("nome");

		Empresa novaEmpresa = new Empresa(nome);

		new EmpresaDAO().adiciona(novaEmpresa);
		//incluindo atributo no request para ser acessado na tela
		req.setAttribute("empresa", novaEmpresa);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/novaEmpresa.jsp");
		dispatcher.forward(req, resp);
		
	}

}
