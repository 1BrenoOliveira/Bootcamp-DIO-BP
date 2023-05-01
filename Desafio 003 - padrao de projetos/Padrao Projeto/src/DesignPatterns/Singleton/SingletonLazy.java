package DesignPatterns.Singleton;

/**
 * 
 * Singleton "preguiçoso"
 * So é possivel criar uma instancia do objeto
 * @author Breno
 *
 */
public class SingletonLazy {

	
	private static SingletonLazy instancia;
	
	private SingletonLazy() {
		super();
	}
	
	
	public static SingletonLazy getInstancia() {
		if(instancia==null) instancia = new SingletonLazy();
		return instancia;
	}
}
