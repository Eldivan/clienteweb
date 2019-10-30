package br.com.curso.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.curso.entidades.Cargo;
import br.com.curso.entidades.Usuario;
import br.com.curso.jdbc.UsuarioDAO;


@WebServlet("/usuariocontroller.do")
public class UsuarioController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
  
    public UsuarioController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		String acao = request.getParameter("acao");
		UsuarioDAO usuarioDao = new UsuarioDAO();
				
		if (acao!=null && acao.equals("exc")) {
			Usuario usuario = new Usuario();
			String id = request.getParameter("id");
			usuario.setId(Integer.parseInt(id));
			usuarioDao.excluir(usuario);
	
			response.sendRedirect("usuariocontroller.do?acao=lis");			
		}
		
		if (acao !=null && acao.equals("alt")) {
			
			String id = request.getParameter("id");
			Usuario usuario =usuarioDao.buscarPorId(Integer.parseInt(id));
			
			request.setAttribute("usuario", usuario);
			
			RequestDispatcher saida = request.getRequestDispatcher("frmusuario.jsp");
			saida.forward(request, response);
			
		}
		
		if (acao !=null && acao.equals("cad")) {
			
			Usuario usuario = new Usuario();
			usuario.setId(0);
			usuario.setNome("");
			usuario.setLogin("");
			usuario.setSenha("");
			usuario.setIdCargo(0);
			
			request.setAttribute("usuario", usuario);
			RequestDispatcher saida = request.getRequestDispatcher("frmusuario.jsp");
			saida.forward(request, response);
			
		}
	
		
		if (acao!=null && acao.equals("lis")) {
		List<Usuario> lista = usuarioDao.buscarTodos();
		
		request.setAttribute("lista", lista);
		
		RequestDispatcher saida = request.getRequestDispatcher("listausuarios.jsp");
		saida.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		System.out.println("Chamando o metodo Post");
		
		String id= request.getParameter("txtid");
		String nome= request.getParameter("txtnome");	
		String login= request.getParameter("txtlogin");
		String senha= request.getParameter("txtsenha");
		String idCargo = request.getParameter("txtidcargo");
		
		Usuario usuario = new Usuario();
		
		if (id!=""){
			usuario.setId(Integer.parseInt(id));
		}
		usuario.setNome(nome);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		usuario.setIdCargo(Integer.parseInt(idCargo));
		
				
		UsuarioDAO usuDao =new UsuarioDAO();
		usuDao.salvar(usuario);
		
		response.sendRedirect("usuariocontroller.do?acao=lis");
	}

}
