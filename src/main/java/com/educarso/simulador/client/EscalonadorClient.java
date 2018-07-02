package com.educarso.simulador.client;

import java.net.URI;
import java.util.Arrays;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.educarso.simulador.aplicacao.EscalonadorDomain;

public class EscalonadorClient {

	public EscalonadorDomain listar() {

		RestTemplate restTemplate = new RestTemplate();

		RequestEntity<Void> request = RequestEntity

				.get(URI.create("http://localhost:8080/escalonador"))

				.header("Authorization", "Basic YWxnYXdvcmtzOnMzbmg0").build();

		ResponseEntity<EscalonadorDomain> response = restTemplate.exchange(request, EscalonadorDomain.class);

		return response.getBody();

	}

	public String salvar(EscalonadorDomain esc) {

		RestTemplate restTemplate = new RestTemplate();

		RequestEntity<EscalonadorDomain> request = RequestEntity

				.post(URI.create("http://localhost:8080/escalonador"))

				.header("Authorization", "Basic YWxnYXdvcmtzOnMzbmg0")

				.body(esc);

		ResponseEntity<Void> response = restTemplate.exchange(request, Void.class);

		return response.getHeaders().getLocation().toString();

	}

}
