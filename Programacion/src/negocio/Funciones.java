package negocio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;



public class Funciones {
	
	public static int traerAnio(LocalDate fecha) {
		return fecha.getYear();
	}
	
	public static int traerMes(LocalDate fecha) {
		return fecha.getMonthValue();
	}
	
	public static Month traerMesNombre(LocalDate fecha) {
		return fecha.getMonth();
	}
	
	public static int traerDia(LocalDate fecha) {
		return fecha.getDayOfMonth();
	}
	
	public static int traerHora(LocalTime hora) {
		return hora.getHour();
	}
	
	public static int traerMinutos(LocalTime hora) {
		return hora.getMinute();
	}
	
	public static int traerSegundos(LocalTime hora) {
		return hora.getSecond();
	}
	
	//-----------------------------------------------------------------------
	
	public static boolean esBisiesto(int anio) {
		boolean resultado = false;
		if (anio % 4 == 0 && ((anio % 100 != 0) || (anio % 400 == 0))) {
			resultado = true;
		}
		return resultado;
	}

	public static boolean esFechaValida(int anio, int mes, int dia) {
		boolean resultado = true;

		if (mes < 1 || mes > 12) {
			resultado = false;
		}

		if (anio < 1) {
			resultado = false;
		}

		switch (mes) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12: {
			if (dia < 1 || dia > 31) {
				resultado = false;
			}
			break;
		}

		case 2: {
			if (esBisiesto(anio) == true) {
				if (dia < 1 || dia > 29) {
					resultado = false;
				}
			} else {
				if (dia < 1 || dia > 28) {
					resultado = false;
				}
			}
			break;
		}
		case 4:
		case 6:
		case 9:
		case 11: {
			if (dia < 1 || dia > 30) {
				resultado = false;
			}
			break;
		}	
		default:
			resultado = false;
			break;
		}

		return resultado;
	}
	
	//-----------------------------------------------------------------------
	
	public static LocalTime traerTiempo(int hour, int minute, int second) {
		LocalTime LT = LocalTime.of(hour, minute, second);
		return LT;
	}
	
	public static LocalDate traerFecha(String fecha) {
		// 20/03/2018 Primero el dia, despues mes y despues año
		
		return traerFecha(Integer.parseInt(fecha.substring(0, 2)), Integer.parseInt(fecha.substring(3, 5)),
						Integer.parseInt(fecha.substring(6, 10)));
	}
	
	public static LocalDate traerFecha(int dia, int mes, int anio) {
		LocalDate LD = null;
		if (esFechaValida(anio, mes, dia))
		LD = LocalDate.of(anio, mes, dia);
		return LD;
	}
	
	public static LocalDate traerFechaAhora() {
		return LocalDate.now();
	}
	
	public static LocalTime traerTiempoAhora() {
		return LocalTime.now();
	}
	//-----------------------------------------------------------------------
	

	public static String traerFechaCorta(LocalDate fecha) {
		return traerDia(fecha) + "/" + traerMes(fecha) + "/" + traerAnio(fecha);
	}
	
	public static String traerFechaCortaMes(LocalDate fecha) {
		return traerDia(fecha) + " de " + traerMesNombre(fecha) + " del año " + traerAnio(fecha);
	}
	
	public static String traerHoraCorta(LocalTime hora) {
		return traerHora(hora) + ":" + traerMinutos(hora);
	}
	
	public static boolean sonFechasIguales(LocalDate fecha1,LocalDate fecha2) {
		return fecha1.isEqual(fecha2);
	}
	
	
	
	
	

}


