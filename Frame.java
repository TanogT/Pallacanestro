
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

public class Frame extends Thread{


	final int LARGHEZZA = 800;
	final int ALTEZZA = 500;
	
	private double v;
	private double angolo;
	
	JFrame frame = new JFrame();
	JPanel panel1 = new JPanel();
	JLabel label1 = new JLabel();
	JSlider slider1 = new JSlider(0, 100, 50);
	JLabel label2 = new JLabel();
	JSlider slider2 = new JSlider(0, 100, 50);
	
	JPanel panel2 = new JPanel();

	
	JButton button = new JButton();
	
	PanelLancio pL = new PanelLancio();
    
    Palla p = new Palla();
    
    
    
    private boolean gioco = false;

    
	public Frame(){
		setSlider();
		setLabel();
		setButton();
		setPanel();
		setFrame();
		System.out.println("Frame creato");
	}
	private void setFrame(){
		frame.setTitle("Pallacanestro");
		frame.setSize(LARGHEZZA, ALTEZZA);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout(10, 10));

		frame.getContentPane().add(panel1, BorderLayout.WEST);
		//frame.getContentPane().add(panel2, BorderLayout.CENTER);
		//Parabola parabola = new Parabola();
		//frame.add(parabola);
		frame.getContentPane().add(pL, BorderLayout.CENTER);

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
		panel1.add(button);
		
		panel1.setMaximumSize(null);
		
		
	}
	
	private void setLabel(){
		label1.setBounds(0, 30, 120, 50);
		label1.setAlignmentX(Component.CENTER_ALIGNMENT);
		label1.setText("Velocita': " + slider1.getValue());
		label1.setPreferredSize(new Dimension(120, 30));
		
		label2.setBounds(0, 100, 120, 50);
		label2.setAlignmentX(Component.CENTER_ALIGNMENT);
		label2.setPreferredSize(new Dimension(120, 30));
		label2.setText("Angolo: " + slider2.getValue());
		label2.setLayout(null);
		
		
	}
	
	private void setButton() {
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setText("Gioca");
		button.setAlignmentY(150);
		button.setPreferredSize(new Dimension(120, 30));
		button.setFocusPainted(false);
		button.addActionListener(e -> giocaBut());
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
	
	public void cambiaVelocita() {
		int v = slider1.getValue();
		label1.setText("Velocita': " + v);
		setvelocita(v);
	}
	
	public void cambiaAngolo() {
		int angolo = slider2.getValue();
		label2.setText("Angolo: " + angolo);
		setAngolo(angolo);
	}

	public void giocaBut(){
		frame.setResizable(false);
		button.setEnabled(false);
		
		pL.startLancio();
		
		
		p.setPalla(angolo, v, pL.getCentroXCanestro1(), pL.getCentroXCanestro2(), pL.getCentroYCanestro());
		p.setMovimento(true);
		
		Thread thFrame = new Thread(p);
		thFrame.start();
		System.out.println("finito");
	}
	
	
	

	
	
	
	@Override
	public void run() {
		gioco = true;
		while(gioco) {
			if(pL.getX() != p.getX() || pL.getY() != p.getY()) {
				pL.setX(p.getX());
				pL.setY(p.getY()); 
				pL.spostaPalla(pL.getX(), pL.getY());
			}
			if(!p.isMovimento() && p.isCanestro() && !p.isShowMessage())
			{
				p.setShowMessage(true);
				JOptionPane.showMessageDialog(frame, "Hai fatto canestro!");
			}
			
			if(!p.isMovimento())
			{
				frame.setResizable(true);
				button.setEnabled(true);
			}
			
			//disegnaParabola(null);
			pL.setDimensioni();
			if(!p.isMovimento())
		    {
				pL.setStartPosition();
		    	
		    }
		}
	}
	
	
}
