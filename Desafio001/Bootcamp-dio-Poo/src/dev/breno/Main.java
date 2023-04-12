package dev.breno;

import java.time.LocalDate;

import dev.breno.domain.Bootcamp;
import dev.breno.domain.Curso;
import dev.breno.domain.Dev;
import dev.breno.domain.Mentoria;

public class Main {
	public static void main(String[] args) {

		Curso curso1 = new Curso();

		curso1.setTitulo("Curso Java");
		curso1.setDescricao("descrição do curso");
		curso1.setCargaHoraria(8);

		Curso curso2 = new Curso();

		curso2.setTitulo("Curso Js");
		curso2.setDescricao("descrição do curso");
		curso2.setCargaHoraria(4);

		Mentoria mentoria1 = new Mentoria();
		mentoria1.setTitulo("mentoria de java");
		mentoria1.setDescricao("descrição mentoria java");
		mentoria1.setData(LocalDate.now());
		/*
		System.out.println(curso1);
		System.out.println(curso2);
		System.out.println(mentoria1);
		
		*/
		
		Bootcamp bootcamp = new Bootcamp();
		bootcamp.setNome("Bootcamp Java Developer");
		bootcamp.setDecricao("DEscrição do bootcamp...");
		bootcamp.getConteudo().add(curso1);
		bootcamp.getConteudo().add(curso2);
		bootcamp.getConteudo().add(mentoria1);
		
		Dev devBreno = new Dev();
		devBreno.setNome("Breno");
		devBreno.inscreverBootcamp(bootcamp);
		System.out.println("Breno:\n\n");
		System.out.println("Conteudo inscrito " + devBreno.getConteudosInscritos());
		devBreno.progredir();
		devBreno.progredir();
		devBreno.progredir();
		System.out.println("Conteudo inscrito depois progressão:\n" + devBreno.getConteudosInscritos());
		System.out.println("Conteudo concluidos " + devBreno.getConteudosConcluidos());
		System.out.println("XP: " + devBreno.calcularXp());
		
		System.out.println("----------------------------------------------------------------------------------------------");
		
		
		Dev devJoaquim = new Dev();
		devJoaquim.setNome("Joaquim");
		devJoaquim.inscreverBootcamp(bootcamp);
		System.out.println("Joaquim:\n\n");
		System.out.println("Conteudo inscrito" + devJoaquim.getConteudosInscritos());
		devJoaquim.progredir();
		System.out.println("Conteudo inscrito depois progressão:\n" + devJoaquim.getConteudosInscritos());
		System.out.println("Conteudo concluidos " + devJoaquim.getConteudosConcluidos());
		System.out.println("XP: " + devJoaquim.calcularXp());
		
	}
}
