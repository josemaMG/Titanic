package fp.accidentes.navales;

import java.util.Objects;
//Puede ser un record por no tener ninguna colección como atributo base y tener todas sus propiedades consultables, sin añadir ninguna que se pueda modificar.
public class PasajeroBarco {
	private Integer id, clase, edad, numHermanosOParejaAbordo, numPadresOHijosAbordo;
	private Boolean superviviente;
	private String nombre, cabina, ciudadEmbarque;
	private Sexo sexo;
	private Double precioTicket;

	public PasajeroBarco(Integer id, Boolean superviviente, Integer clase, String nombre, Sexo sexo, Integer edad, Integer numHermanosOParejaAbordo,
			Integer numPadresOHijosAbordo, Double precioTicket, String cabina, String ciudadEmbarque) {
		
		checkNoNull(id);
		checkNoNull(superviviente);
		checkNumeroInt(edad);
		checkNumeroInt(numHermanosOParejaAbordo);
		checkNumeroInt(numPadresOHijosAbordo);
		checkNumeroDouble(precioTicket);
		
		this.id = id;
		this.clase = clase;
		this.edad = edad;
		this.numHermanosOParejaAbordo = numHermanosOParejaAbordo;
		this.numPadresOHijosAbordo = numPadresOHijosAbordo;
		this.superviviente = superviviente;
		this.nombre = nombre;
		this.cabina = cabina;
		this.ciudadEmbarque = ciudadEmbarque;
		this.sexo = sexo;
		this.precioTicket = precioTicket;
	}
	
	public Integer getId() {
		return id;
	}
	
	public Integer getClase() {
		return clase;
	}
	
	public Integer getEdad() {
		return edad;
	}
	
	public Integer getNumHermanosOParejaAbordo() {
		return numHermanosOParejaAbordo;
	}
	
	public Integer getNumPadresOHijosAbordo() {
		return numPadresOHijosAbordo;
	}
	
	public Boolean getSuperviviente() {
		return superviviente;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getCabina() {
		return cabina;
	}
	
	public String getCiudadEmbarque() {
		return ciudadEmbarque;
	}
	
	public Sexo getSexo() {
		return sexo;
	}
	
	public Double getPrecioTicket() {
		return precioTicket;
	}
	
	public Integer getNumFamiliares() {
		return numHermanosOParejaAbordo + numPadresOHijosAbordo;
	}


	public int hashCode() {
		return Objects.hash(id);
	}


	public boolean equals(Object obj) {
		Boolean result=false;
		if (getClass() == obj.getClass()) {
			PasajeroBarco other = (PasajeroBarco) obj;
			result = Objects.equals(id, other.id);
		}
			return result;
	}

	public String toString() {
		return "FactoriaAccidentesNaval [id=" + id + ", clase=" + clase + ", edad=" + edad
				+ ", numHermanosOParejaAbordo=" + numHermanosOParejaAbordo + ", numPadresOHijosAbordo="
				+ numPadresOHijosAbordo + ", superviviente=" + superviviente + ", nombre=" + nombre + ", cabina="
				+ cabina + ", ciudadEmbarque=" + ciudadEmbarque + ", sexo=" + sexo + ", precioTicket=" + precioTicket
				+ ", getNumFamiliares()=" + getNumFamiliares() + "]";
	}
	
	private void checkNumeroInt(Integer n) {
		if(n<0) {
			throw new IllegalArgumentException();
		}
	}
	
	private void checkNumeroDouble(Double n) {
		if(n<0.) {
			throw new IllegalArgumentException();
		}
	}
	
	private void checkNoNull(Object s) {
		if (s==null) {
			throw new IllegalArgumentException();
		}
	}
	
}
