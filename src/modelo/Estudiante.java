/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author dacastro
 */
public class Estudiante extends Persona {

    private String codigo;
    private String carrera;

    public Estudiante() {
    }

    public Estudiante(String nombre, String telefono, String codigo, String carrera, String correo) {
        super(nombre, telefono, correo);
        this.codigo = codigo;
        this.carrera = carrera;
    }

    /**
     * Get the value of carrera
     *
     * @return the value of carrera
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * Set the value of carrera
     *
     * @param carrera new value of carrera
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    /**
     * Get the value of codigo
     *
     * @return the value of codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Set the value of codigo
     *
     * @param codigo new value of codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return super.toString() + "," + codigo + "," + carrera;
    }

    public boolean crearArchivoEstudiante(LinkedList<Estudiante> listaEstudiantes) {
        boolean g = false;
        FileWriter flwriter = null;
        try {
            flwriter = new FileWriter("estudiantes.txt");
            BufferedWriter bfwriter = new BufferedWriter(flwriter);

            for (int i = 0; i < listaEstudiantes.size(); i++) {
                //escribe los datos en el archivo
                bfwriter.write(listaEstudiantes.get(i) + "\n");
            }
            bfwriter.close();
            System.out.println("Archivo creado satisfactoriamente..");
            g = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (flwriter != null) {
                try {//cierra el flujo principal
                    flwriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return g;
    }

    public boolean crearArchivoXML(LinkedList<Estudiante> ListaE) {

        boolean g = false;

        try {
            //creacion del elemento
            Element universidad = new Element("universidad");
            Document doc = new Document(universidad);
            //ciclo para guardar datos
            for (int i = 0; i < ListaE.size(); i++) {

                //creacion del documento
                Element estudiante = new Element("estudiante");

                //obtener los datos de la lista y gardardarlos en el elemento "estudiante"
                estudiante.addContent(new Element("nombre").setText(ListaE.get(i).getNombre()));

                estudiante.addContent(new Element("telefono").setText(ListaE.get(i).getTelefono()));

                estudiante.addContent(new Element("correo").setText(ListaE.get(i).getCorreo()));

                estudiante.addContent(new Element("codigo").setText(ListaE.get(i).getCodigo()));

                estudiante.addContent(new Element("carrera").setText(ListaE.get(i).getCarrera()));

                doc.getRootElement().addContent(estudiante);
            }
            XMLOutputter xmlOutput = new XMLOutputter();
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(doc, new FileWriter("universidad.xml"));

        } catch (IOException io) {
            
            System.out.println(io.getMessage());
            g = false;
        }
        return g;
    }
}
