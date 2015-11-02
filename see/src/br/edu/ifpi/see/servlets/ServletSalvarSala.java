package br.edu.ifpi.see.servlets;

import java.io.IOException;
import java.util.List;

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

public class ServletSalvarSala extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletSalvarSala() {
        super();
    }

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EntityTransaction et = (EntityTransaction) JPAUtil.getTransaction();
		SalaDAO salaDao = new SalaDAO();
		MicroControladorDAO mcDao = new MicroControladorDAO();
		
		Sala s = (Sala) request.getSession().getAttribute("sala");
		
		if(s == null){
			
			String numero = request.getParameter("numero");
			String descricao = request.getParameter("descricao");
			int pavimento = Integer.parseInt(request.getParameter("pavimento"));
			
			s = new Sala();
			s.setNumero(numero);
			s.setDescricao(descricao);
			s.setPavimento(pavimento);
			s.setAtiva(true);
			s.setUsuario((Usuario) request.getSession().getAttribute("usuario"));
		}
		
		et.begin();
		
		salaDao.salvar(s);
		if(s.getListaMicroControlador() != null){
			for(MicroControlador mc : s.getListaMicroControlador()){
				mc.setSala(s);
				mcDao.salvar(mc);
			}
		}
		
		et.commit();
		
		((List<Sala>) getServletContext().getAttribute("salas")).add(s);
		//GeraTabela gt = (GeraTabela) request.getSession().getAttribute("tabela");
		//gt.getSalas().add(s);
		
		request.getSession().removeAttribute("sala");
		
		response.getWriter().println("<script>alert('Sala cadastradda com sucesso!');</script>");
		response.getWriter().println("<script>window.location.href='/"+getServletContext().getInitParameter("app-name")+"/JSP/gerente/gerente.jsp'</script>");
		
	}

}
