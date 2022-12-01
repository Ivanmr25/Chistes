package Prueba;

import java.sql.Connection;
import java.util.ArrayList;

import Connection.Conexion;
import model.dao.DaoCategoria;
import model.dao.DaoChiste;
import model.entities.Categoria;
import model.entities.Chiste;


public class Prueba {

	public static void main(String[] args) {
		Connection con = Conexion.conecta();
		ArrayList<Chiste> bicis =  new DaoChiste().getChistes("%", con);
		
		for (Chiste bici:bicis) {
			System.out.println(bici);
		}

	}

}
