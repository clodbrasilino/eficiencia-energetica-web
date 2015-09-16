package br.edu.ifpi.see.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpi.see.dao.UsuarioDAO;
import br.edu.ifpi.see.model.Gerente;
import br.edu.ifpi.see.model.Usuario;
import br.edu.ifpi.see.util.Message;
import br.edu.ifpi.see.validation.Validador;
import br.edu.ifpi.see.validation.Validavel;

public class ServletCadastroGerente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletCadastroGerente() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Pega os parâmentros
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String senha = request.getParameter("senha");
		String confirmacaoSenha = request.getParameter("confirmacaoSenha");
		
		// Cria o objeto gerente
		Usuario gerente = new Gerente(nome, endereco, email, telefone, senha, confirmacaoSenha, true);
		
		// Valida o gerente
		Validador v = new Validador();
		if(v.valida(request, (Validavel) gerente)){
			
			// Salva o gerente
			UsuarioDAO dao = new UsuarioDAO();
			dao.salvar(gerente);
			
			// Exibe mensagem de sucesso e chama a próxima página
			Message msg = new Message(request, response, "Gerente de salas cadastro com sucesso!", "/JSP/administrador/administrador.jsp");
			msg.show();
			
		}else{
			
			// Volta para a página de cadastro, caso ocorra algum erro de validação
			response.sendRedirect("/"+getServletContext().getInitParameter("app-name")+"/JSP/administrador/novoGerente.jsp");
			
		}
		
	}

}
