package com.testeS.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.testeS.bean.Telefone;
import com.testeS.bean.Usuario;

public class UsuarioDao {

	public static Connection getConnection() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "root", "");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static int deletarUsuario(Usuario u) {
		int status = 0;

		try {
			
			Connection con = getConnection();
			con.setAutoCommit(false);
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("DELETE FROM telefone WHERE id_fone_user=?");
			ps.setInt(1, u.getId());
			
			ps = (PreparedStatement) con.prepareStatement("DELETE FROM usuario WHERE id=?");
			ps.setInt(1, u.getId());
			status = ps.executeUpdate();
			con.commit();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static int salvarUsuario(Usuario u) {
		int status = 0;

		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("INSERT INTO usuario (nome, password, email) VALUES (?,?,?)");
			ps.setString(1, u.getNome());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getEmail());
			status = ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public static int login(Usuario u){
		ResultSet status;
		int s = 0;
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("SELECT * FROM usuario WHERE nome=? AND password=?");
			ps.setString(1, u.getNome());
			ps.setString(2, u.getPassword());
			status = ps.executeQuery();
			
			if(status.next() ) {
				s=1;
				System.out.println(status);
			}else {
				System.out.println(0);
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return s;
	}
	
	public static int salvarTelefone(Telefone t) {
		int status = 0;

		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("INSERT INTO telefone (id_fone_user, fone) VALUES (?,?)");
			ps.setInt(1, t.getId());
			ps.setString(2, t.getFone());
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static Usuario getRegistroById(int id) {
		Usuario usuario = null;

		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM usuario LEFT JOIN telefone ON usuario.id=telefone.id_fone_user WHERE usuario.id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setPassword(rs.getString("password"));
				usuario.setEmail(rs.getString("email"));
				usuario.setTelefone(rs.getString("fone"));
				

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return usuario;
	}

	public static int updateUsuario(Usuario u) {
		int status = 0;

		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("UPDATE usuario SET nome=?, password=?, email=? WHERE id=?");
			ps.setString(1, u.getNome());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getEmail());
			ps.setInt(4, u.getId());
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("ERRO NO UPDATE " + e);
		}
		return status;
	}

	public static List<Usuario> getAllUsuarios() {
		List<Usuario> list = new ArrayList<Usuario>();
		List<Telefone> fones = new ArrayList<Telefone>();
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(
					"SELECT usuario.id,usuario.nome,usuario.password,usuario.email,telefone.fone AS telefone FROM usuario LEFT JOIN telefone ON usuario.id=telefone.id_fone_user");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setPassword(rs.getString("password"));
				usuario.setEmail(rs.getString("email"));
				usuario.setTelefone(rs.getString("telefone"));
				
				if(rs.getString("telefone") != null) {
					Telefone tel = new Telefone();
					tel.setId(usuario.getId());
					tel.setFone(rs.getString("telefone"));
					fones.add(tel);
					usuario.setFones(fones);
				}
				

				list.add(usuario);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

}
