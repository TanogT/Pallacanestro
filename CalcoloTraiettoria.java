package palla_canestro;


public class CalcoloTraiettoria{
	private double alfa, v;
	private double x;
	
	public void setX(double x) {
		this.x = x;
	}
	
	private static final double G = 9.81;
	
	public void setAlfa(double alfa) {
		if(alfa > 0 && alfa < 90)
			this.alfa = alfa;
	}
	public void setV(int v) {
		if(v > 0)
			this.v = v;
	}
	
	public void setVal(double angolo, double v2) {
		if(angolo > 0 && angolo < 90 && v2 > 0) {
			this.alfa = angolo;
			this.v = v2;
		}
	}
	
	public int calcolaAltezza() {
		double rad = radianti(alfa);
		return (int) ((Math.pow(v, 2) * Math.pow(Math.sin(rad), 2)) / (2 * G));
	}
	
	public int calcolaGittata() {
		double rad = radianti(alfa);
		return (int) ((2 * Math.pow(v, 2) * Math.cos(rad) * Math.sin(rad)) / G);
	}
	
	public double calcolaY() {
		double rad = radianti(alfa);
		double y = (-(G / (2 * Math.pow(v, 2) * Math.pow(Math.cos(rad), 2)) * Math.pow(x, 2))) +  Math.tan(rad) * x;
		
		if(y >= 0) {
			return y;
		}
		else
			return -1;
	}
	
	public double radianti(double gradi) {
		return (gradi * Math.PI) / 180;
	}
	

}
