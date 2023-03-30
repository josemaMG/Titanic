package fp.accidentes.navales;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AccidenteNaval {
	private SortedSet<PasajeroBarco> pasajeros;
	
	public AccidenteNaval() {
		pasajeros=new TreeSet<>();
	}
	
	public AccidenteNaval(Stream<PasajeroBarco> n) {
		pasajeros= new TreeSet<PasajeroBarco>(n.toList());
	}

	public SortedSet<PasajeroBarco> getPasajeros() {
		return new TreeSet<>(pasajeros);
	}

	

	public boolean equals(Object obj) {
		Boolean result=false;
		if (getClass() == obj.getClass()) {
		AccidenteNaval other = (AccidenteNaval) obj;
		result= !(pasajeros.retainAll(other.pasajeros));
		}
		return result;
	}

	public String toString() {
		String result="";
		for (PasajeroBarco e : pasajeros) {
			result=result +"/n"+e;
		}
		return result;
	}
	
	public Double getEdadMediaPorDebajoDe(Boolean superviviente, Integer limite) {   //Se va a ir pronto...
		Double result=0.;
		Integer contador=1;
		for (PasajeroBarco e:pasajeros) {
			if (superviviente==e.getSuperviviente() && limite<e.getEdad()) {
				result+=e.getEdad();
				contador+=1;
			}
		}
		return result/contador;
	}
	
	public String getCiudadEmbarqueConMayorPrecio() {
		return Collections.max(pasajeros,Comparator.comparing(e->e.getPrecioTicket())).getCiudadEmbarque();
	}
	
	public Map<Integer, Long> getNumeroVictimasMenoresDePorEdad(Integer edad) {
		return pasajeros.stream().filter(e->e.getEdad()<edad).map(e->e.getEdad()).collect(Collectors.groupingBy(e->e, Collectors.counting()));
	}
	
	public Map<String, Double> getPorcentajeSupervivientesPorCiudadEmbarque() {
		return pasajeros.stream().map(e->e.getCiudadEmbarque()).collect(Collectors.groupingBy(e->e,Collectors.averagingDouble(null)));
	}
	
}
