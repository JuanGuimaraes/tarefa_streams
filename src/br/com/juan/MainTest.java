package br.com.juan;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainTest {

    @Test
    public void testFiltrarSomenteMulheres() {
        List<String> entradas = Arrays.asList(
                "Ana,F",
                "João,M",
                "Maria,F",
                "Pedro,M"
        );

        List<Pessoa> pessoas = App.processarEntradas(entradas);

        List<Pessoa> mulheres = App.filtrarMulheres(pessoas);

        assertTrue("A lista contém apenas mulheres.",
                mulheres.stream().allMatch(pessoa -> pessoa.getSexo().equals("F")));

        assertEquals("O número de mulheres na lista está correto.", 2, mulheres.size());
        assertEquals("Primeira mulher na lista é correta.", "Ana", mulheres.get(0).getNome());
        assertEquals("Segunda mulher na lista é correta.", "Maria", mulheres.get(1).getNome());
    }

    @Test
    public void testEntradasInvalidas() {
        List<String> entradas = Arrays.asList(
                "Carlos,X", 
                "Julia"     
        );

        List<Pessoa> pessoas = App.processarEntradas(entradas);

        assertTrue("A lista deve estar vazia para entradas inválidas.", pessoas.isEmpty());
    }
}
