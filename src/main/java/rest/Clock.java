package rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

public class Clock extends HttpServlet {
	private int hour;
	private int minute;
	List<int[]> history = new ArrayList<int[]>();
	
	public void setHour(int hour) {
		// TODO Auto-generated method stub
		this.hour = Math.abs(hour);
		
	}

	public int getHour() {
		// TODO Auto-generated method stub
		return this.hour;
	}
	
	public void setMinute(int minute) {
		// TODO Auto-generated method stub
		this.minute = Math.abs(minute);
		
	}

	public int getMinute() {
		// TODO Auto-generated method stub
		return this.minute;
	}
	
	// Dado o ponteiro de hora, calcular seu �ngulo
	// Cada hora s�o 30 graus.
	// Conta-se o m�dulo de 12 por causa das horas >=12
	public int getAngleHour(int hour) {
		return (hour%12)*30;
	}
	
	// Dado o ponteiro de minuto, calcular seu �ngulo
	// Cada minuto s�o 6 graus.
	// Conta-se o m�dulo de 60 por causa de teste com minutos >=60
	public int getAngleMinute(int minute) {
		return (minute%60)*6;
	}
	
	// Considerando os �ngulos calculados de horas e minutos, calcula-se o menor �ngulo
	// poss�vel entre os ponteiros. O maior �ngulo poss�vel no rel�gio ser� 180 graus.
	// Caso o �ngulo calculado seja maior, pega-se o �ngulo complementar a ele (360 - angulo).
	// Guarda o retorno num hist�rico
	public int getAngleHourAndMinute() {
		int result = Math.abs(getAngleHour(this.hour) - getAngleMinute(this.minute));
		if (result>180)
			result = 360-result;
		keepHistory(this.hour, this.minute, result);
		return result;
	}
	
	// armazenar hist�rico para n�o precisar recalcular o resultado
	public void keepHistory(int hour, int minute, int result){
		this.history.add(new int[] {hour,minute,result});
	}
	
	// verificar se a consulta j� foi realizada anteriormente para n�o precisar recalcular
	// retorna �ngulo caso haja no hist�rico, retorna -1 caso n�o esteja
	public int angleInHistory(int hour, int minute){
		for (int i=0; i< this.history.size(); i++)
			if (this.history.get(i)[0]==hour || this.history.get(i)[1]==minute)
				return this.history.get(i)[2];
		
		return -1;
	}

}
