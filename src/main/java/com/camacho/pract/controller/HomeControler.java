package com.camacho.pract.controller;

import com.camacho.pract.model.Vacante;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeControler {

    @GetMapping("/tabla")
    public String mostrarTabla(Model model){
        List<Vacante> lista = getVacantes();
        model.addAttribute("vacantes",lista);

        return "tabla";sdklmdskmvslkmsdlksdmlkscmsklmcs
    }
    @GetMapping("/detalle")
    public String mostrarDetalle(Model model){
        Vacante vacante = new Vacante();

        vacante.setNombre("Contador");
        vacante.setFecha(new Date());
        vacante.setSalario(15200.00);
        vacante.setDescripcion("Se requiere contador con las habilidades necesarias");

        model.addAttribute("vacante",vacante);

        return "detalle";
    }


    @GetMapping("/listado")
    public String mostrarListado(Model model){
        List <String> lista = new LinkedList<>();

        lista.add("Ingeniero en sistemas");
        lista.add("Auxiliar en conbtabilidad");
        lista.add("Recursos Humanos");
        lista.add("Vendedor");
        lista.add("Arquitecto");

        model.addAttribute("lista",lista);

        return "listado";
    }

    @GetMapping("/")
    public String mostrarHome(Model model){
        String nombre ="Auxiliar de contabilidad";
        Date fechaPub = new Date();
        double salario = 7000.00;
        boolean vigente = true;

        model.addAttribute("nombre",nombre);
        model.addAttribute("fecha",fechaPub);
        model.addAttribute("salario",salario);
        model.addAttribute("vigente",vigente);
        return "home";

    }

    private List<Vacante> getVacantes(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        List<Vacante> lista = new LinkedList<>();

        try {
            Vacante vacante1 = new Vacante();
            vacante1.setId(1);
            vacante1.setNombre("Ingeniero Civil");
            vacante1.setDescripcion("Solicitamos ingeniero civil para diseñar puente peatonal");
            vacante1.setFecha(sdf.parse("08-02-2019"));
            vacante1.setSalario(8500.00);
            vacante1.setDestacado(1);
            vacante1.setImagen("empresa1.png");

            Vacante vacante2 = new Vacante();
            vacante2.setId(2);
            vacante2.setNombre("Contador publico");
            vacante2.setDescripcion("Empresa importante solicita contador con 5 años de experiencia titulado");
            vacante2.setFecha(sdf.parse("09-02-2019"));
            vacante2.setSalario(8000.00);
            vacante2.setDestacado(0);
            vacante2.setImagen("empresa2.png");



            Vacante vacante3 = new Vacante();
            vacante3.setId(3);
            vacante3.setNombre("Ingeniero Electrico");
            vacante3.setDescripcion("Empresa internacional solicita ingeniero mecanico para mantenimiento de la instalacion electrica ");
            vacante3.setFecha(sdf.parse("10-02-2019"));
            vacante3.setSalario(1000.00);
            vacante3.setDestacado(0);


            Vacante vacante4 = new Vacante();
            vacante4.setId(4);
            vacante4.setNombre("Diseñador grafico");
            vacante4.setDescripcion("Solicitamos diseñador grafico titulado para realizar publicidad de la empresa");
            vacante4.setFecha(sdf.parse("10-02-2019"));
            vacante4.setSalario(6500.00);
            vacante4.setDestacado(1);
            vacante4.setImagen("empresa3.png");



            lista.add(vacante1);
            lista.add(vacante2);
            lista.add(vacante3);
            lista.add(vacante4);

        } catch (ParseException e) {
            System.out.println("Error: "+e.getMessage());
        }

        return lista;
    }
}
