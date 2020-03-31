package utn.frsf.died.guia05.p1;

public class Coordenada {

	private final int kmR_ECU_TIERRA = 6378;
	private final int kmR_POL_TIERRA = 6357;
	
	private double latitud;
	private double longitud;
		
	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		if(latitud > 90 || latitud < -90)
			throw new java.lang.Error("La latitud ingresada no se encuentra dentro del rango valido [-90;90]");
		
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		if(longitud > 180 || longitud < -180)
			throw new java.lang.Error("La longitud ingresada no se encuentra dentro del rango valido [-90;90]");		
		this.longitud = longitud;
	}

	public Coordenada() {
		super();
	}

	public Coordenada(double latitud, double longitud) {
		super();
		this.setLongitud(longitud);
		this.setLatitud(latitud);
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Coordenada other = (Coordenada) obj;
		
		if (Double.doubleToLongBits(latitud) != Double.doubleToLongBits(other.latitud))
			return false;
		
		if (Double.doubleToLongBits(longitud) != Double.doubleToLongBits(other.longitud))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Coordenada [longitud=" + longitud + ", latitud=" + latitud + "]";
	}
	
	public Coordenada mover(int mtsLt, int mtsLn) {
		double kmLt = mtsLt/1000;
		double kmLn = mtsLn/1000;
		
		double lat= this.latitud + (kmLt*360) / (2*Math.PI*this.kmR_ECU_TIERRA);
		double lon = this.longitud + (kmLn*360) / (2*Math.PI*this.kmR_POL_TIERRA);
		
		return new Coordenada(lat,lon);
	}
	
	public double getLatitudAsMt()
	{
		double km = (2 * Math.PI * this.kmR_ECU_TIERRA * this.latitud)/360;
		return km*1000;
	}

	public double getLongitudAsMt()
	{
		double km = (2 * Math.PI * this.kmR_POL_TIERRA * this.longitud)/360;
		return km*1000;
	}
	
	public static double distanciaMt(Coordenada a, Coordenada b) {
		
		var x0 = b.getLongitudAsMt();
		var x1 = a.getLongitudAsMt();
		var y0 = b.getLatitudAsMt();
		var y1 = a.getLatitudAsMt(); 
		
		var res =  Math.sqrt( Math.pow(x1-x0,2) + Math.pow(y1-y0,2));
		return res;
	}
}
