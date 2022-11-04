package disequzioni;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class CartesianPlane extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	private boolean procedo;
	
	private int segno;
	private int funzione;
	
	private double x1;
	private double x2;
	private double y1;
	private double y2;
	
	private double gradoArco1, gradoArco2;
	
	private boolean fuori;
	
	public void setProcedo(boolean procedo) {
		this.procedo = procedo;
		System.out.println("30: "+ procedo);
	}
	public boolean getProcedo() {
		return procedo;
	}

	
	
	
}