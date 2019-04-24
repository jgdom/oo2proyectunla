package datos;

import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class Evento {
	
	private long idEvento;
	private String evento;
	private LocalDate fecha;
	private LocalTime hora;
	private Set<Cliente>clientes;
	
	public Evento() {}

	public Evento(String evento, LocalDate fecha, LocalTime hora) {
		super();
		this.evento = evento;
		this.fecha = fecha;
		this.hora = hora;
	}

	public long getIdEvento() {
		return idEvento;
	}

	protected void setIdEvento(long idEvento) {
		this.idEvento = idEvento;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public Set<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public boolean equals(Evento evento) {
		return this.idEvento == evento.getIdEvento();
	}
	
	public boolean agregar(Cliente cliente) {
		return clientes.add(cliente);
	}
	
	public boolean eliminar(Cliente cliente) {
		return clientes.remove(cliente);
	}

	@Override
	public String toString() {
		return "Evento [idEvento=" + idEvento + ", evento=" + evento + ", fecha=" + fecha + ", hora=" + hora + "]";
	}

	
	
	



	
	

}
