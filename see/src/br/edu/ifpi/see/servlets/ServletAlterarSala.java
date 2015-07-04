package br.edu.ifpi.see.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpi.see.dao.MicroControladorDAO;
import br.edu.ifpi.see.dao.SalaDAO;
import br.edu.ifpi.see.model.MicroControlador;
import br.edu.ifpi.see.model.Sala;
import br.edu.ifpi.see.model.Usuario;
import br.edu.ifpi.see.util.JPAUtil;

/**
 * Servlet implementation class ServletAlterarSala
 */
public class ServletAlterarSala extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlterarSala() {
        super();
    }
    
    // TODO Implementar Servlet de Alterar Sala

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long id = Integer.parseInt(request.getParameter("id"));
		
		EntityTransaction et = ((EntityManager) getServletContext().getAttribute("em")).getTransaction();
		
		et.begin();
		
		SalaDAO dao = new SalaDAO();
		Sala s = dao.pesquisar(id);
		
		et.commit();
		request.setAttribute("sala", s);
		request.getSession().setAttribute("sala", s);
		
		request.getRequestDispatcher("JSP/gerente/alterarSala.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*long id = Integer.parseInt(request.getParameter("id"));
		String numero = request.getParameter("numero");
		String descricao = request.getParameter("descricao");
		int pavimento = Integer.parseInt(request.getParameter("pavimento"));
		
//		EntityTransaction et = JPAUtil.getTransaction();
		EntityTransaction et = ((EntityManager) getServletContext().getAttribute("em")).getTransaction();
		
		et.begin();
		SalaDAO dao = new SalaDAO();
		
		Sala s = dao.pesquisar(id);
		
		s.setNumero(numero);
		s.setDescricao(descricao);
		s.setPavimento(pavimento);
		
		dao.atualizar(s);
		et.commit();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('Sala atualizada com sucesso!')");
		out.println("document.location.href='/"+getServletContext().getInitParameter("app-name")+"/JSP/gerente/gerente.jsp'");
		out.println("</script>");*/
		
		String salvar = request.getParameter("salvar");
		String add = request.getParameter("add");
		
		/* Este bloco de código é executado quando o usuário clica no botão 'Salvar' e salva uma sala */
		if(salvar != null){
			EntityTransaction et = JPAUtil.getTransaction();
			SalaDAO salaDao = new SalaDAO();
			MicroControladorDAO mcDao = new MicroControladorDAO();
			
			String numero = request.getParameter("numero");
			String descricao = request.getParameter("descricao");
			int pavimento = Integer.parseInt(request.getParameter("pavimento"));
			
			Sala s = (Sala) request.getSession().getAttribute("sala");
			
			// Este bloco de código é executado para salvar uma sala com uma lista de micro controladores
			if(s != null){
				et.begin();
				s.setUsuario((Usuario) request.getSession().getAttribute("usuario"));
				salaDao.atualizar(s);
				for(MicroControlador mc : s.getListaMicroControlador()){
					mc.setSala(s);
					mcDao.atualizar(mc);
				}
				et.commit();
			
			// Este bloco de código é executado para salvar uma sala sem uma lista de micro controladores
			}else{
				s = new Sala();
				s.setNumero(numero);
				s.setDescricao(descricao);
				s.setPavimento(pavimento);
				
				et.begin();
				s.setUsuario((Usuario) request.getSession().getAttribute("usuario"));
				salaDao.atualizar(s);
				et.commit();
			}
			
			// Mensagem
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('Sala atualizada com sucesso!');");
			out.println("</script>");
			
			// Remove o objeto sala da sessão e direciona para a página de gerente
			request.getSession().removeAttribute("sala");
			response.sendRedirect("/"+getServletContext().getInitParameter("app-name")+"/JSP/gerente/gerente.jsp");
		
		/* Este bloco de código é executado quando o usuário clica no botão 'Adicionar' e chama a página de cadastro de micro controladores */
		}else if(add != null){
			Sala s = (Sala) request.getSession().getAttribute("sala");
			if(s == null){
				String numero = request.getParameter("numero");
				String descricao = request.getParameter("descricao");
				int pavimento = Integer.parseInt(request.getParameter("pavimento"));
				
				s = new Sala();
				s.setNumero(numero);
				s.setDescricao(descricao);
				s.setPavimento(pavimento);
				s.setListaMicroControlador(new ArrayList<MicroControlador>());
				
				request.getSession().setAttribute("sala", s);
			}
			
			request.getRequestDispatcher("/JSP/gerente/novoMicroControlador.jsp").forward(request, response);
		}
		
	}

}
