package br.edu.ifpi.see.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpi.see.dao.UsuarioDAO;
import br.edu.ifpi.see.model.Usuario;
import br.edu.ifpi.see.util.Message;

public class ServletAlterarSenhaAdministrador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletAlterarSenhaAdministrador() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String senhaAtual = request.getParameter("senhaAtual");
		String novaSenha = request.getParameter("novaSenha");
		String confirmacaoSenha = request.getParameter("confirmacaoSenha");
		
		Usuario u = (Usuario) request.getSession().getAttribute("usuario");
		
		if(senhaAtual.equals(u.getSenha())){
			if(novaSenha.equals("") && confirmacaoSenha.equals("")){
				Message msg = new Message(request, response, "Informe uma nova senha!", "/JSP/administrador/alterarDados.jsp");
				msg.show();
			}else{
				if(confirmacaoSenha.equals(novaSenha)){
					
					UsuarioDAO dao = new UsuarioDAO();
					u.setSenha(novaSenha);
					dao.atualizar(u);
					
					Message msg = new Message(request, response, "Senha alterada com sucesso!", "/JSP/administrador/alterarDados.jsp");
					msg.show();
					
				}else{
					Message msg = new Message(request, response, "As senhas informadas são diferentes!", "/JSP/administrador/alterarDados.jsp");
					msg.show();
				}
			}
		}else{
			Message msg = new Message(request, response, "Senha inválida!", "/JSP/administrador/alterarDados.jsp");
			msg.show();
		}
		
	}

}
