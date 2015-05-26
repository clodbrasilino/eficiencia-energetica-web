package br.edu.ifpi.see.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
 * Servlet implementation class ServletCadastroSala
 */
public class ServletCadastroSala extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCadastroSala() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String salvar = request.getParameter("salvar");
		String add = request.getParameter("add");
		
		/* Este bloco de c�digo � executado quando o usu�rio clica no bot�o 'Salvar' e salva uma sala */
		if(salvar != null){
			EntityTransaction et = JPAUtil.getTransaction();
			SalaDAO salaDao = new SalaDAO();
			MicroControladorDAO mcDao = new MicroControladorDAO();
			
			String numero = request.getParameter("numero");
			String descricao = request.getParameter("descricao");
			int pavimento = Integer.parseInt(request.getParameter("pavimento"));
			
			Sala s = (Sala) request.getSession().getAttribute("sala");
			
			// Este bloco de c�digo � executado para salvar uma sala com uma lista de micro controladores
			if(s != null){
				et.begin();
				s.setUsuario((Usuario) request.getSession().getAttribute("usuario"));
				salaDao.salvar(s);
				for(MicroControlador mc : s.getListaMicroControlador()){
					mc.setSala(s);
					mcDao.salvar(mc);
				}
				et.commit();
			
			// Este bloco de c�digo � executado para salvar uma sala sem uma lista de micro controladores
			}else{
				s = new Sala();
				s.setNumero(numero);
				s.setDescricao(descricao);
				s.setPavimento(pavimento);
				
				et.begin();
				s.setUsuario((Usuario) request.getSession().getAttribute("usuario"));
				salaDao.salvar(s);
				et.commit();
			}
			
			// Mensagem
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('Sala cadastrada com sucesso!');");
			out.println("</script>");
			
			// Remove o objeto sala da sess�o e direciona para a p�gina de gerente
			request.getSession().removeAttribute("sala");
			response.sendRedirect("/"+getServletContext().getInitParameter("app-name")+"/JSP/gerente/gerente.jsp");
		
		/* Este bloco de c�digo � executado quando o usu�rio clica no bot�o 'Adicionar' e chama a p�gina de cadastro de micro controladores */
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