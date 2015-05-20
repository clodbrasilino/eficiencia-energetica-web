package br.edu.ifpi.see.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpi.see.dao.UsuarioDAO;
import br.edu.ifpi.see.model.Usuario;

/**
 * Servlet implementation class ServletCadastroGerente
 */
public class ServletCadastroGerente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCadastroGerente() {
        super();
    }
    
    // TODO Implementar Servlet de Cadastrar Gerente

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String senha = request.getParameter("senha");
		String confirmacaoSenha = request.getParameter("confirmacaoSenha");
		
		if(senha.equals(confirmacaoSenha)){
			UsuarioDAO dao = new UsuarioDAO();
			dao.salvar(new Usuario(nome, endereco, email, telefone, senha, 2, null));
		}
	}

}
