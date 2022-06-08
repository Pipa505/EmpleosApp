package com.camacho.pract.controller;

import com.camacho.pract.model.Vacante;
import com.camacho.pract.service.ICategoriasService;
import com.camacho.pract.service.IVacantesService;
import com.camacho.pract.util.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {

    @Value("${empleosapp.ruta.imagenes}")
    private String ruta;
    @Autowired
    private IVacantesService serviceVacantes;

    @Autowired
    private ICategoriasService serviceCategorias;
    @GetMapping("/index")
    public String mostrarIndex(Model model){
       List<Vacante> lista = serviceVacantes.buscarTodas();
       model.addAttribute("vacantes",lista);
        return "vacantes/listVacantes";
    }
    @GetMapping("/create")
    public String crear(Vacante vacante, Model model){
        model.addAttribute("categorias",serviceCategorias.buscarTodas());
        return "vacantes/formVacante";
    }
    /*@PostMapping("/save")
    public String guardar(@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion,
                          @RequestParam("estatus") String estatus,@RequestParam("fecha") String fecha,@RequestParam("destacado") int destacado,
                          @RequestParam("salario") double salario,@RequestParam("detalles") String detalles){
        System.out.println("Nombre Vacante: "+nombre);
        System.out.println("Descripcion: "+descripcion);
        System.out.println("estatus: "+estatus);
        System.out.println("Fecha de pub: "+fecha);
        System.out.println("Destacado: "+destacado);
        System.out.println("Salario ofrecido: "+salario);
        System.out.println("detalles: "+detalles);
        return "vacantes/listVacantes";
    }*/
    @PostMapping("/save")
    public String guardar(Vacante vacante, BindingResult result, RedirectAttributes attributes, @RequestParam("archivoImagen")MultipartFile multiPart,Model model){
        if (result.hasErrors()){
            for (ObjectError error: result.getAllErrors()){
                System.out.println("Ocurrio un error: "+error.getDefaultMessage());
            }
            model.addAttribute("categorias",serviceCategorias.buscarTodas());
            return "vacantes/formVacante";
        }
        if (!multiPart.isEmpty()) {
            //String ruta = "/empleos/img-vacantes/"; // Linux/MAC
            //String ruta = "d:/empleos/img-vacantes/"; // Windows
            String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
            if (nombreImagen != null){ // La imagen si se subio
                // Procesamos la variable nombreImagen
                vacante.setImagen(nombreImagen);
            }
        }
        serviceVacantes.guardar(vacante);
        attributes.addFlashAttribute("msg","Registro Guardado");
        System.out.println("Vacante: "+vacante);
        return "redirect:/vacantes/index";
    }
    @GetMapping("/delete")
    public String eliminar(@RequestParam("id") int idVacante,Model model){
        System.out.println("Borrando vacante con id: "+idVacante);
        model.addAttribute("id",idVacante);
        return "mensaje";
    }
    @GetMapping("/view/{id}")
    public String verDetalle(@PathVariable("id") int idVacante, Model model){
        Vacante vacante = serviceVacantes.buscarPorId(idVacante);
        System.out.println("vacante: "+ vacante);
        model.addAttribute("vacante",vacante);

        //Buscar los detalles de la vacante en la BD
        return  "detalle";
    }
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,false));
    }


}
