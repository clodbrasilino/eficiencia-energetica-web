package br.edu.ifpi.see.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpi.see.dao.UsuarioDAO;
import br.edu.ifpi.see.model.Administrador;
import br.edu.ifpi.see.util.Message;
import br.edu.ifpi.see.validation.Validador;

public class ServletAlterarDadosAdministrador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletAlterarDadosAdministrador() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("/"+getServletContext().getInitParameter("app-name")+"/JSP/administrador/alterarDados.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Pega os parâmetros
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		
		// Pega o administrador
		Administrador administrador = (Administrador) request.getSession().getAttribute("usuario");
		
		// Altera os dados cadastrais do administrador
		administrador.setNome(nome);
		administrador.setEndereco(endereco);
		administrador.setEmail(email);
		administrador.setTelefone(telefone);
		
		// Valida o administrador
		Validador v = new Validador();
		if(v.valida(request, administrador)){
			
			// Atualiza o administrador
			UsuarioDAO dao = new UsuarioDAO();
			dao.atualizar(administrador);
			
			// Exibe mensagem de sucesso e chama a próxima página
			Message msg = new Message(request, response, "Dados atualizados com sucesso!", "/JSP/administrador/administrador.jsp");
			msg.show();
			
		}else{
			
			// Volta para a página de cadastro, caso ocorra algum erro de validação
			request.getRequestDispatcher("JSP/administrador/alterarDados.jsp").forward(request, response);
			
		}
		
	}

}
