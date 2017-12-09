/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestempl;

import ConectorBBDDMySQL.ConectorBBDD;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import modelo.Modelo;
import org.xml.sax.SAXException;
import vista.Vista;

/**
 *
 * @author Jc
 */
public class GestEmpl {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException, IOException, ParserConfigurationException, SAXException, FileNotFoundException, TransformerException, JAXBException {
        Modelo m = new Modelo();
        ConectorBBDD conBBDD= new ConectorBBDD();
        Vista v = new Vista(m,conBBDD);
        boolean salir = false;
        Scanner sc = new Scanner(System.in);
        String menu = "\nInicio: \n\t01 Mostrar empleados\n\t02 Generar aleatorios\n\t03 Alta de empleado\n"
                + "Ficheros texto: \n\t11 Escribir delimitado\n\t12 Escribir encolumnado\n\t13 Leer delimitado\n \t14 Leer encolumnado\n"
                + "Ficheros binarios: \n\t15 Exportar binario\n\t16 Importar binario\n\t17 Exportar objeto\n\t18 Importar objeto"
                + "\n********BBDD********\n\t19 Exportar a BBDD\n\t20 Importar de BBDD"
                + "\nSalir\n\n"
                + "Escriba una opción: ";
        String opcion;
        do {
            System.out.print(menu);
            opcion = sc.nextLine();
            switch (opcion.toLowerCase()) {
                case "01":
                case "mostrar empleados":
                case "mostrar":
                    m.mostrarEmpleados();
                    break;
                case "02":
                case "generar aleatorios":
                case "generar":
                case "aleatorios":
                    v.cargar_aleatorios();
                    break;
                case "03":
                case "alta de empleado":
                case "alta":
                    v.altaEmpleado();
                    break;
                case "11":
                case "escribir delimitado":
                    v.escribirDelimitado();
                    break;
                case "12":
                case "escribir encolumnado":
                    v.escribirEncolumnado();
                    break;
                case "13":
                case "leer delimitado":
                    v.leerDelimitado();
                    break;
                case "14":
                case "leer encolumnado":
                    v.leerEncolumnado();
                    break;
                case "15":
                case "exportar binario":
                    v.exportarBinario();
                    break;
                case "16":
                case "importar binario":
                    v.importarBinario();
                    break;
                case "17":
                case "exportar objeto":
                    v.exportarObjeto();
                    break;
                case "18":
                case "importar objeto":
                    v.importarObjeto();
                    break;
                case "19":
                case "exportar BBDD":
                    v.exportarBBDD();
                    break;
                case "20":
                case "importar BBDD":
                    v.importarBBDD();
                    break;
                
                case "salir":
                case "q":
                    salir = true;
                    break;
                default:
                    System.err.printf("%nOpciÃ³n incorrecta%n%n");
                    break;
            } // fin de switch
        } while (!salir);
    }

}
