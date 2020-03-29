/**
 * 
 */
package died.lab01.problema01;

/**
 * @author her38
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Punto p1 = new Punto(1,1);
		Punto p2 = new Punto(2,2);
		Recta r1 = new Recta(p1,p2);
		
		System.out.println("Pendiente Recta 1: " + r1.pendiente());
		
		Punto p3 = new Punto(3,3);
		Recta r2 = new Recta(p2,p3);
		
		System.out.println("Equals r1, r2?: " + r1.equals(r2));
	}

}
