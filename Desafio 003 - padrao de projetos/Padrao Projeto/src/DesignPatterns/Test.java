package DesignPatterns;

import DesignPatterns.Singleton.SingletonEager;
import DesignPatterns.Singleton.SingletonLazy;
import DesignPatterns.Singleton.SingletonLazyHolder;
import DesignPatterns.Strategy.Comportamento;
import DesignPatterns.Strategy.ComportamentoAgressivo;
import DesignPatterns.Strategy.ComportamentoDefensivo;
import DesignPatterns.Strategy.ComportamentoNormal;
import DesignPatterns.Strategy.Robo;
import DesignPatterns.facade.Facade;

public class Test {

	public static void main(String[] args) {
		
		System.out.println("\n\n\n *******Singleton***********");
		//Singleton
		SingletonLazy lazy = SingletonLazy.getInstancia();
		System.out.println(lazy);
		lazy = SingletonLazy.getInstancia();
		System.out.println(lazy);
		
		SingletonEager eager = SingletonEager.getInstancia();
		System.out.println(eager);
		eager = SingletonEager.getInstancia();
		System.out.println(eager);
		
		SingletonLazyHolder lazyHolder = SingletonLazyHolder.getInstancia();
		System.out.println(lazyHolder);
		lazyHolder = SingletonLazyHolder.getInstancia();
		System.out.println(lazyHolder);
		
		System.out.println("\n\n\n *******Strategy***********");
		//Strategy
		
		Comportamento defensivo = new ComportamentoDefensivo();
		Comportamento normal = new ComportamentoNormal();
		Comportamento agressivo = new ComportamentoAgressivo();
		
		Robo robo = new Robo();
		robo.setComportamento(normal);
		
		robo.mover();
		robo.mover();
		robo.setComportamento(defensivo);
		robo.mover();
		robo.mover();
		robo.setComportamento(agressivo);
		robo.mover();
		robo.mover();
		
		
		System.out.println("\n\n\n *******Facade***********");
		//Facade
		
		Facade facade = new Facade();
		facade.migrarCliente("Venilton", "14001788");
				
	}

}
