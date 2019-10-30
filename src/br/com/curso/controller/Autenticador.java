package br.com.curso.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.SendResult;

import br.com.curso.entidades.Usuario;
import br.com.curso.jdbc.UsuarioDAO;

/**
 * Servlet implementation class Autenticador
 */
@WebServlet(name = "autcontroller.do", urlPatterns = { "/autcontroller.do" })
public class Autenticador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Autenticador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession sessao = request.getSession(false);
		if(sessao != null) {
			sessao.invalidate();
		}
		response.sendRedirect("login.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");  
		String senha = request.getParameter("senha");
	
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		
		Usuario usuRetorno= usuarioDao.autenticar(usuario);
		if (usuRetorno != null ) {
			
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usulogado", usuRetorno);
			
			sessao.setMaxInactiveInterval(30000);
			
			 request.getRequestDispatcher("index.jsp").forward(request, response); 
		
		}else {
			
			response.sendRedirect("login.html");
		}
		
	}

}
