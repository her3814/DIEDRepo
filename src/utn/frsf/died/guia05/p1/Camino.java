package utn.frsf.died.guia05.p1;
import java.util.ArrayList;
import java.util.List;

public class Camino {
	
	private ArrayList<Coordenada> Coordenadas;
	
	public Camino() {
		
		super();
		this.Coordenadas=new ArrayList<Coordenada>();
		
		
	}
	
	public Camino(Coordenada c) {
		
		super();
		this.Coordenadas=new ArrayList<Coordenada>();
		this.Coordenadas.add(c);
		
	}
	
	public Camino(List<Coordenada> c) {
		
		super();
		this.Coordenadas=new ArrayList<Coordenada>(c);
		
		
	}
	
	public List<Coordenada> getCoordenadas(){
		
		return this.Coordenadas;
		
	}
	
	public void agregar(Coordenada x) {
		
		this.Coordenadas.add(x);
		
	}
	
	public void agregar(double lat, double lon) {
		
		this.Coordenadas.add(new Coordenada(lat,lon));
		
	}
	
	
	public void agregar(int mtsLt, int mtsLn) {
			
			int idx = this.Coordenadas.size()-1;
		
			this.Coordenadas.add(this.Coordenadas.get(idx).mover(mtsLt, mtsLn));
			
	}
	
	public List<Coordenada> buscar(Coordenada no, Coordenada se){
		ArrayList<Coordenada> res = new ArrayList<Coordenada>();

		for(Coordenada punto : this.Coordenadas) {
			    if(punto.getLongitud() > no.getLongitud() 
				&& punto.getLatitud() < no.getLatitud() 
				&& punto.getLongitud() < se.getLongitud() 
				&& punto.getLatitud() > se.getLatitud()
					)
			{
				res.add(punto);
			}
		}
		
		return res;
	}
	
	public List<Coordenada> buscar(Coordenada punto, double mts){
		ArrayList<Coordenada> res = new ArrayList<Coordenada>();
		
		for(Coordenada c : this.Coordenadas) {
			if(Coordenada.distanciaMt(c,punto) <= mts) {
				res.add(c);
			}
		}
		
		return res;
	}

}