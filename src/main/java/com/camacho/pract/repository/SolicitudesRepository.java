package com.camacho.pract.repository;

import com.camacho.pract.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SolicitudesRepository extends JpaRepository<Solicitud, Integer> {

}
