
public class Main {

	public static void main(String[] args){

		Frame frame = new Frame();
		
		Thread thread_frame = new Thread(frame);
		thread_frame.start();
	}	
}
