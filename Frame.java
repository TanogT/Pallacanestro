//package palla_canestro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
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

public class Frame extends JPanel implements Runnable{
	//final String pathPalla = "D:\\programmazione\\java\\palla_canestro\\src\\palla_canestro\\images\\palla.png";
	//final String pathCanestro = "D:\\programmazione\\java\\palla_canestro\\src\\palla_canestro\\images\\canestro.jpg";

	
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
	

	
	JButton button = new JButton();		//bottone gioca
	JButton button2 = new JButton();	//bottone reset
	
	int x;
	int y;
    
    LanciaPalla p = new LanciaPalla();
    
    PanelLancio panelLancio = new PanelLancio();
  
    public int getX() {
    	return p.getX();
    }
    public int getY() {
    	return p.getY();
    }
    
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
		frame.getContentPane().add(panelLancio, BorderLayout.CENTER);

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
		

		//PanelLancio panel3 = new PanelLancio();
		//panel2.add(panel3);
	}
	
	private void setLabel(){
		label1.setAlignmentX(Component.CENTER_ALIGNMENT);
		label1.setText("Velocita': " + slider1.getValue());
		label1.setPreferredSize(new Dimension(120, 30));
		
		label2.setAlignmentX(Component.CENTER_ALIGNMENT);
		label2.setPreferredSize(new Dimension(120, 30));
		label2.setText("Angolo: " + slider2.getValue());
		label2.setLayout(null);
		

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
		
		panelLancio.setXYCanestro();
		
		//imposto attributi a LanciaPalla per il calcolo della traiettoria
		p.setPalla(angolo, v, panelLancio.getCentroXCanestro1(), panelLancio.getCentroXCanestro2(), panelLancio.getCentroYCanestro());
		p.setMovimento(true);
		
		//apro un tread per il calcolo della traiettoria
		Thread thFrame = new Thread(p);
		thFrame.start();
	}
	
	private void resetBut() {
		p.setMovimento(false);
		//thFrame.resume();
	}
	
	
	
	
	
	
	
	@Override
	 public void paintComponent(Graphics g) {
		    int width = getWidth();
		    int height = getHeight();
		    g.setColor(Color.black);
		    g.drawOval(0, 0, width, height);
		  }
	
	
	@Override
	public void run() {
		boolean gioco = true;
		while(gioco) {
			
			//se le x o le y sono state cambiate durante il periodo di lancio
			if((x != p.getX() || y != p.getY()) && p.isMovimento()){	
				x = p.getX();
				y = p.getY();
				panelLancio.proporzionaXY(x, y);
				panelLancio.spostaPalla();
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
				panelLancio.setDimensioni();	//adatta le dimensioni delle immagini in base a quella dello schermo
			}
			
			//disegnaParabola();
		}
	}
}
