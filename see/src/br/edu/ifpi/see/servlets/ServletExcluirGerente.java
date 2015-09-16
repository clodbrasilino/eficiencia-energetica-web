package br.edu.ifpi.see.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpi.see.dao.UsuarioDAO;
import br.edu.ifpi.see.model.Usuario;
import br.edu.ifpi.see.util.Message;

public class ServletExcluirGerente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletExcluirGerente() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Pega o parâmetro
		long id = Integer.parseInt(request.getParameter("id"));
		
		// Consulta o gerente
		UsuarioDAO dao = new UsuarioDAO();
		Usuario gerente = dao.pesquisar(id);
		
		// Exclui o gerente
		dao.apagar(gerente);
		
		// Exibe mensagem de sucesso e chama a próxima página
		Message msg = new Message(request, response, "Gerente de salas excluído com sucesso!", "/JSP/administrador/administrador.jsp");
		msg.show();
		
	}

}
