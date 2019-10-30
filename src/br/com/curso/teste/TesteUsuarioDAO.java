package br.com.curso.teste;

import java.util.List;

import br.com.curso.entidades.Usuario;
import br.com.curso.jdbc.CargoDAO;
import br.com.curso.jdbc.UsuarioDAO;

public class TesteUsuarioDAO {

	public static void main(String[] args) {
		//testeCadastrar();
		//testeAlterar();
	    //testeExcluir();
	    //testeBuscarTodos();
		//testeBuscaPorId();
		//testeBuscarPorNome();
		//testelistarUsuarioCargo(); 
		//testeAutenticar();
	}
	
	private static void testeBuscaPorId() {
		UsuarioDAO usuDao = new UsuarioDAO();
		Usuario usuario = usuDao.buscarPorId(1);
		
		System.out.println("Id: " + usuario.getId());
		System.out.println("Nome: " + usuario.getNome());
		System.out.println("Login: " + usuario.getLogin());
		System.out.println("Senha: " + usuario.getSenha());
		System.out.println("Id Cargo : " + usuario.getIdCargo());

	}

	private static void testeCadastrar() {
		Usuario usu = new Usuario();
		usu.setNome("Marcus Silva");
		usu.setLogin("Msilva");
		usu.setSenha("123456");
		usu.setIdCargo(1);
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.cadastrar(usu);
	}
	
	private static void testeAlterar() {
		Usuario usuAlt = new Usuario();
		usuAlt.setNome("Vitoria Silva");
		usuAlt.setLogin("Vsilva");
		usuAlt.setSenha("654321");
		usuAlt.setIdCargo(3);
		usuAlt.setId(14);
		
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.alterar(usuAlt);
	}
	
	private static void testeExcluir() {
		Usuario usuExc = new Usuario();
		
		usuExc.setId(4);
		
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.excluir(usuExc);
	}
	
	private static void testeBuscarTodos() {
		UsuarioDAO usuTod = new UsuarioDAO();
	
		List<Usuario> listaResultado = usuTod.buscarTodos();
		for (Usuario u : listaResultado) {
			System.out.println(u.getId()+" "+u.getNome()+" "+u.getLogin()+" "+u.getSenha()+" "+u.getIdCargo());
		}	
	}
	
	private static void testeBuscarPorNome(){
		UsuarioDAO usuNom = new UsuarioDAO();
	
		Usuario usuario = usuNom.buscarPorNome("Eldivan Alves");
			
		System.out.println("Id: " + usuario.getId());
		System.out.println("Nome: " + usuario.getNome());
		System.out.println("Login: " + usuario.getLogin());
		System.out.println("Senha: " + usuario.getSenha());
			
	}
	private static void testelistarUsuarioCargo() {
		UsuarioDAO usuCargoUsu = new UsuarioDAO();
	
		List<Usuario> listaResultado = usuCargoUsu.listarUsuarioCargo();
		
		for (Usuario usucar : listaResultado) {
			
			System.out.println(usucar.getCargo().getId()+" "+ usucar.getCargo().getNome_Do_Cargo()+" "+usucar.getNome()+" | "+ usucar.getLogin());
			
		}
	}
	
	private static void testeAutenticar() {
		Usuario usu = new Usuario();
		usu.setLogin("Psilva");
		usu.setSenha("654321");
		
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.autenticar(usu);
		
		System.out.println(usuDao.autenticar(usu).getNome());
	
		
		
	}
	
}
