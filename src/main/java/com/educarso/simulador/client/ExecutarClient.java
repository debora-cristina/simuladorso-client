package com.educarso.simulador.client;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.educarso.simulador.aplicacao.EscalonadorDomain;
import com.educarso.simulador.aplicacao.MapaProcessos;
import com.educarso.simulador.aplicacao.Processo;

import lombok.Getter;
import lombok.Setter;

public class ExecutarClient {
	
	@Getter
	@Setter
	private List<MapaProcessos> mapa = new ArrayList<MapaProcessos>();
	@Getter
	@Setter
	private List<Processo> processo = new ArrayList<Processo>();
	private EscalonadorDomain escalonadorExec = new EscalonadorDomain();
	
	public String salvar(EscalonadorDomain esc) {

		RestTemplate restTemplate = new RestTemplate();

		RequestEntity<EscalonadorDomain> request = RequestEntity

				.post(URI.create("http://localhost:8080/executar"))

				.header("Authorization", "Basic YWxnYXdvcmtzOnMzbmg0")

				.body(esc);

		ResponseEntity<Void> response = restTemplate.exchange(request, Void.class);

		return response.getHeaders().getLocation().toString();

	}
	
	public String salvarProcesso(Processo esc) {

		RestTemplate restTemplate = new RestTemplate();

		RequestEntity<Processo> request = RequestEntity

				.post(URI.create("http://localhost:8080/executar/processos"))

				.header("Authorization", "Basic YWxnYXdvcmtzOnMzbmk0")

				.body(esc);
		
		processo.add(request.getBody());

		ResponseEntity<Void> response = restTemplate.exchange(request, Void.class);

		return response.getHeaders().getLocation().toString();

	}

	public MapaProcessos[] listar() {

		RestTemplate restTemplate = new RestTemplate();

		RequestEntity<Void> request = RequestEntity

				.get(URI.create("http://localhost:8080/executar"))

				.header("Authorization", "Basic YWxnYXdvcmtzOnMzbmg0").build();

		ResponseEntity<MapaProcessos[]> response = restTemplate.exchange(request, MapaProcessos[].class);
		
		//System.out.println(r);
		
		//ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity(urlGETList, Object[].class);
		mapa = Arrays.asList(response.getBody());

		return response.getBody();

	}
}
