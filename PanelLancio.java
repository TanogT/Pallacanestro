import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelLancio extends JPanel{
	/*static final String pathPalla = "C:\\Users\\torrisi_g\\Downloads\\Pallacanestro-main\\images\\palla.png";
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
		g.translate(150, 0);
		
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
	}*/
	//JPanel panel2 = new JPanel();
	JLabel label3 = new JLabel();	//palla
	JLabel label4 = new JLabel();	//canestro
	
	final String pathPalla = "C:\\Users\\gaeta\\Documents\\java\\Pallacanestro\\palla.png";
	final String pathCanestro = "C:\\Users\\gaeta\\Documents\\java\\Pallacanestro\\canestro.jpg";
	
	ImageIcon ic1 = new ImageIcon(pathPalla);
    ImageIcon palla = new ImageIcon(ic1.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH));
    
    ImageIcon ic2 = new ImageIcon(pathCanestro);
    ImageIcon canestro = new ImageIcon(ic2.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
    
    private int x, y;		//x y della traiettoria calcolati
    private int xPalla, yPalla, xCanestro, yCanestro;	//posizioni iniziali della palla e canestro proporzionati al frame
    private int latoPalla, latoCanestro;
    
    

    private int centroXCanestro1, centroXCanestro2, centroYCanestro;	//punti per cui se la palla passa fa canestro
    
    
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
	
	public void setXYCanestro() {
		
		//calcolo posizione del canestro
		//centroXCanestro1 : latoCanestro = 395 : 980
		centroXCanestro1 = ((395 + (latoPalla / 2)) * latoCanestro) / 980;		//centro del canestro di dimensioni 980x980  -->  395x340 - [585 - latoPalla]x340
		centroXCanestro2 = ((585 - (latoPalla / 2)) * latoCanestro) / 980;
		centroYCanestro = (640 * latoCanestro) / 980;
		
		centroXCanestro1 += xCanestro;	//aggiungo offset del canestro
		centroXCanestro1 -= xPalla;		//profondità del canestro considerando il punto della palla iniziale come x0
		centroXCanestro2 += xCanestro;	//aggiungo offset del canestro
		centroXCanestro2 -= xPalla;		//profondità del canestro considerando il punto della palla iniziale come x0
		
		//ricavo la y del canestro a partire dall'altezza di partenza della palla
		int h = (this.getHeight() / 2) - latoCanestro;	//altezza dal fondo al piede del canestro
		centroYCanestro += h;		//altezza dal fondo al canestro
		centroYCanestro -= (this.getHeight() - yPalla);	//altezza del canestro considerando il suolo della palla
		
		//proporziono in base alle x ed y calcolate
		//xCanestro : x(xCT) = panel2Width : 250;
		centroXCanestro1 = (centroXCanestro1 * 250) / this.getWidth();
		centroXCanestro2 = (centroXCanestro2 * 250) / this.getWidth();
		centroYCanestro = (centroYCanestro * 250) / this.getHeight();
	}

	public PanelLancio() {
		//label3.setIcon(palla);
		
	//	label4.setIcon(canestro);
		x = 0;
		y = 0;
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	//	this.setLayout(null);
		//
	//	this.add(label3);
	//	this.add(label4);
		
		//panel2.add(new PanelLancio());
		// this.setPreferredSize(new Dimension(500, 500));
	}
	
	public void setDimensioni() {
		
	}
	public void spostaPalla() {
		//label3.setBounds(x + xPalla, yPalla - y, latoPalla, latoPalla);
	}
	
	//adatto le x calcolate alla dimensione dello schermo
		public void proporzionaXY(int xP, int yP) {
			//xPallaCT : x(xFrame) = 250(kPrescelto) : panel2Width;
			x = (xP * this.getWidth()) / 250;
			y = (yP * this.getHeight()) / 250;
		}
	
	public void paint(Graphics g) {
		int h = this.getHeight();
		int w = this.getWidth();
		int area = h * w;
		
		//palla
		int areaPalla = area / 500;		//l'area della palla deve essere di scala 1 : 500 rispetto all'area del panel
		latoPalla = (int)Math.sqrt(areaPalla);
		ImageIcon ic1 = new ImageIcon(pathPalla);
		ImageIcon palla = new ImageIcon(ic1.getImage().getScaledInstance(latoPalla, latoPalla, Image.SCALE_SMOOTH));
	
		Image image = new ImageIcon(pathPalla).getImage();
		
		this.palla = palla;
	    try {
	    //	System.out.println("ok PAlla" + latoPalla);
	    	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Palla 0");
		}
		
	    
	    //calcolo il nuovo offset della palla
	    xPalla = (w / 6) - latoPalla / 2;
		yPalla = (h - (h / 5)) - latoPalla / 2;		
	    
		//se la palla non è in movimento la aggiorno in base ai valori calcolati
    	//label3.removeAll();
	  //  label3.setIcon(palla);
    	//label3.setBounds(xPalla - 50, yPalla, latoPalla, latoPalla);
	    
	    //canestro
	    xCanestro = w - (w / 3);
	    yCanestro = h / 2;
	    
	    int areaCanestro = area / 9;
	    latoCanestro = (int)Math.sqrt(areaCanestro);
	    ImageIcon ic2 = new ImageIcon(pathCanestro);
	    ImageIcon canestro = new ImageIcon(ic2.getImage().getScaledInstance(latoCanestro, latoCanestro, Image.SCALE_SMOOTH));
	    this.canestro = canestro;
	    try {
	    	
			
		} catch (Exception e) {
			System.out.println("canestro 0");
		}
	  //  label4.removeAll();
	  //  label4.setIcon(canestro);
	  //  label4.setBounds(xCanestro, yCanestro, latoCanestro, latoCanestro);
	    System.out.println(x);
	    g.drawImage(image, x - 50, y, (int)latoPalla, (int)latoPalla, this);
		g.translate(0, 0);
		g.drawLine(0, 0, 500, 500);
	}
}