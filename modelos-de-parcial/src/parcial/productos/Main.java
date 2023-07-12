package parcial.productos;

import java.util.Date;

public class Main {

	public static void main(String[] args) {
		Usuario usuarioLeandro = new Usuario(1, "Leandro", "Sandoval", new Cuenta(1, "leandro123"));
		usuarioLeandro.getCuenta().depositar(100_000);

		Producto televisor = new Electrodomestico("Televisor", 35000, 10, "Samsung", "Argentina");
		Producto cifCrema = new Limpieza("Cif Crema", 600, 50);
		Producto fideosArcor = new Comestible("Fideos Arcor", 530.50, 100, new Date());
		Compra compraFideos = new Compra(fideosArcor, 75);

		CarritoDeCompra carritoDeCompra = new CarritoDeCompra(1, usuarioLeandro);

		carritoDeCompra.agregarProducto(televisor);
		carritoDeCompra.agregarProducto(cifCrema);
		carritoDeCompra.agregarCompra(compraFideos);

		try {
			carritoDeCompra.realizarProcesoDePago();
			System.out.println("El saldo del usuario " + usuarioLeandro.getNombre() + " resultante es de "
					+ usuarioLeandro.getCuenta().consultarSaldo());
			;
		} catch (SaldoInvalidoException e) {
			System.out.println("Hubo un error en el proceso de pago");
			e.printStackTrace();
		}

	}
}
