package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.entities.Chiste;


public class DaoChiste {
	public ArrayList<Chiste> getChistes(String categoria,Connection con) {
		ResultSet rs;
		ArrayList<Chiste> chistes = new ArrayList<Chiste>();

		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "Select * FROM CHISTE C , CATEGORIA H , PUNTOS P WHERE C.IDCATEGORIA = H.ID AND C.ID = P.IDCHISTE AND C.IDCATEGORIA LIKE '"+categoria+"' ";
			rs = st.executeQuery(ordenSql);

			while (rs.next()) {
				Chiste coche = new Chiste();
				coche.setId(rs.getInt("ID"));
				coche.setAdopo(rs.getString("ADOPO"));
				coche.setDescripcion(rs.getString("DESCRIPCION"));
				coche.setTitulo(rs.getString("TITULO"));
				coche.setIdcategoria(rs.getInt("IDCATEGORIA"));
				coche.setPuntos(rs.getInt("PUNTOS"));
				
				chistes.add(coche);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			System.out
					.println("Error al acceder a la BDs: " + e.getLocalizedMessage());
		}
		return chistes;
	}

}
