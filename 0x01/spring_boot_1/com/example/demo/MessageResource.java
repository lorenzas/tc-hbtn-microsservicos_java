package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/messages")
public class MessageResource {
	
	@GetMapping("/simpleMessageWelcome")
    public String simpleMessageWelcome() {
		return "BEM VINDO A AULA DE MICROSSERVIÇO USANDO SPRING BOOT !!!";
    }
	
	@GetMapping("/login")
	@ResponseBody
	public String login(@RequestParam String user, @RequestParam String password) {
		if (user.equals(null) || password.equals(null) || user.isBlank() || password.isBlank()) {
			return "USUÁRIO E SENHA NÃO INFORMADOS";
		} 
		
		if (user.length() > 15 || password.length() > 15) {
			return "USUÁRIO E SENHA INVÁLIDOS";
		}
		
		return "LOGIN EFETUADO COM SUCESSO !!!";
	}
	
}
