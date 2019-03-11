package conectToBBDD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class ConectarBBDD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//generar la conexion
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebaClase", "root", "");
			
			//crear un objeto de tipo Statement para realizar las consultas
			Statement miStatement=(Statement) miConexion.createStatement();
			
			//pendiente probar comandos para insertar 
			//dejo comentado el insert, porque ya lo he hecho, y me da error porque es repetido
//			String instruccionSql = "INSERT INTO PRODUCTOS1 (CODARTICULO, NOMBRE, PRECIO, IMPORTADO) values(3, 'peras', 2, 0)";
//			miStatement.executeUpdate(instruccionSql);
			String instruccionSql = "UPDATE PRODUCTOS1 SET PRECIO = 7 WHERE NOMBRE = 'cafe'";
			miStatement.executeUpdate(instruccionSql);
			
			//ejecutar sql
			ResultSet miResulset=miStatement.executeQuery("SELECT * FROM PRODUCTOS1");
			
			//Bucle para visualizar dichos datos
			while(miResulset.next()){
				System.out.println(miResulset.getString("Nombre") +" " + miResulset.getString("Precio"));
				
			}
		}
			catch(Exception e) {
				System.out.println("no conecta!");
				//si quiero saber el tipo de error
				e.printStackTrace();
			}
		}

	}


