package br.com.curso.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.curso.entidades.Cargo;
import br.com.curso.entidades.Usuario;

public class UsuarioDAO {

	private Connection con = Conexao.getConnection();

	
	public Usuario autenticar(Usuario usuario) {
		
		String sql = "select * from usuario where login = ? and senha = ?";
		Usuario usuRet = null;
		try (PreparedStatement ps = con.prepareStatement(sql)) {
			
			Usuario usuRetorno = new Usuario();
			
			ps.setString(1, usuario.getLogin());
			ps.setString(2, usuario.getSenha());
			
			ResultSet rs = ps.executeQuery();

			if( rs.next()) {
				usuRet = new Usuario();
				
				usuRet.setId(rs.getInt("id"));
				usuRet.setNome(rs.getString("nome"));
				usuRet.setLogin(rs.getString("login"));
				usuRet.setSenha(rs.getString("senha"));	
			}

		} catch (SQLException e) {
			System.out.println("Usuario naõ cadastrado!!!");
			e.printStackTrace();
		}

		return usuRet;
	}

	public void cadastrar(Usuario usuario) {
		String sql = "insert into usuario (nome, login, senha, id_cargo) values (?,?,?,?);";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getLogin());
			ps.setString(3, usuario.getSenha());
			ps.setInt(4, usuario.getIdCargo());

			ps.execute();
			ps.close();

			System.out.println("Cadastrado com suceso!!");
		} catch (SQLException e) {
			System.out.println("Falha no cadastro" + e.getMessage());
			e.printStackTrace();
		}
	}

	public void alterar(Usuario usuario) {
		String sql = "update usuario set nome=?, login=?, senha=?, id_cargo=?  where id=?;";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getLogin());
			ps.setString(3, usuario.getSenha());
			ps.setInt(4, usuario.getIdCargo());
			
			ps.setInt(5, usuario.getId());

			ps.execute();
			ps.close();

			System.out.println("Alteração realizada com suceso!!");
		} catch (SQLException e) {
			System.out.println("Falha no registro" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void salvar(Usuario usuario) {
		
		if (usuario.getId()!=null && usuario.getId()!=0) {
		alterar(usuario);
		}else {
			cadastrar(usuario);
		}
	}
	

	public void excluir(Usuario usuario) {
		String sql = "delete from usuario where id=?;";
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, usuario.getId());

			ps.execute();
			ps.close();

			System.out.println("Exclusão realizada com suceso!!");
		} catch (SQLException e) {
			System.out.println("Registro não identificado!!" + e.getMessage());
			e.printStackTrace();
		}
	}

	public List<Usuario> buscarTodos() {

		String sql = "select * from usuario";
		List<Usuario> lista = new ArrayList<>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Usuario usu = new Usuario();
				usu.setId(rs.getInt("id"));
				usu.setNome(rs.getString("nome"));
				usu.setLogin(rs.getString("login"));
				usu.setSenha(rs.getString("senha"));
				usu.setIdCargo(rs.getInt("id_cargo"));
				
				lista.add(usu);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return lista;
	}

	public Usuario buscarPorId(Integer id) {
		Usuario usu = null;
		String sql = "select * from usuario where id = ?";

		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				usu = new Usuario();
				usu.setId(rs.getInt("id"));
				usu.setLogin(rs.getString("login"));
				usu.setNome(rs.getString("nome"));
				usu.setSenha(rs.getString("senha"));
				usu.setIdCargo(rs.getInt("id_cargo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usu;
	}

	public Usuario buscarPorNome(String nome) {
		Usuario usu = null;
		String sql = "select * from usuario where nome = ?";

		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, nome);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				usu = new Usuario();
				usu.setId(rs.getInt("id"));
				usu.setLogin(rs.getString("login"));
				usu.setNome(rs.getString("nome"));
				usu.setSenha(rs.getString("senha"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usu;
	}

	public List<Usuario> listarUsuarioCargo() {

		String sql = "select cargo.id ,cargo.nome_do_cargo , usuario.nome, usuario.login from cargo, usuario where cargo.id = usuario.id_cargo;";
		List<Usuario> lista = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Cargo cargo = new Cargo();
				cargo.setId(rs.getInt("id"));
				cargo.setNome_Do_Cargo(rs.getString("nome_do_cargo"));

				Usuario usu = new Usuario();
				usu.setLogin(rs.getString("login"));
				usu.setNome(rs.getString("nome"));

				usu.setCargo(cargo);
				usu.getNome_Do_Cargo();
				usu.getIdCargo();

				lista.add(usu);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

}
