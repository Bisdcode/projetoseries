package com.brisa.projetoseries;

import com.brisa.projetoseries.model.DadosSerie;
import com.brisa.projetoseries.service.ConsumoApi;
import com.brisa.projetoseries.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoseriesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoseriesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();

		var json = consumoApi.obterDados("http://omdbapi.com/?t=gilmore+girls&apikey=fe6d1528");
		System.out.println(json);
//		json = consumoApi.obterDados("https://coffee.alexflipnote.dev/random.json");
//		System.out.println("Caffe?" + json);

		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
	}
}
