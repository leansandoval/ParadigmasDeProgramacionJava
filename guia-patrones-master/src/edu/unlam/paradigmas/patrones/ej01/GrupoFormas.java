package edu.unlam.paradigmas.patrones.ej01;

import java.util.ArrayList;
import java.util.List;

public class GrupoFormas extends FormaGeometrica {

	private List<FormaGeometrica> formasGeometricas;

	public GrupoFormas() {
		formasGeometricas = new ArrayList<>();
	}

	public void agregarFormaGeometrica(FormaGeometrica formaGeometrica) {
		formasGeometricas.add(formaGeometrica);
	}

	public void eliminarFormaGeometrica(FormaGeometrica formaGeometrica) {
		formasGeometricas.remove(formaGeometrica);
	}

	@Override
	public double getArea() {
		double areaTotal = 0;
		for (FormaGeometrica formaGeometrica : formasGeometricas)
			areaTotal += formaGeometrica.getArea();
		return areaTotal;
	}

	@Override
	public double getPerimetro() {
		double perimetroTotal = 0;
		for (FormaGeometrica formaGeometrica : formasGeometricas)
			perimetroTotal += formaGeometrica.getPerimetro();
		return perimetroTotal;
	}

}
