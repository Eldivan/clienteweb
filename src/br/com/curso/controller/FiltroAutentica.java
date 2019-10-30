package br.com.curso.controller;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FiltroAutentica
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD
		}
					, urlPatterns = { "/*" })
public class FiltroAutentica implements Filter {

   
    public FiltroAutentica() {
       
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 
		// casting do httpServlet request
		HttpServletRequest  httpServletRequest = (HttpServletRequest) request;
		
		String url= httpServletRequest.getRequestURI();
		
		//capturando a sessao
		HttpSession sessao = httpServletRequest .getSession();
		
		// esta logado?
		if(sessao.getAttribute("usulogado")!= null || url.lastIndexOf("login.html")>-1 ||
				url.lastIndexOf("autcontroller.do") >-1 ) {
			chain.doFilter(request, response);  // permite o fluxo de requisição
		}else {
			//redireciona para o login
			((HttpServletResponse)response).sendRedirect("login.html");
		}
		
		
	}

		public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
