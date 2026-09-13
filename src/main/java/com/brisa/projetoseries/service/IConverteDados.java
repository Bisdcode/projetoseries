package com.brisa.projetoseries.service;

public interface IConverteDados {
	<T> T obterDados(String json, Class<T> classe);
}
