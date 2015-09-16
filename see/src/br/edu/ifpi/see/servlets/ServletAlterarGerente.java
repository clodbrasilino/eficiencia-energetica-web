package br.edu.ifpi.see.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpi.see.dao.UsuarioDAO;
import br.edu.ifpi.see.model.Gerente;
import br.edu.ifpi.see.util.Message;
import br.edu.ifpi.see.validation.Validador;

public class ServletAlterarGerente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gerente gerente;
	
    public ServletAlterarGerente() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Pega o parâmetro
		int id = Integer.parseInt(request.getParameter("id"));
		
		// Consulta o gerente
		UsuarioDAO dao = new UsuarioDAO();
		gerente = (Gerente) dao.pesquisar(id);
		
		// Coloca o gerente na requisição
		request.setAttribute("gerente", gerente);
		request.getRequestDispatcher("JSP/administrador/alterarGerente.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Pega os parâmetros
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String senha = request.getParameter("senha");
		String confirmacaoSenha = request.getParameter("confirmacaoSenha");
		String ativo = request.getParameter("ativo");
		
		// Altera os dados cadastrais do gerente
		gerente.setNome(nome);
		gerente.setEndereco(endereco);
		gerente.setEmail(email);
		gerente.setTelefone(telefone);
		gerente.setSenha(senha);
		gerente.setConfirmacaoSenha(confirmacaoSenha);
		gerente.setAtivo(Boolean.parseBoolean(ativo));
		
		// Valida o gerente
		Validador v = new Validador();
		if(v.valida(request, gerente)){
			
			// Atualiza o gerente
			UsuarioDAO dao = new UsuarioDAO();
			dao.atualizar(gerente);
			
			// Exibe mensagem de sucesso e chama a próxima página
			Message msg = new Message(request, response, "Gerente de salas atualizado com sucesso!", "/JSP/administrador/administrador.jsp");
			msg.show();
			
		}else{
			
			// Volta para a página de cadastro, caso ocorra algum erro de validação
			request.setAttribute("gerente", gerente);
			request.getRequestDispatcher("JSP/administrador/alterarGerente.jsp").forward(request, response);
			
		}
		
	}

}
