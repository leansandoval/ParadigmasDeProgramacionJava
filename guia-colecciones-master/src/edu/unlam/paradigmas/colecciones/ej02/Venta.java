package edu.unlam.paradigmas.colecciones.ej02;

public class Venta {

	int numero;
	Fecha fecha;
	Hora hora;
	String nombreCliente;
	double monto;

	public Venta(int numero, Fecha fecha, Hora hora, String nombreCliente, double monto) {
		if (nombreCliente == null)
			throw new NullPointerException("El nombre del cliente esta vacio");
		if (monto < 0)
			throw new IllegalArgumentException("El monto no debe ser negativo");
		if(numero < 0)
			throw new IllegalArgumentException("El numero de venta debe ser positivo");
		this.numero = numero;
		this.fecha = fecha;
		this.hora = hora;
		this.nombreCliente = nombreCliente;
		this.monto = monto;
	}

	@Override
	public String toString() {
		return "Fecha venta = " + fecha + ", Hora = " + hora + ", Cliente = " + nombreCliente + ", Monto = " + monto;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Fecha getFecha() {
		return fecha;
	}

	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}

	public Hora getHora() {
		return hora;
	}

	public void setHora(Hora hora) {
		this.hora = hora;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

}
