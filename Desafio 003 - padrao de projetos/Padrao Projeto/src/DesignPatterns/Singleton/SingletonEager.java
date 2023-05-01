package DesignPatterns.Singleton;

/**
 * 
 * Singleton "preguiçoso"
 * So é possivel criar uma instancia do objeto
 * @author Breno
 *
 */
public class SingletonEager {

	
	private static SingletonEager instancia = new SingletonEager();
	
	private SingletonEager() {
		super();
	}
	
	public static SingletonEager getInstancia() {
		return instancia;
	}
}