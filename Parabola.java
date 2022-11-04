import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Parabola extends JPanel{

	public Parabola() {
		// TODO Auto-generated constructor stub
	}
	
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		super.setBorder(BorderFactory.createLineBorder(Color.black));
		super.setBounds(270, 0, 600, 400);
		g.setColor(Color.BLACK);
		g.drawLine(300, 0, 300, 400);
		
		
		super.setVisible(true);
		
	}
}
