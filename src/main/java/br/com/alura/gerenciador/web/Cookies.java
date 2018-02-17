package br.com.alura.gerenciador.web;

import java.util.Optional;

import javax.servlet.http.Cookie;

public class Cookies {

	private static final Object USUARIO_LOGADO = "usuarioLogado";
	private Optional<Cookie[]> cookies;

	public Cookies(Cookie[] cookies) {
		this.cookies = Optional.ofNullable(cookies);
	}

	public Cookie buscaUsuarioLogado() {

		for(Cookie cookie : cookies.orElse(new Cookie[0])) {
			if(cookie.getName().equals(USUARIO_LOGADO)) {
				return cookie;
			}
		}
		
		return null;
	}
	
	
	

}
