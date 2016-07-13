package rest;

import org.junit.Test;

import junit.framework.TestCase;

public class TestClock extends TestCase {
	
	private static Clock clock = new Clock();
	
	// testa instanciação do objeto clock
	@Test
	public void testClock(){
		this.assertSame(Clock.class, clock.getClass());
	}
	
	// testa set de horas
	@Test
	public void testHour(){
		int hour = 10;
		clock.setHour(hour);
		this.assertEquals(hour,clock.getHour());
	}
	
	// testa set de minutos
	@Test
	public void testMinute(){
		int minute = 10;
		clock.setMinute(minute);
		this.assertEquals(minute,clock.getMinute());
	}
	
	// testa ângulo para horas < 12
	@Test
	public void testGetAngleHourLessThen12(){
		int hour = 3;
		int expected = 90;
		this.assertEquals(expected, clock.getAngleHour(hour));
	}
	
	// testa ângulo para horas >=12
	@Test
	public void testGetAngleHourGreaterThen12(){
		int hour = 15;
		int expected = 90;
		this.assertEquals(expected, clock.getAngleHour(hour));
	}
	
	// testa ângulo para hora = 0
	@Test
	public void testGetAngleHourZero(){
		int hour = 0;
		int expected = 0;
		this.assertEquals(expected, clock.getAngleHour(hour));
	}
	
	// testa ângulo dos minutos
	@Test
	public void testGetAngleMinute(){
		int minute = 3;
		int expected = 18;
		this.assertEquals(expected, clock.getAngleMinute(minute));
	}
	
	// com horas e minutos, testa um ângulo inferior a 180 graus
	@Test
	public void testGetAngleHourAndMinuteLessThen180(){
		int minute = 30;
		int hour = 15;
		int expected = 90;
		clock.setHour(hour);
		clock.setMinute(minute);
		this.assertEquals(expected,clock.getAngleHourAndMinute());
	}
	
	// com horas e minutos testa um ângulo superior a 180 graus
	@Test
	public void testGetAngleHourAndMinuteGreaterThen180(){
		int minute = 55;
		int hour = 15;
		int expected = 120;
		clock.setHour(hour);
		clock.setMinute(minute);
		this.assertEquals(expected,clock.getAngleHourAndMinute());
	}
	
}
