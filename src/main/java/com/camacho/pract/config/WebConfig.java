package com.camacho.pract.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Value("${empleosapp.ruta.imagenes}")
    private String rutaImagenes;

    @Value("d:/empleos/cv/")
    private String rutaCv;

    public void addResourceHandlers(ResourceHandlerRegistry registry){
        //registry.addResourceHandler("/logos/**").addResourceLocations("file:d:/empleos/img-vacantes/");
        registry.addResourceHandler("/logos/**").addResourceLocations("file:"+rutaImagenes);

        registry.addResourceHandler("/cv/**").addResourceLocations("file:"+rutaCv);
    }
}
