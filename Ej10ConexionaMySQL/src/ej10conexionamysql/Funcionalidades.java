/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej10conexionamysql;

import com.mysql.jdbc.CommunicationsException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Jesus
 */
public class Funcionalidades {

    private static Connection conexion;
    private static DatabaseMetaData dbmd;
    static Scanner leer = new Scanner(System.in);
    private static double SalarioMinimoInterprofesional = 1200.5;

    public Funcionalidades(Connection conexion) throws SQLException {
        this.conexion = conexion;
        this.dbmd = conexion.getMetaData();
    }

    public void consultasDefinicionDatos() {
        //drop create alter
        String opcionMenu;
        do {
            System.out.println("Elige una opcion:\n\t1-Crear tabla.\n\t2-Borrar tabla.\n\t0-Salir:");
            opcionMenu = leer.nextLine();
            switch (opcionMenu) {
                case "1":
                    creaTabla();
                    break;
                case "2":
                    borrarTabla();
                    break;
                case "0":
                    System.out.println("Saliendo.....");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
        } while (!"0".equals(opcionMenu));
    }

    private static void creaTabla() {
        String columna;
        System.out.println("****Creacion tablas****");
        String consulta1 = "CREATE TABLE `departamentos` (\n" +
"  `dept_no` tinyint(2) NOT NULL,\n" +
"  `dnombre` varchar(15) DEFAULT NULL,\n" +
"  `loc` varchar(15) DEFAULT NULL,\n" +
"  PRIMARY KEY (`dept_no`)\n" +
")";
        String consulta2="CREATE TABLE `empleados` (\n" +
"  `emp_no` tinyint(4) NOT NULL,\n" +
"  `apellido` varchar(10) DEFAULT NULL,\n" +
"  `oficio` varchar(10) DEFAULT NULL,\n" +
"  `dir` int(11) DEFAULT NULL,\n" +
"  `feha_alta` date DEFAULT NULL,\n" +
"  `salario` float DEFAULT NULL,\n" +
"  `comision` float DEFAULT NULL,\n" +
"  `dept_no` tinyint(4) DEFAULT NULL,\n" +
"  PRIMARY KEY (`emp_no`),\n" +
"  KEY `dept_no` (`dept_no`),\n" +
"  CONSTRAINT `empleados_ibfk_1` FOREIGN KEY (`dept_no`) REFERENCES `departamentos` (`dept_no`)\n" +
")";
        try {
            System.out.print("Indica la tabla que quieres crear departamentos/empleados: ");
            String nombreTabla=leer.nextLine();
            Statement sentencia = conexion.createStatement();
            sentencia.executeUpdate("departamentos".equals(nombreTabla)?consulta1:consulta2);
            sentencia.close();
            System.out.println("Tabla creada con exito");
        } catch (SQLException ex) {
            System.out.println("No se pudo crear la tabla." + ex.getMessage());
        }

    }

//    private static void creaTabla() {
//        String columna;
//        System.out.println("****Creacion tabla****");
//        String consulta = "CREATE TABLE ";
//        System.out.println("Introduce un nombre para la tabla");
//        String nombreTabla = leer.nextLine();
//        consulta += nombreTabla + "(";
//        boolean correcto = true;
//        int numeroColumnas = 0;
//        do {
//            System.out.println("Numero de columnas que tendra la tabla:");
//            try {
//                numeroColumnas = Integer.parseInt(leer.nextLine());
//            } catch (NumberFormatException e) {
//                System.out.println("Numero no valido");
//                correcto = false;
//            }
//        } while (!correcto);
//        do {
//            System.out.println("Introduce el nombre de la columna seguido de el tipo de datos que almacenara (name datatype)");
//            columna = leer.nextLine();
//            numeroColumnas--;
//            if (numeroColumnas <= 0) {
//                consulta += columna + ", ";
//            }
//        } while (numeroColumnas <= 0);
//        consulta += columna + ");";
//        System.out.println("Consulta que se ejecutara: " + consulta);
//        try {
//            Statement sentencia = conexion.createStatement();
//            sentencia.executeUpdate(consulta);
//            sentencia.close();
//            System.out.println("Tabla creada con exito");
//        } catch (SQLException ex) {
//            System.out.println("No se pudo crear la tabla." + ex.getMessage());
//        }
//
//    }

    private static void borrarTabla() {
        System.out.println("****Borrar tabla****");
        String consulta = "DROP TABLE ";
        System.out.println("Introduce el nombre de la tabla");
        String nombreTabla = leer.nextLine();
        consulta += nombreTabla + ";";
        try {
            Statement sentencia = conexion.createStatement();
            sentencia.execute(consulta);
            sentencia.close();
            System.out.println("Tabla borrada con exito");
        } catch (SQLException ex) {
            System.out.println("No se pudo borrar la tabla." + ex.getMessage());
        }

    }

    private static void altas() {
        System.out.println("*****ALTA DE REGISTROS*****");
        String consulta = "INSERT INTO ";
        System.out.println("Introduce nombre de la tabla a la que añadir registros: ");
        String nombreTabla = leer.nextLine();
        try {
            Statement sentencia = conexion.createStatement();
            ResultSet rs = sentencia.executeQuery("SELECT * FROM " + nombreTabla.trim() + ";");
            ResultSetMetaData rSMD = rs.getMetaData();
            rs.last();
            int numeroIdentificador = ("departamentos".equals(nombreTabla.trim())) ? rs.getInt(1) + 10 : rs.getInt(1) + 1;
            System.out.println("numero identificador: " + numeroIdentificador);
            if ("departamentos".equals(nombreTabla.toLowerCase())) {
                consulta += nombreTabla + " VALUES (?,?,?);";
                PreparedStatement sentenciaInsercion = conexion.prepareStatement(consulta);
                System.out.print("Introduce un nombre de departamento: ");
                String nombreDept = leer.nextLine();
                System.out.print("Introduce una localidad: ");
                String nombreLocalidad = leer.nextLine();
                sentenciaInsercion.setInt(1, numeroIdentificador);
                sentenciaInsercion.setString(2, nombreDept);
                sentenciaInsercion.setString(3, nombreLocalidad);
                System.out.println("Consulta: " + sentenciaInsercion.toString());
                int filas = sentenciaInsercion.executeUpdate();
                System.out.println("Se han modificado " + filas + "filas");
            } else if ("empleados".equals(nombreTabla.toLowerCase())) {
                consulta += nombreTabla + " VALUES (?,?,?,?,?,?,?,?);";
                PreparedStatement sentenciaInsercion = conexion.prepareStatement(consulta);
                System.out.print("Introduce un apellido de empleado: ");
                String apellidoEmpl = leer.nextLine();
                System.out.print("Introduce un oficio: ");
                String nombreOficio = leer.nextLine();
                System.out.print("Introduce un dir: ");
                int nombreDir = Integer.parseInt(leer.nextLine());
                double salario;
                do {
                    System.out.print("Introduce un salario mayor que el SMI: ");
                    salario = Double.parseDouble(leer.nextLine());
                } while (salario < SalarioMinimoInterprofesional);
                System.out.print("Introduce una comision:");
                float comision = Float.parseFloat(leer.nextLine());
                int numeroDept;
                ResultSet rsComprobacion;
                do {
                    System.out.print("Introduce un numero de dept valido:");
                    numeroDept = Integer.parseInt(leer.nextLine());
                    Statement sentenciaComprobacion = conexion.createStatement();
                    rsComprobacion = sentenciaComprobacion.executeQuery("SELECT * FROM " + nombreTabla + " WHERE dept_no= " + numeroDept + " ;");
                } while (!rsComprobacion.first());
                sentenciaInsercion.setInt(1, numeroIdentificador);
                sentenciaInsercion.setString(2, apellidoEmpl);
                sentenciaInsercion.setString(3, nombreOficio);
                sentenciaInsercion.setInt(4, nombreDir);
                Date fecha = Date.valueOf(LocalDate.now());
                sentenciaInsercion.setDate(5, fecha);
                sentenciaInsercion.setDouble(6, salario);
                sentenciaInsercion.setFloat(7, comision);
                sentenciaInsercion.setInt(8, numeroDept);
                int filas = sentenciaInsercion.executeUpdate();
                System.out.println("Se han modificado " + filas + "filas");

            } else {
                System.out.println("No existe la tabla");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void bajas() {
        System.out.println("*****BAJA DE REGISTROS*****");
        String consulta = "DELETE FROM ";
        System.out.println("Introduce nombre de la tabla de la que quiere borrar registros: ");
        String nombreTabla = leer.nextLine();
        try {
            Statement sentencia = conexion.createStatement();
            ResultSet rs = sentencia.executeQuery("SELECT * FROM " + nombreTabla + ";");
            ResultSetMetaData rSMD = rs.getMetaData();
            if ("departamentos".equals(nombreTabla.toLowerCase())) {
                consulta += nombreTabla + " WHERE dept_no=";
                System.out.print("Introduce el numero de departamento que quiere eliminar:");
                int dept_no = Integer.parseInt(leer.nextLine());
                Statement sentenciaDept = conexion.createStatement();
                ResultSet rsDept = sentenciaDept.executeQuery("SELECT * FROM " + nombreTabla + " WHERE dept_no=" + dept_no + ";");
                if (rsDept.first()) {
                    consulta += dept_no + ";";
                    Statement sentenciaUpdateDept = conexion.createStatement();
                    System.out.println("consulta: " + consulta);
                    int filas = sentenciaUpdateDept.executeUpdate(consulta);
                    System.out.println("Se han modificado " + filas + "filas");
                } else {
                    System.out.println("No existe el registro indicado.");
                }
            } else if ("empleados".equals(nombreTabla.toLowerCase())) {
                consulta += nombreTabla + " WHERE emp_no=";
                System.out.print("Introduce el numero de empleado que quiere eliminar:");
                int empl_no = Integer.parseInt(leer.nextLine());
                Statement sentenciaEmpl = conexion.createStatement();
                ResultSet rsDept = sentenciaEmpl.executeQuery("SELECT * FROM " + nombreTabla + " WHERE emp_no=" + empl_no + ";");
                if (rsDept.first()) {
                    consulta += empl_no + ";";
                    Statement sentenciaUpdateEmpl = conexion.createStatement();
                    System.out.println("Consulta: " + consulta);
                    int filas = sentenciaUpdateEmpl.executeUpdate(consulta);
                    System.out.println("Se han modificado " + filas + "filas");
                } else {
                    System.out.println("No existe el registro indicado.");
                }
            } else {
                System.out.println("La tabla no esta en la BBDD");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void modificarTabla() {
        System.out.println("*****MODIFICACION DE REGISTROS*****");
        String consulta = "UPDATE ";
        System.out.print("Introduce nombre de la tabla que quieres modificar registros: ");
        String nombreTabla = leer.nextLine();
        try {
            if ("departamentos".equals(nombreTabla.toLowerCase())) {
                System.out.print("Introduce el dept_no del departamento que quieres actualizar: ");
                int dept_no = Integer.parseInt(leer.nextLine());
                Statement sentencia = conexion.createStatement();
                ResultSet rs = sentencia.executeQuery("SELECT * FROM " + nombreTabla + " WHERE dept_no=" + dept_no + ";");
//                ResultSetMetaData rSMD = rs.getMetaData();
                if (!rs.first()) {
                    System.out.println("No existe el registro.");
                } else {
                    consulta += nombreTabla + " SET dept_no=" + dept_no + ", dnombre=?, loc=? WHERE dept_no=" + dept_no + ";";
                    PreparedStatement sentenciaInsercion = conexion.prepareStatement(consulta);
                    System.out.print("Introduce un nombre de departamento: ");
                    String nombreDept = leer.nextLine();
                    System.out.print("Introduce una localidad: ");
                    String nombreLocalidad = leer.nextLine();
                    sentenciaInsercion.setString(1, nombreDept);
                    sentenciaInsercion.setString(2, nombreLocalidad);
                    int filas = sentenciaInsercion.executeUpdate();
                    System.out.println("Se han modificado " + filas + "filas");
                }
            } else if ("empleados".equals(nombreTabla.toLowerCase())) {
                System.out.print("Introduce el empl_no del empleado que quieres modificar:");
                int empl_no = Integer.parseInt(leer.nextLine());

                Statement sentencia = conexion.createStatement();
                ResultSet rs = sentencia.executeQuery("SELECT * FROM " + nombreTabla + " WHERE emp_no=" + empl_no + ";");
                if (!rs.first()) {
                    System.out.println("no existe ningune empleado con el empl_no indicado en la BBDD.");
                } else {

                    consulta += nombreTabla + " SET emp_no=" + empl_no + ", apellido=?, oficio=?, dir=?, fecha_alta=?, salario=?, comision=?, dept_no=? WHERE emp_no=" + empl_no + ";";
                    PreparedStatement sentenciaInsercion = conexion.prepareStatement(consulta);
                    System.out.print("Introduce un apellido de empleado: ");
                    String apellidoEmpl = leer.nextLine();
                    System.out.print("Introduce un oficio: ");
                    String nombreOficio = leer.nextLine();
                    System.out.print("Introduce un dir: ");
                    int nombreDir = Integer.parseInt(leer.nextLine());
                    double salario;
                    do {
                        System.out.print("Introduce un salario mayor que el SMI: ");
                        salario = Double.parseDouble(leer.nextLine());
                    } while (salario < SalarioMinimoInterprofesional);
                    System.out.print("Introduce una comision:");
                    double comision = Double.parseDouble(leer.nextLine());
                    int numeroDept;
                    ResultSet rsComprobacion;
                    do {
                        System.out.print("Introduce un numero de dept valido:");
                        numeroDept = Integer.parseInt(leer.nextLine());
                        Statement sentenciaComprobacion = conexion.createStatement();
                        rsComprobacion = sentenciaComprobacion.executeQuery("SELECT * FROM " + nombreTabla + " WHERE dept_no=" + numeroDept + ";");
                    } while (!rsComprobacion.first());
                    sentenciaInsercion.setString(1, apellidoEmpl);
                    sentenciaInsercion.setString(2, nombreOficio);
                    sentenciaInsercion.setInt(3, nombreDir);
                    Date fecha = Date.valueOf(LocalDate.now());
                    sentenciaInsercion.setDate(4, fecha);
                    sentenciaInsercion.setDouble(5, salario);
                    sentenciaInsercion.setDouble(6, comision);
                    sentenciaInsercion.setInt(7, numeroDept);
                    int filas = sentenciaInsercion.executeUpdate();
                    System.out.println("Se han modificado " + filas + "filas");
                }
            } else {
                System.out.println("No existe la tabla");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void consultasModificacionDatos() {
        String opcion;
        do {
            System.out.println("Elige una opcion:\n\t1-Altas\n\t2-Bajas\n\t3-Modificaciones\n\t0-Salir");
            opcion = leer.nextLine();
            switch (opcion) {
                case "1":
                    altas();
                    break;
                case "2":
                    bajas();
                    break;
                case "3":
                    modificarTabla();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Opcion incorrexta");
            }
        } while (!"0".equals(opcion));
    }

    public void informacionBBDD() {
        System.out.println("**********Metadatos**********");
        try {
            System.out.println("Nombre: " + dbmd.getDatabaseProductName());
            System.out.println("Driver: " + dbmd.getDriverName());
            System.out.println("URL: " + dbmd.getURL());
            System.out.println("User: " + dbmd.getUserName());
        } catch (SQLException e) {
            System.out.println("Excepcion: " + e.getMessage());
        }
    }

    public void informacionBBDDColumnas() {
        System.out.println("**********INFORMACION COLUMNAS**********");
        ResultSet infoColumnas;
        try {
            infoColumnas = dbmd.getColumns(null, null, null, null);
            while (infoColumnas.next()) {
                System.out.println("Tabla: " + infoColumnas.getString(3) + " Columna: " + infoColumnas.getString("COLUMN_NAME") + ", Tipo: " + infoColumnas.getString("TYPE_NAME") + ", Tamaño: " + infoColumnas.getString("COLUMN_SIZE") + ", ¿Es nula?: " + infoColumnas.getString("IS_NULLABLE"));
            }
        } catch (SQLException ex) {
            System.out.println("Excepcion al buscar las infoColumnas.");
        }
    }

    public void informacionBBDDTablas() {
        System.out.println("**********INFORMACION TABLAS**********");
        try {
            ResultSet infoTablas;
            infoTablas = dbmd.getTables(null, "ejemplo", null, null);
            while (infoTablas.next()) {
                System.out.print(infoTablas.getString(4) + " - Catálogo: " + infoTablas.getString(1) + ", Esquema: " + infoTablas.getString(2) + ", Nombre: " + infoTablas.getString(3));
            }
        } catch (SQLException ex) {
            System.out.println("Excepcion al buscar las tablas.");
        }
    }

    public void consultasDescripcionDatos() {
        try {
            Statement sentencia = conexion.createStatement();
            System.out.println("Introduce una consulta:");
            String consulta = leer.nextLine();
            ResultSet resul = sentencia.executeQuery(consulta);
            ResultSetMetaData rSMD = resul.getMetaData();

            while (resul.next()) {
                for (int i = 1; i < rSMD.getColumnCount() + 1; i++) {
                    System.out.printf("%-20s", resul.getString(i));

                }
                System.out.println("");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void subirSalarioProcedimiento() {
        try {
            System.out.print("Indique el dept_no al que quiere aplicarle la subida: ");
            int dept_no = Integer.parseInt(leer.nextLine());
            System.out.print("Indique el porcentaje de subida que quiere aplicar: ");
            int porcentajeSubida = Integer.parseInt(leer.nextLine());

            String sql = "{CALL subida_salario(?,?)}";
//            PreparedStatement sentencia= conexion.prepareStatement(sql);
            CallableStatement sentencia = conexion.prepareCall(sql);
            sentencia.setInt(1, dept_no);
            sentencia.setInt(2, porcentajeSubida);
            sentencia.execute();
            sentencia.close();
        } catch (SQLException ex) {
            Logger.getLogger(Funcionalidades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearInformes() {
        String reportSource = "./plantilla/plantilla_Actividad12.jrxml";
        String reportHTML = "./informes/Informe.html";
        String reportPDF = "./informes/Informe.pdf";
        String reportXML = "./informes/Informe.xml";
        Map<String, Object> params = new HashMap<>();
        params.put("titulo", "RESUMEN DATOS DE DEPARTAMENTOS.");
        params.put("autor", "Jesus");
        params.put("fecha", java.time.LocalDate.now().toString());
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            JasperPrint MiInforme = JasperFillManager.fillReport(jasperReport, params, conexion);
            JasperViewer.viewReport(MiInforme);
            JasperExportManager.exportReportToHtmlFile(MiInforme, reportHTML);
            JasperExportManager.exportReportToPdfFile(MiInforme, reportPDF);
            JasperExportManager.exportReportToXmlFile(MiInforme, reportXML, false);
            System.out.println("ARCHIVOS CREADOS");
        } catch (JRException ex) {
            System.out.println(" Error Jasper.");
            ex.printStackTrace();
        }
    }

}
