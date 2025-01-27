package br.com.juan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {
	
	public static List<Pessoa> processarEntradas(List<String> entradas) {
        List<Pessoa> pessoas = new ArrayList<>();

        for (String entrada : entradas) {
            String[] partes = entrada.split(",");
            if (partes.length == 2) {
                String nome = partes[0].trim();
                String sexo = partes[1].trim().toUpperCase();

                if (sexo.equals("M") || sexo.equals("F")) {
                    pessoas.add(new Pessoa(nome, sexo));
                }
            }
        }

        return pessoas;
    }
	
	public static List<Pessoa> filtrarMulheres(List<Pessoa> pessoas) {
        return pessoas.stream()
                      .filter(pessoa -> pessoa.getSexo().equals("F"))
                      .collect(Collectors.toList());
    }
	
	 public static void main(String[] args) {
		    Scanner scanner = new Scanner(System.in);
	        List<String> entradas = new ArrayList<>();

	        System.out.println("Digite os nomes e sexos das pessoas (nome,sexo), separados por vírgula. Exemplo: Ana,F; João,M; (digite 'sair' para encerrar):");

	        while (true) {
	            String entrada = scanner.nextLine();

	            if (entrada.equalsIgnoreCase("sair")) {
	                break;
	            }
	            entradas.add(entrada);
	        }

	        List<Pessoa> pessoas = processarEntradas(entradas);
	        List<Pessoa> mulheres = filtrarMulheres(pessoas);

	        System.out.println("Mulheres no grupo:");
	        mulheres.forEach(mulher -> System.out.println(mulher.getNome()));

	        scanner.close();
	    }
}
