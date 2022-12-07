//package palla_canestro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class Frame extends Thread{
	//final String pathPalla = "D:\\programmazione\\java\\palla_canestro\\src\\palla_canestro\\images\\palla.png";
	//final String pathCanestro = "D:\\programmazione\\java\\palla_canestro\\src\\palla_canestro\\images\\canestro.jpg";
	final String pathPalla = "C:\\Users\\gaeta\\Documents\\java\\Pallacanestro\\palla.png";
	final String pathCanestro = "C:\\Users\\gaeta\\Documents\\java\\Pallacanestro\\canestro.jpg";
	
	//dimensioni iniziali del frame
	final int LARGHEZZA = 800;	
	final int ALTEZZA = 500;
	
	private double v = 50;
	private double angolo = 45;
	
	JFrame frame = new JFrame();
	JPanel panel1 = new JPanel();
	JLabel label1 = new JLabel();
	JSlider slider1 = new JSlider(0, 100, 50);	//slider velocita
	JLabel label2 = new JLabel();
	JSlider slider2 = new JSlider(0, 89, 45);	//slider angolo
	
	JPanel panel2 = new JPanel();
	JLabel label3 = new JLabel();	//palla
	JLabel label4 = new JLabel();	//canestro
	
	JButton button = new JButton();		//bottone gioca
	JButton button2 = new JButton();	//bottone reset
	
	ImageIcon ic1 = new ImageIcon(pathPalla);
    ImageIcon palla = new ImageIcon(ic1.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH));
    
    ImageIcon ic2 = new ImageIcon(pathCanestro);
    ImageIcon canestro = new ImageIcon(ic2.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
    
    LanciaPalla p = new LanciaPalla();
    
    private int x, y;		//x y della traiettoria calcolati
    private int xPalla, yPalla, xCanestro, yCanestro;	//posizioni iniziali della palla e canestro proporzionati al frame
    private int latoPalla, latoCanestro;
    private int centroXCanestro1, centroXCanestro2, centroYCanestro;	//punti per cui se la palla passa fa canestro
    
	public Frame(){
		setSlider();
		setLabel();
		setButton();
		setPanel();
		setFrame();
		
		p.setShowMessage(true);		//necessario per non far apparire il joptionpane ad avvio del frame
		System.out.println("Frame creato");
	}
	private void setFrame(){
		frame.setTitle("Pallacanestro");
		frame.setSize(LARGHEZZA, ALTEZZA);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout(10, 10));

		frame.getContentPane().add(panel1, BorderLayout.WEST);
		frame.getContentPane().add(panel2, BorderLayout.CENTER);

		frame.setVisible(true);
	}
	
	private void setPanel() {
		panel1.setBorder(BorderFactory.createLineBorder(Color.black));
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		
		panel1.add(label1);
		panel1.add(slider1);
		panel1.add(Box.createRigidArea(new Dimension(0,40)));		//separatore
		panel1.add(label2);
		panel1.add(slider2);
		panel1.add(Box.createRigidArea(new Dimension(0,40)));		//separatore
		
		JPanel buttonPane = new JPanel();
		buttonPane.setBorder(BorderFactory.createLineBorder(Color.black));
		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
		buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 25));
		buttonPane.add(Box.createHorizontalGlue());
		buttonPane.add(button);
		buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
		buttonPane.add(button2);
		panel1.add(buttonPane);
		
		panel2.setBorder(BorderFactory.createLineBorder(Color.black));
		panel2.setLayout(null);
		panel2.add(label3);
		panel2.add(label4);
	}
	
	private void setLabel(){
		label1.setAlignmentX(Component.CENTER_ALIGNMENT);
		label1.setText("Velocita': " + slider1.getValue());
		label1.setPreferredSize(new Dimension(120, 30));
		
		label2.setAlignmentX(Component.CENTER_ALIGNMENT);
		label2.setPreferredSize(new Dimension(120, 30));
		label2.setText("Angolo: " + slider2.getValue());
		label2.setLayout(null);
		
		label3.setIcon(palla);
		
		label4.setIcon(canestro);
	}
	
	private void setButton() {
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setText("Gioca");
		button.setAlignmentY(150);
		button.setPreferredSize(new Dimension(70, 30));
		button.setFocusPainted(false);
		button.addActionListener(e -> giocaBut());
		
		button2.setAlignmentX(Component.CENTER_ALIGNMENT);
		button2.setText("Reset");
		button2.setAlignmentY(150);
		button2.setPreferredSize(new Dimension(70, 30));
		button2.setFocusPainted(false);
		button2.addActionListener(e -> resetBut());
	}
	
	private void setSlider() {
		slider1.setAlignmentX(Component.CENTER_ALIGNMENT);
		slider1.setPaintTrack(true);
		slider1.setMajorTickSpacing(25);
		slider1.setPaintLabels(true);
		slider1.addChangeListener(e -> cambiaVelocita());
		slider1.setVisible(true);
		
		slider2.setAlignmentX(Component.CENTER_ALIGNMENT);
		slider2.setPaintTrack(true);
		slider2.setMajorTickSpacing(25);
		slider2.setPaintLabels(true);
		slider2.addChangeListener(e -> cambiaAngolo());
		slider2.setVisible(true);
	}
	
	public double getVelocita() {
		return v;
	}
	public void setvelocita(double v) {
		this.v = v;
	}
	
	public double getAngolo() {
		return angolo;
	}
	public void setAngolo(double angolo) {
		this.angolo = angolo;
	}
	
	//metodo invocato allo spostamento dello slider velocita(slider1)
	public void cambiaVelocita() {
		int v = slider1.getValue();
		label1.setText("Velocita': " + v);
		setvelocita(v);
	}
	
	//metodo invocato allo spostamento dello slider angolo(slider2)
	public void cambiaAngolo() {
		int angolo = slider2.getValue();
		label2.setText("Angolo: " + angolo);
		setAngolo(angolo);
	}

	public void giocaBut(){
		frame.setResizable(false);
		button.setEnabled(false);
		
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
		int h = (panel2.getHeight() / 2) - latoCanestro;	//altezza dal fondo al piede del canestro
		centroYCanestro += h;		//altezza dal fondo al canestro
		centroYCanestro -= (panel2.getHeight() - yPalla);	//altezza del canestro considerando il suolo della palla
		
		//proporziono in base alle x ed y calcolate
		//xCanestro : x(xCT) = panel2Width : 250;
		centroXCanestro1 = (centroXCanestro1 * 250) / panel2.getWidth();
		centroXCanestro2 = (centroXCanestro2 * 250) / panel2.getWidth();
		centroYCanestro = (centroYCanestro * 250) / panel2.getHeight();
		
		//imposto attributi a LanciaPalla per il calcolo della traiettoria
		p.setPalla(angolo, v, centroXCanestro1, centroXCanestro2, centroYCanestro);
		p.setMovimento(true);
		
		//apro un tread per il calcolo della traiettoria
		Thread thFrame = new Thread(p);
		thFrame.start();
	}
	
	private void resetBut() {
		p.setMovimento(false);
		//thFrame.resume();
	}
	
	public void spostaPalla() {
		label3.setBounds(x + xPalla, yPalla - y, latoPalla, latoPalla);
	}
	
	private void setDimensioni() {
		int h = panel2.getHeight();
		int w = panel2.getWidth();
		int area = h * w;
		
		//palla
		int areaPalla = area / 500;		//l'area della palla deve essere di scala 1 : 500 rispetto all'area del panel
		latoPalla = (int)Math.sqrt(areaPalla);
		ImageIcon ic1 = new ImageIcon(pathPalla);
	    ImageIcon palla = new ImageIcon(ic1.getImage().getScaledInstance(latoPalla, latoPalla, Image.SCALE_SMOOTH));
	    
	    //calcolo il nuovo offset della palla
	    xPalla = (w / 6) - latoPalla / 2;
		yPalla = (h - (h / 5)) - latoPalla / 2;		
	    
		//se la palla non è in movimento la aggiorno in base ai valori calcolati
    	label3.removeAll();
	    label3.setIcon(palla);
    	label3.setBounds(xPalla - 50, yPalla, latoPalla, latoPalla);
	    
	    //canestro
	    xCanestro = w - (w / 3);
	    yCanestro = h / 2;
	    
	    int areaCanestro = area / 9;
	    latoCanestro = (int)Math.sqrt(areaCanestro);
	    ImageIcon ic2 = new ImageIcon(pathCanestro);
	    ImageIcon canestro = new ImageIcon(ic2.getImage().getScaledInstance(latoCanestro, latoCanestro, Image.SCALE_SMOOTH));
		
	    label4.removeAll();
	    label4.setIcon(canestro);
	    label4.setBounds(xCanestro, yCanestro, latoCanestro, latoCanestro);
	}
	
	//adatto le x calcolate alla dimensione dello schermo
	private void proporzionaXY() {
		//xPallaCT : x(xFrame) = 250(kPrescelto) : panel2Width;
		x = (p.getX() * panel2.getWidth()) / 250;
		y = (p.getY() * panel2.getHeight()) / 250;
	}
	
	@Override
	public void run() {
		boolean gioco = true;
		while(gioco) {
			//se le x o le y sono state cambiate durante il periodo di lancio
			if((x != p.getX() || y != p.getY()) && p.isMovimento()){	
				x = p.getX();
				y = p.getY();
				proporzionaXY();
				spostaPalla();
			}
			
			//se hai fatto canestro e il messaggio non è stato mostrato
			if(!p.isMovimento() && p.isCanestro() && !p.isShowMessage())
			{
				p.setShowMessage(true);
				JOptionPane.showMessageDialog(frame, "Hai fatto canestro!  :)");
			}else if(!p.isMovimento() && !p.isCanestro() && !p.isShowMessage()) {
				p.setShowMessage(true);
				JOptionPane.showMessageDialog(frame, "Non hai fatto canetro!  :(");
			}
			
			//se la palla è ferma al punto zero
			if(!p.isMovimento())
			{
				frame.setResizable(true);
				button.setEnabled(true);
				setDimensioni();	//adatta le dimensioni delle immagini in base a quella dello schermo
			}		
		}
	}
}
