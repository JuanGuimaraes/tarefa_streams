package br.com.juan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {
	 public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
	        List<Pessoa> pessoas = new ArrayList<>();

	        System.out.println("Digite os nomes e sexos das pessoas (nome,sexo), separados por vírgula. Exemplo: Ana,F; João,M; (digite 'sair' para encerrar e exibir a lista):");

	        while (true) {
	            String entrada = scanner.nextLine();

	            if (entrada.equalsIgnoreCase("sair")) {
	                break;
	            }

	            String[] partes = entrada.split(",");
	            if (partes.length == 2) {
	                String nome = partes[0].trim();
	                String sexo = partes[1].trim().toUpperCase();

	                if (sexo.equals("M") || sexo.equals("F")) {
	                    pessoas.add(new Pessoa(nome, sexo));
	                } else {
	                    System.out.println("Sexo inválido. Use 'M' para masculino e 'F' para feminino.");
	                }
	            } else {
	                System.out.println("Entrada inválida. Use o formato nome,sexo.");
	            }
	        }

	        List<Pessoa> mulheres = pessoas.stream()
	                                       .filter(pessoa -> pessoa.getSexo().equals("F"))
	                                       .collect(Collectors.toList());

	        System.out.println("Mulheres no grupo:");
	        mulheres.forEach(mulher -> System.out.println(mulher.getNome()));

	        scanner.close();
	 }
}
