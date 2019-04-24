package test;

import composite.Bajista;
import composite.Baterista;
import composite.Cantante;
import composite.Guitarrista;
import composite.GrupoCompuesto;

public class Test {
	public static void main(String[] args) {
		
		GrupoCompuesto theRamones = new GrupoCompuesto("The Ramones");
		theRamones.addIntegranteComponente(new Baterista("Toomy Ramone"));
		theRamones.addIntegranteComponente(new Cantante("Joey Ramone"));
		theRamones.addIntegranteComponente(new Guitarrista("Jonny Ramone"));
		theRamones.addIntegranteComponente(new Bajista("Dee Dee Ramone"));
		System.out.println(theRamones.usarInstrumento());
		
//Otro ejemplo pero con una banda con dos guitarristas
		GrupoCompuesto acdc = new GrupoCompuesto("AC-DC");
		GrupoCompuesto guitarristas = new GrupoCompuesto("Guitarristas");
		guitarristas.addIntegranteComponente(new Guitarrista("Angus Young"));
		guitarristas.addIntegranteComponente(new Guitarrista("Malcolm Young"));
		acdc.addIntegranteComponente(guitarristas);
		acdc.addIntegranteComponente(new Baterista("Chris Slade"));
		acdc.addIntegranteComponente(new Cantante("Brian Johnson"));
		acdc.addIntegranteComponente(new Bajista("Cliff Williams"));
		System.out.println(acdc.usarInstrumento());
	}
}
