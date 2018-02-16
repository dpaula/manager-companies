package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns = "/novaEmpresa")
public class NovaEmpresa extends HttpServlet {

//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//		String nome = req.getParameter("nome");
//
//		Empresa novaEmpresa = new Empresa(nome);
//
//		new EmpresaDAO().adiciona(novaEmpresa);
//
//		PrintWriter writer = resp.getWriter();
//		writer.println("<html><body>");
//		writer.println("<h2>Empresa adicionada com sucesso: " + novaEmpresa.getNome() + "</h2>");
//		writer.println("</body></html>");
//
//	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nome = req.getParameter("nome");

		Empresa novaEmpresa = new Empresa(nome);

		new EmpresaDAO().adiciona(novaEmpresa);

		PrintWriter writer = resp.getWriter();
		writer.println("<html><body>");
		writer.println("<h2>Empresa adicionada com sucesso: " + novaEmpresa.getNome() + "</h2>");
		writer.println("</body></html>");
	}

}
