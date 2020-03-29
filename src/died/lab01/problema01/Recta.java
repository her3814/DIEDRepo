/**
 * 
 */
package died.lab01.problema01;

/**
 * @author her38
 *
 */
public class Recta {

	private Punto p1;
	
	private Punto p2;
	
	
	
	public Recta(Punto p1, Punto p2) {
		super();
		this.p1 = p1;
		this.p2 = p2;	
		
		
	}
	
	public Recta() {
		super();
		p1 = new Punto(1,1);
		p2 = new Punto(2,2);
	}

	public float pendiente() {
		float m = (p2.getY()-p1.getY()) / (p2.getX()-p1.getX());
		return m;
	}
	
	public boolean paralelas(Recta otraRecta) {
		return this.pendiente() == otraRecta.pendiente();
	}
	
	
	public Punto getP1() {
		return p1;
	}

	public void setP1(Punto p1) {
		this.p1 = p1;
	}

	public Punto getP2() {
		return p2;
	}

	public void setP2(Punto p2) {
		this.p2 = p2;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recta r2 = (Recta)obj;
		
		Recta r3 = new Recta(this.getP1(), r2.getP2());
		
		return (this.pendiente() == r3.pendiente() && r2.pendiente() == r3.pendiente());
		}
		
}
