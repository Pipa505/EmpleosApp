package com.camacho.pract.controller;

import com.camacho.pract.model.Vacante;
import com.camacho.pract.service.IVacantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeControler {

    @Autowired
    private IVacantesService serviceVacantes;

    @GetMapping("/tabla")
    public String mostrarTabla(Model model){
        List<Vacante> lista = serviceVacantes.buscarTodas();
        model.addAttribute("vacantes",lista);

        return "tabla";
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
        return "home";
    }
    @ModelAttribute
    public void setGenericos(Model model){
        model.addAttribute("vacantes",serviceVacantes.buscarDestacadas());
    }


}
