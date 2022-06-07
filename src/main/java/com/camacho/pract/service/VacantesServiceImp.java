package com.camacho.pract.service;

import com.camacho.pract.model.Vacante;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

@Service
public class VacantesServiceImp implements IVacantesService {

    private List<Vacante> lista = null;
    public VacantesServiceImp(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        lista = new LinkedList<>();

        try {
            Vacante vacante1 = new Vacante();
            vacante1.setId(1);
            vacante1.setNombre("Ingeniero Civil");
            vacante1.setDescripcion("Solicitamos ingeniero civil para diseñar puente peatonal");
            vacante1.setFecha(sdf.parse("08-02-2019"));
            vacante1.setSalario(12000.00);
            vacante1.setDestacado(1);
            vacante1.setImagen("logo1.png");
            vacante1.setEstatus("Aprobada");

            Vacante vacante2 = new Vacante();
            vacante2.setId(2);
            vacante2.setNombre("Contador publico");
            vacante2.setDescripcion("Empresa importante solicita contador con 5 años de experiencia titulado");
            vacante2.setFecha(sdf.parse("09-02-2019"));
            vacante2.setSalario(8000.00);
            vacante2.setDestacado(0);
            vacante2.setImagen("logo2.png");
            vacante2.setEstatus("Creada");

            Vacante vacante3 = new Vacante();
            vacante3.setId(3);
            vacante3.setNombre("Ingeniero Electrico");
            vacante3.setDescripcion("Empresa internacional solicita ingeniero mecanico para mantenimiento de la instalacion electrica ");
            vacante3.setFecha(sdf.parse("10-02-2019"));
            vacante3.setSalario(1000.00);
            vacante3.setDestacado(0);
            vacante3.setEstatus("Eliminada");

            Vacante vacante4 = new Vacante();
            vacante4.setId(4);
            vacante4.setNombre("Diseñador grafico");
            vacante4.setDescripcion("Solicitamos diseñador grafico titulado para realizar publicidad de la empresa");
            vacante4.setFecha(sdf.parse("10-02-2019"));
            vacante4.setSalario(6500.00);
            vacante4.setDestacado(1);
            vacante4.setImagen("logo3.png");

            lista.add(vacante1);
            lista.add(vacante2);
            lista.add(vacante3);
            lista.add(vacante4);

        } catch (ParseException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
    @Override
    public List<Vacante> buscarTodas() {
        return lista;
    }

    @Override
    public Vacante buscarPorId(Integer idVacante) {
        for (Vacante v:lista){
            if(v.getId()==idVacante){
                return v;
            }
        }
        return null;
    }

    @Override
    public void guardar(Vacante vacante) {
        lista.add(vacante);
    }
}
