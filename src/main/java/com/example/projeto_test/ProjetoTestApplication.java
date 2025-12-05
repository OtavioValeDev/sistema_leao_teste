package com.example.projeto_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principal da aplicação Spring Boot.
 *
 * Esta classe inicializa todo o sistema de gestão de restaurante,
 * incluindo APIs REST para produtos e recibos, interface web
 * e configuração automática do banco H2.
 *
 * Funcionalidades principais:
 * - CRUD completo de produtos do cardápio
 * - Sistema de recibos com números de chamada aleatórios
 * - Interface web responsiva para gestão
 * - APIs REST documentadas
 *
 * @author Sistema de Gestão de Restaurante
 * @version 1.0
 * @since 2025-01-01
 */
@SpringBootApplication
public class ProjetoTestApplication {

	/**
	 * Ponto de entrada da aplicação Java.
	 *
	 * Inicializa o Spring Boot que automaticamente:
	 * - Configura servidor Tomcat embutido na porta 8080
	 * - Carrega configurações do application.properties
	 * - Escaneia e registra todos os componentes (@Controller, @Service, @Repository)
	 * - Inicializa banco H2 em memória
	 * - Configura validações e tratamento de exceções
	 *
	 * @param args Argumentos da linha de comando (não utilizados)
	 */
	public static void main(String[] args) {
		SpringApplication.run(ProjetoTestApplication.class, args);
	}
}
