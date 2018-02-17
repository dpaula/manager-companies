package br.com.alura.gerenciador.web;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns="/busca")
public class BuscaEmpresa extends HttpServlet {
	
	
	//A servlet é instanciada apenas uma vez
	public BuscaEmpresa() {
		System.out.println("Construindo uma servlet do tipo BuscaEmpresa: "+this);
	}
	
	//logo após a criação do objeto, é feita inicialização, que também é somente uma vez
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Inicializando a servlet: "+this);
	}
	
	//destruido somente quando o servidor é parado
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("Destruindo a servlet: "+this);
	}
	
	
	//como só vai ter uma instancia desse servlet, não devemos usar variáveis de classe(membro), pois elas podem entrar em concorrência
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter();
		writer.println("<html><body>");
		
		writer.println("Resultado da busca: <br/>");
		
		montaResultado(writer, req);
		
		writer.println("</body></html>");
	}

	private void montaResultado(PrintWriter writer, HttpServletRequest req) {
		String filtro = req.getParameter("filtro");
		
		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);
		
		writer.println("<ul>");
		for (Empresa empresa : empresas) {
			writer.println("<li>"+empresa.getId()+": "+empresa.getNome()+"</li>");
		}
		
		writer.println("</ul>");
		
		
		
	}

}
