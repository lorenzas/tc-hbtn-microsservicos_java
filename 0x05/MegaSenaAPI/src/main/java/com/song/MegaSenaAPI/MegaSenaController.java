package com.song.MegaSenaAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/megasena")
public class MegaSenaController {

    @GetMapping("/simpleMessageWelcome")
    public String mensagemBoasVindas() {
        return "Bem vindo a API REST para geração de números para a loteria Mega Sena.";
    }


    @GetMapping("/getNumbers")
    public List<Integer> numerosMegaSena() {
        Set<Integer> numeros = new TreeSet<>();
        while (numeros.size() < 6) {
            numeros.add(sortearNumero(1, 60));
        }
        return numeros.stream().collect(Collectors.toList());
    }

    public Integer sortearNumero(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }
}