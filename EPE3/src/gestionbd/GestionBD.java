
package gestionbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import principal.principal;


public class GestionBD {

    
     Connection conexion = null;
    Statement sentencia = null;
    ResultSet resultados = null;
    String DRIVER = "org.sqlite.JDBC";
    String NOMBREBD = "JNJ.sqlite";
    String URL = "jdbc:sqlite:"+NOMBREBD;
    
    
    
    
   
    
    
    
     public void crearBD(){
        
        try{
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL);
            
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e, 
                    "Error!!", JOptionPane.ERROR_MESSAGE);
        }
        System.out.println("BD creada!!");
        
    }//.
     
     
     public void crearTabla_alumno(){
       
        try{
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL);
            
            sentencia = conexion.createStatement();
            String sql = "CREATE TABLE ALUMNO(" +
                    "RUT         INT     PRIMARY KEY NOT NULL, " +
                    "NOMBRE     TEXT    NOT NULL, " +
                    "APELLIDO_P   TEXT    NOT NULL,  "+
                    "APELLIDO_M     TEXT    NOT NULL, "+
                    "SEXO TEXT   NOT NULL, "+
                    "JORNADA TEXT NOT NULL)";
            sentencia.executeUpdate(sql);
            sentencia.close();
            conexion.close();
            
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e, 
                    "Error!!", JOptionPane.ERROR_MESSAGE);
        }
        System.out.println("tabla creada!!"); 
        
    }//
     
          public void crearTabla_profesor(){
       
        try{
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL);
            
            sentencia = conexion.createStatement();
            String sql = "CREATE TABLE PROFESOR(" +
                    "RUT         INT     PRIMARY KEY NOT NULL, " +
                    "NOMBRE     TEXT    NOT NULL, " +
                    "APELLIDO   TEXT    NOT NULL,  "+
                    "SEXO TEXT   NOT NULL, "+
                    "ASIGNATURA TEXT NOT NULL)";
            sentencia.executeUpdate(sql);
            sentencia.close();
            conexion.close();
            
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e, 
                    "Error!!", JOptionPane.ERROR_MESSAGE);
        }
        System.out.println("tabla creada!!"); 
        
    }//
     
public void insertarDatos_alumno(int rut, String nombre, String apellido_p, String apellido_m,
             String sexo,String jornada){
       
        try{
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL);
            
            sentencia = conexion.createStatement();
            String sql = "INSERT INTO ALUMNO("+
                    "RUT, NOMBRE, APELLIDO_P, APELLIDO_M, SEXO, JORNADA) VALUES(" +
                    "'"+rut+"', '"+nombre+"','"+apellido_p+"','"+apellido_m+"','"+sexo+"','"+jornada+"')";
            
            sentencia.executeUpdate(sql);
            sentencia.close();
            conexion.close();
            
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e, 
                    "Error!!", JOptionPane.ERROR_MESSAGE);
        }
        JOptionPane.showMessageDialog(null,"datos ingresados con exito"); 
        
    }//
     public void insertarDatos_profesor(int rut, String nombre, String apellido,
             String sexo,String asignatura){
       
        try{
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL);
            
            sentencia = conexion.createStatement();
            String sql = "INSERT INTO PROFESOR("+
                    "RUT, NOMBRE, APELLIDO, SEXO, ASIGNATURA) VALUES(" +
                    "'"+rut+"', '"+nombre+"','"+apellido+"','"+sexo+"','"+asignatura+"')";
            
            sentencia.executeUpdate(sql);
            sentencia.close();
            conexion.close();
            
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e, 
                    "Error!!", JOptionPane.ERROR_MESSAGE);
        }
       JOptionPane.showMessageDialog(null,"datos ingresados exitosamente "); 
        
    }//    
     
     
     public void mostrarDatosAlumno(JTable tbl_alumno ){
         
         try{
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL);
            sentencia = conexion.createStatement();
            String sql = "SELECT * FROM ALUMNO";
            resultados = sentencia.executeQuery(sql);
            int fila = 0;
            while(resultados.next()){
                
                tbl_alumno.setValueAt(resultados.getInt("RUT"), fila, 0);
                tbl_alumno.setValueAt(resultados.getString("NOMBRE"), fila, 1);
                tbl_alumno.setValueAt(resultados.getString("APELLIDO_P"), fila, 2);
                tbl_alumno.setValueAt(resultados.getString("APELLIDO_M"),fila,3);
                tbl_alumno.setValueAt(resultados.getString("SEXO"), fila, 4);
                tbl_alumno.setValueAt(resultados.getString("JORNADA"), fila, 5);
                
                fila++;
            }
            
            resultados.close();
            sentencia.close();
            conexion.close();
            
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e, 
                    "Error!!", JOptionPane.ERROR_MESSAGE);
        }
         
         
         
     }//.
                public void mostrarDatosProfe(JTable tbl_profe ){
         
         try{
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL);
            sentencia = conexion.createStatement();
            String sql = "SELECT * FROM PROFESOR";
            resultados = sentencia.executeQuery(sql);
            int fila = 0;
            while(resultados.next()){
                
                tbl_profe.setValueAt(resultados.getInt("RUT"), fila, 0);
                tbl_profe.setValueAt(resultados.getString("NOMBRE"), fila, 1);
                tbl_profe.setValueAt(resultados.getString("APELLIDO"), fila, 2);
                tbl_profe.setValueAt(resultados.getString("SEXO"),fila,3);
                tbl_profe.setValueAt(resultados.getString("ASIGNATURA"), fila, 4);
                
                
                fila++;
            }
            
            resultados.close();
            sentencia.close();
            conexion.close();
            
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e, 
                    "Error!!", JOptionPane.ERROR_MESSAGE);
        }
         
         
         
     }//.

              
                
                
                
                
                public void EliminarDatosAlumno(int rut){
         
         try{
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL);
            sentencia = conexion.createStatement();
            String sql = "DELETE  FROM ALUMNO WHERE RUT = '"+rut+"'";
            resultados = sentencia.executeQuery(sql);
            
       
            
            resultados.close();
            sentencia.close();
            conexion.close();
         
            
            JOptionPane.showMessageDialog(null, "Datos eliminados correctamente");
            
            
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e, 
                    "Error!!", JOptionPane.ERROR_MESSAGE);
        }
         
         
         
     }//.
     
                
                
                
    public static void main(String[] args) {
                GestionBD gbd = new GestionBD();
gbd.crearTabla_profesor();
    }
    
    
}
