package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.entities.Categoria;


public class DaoCategoria {
	public ArrayList<Categoria> getCategorias(Connection con) {
		ResultSet rs;
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
	
		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "SELECT * from CATEGORIA";
			rs = st.executeQuery(ordenSql);

			while (rs.next()) {
				Categoria categoria = new Categoria();
				categoria.setId(rs.getInt("ID"));
				categoria.setNombre(rs.getString("NOMBRE"));
				
				categorias.add(categoria);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			System.out
					.println("Error al acceder a la BDs: " + e.getMessage());
		}
		return categorias;
	}

}
