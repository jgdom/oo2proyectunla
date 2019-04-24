package test;

import datos.Empresa;

public class TestSingletonEmpresa {
	public static void main(String[] args) {
		System.out.println("Objeto empresa");
		System.out.println("----------------------------");
		Empresa empresa = Empresa.getInstanciaEmpresa();
		System.out.println(empresa.getNombre());
		System.out.println(empresa.getEmail());
		System.out.println("Objeto empresa1");
		System.out.println("----------------------------");
		Empresa empresa1 = Empresa.getInstanciaEmpresa();
		System.out.println(empresa1.getNombre());
		System.out.println(empresa1.getEmail());
		System.out.println("empresa.equals(empresa1)=" + empresa.equals(empresa1));
	}
}
