package com.camacho.pract.controller;

import com.camacho.pract.model.Categoria;
import com.camacho.pract.service.ICategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.ws.soap.Addressing;
import java.util.List;

@Controller
@RequestMapping(value="/categorias")

public class CategoriasController {

    @Autowired
    private ICategoriasService categoriasService;

    // @GetMapping("/index")
    @RequestMapping(value="/index", method= RequestMethod.GET)
    public String mostrarIndex(Model model) {
        List<Categoria> lista = categoriasService.buscarTodas();
        model.addAttribute("categorias",lista);
        return "categorias/listCategorias";
    }
    // @GetMapping("/create")
    @RequestMapping(value="/create", method=RequestMethod.GET)
    public String crear() {
        return "categorias/formCategoria";
    }
    // @PostMapping("/save")
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String guardar(@RequestParam("nombre") String nombre,@RequestParam("descripcion") String descripcion) {
        System.out.println("categoria: "+nombre);
        System.out.println("descripcion: "+descripcion);
        return "categorias/listCategorias";
    }

}
