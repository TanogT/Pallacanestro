import javax.swing.JFrame;

//package palla_canestro;

public class Main {

	public static void main(String[] args){

		Frame frame = new Frame();

		//PanelLancio p = new PanelLancio();
		//JFrame frame = new JFrame();
		//frame.setVisible(true);
		//frame.setSize(800, 500);
		//frame.add(p);
		Thread thread_frame = new Thread(frame);
		thread_frame.start();
	}	
}
