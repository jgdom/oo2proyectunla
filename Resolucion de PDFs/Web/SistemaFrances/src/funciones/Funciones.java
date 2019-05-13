package funciones;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class Funciones {

	public static int traerAnio(GregorianCalendar f) {
		return f.get(Calendar.YEAR);
	}
	
	public static int traerAnio(LocalDate f) {
		return f.getYear();
	}

	public static boolean esBisiesto(int anio) {
		boolean r = false;
		if (anio % 4 == 0 && anio % 100 != 0 || anio % 400 == 0)
			r = true;
		return r;
	}

	public static int traerMes(GregorianCalendar f) {
		return f.get(Calendar.MONTH) + 1;
	}
	
	public static int traerMes(LocalDate f) {
		return f.getMonthValue();
	}

	public static int traerDia(GregorianCalendar f) {
		return f.get(Calendar.DAY_OF_MONTH);
	}
	
	public static int traerDia(LocalDate f) {
		return f.getDayOfMonth();
	}

	public static int traerHora(GregorianCalendar f) {
		return f.get(Calendar.HOUR_OF_DAY);
	}
	
	public static int traerHora(LocalDateTime f) {
		return f.getHour();
	}

	public static int traerMinuto(GregorianCalendar f) {
		return f.get(Calendar.MINUTE);
	}
	
	public static int traerMinuto(LocalDateTime f) {
		return f.getMinute();
	}

	public static int traerSegundo(GregorianCalendar f) {
		return f.get(Calendar.SECOND);
	}
	
	public static int traerSegundo(LocalDateTime f) {
		return f.getSecond();
	}

	public static boolean esFechaValida(int anio, int mes, int dia) {
		boolean valido = false;
		int cdias = 0;
		if (0 < anio && anio < 3000) {
			if (1 <= mes && mes <= 12) {
				if (mes == 1 || mes == 3 | mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
					cdias = 31;
				}
				if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
					cdias = 30;
				}
				if (mes == 2) {
					if (esBisiesto(anio) == true) {
						cdias = 29;
					} else {
						cdias = 28;
					}
				}
				if (1 <= dia && dia <= cdias) {
					valido = true;
				}
			}
		}
		return valido;
	}

	public static GregorianCalendar traerFechaGC(int anio, int mes, int dia) {
		GregorianCalendar fecha = new GregorianCalendar();
		fecha.set(anio, (mes - 1), dia);
		return (GregorianCalendar) fecha;
	}
	
	public static LocalDate traerFecha(int anio, int mes, int dia) {
		LocalDate fecha = LocalDate.of(anio, mes, dia);
		return fecha;
	}

	public static GregorianCalendar traerFechaGC(String fecha) {
		int dia = Integer.parseInt(fecha.substring(0, 2));
		int mes = (Integer.parseInt(fecha.substring(3, 5)) - 1);
		int anio = Integer.parseInt(fecha.substring(6, 10));
		GregorianCalendar f = new GregorianCalendar(anio, mes, dia);
		return f;
	}
	
	public static LocalDate traerFecha(String fecha) {
		int dia = Integer.parseInt(fecha.substring(0, 2));
		int mes = (Integer.parseInt(fecha.substring(3, 5)) - 1);
		int anio = Integer.parseInt(fecha.substring(6, 10));
		LocalDate f = LocalDate.of(anio, mes, dia);
		return f;
	}

	public static String traerFechaCorta(GregorianCalendar fecha) {
		return traerDia(fecha) + "/" + traerMes(fecha) + "/" + traerAnio(fecha);
	}
	
	public static String traerFechaCorta(LocalDate fecha) {
		return traerDia(fecha) + "/" + traerMes(fecha) + "/" + traerAnio(fecha);
	}

	public static String traerFechaCortaHora(GregorianCalendar fecha) {
		return traerDia(fecha) + "/" + traerMes(fecha) + "/" + traerAnio(fecha) + " " + traerHora(fecha) + ":"
				+ traerMinuto(fecha) + ":" + traerSegundo(fecha);
	}
	
	public static String traerFechaCortaHora(LocalDateTime fecha) {
		return traerDia(fecha.toLocalDate()) + "/" + traerMes(fecha.toLocalDate()) + "/" + traerAnio(fecha.toLocalDate()) + " " + traerHora(fecha) + ":"
				+ traerMinuto(fecha) + ":" + traerSegundo(fecha);
	}

	public static GregorianCalendar traerFechaProximo(GregorianCalendar fecha, int cantDias) {
		GregorianCalendar proximo = new GregorianCalendar(traerAnio(fecha), traerMes(fecha) - 1, traerDia(fecha));
		proximo.add(Calendar.DAY_OF_MONTH, cantDias);
		return proximo;
	}
	
	public static LocalDate traerFechaProximo(LocalDate fecha, int cantDias) {
		LocalDate proximo = LocalDate.of(traerAnio(fecha), traerMes(fecha), traerDia(fecha));
		proximo.plusDays(cantDias);
		return proximo;
	}

	public static boolean esDiaHabil(GregorianCalendar fecha) {
		boolean r = true;
		if (fecha.get(Calendar.DAY_OF_WEEK) == 1 || fecha.get(Calendar.DAY_OF_WEEK) == 7)
			r = false;
		return r;
	}
	
	public static boolean esDiaHabil(LocalDate fecha) {
		boolean r = true;
		if (fecha.getDayOfWeek().getValue() <= 6)
			r = false;
		return r;
	}

	public static String traerDiaDeLaSemana(GregorianCalendar fecha) {
		String dia = "";
		int d = fecha.get(Calendar.DAY_OF_WEEK);
		switch (d) {
		case 1:
			dia = "Domingo";
			break;
		case 2:
			dia = "Lunes";
			break;
		case 3:
			dia = "Martes";
			break;
		case 4:
			dia = "Miercoles";
			break;
		case 5:
			dia = "Jueves";
			break;
		case 6:
			dia = "Viernes";
			break;
		case 7:
			dia = "Sabado";
			break;
		}
		return dia;
	}
	
	public static String traerDiaDeLaSemana(LocalDate fecha) {
		String dia = "";
		int d = fecha.getDayOfWeek().getValue();
		switch (d) {
		case 1:
			dia = "Lunes";
			break;
		case 2:
			dia = "Martes";
			break;
		case 3:
			dia = "Miercoles";
			break;
		case 4:
			dia = "Jueves";
			break;
		case 5:
			dia = "Viernes";
			break;
		case 6:
			dia = "Sabado";
			break;
		case 7:
			dia = "Domingo";
			break;
		}
		return dia;
	}

	public static String traerMesEnLetras(GregorianCalendar fecha) {
		String mes = "";
		int m = Funciones.traerMes(fecha);
		switch (m) {
		case 1:
			mes = "Enero";
			break;
		case 2:
			mes = "Febrero";
			break;
		case 3:
			mes = "Marzo";
			break;
		case 4:
			mes = "Abril";
			break;
		case 5:
			mes = "Mayo";
			break;
		case 6:
			mes = "Junio";
			break;
		case 7:
			mes = "Julio";
			break;
		case 8:
			mes = "Agosto";
			break;
		case 9:
			mes = "Septiembre";
			break;
		case 10:
			mes = "Octubre";
			break;
		case 11:
			mes = "Noviembre";
			break;
		case 12:
			mes = "Diciembre";
			break;
		}
		return mes;
	}
	
	public static String traerMesEnLetras(LocalDate fecha) {
		String mes = "";
		int m = Funciones.traerMes(fecha);
		switch (m) {
		case 1:
			mes = "Enero";
			break;
		case 2:
			mes = "Febrero";
			break;
		case 3:
			mes = "Marzo";
			break;
		case 4:
			mes = "Abril";
			break;
		case 5:
			mes = "Mayo";
			break;
		case 6:
			mes = "Junio";
			break;
		case 7:
			mes = "Julio";
			break;
		case 8:
			mes = "Agosto";
			break;
		case 9:
			mes = "Septiembre";
			break;
		case 10:
			mes = "Octubre";
			break;
		case 11:
			mes = "Noviembre";
			break;
		case 12:
			mes = "Diciembre";
			break;
		}
		return mes;
	}

	public static String traerFechaLarga(GregorianCalendar fecha) {
		return Funciones.traerDiaDeLaSemana(fecha) + " " + Funciones.traerDia(fecha) + " de "
				+ Funciones.traerMesEnLetras(fecha) + " del " + Funciones.traerAnio(fecha);
	}
	
	public static String traerFechaLarga(LocalDate fecha) {
		return Funciones.traerDiaDeLaSemana(fecha) + " " + Funciones.traerDia(fecha) + " de "
				+ Funciones.traerMesEnLetras(fecha) + " del " + Funciones.traerAnio(fecha);
	}

	public static boolean sonFechasIguales(GregorianCalendar fecha, GregorianCalendar fecha1) {
		boolean r = false;
		if (Funciones.traerFechaCorta(fecha).equals(Funciones.traerFechaCorta(fecha1)))
			r = true;
		return r;
	}
	
	public static boolean sonFechasIguales(LocalDate fecha, LocalDate fecha1) {
		boolean r = false;
		if (Funciones.traerFechaCorta(fecha).equals(Funciones.traerFechaCorta(fecha1)))
			r = true;
		return r;
	}

	public static boolean sonFechasHorasIguales(GregorianCalendar fecha, GregorianCalendar fecha1) {
		boolean r = false;
		if (Funciones.traerFechaCortaHora(fecha).equals(Funciones.traerFechaCortaHora(fecha1)))
			r = true;
		return r;
	}
	
	public static boolean sonFechasHorasIguales(LocalDateTime fecha, LocalDateTime fecha1) {
		boolean r = false;
		if (Funciones.traerFechaCortaHora(fecha).equals(Funciones.traerFechaCortaHora(fecha1)))
			r = true;
		return r;
	}

	public static int traerCantDiasDeUnMes(int anio, int mes) {
		int cDias = 0;
		if (mes == 1 || mes == 3 | mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
			cDias = 31;
		}
		if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
			cDias = 30;
		}
		if (mes == 2) {
			if (esBisiesto(anio) == true) {
				cDias = 29;
			} else {
				cDias = 28;
			}
		}
		return cDias;
	}

	public static double aproximar2Decimal(double valor) {
		double r = 0;
		r = Math.round(valor * 100) / 100d;
		return r;
	}

	public static boolean esNumero(char c) {
		boolean respuesta = false;
		for (int i = 0; i < 10; i++) {
			if (c == String.valueOf(i).charAt(0)) {
				respuesta = true;
			}
		}
		return respuesta;
	}

	public static boolean esLetra(char c) {
		String abecedario = "qwertyuiopasdfghjkl�zxcvbnmQWERTYUIOPASDFGHJKL�ZXCVBNM";
		boolean validar = false;
		for (int i = 0; i < abecedario.length(); i++) {
			if (c == abecedario.charAt(i)) {
				validar = true;
			}
		}
		return validar;
	}

	public static boolean esCadenaDeNumeros(String cadena) {
		boolean respuesta = true;
		for (int i = 0; i < cadena.length(); i++) {
			if (Funciones.esNumero(cadena.charAt(i)) != true) {
				respuesta = false;
			}
		}
		return respuesta;
	}

	public static boolean esCadenaDeCaracteres(String cadena) {
		boolean val = true;
		for (int i = 0; i < cadena.length(); i++) {
			if (!(Funciones.esLetra(cadena.charAt(i)))) {
				val = false;
			}
		}
		return val;
	}

	public static double convertirADouble(int n) {
		return ((double) n);
	}
}