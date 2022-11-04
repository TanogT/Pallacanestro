import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelLancio extends JPanel{
	static final String pathPalla = "C:\\Users\\torrisi_g\\Downloads\\Pallacanestro-main\\images\\palla.png";
	static final String pathCanestro = "C:\\Users\\torrisi_g\\Downloads\\Pallacanestro-main\\images\\canestro.jpg";
	
	JLabel label3 = new JLabel();	//palla
	JLabel label4 = new JLabel();	//canestro
	
	ImageIcon ic1 = new ImageIcon(pathPalla);
    ImageIcon palla = new ImageIcon(ic1.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH));
    
    ImageIcon ic2 = new ImageIcon(pathCanestro);
    ImageIcon canestro = new ImageIcon(ic2.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
    
    private int x = 0;
    public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	private int y = 0;
    private int xPalla, yPalla, xCanestro, yCanestro;
    private int latoPalla, latoCanestro;
    private int centroXCanestro1, centroXCanestro2, centroYCanestro;
    
	public int getCentroXCanestro1() {
		return centroXCanestro1;
	}

	public void setCentroXCanestro1(int centroXCanestro1) {
		this.centroXCanestro1 = centroXCanestro1;
	}

	public int getCentroXCanestro2() {
		return centroXCanestro2;
	}

	public void setCentroXCanestro2(int centroXCanestro2) {
		this.centroXCanestro2 = centroXCanestro2;
	}

	public int getCentroYCanestro() {
		return centroYCanestro;
	}

	public void setCentroYCanestro(int centroYCanestro) {
		this.centroYCanestro = centroYCanestro;
	}

	public PanelLancio() {
		setPanel();
		setLabel();
	}
	
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		//super.setBorder(BorderFactory.createLineBorder(Color.black));
		//super.setBounds(270, 0, 600, 400);
		g.setColor(Color.BLACK);
		g.drawLine(300, 0, 300, 400);
		
		
		super.setVisible(true);
		
	}
	
	private void setPanel() {
		super.setBorder(BorderFactory.createLineBorder(Color.black));
		super.setLayout(null);
		super.add(label3);
		super.add(label4);
		super.getClass();
	}
	
	private void setLabel() {
		label3.setBounds(100, 100, 45, 45);
		label3.setIcon(palla);
		
		label4.setBounds(350, 250, 150, 150);
		label4.setIcon(canestro);
	}
	
	public void spostaPalla(int x, int y) {
		label3.setBounds(x + xPalla, yPalla - y, latoPalla, latoPalla);
	}
	
	public void setDimensioni() {
		int h = super.getHeight();
		int w = super.getWidth();
		int area = h * w;
		
		//palla
		int areaPalla = area / 500;		//l'area della palla deve essere di scala 1 : 200 rispetto all'area del panel
		latoPalla = (int)Math.sqrt(areaPalla);
		ImageIcon ic1 = new ImageIcon(pathPalla);
	    ImageIcon palla = new ImageIcon(ic1.getImage().getScaledInstance(latoPalla, latoPalla, Image.SCALE_SMOOTH));
	    
	    xPalla = (w / 6) - latoPalla / 2;
		yPalla = (h - (h / 5)) - latoPalla / 2;		
	    
	    
	    
	    //canestro
	    xCanestro = w - (w / 3);
	    yCanestro = h - (h / 2);
	    
	    int areaCanestro = area / 9;
	    latoCanestro = (int)Math.sqrt(areaCanestro);
	    ImageIcon ic2 = new ImageIcon(pathCanestro);
	    ImageIcon canestro = new ImageIcon(ic2.getImage().getScaledInstance(latoCanestro, latoCanestro, Image.SCALE_SMOOTH));
		
	    label4.removeAll();
	    label4.setIcon(canestro);
	    label4.setBounds(xCanestro, yCanestro, latoCanestro, latoCanestro);
	    
	    //System.out.println(w + " " + h);
	}
	
	public void startLancio() {
		//calcolo posizione del canestro
		centroXCanestro1 = ((395 + (latoPalla / 2)) * latoCanestro) / 980;		//centro del canestro di dimensioni 980x980  -->  395x340 - [585 - latoPalla]x340
		centroXCanestro2 = ((585 - (latoPalla / 2)) * latoCanestro) / 980;
		centroYCanestro = (340 * latoCanestro) / 980;
		
		centroXCanestro1 += xCanestro;	//aggiungo offset del canestro
		centroXCanestro2 += xCanestro;
		centroYCanestro += yCanestro;
	}
	
	public void setStartPosition() {
		label3.removeAll();
	    label3.setIcon(palla);
    	label3.setBounds(xPalla, yPalla, latoPalla, latoPalla);
	}
}
