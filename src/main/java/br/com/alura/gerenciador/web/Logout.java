package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/logout")
public class Logout extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Cookie cookie = new Cookies(req.getCookies()).buscaUsuarioLogado();
		
		PrintWriter writer = resp.getWriter();
		writer.println("<html><body>");
		
		if(cookie == null) {
			writer.println("<h3>Usuario não estava logado</h3>");
			writer.println("</body></html>");
			return;
		}

		cookie.setMaxAge(0);
		resp.addCookie(cookie);

		writer.println("<h3>Deslogado</h3>");
		writer.println("</body></html>");
	}

}
