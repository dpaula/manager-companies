package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import br.com.alura.gerenciador.Usuario;

@WebFilter(urlPatterns="/*")
public class FiltroDeAuditoria implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		
		String uri = req.getRequestURI();
		System.out.println("URI sendo acessada: "+uri);
		
		String usuario = getUsuario(req);
		
		System.out.println("Usuário "+usuario+" acessando a URI!");
		
		chain.doFilter(request, resp);
	}

	/**
	 * @param req
	 * @return
	 */
	private String getUsuario(HttpServletRequest req) {
		
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario.logado");
		
		Optional<Usuario> opUsuario = Optional.ofNullable(usuario);
		
		return opUsuario.map(Usuario::getEmail).orElse("<deslogado>");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
