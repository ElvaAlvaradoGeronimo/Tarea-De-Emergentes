package com.SIS414.Emergentes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/test")

public class Holamundo{
    @GetMapping
    public String holamundo(){
        return "De aqui en 5 años me veo trabajando en BLIZZARD como programador senior, con un sueldo mensual de 7000$";

    }
}


