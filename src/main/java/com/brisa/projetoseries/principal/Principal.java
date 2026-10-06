package com.brisa.projetoseries.principal;

import com.brisa.projetoseries.model.DadosSerie;
import com.brisa.projetoseries.model.DadosTemporada;
import com.brisa.projetoseries.service.ConsumoApi;
import com.brisa.projetoseries.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

	private Scanner leitura = new Scanner(System.in);
	private ConsumoApi consumo = new ConsumoApi();
	private ConverteDados conversor = new ConverteDados();
	List<DadosTemporada> temporadas = new ArrayList<>();


	private final String ENDERECO = "http://omdbapi.com/?t=";
	private final String API_KEY = "&apikey=fe6d1528";

	public void exibeMenu() {
		System.out.println("Digite o nome da série para busca:");
		var nomeSerie = leitura.nextLine();
		var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);


		for (int i = 1; i <= dados.totalTemporadas(); i++) {
			json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i + API_KEY);
			DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}
		temporadas.forEach(System.out::println);

		for (int i = 0; i < dados.totalTemporadas(); i++) {

		}
	}
}
