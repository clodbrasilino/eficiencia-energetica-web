package br.edu.ifpi.see.servlets;

import java.io.IOException;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpi.see.dao.MicroControladorDAO;
import br.edu.ifpi.see.model.MicroControlador;
import br.edu.ifpi.see.model.Sala;
import br.edu.ifpi.see.util.Message;

/**
 * Servlet implementation class ServletExcluirMicroControlador
 */
public class ServletExcluirMicroControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletExcluirMicroControlador() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Sala s = (Sala) request.getSession().getAttribute("sala");
		
		long id = Long.parseLong(request.getParameter("id"));
		
		EntityTransaction et = ((EntityManager) getServletContext().getAttribute("em")).getTransaction();
		
		MicroControladorDAO microDao = new MicroControladorDAO();
		
		MicroControlador mc = new MicroControlador();
		mc.setId(id);
		
		Iterator<MicroControlador> i = s.getListaMicroControlador().iterator();
		
		
		try{
			while(i.hasNext()) {
				MicroControlador m = (MicroControlador) i.next();
				if (m.getId() == id){
					s.getListaMicroControlador().remove(m);
					request.getSession().removeAttribute("sala");
				}
			}
		} catch(ConcurrentModificationException e){
			//FIXME Se houver problema de acesso concorrente, verifique aqui!
		}
		
		
		et.begin();
		microDao.apagar(mc);
		et.commit();
		
		
		Message m = new Message(request, response, "Micro Controlador exclu�do com sucesso", "/ServletAlterarSala?id=" + s.getId());
		m.show();
	}


}
