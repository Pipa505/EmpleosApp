package com.camacho.pract.controller;

import com.camacho.pract.model.Categoria;
import com.camacho.pract.service.ICategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value="/categorias")

public class CategoriasController {

    @Autowired
    //@Qualifier("categoriasServiceJpa")
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
    public String crear(Categoria categoria,Model model) {
        return "categorias/formCategoria";
    }
    // @PostMapping("/save")
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String guardar(Categoria categoria, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()){
            for (ObjectError error : result.getAllErrors()){
                System.out.println("Ha ocurrido un error: "+error.getDefaultMessage());
            }
            return "categorias/formCategoria";
        }
        categoriasService.guardar(categoria);
        attributes.addFlashAttribute("msg","Categoria creada correctamente");
        System.out.println("Categoria: "+categoria);
        return "redirect:/categorias/index";
    }
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") int idCategoria,RedirectAttributes attributes){
        categoriasService.eliminar(idCategoria);
        attributes.addFlashAttribute("msg","La categoria fue eliminada correctamente");
        return "redirect:/categorias/index";
    }
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") int idCategoria,Model model){
        Categoria categoria = categoriasService.buscarPorId(idCategoria);
        model.addAttribute("categoria",categoria);
        return "categorias/formCategoria";
    }

}
