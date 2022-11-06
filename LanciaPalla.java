package palla_canestro;



public class LanciaPalla implements Runnable{	
	private double angolo;
	private double v;
	
	private int x, y;
	
	private boolean movimento = false;
	private boolean canestro = false;
	private boolean showMessage = false;

	private int centroCanestroX1;
	private int centroCanestroX2;
	private int centroCanestroY;
	
	CalcoloTraiettoria cT = new CalcoloTraiettoria();

	
	public int getCentroCanestroX2() {
		return centroCanestroX2;
	}

	public void setCentroCanestroX2(int centroCanestroX2) {
		this.centroCanestroX2 = centroCanestroX2;
	}

	public int getCentroCanestroY() {
		return centroCanestroY;
	}

	public void setCentroCanestroY(int centroCanestroY) {
		this.centroCanestroY = centroCanestroY;
	}

	public int getCentroCanestroX1() {
		return centroCanestroX1;
	}

	public void setCentroCanestroX1(int centroCanestroX1) {
		this.centroCanestroX1 = centroCanestroX1;
	}
	
	public boolean isShowMessage() {
		return showMessage;
	}

	public void setShowMessage(boolean showMessage) {
		this.showMessage = showMessage;
	}
	
	public boolean isCanestro() {
		return canestro;
	}

	public void setCanestro(boolean canestro) {
		this.canestro = canestro;
	}
	public boolean isMovimento() {
		return movimento;
	}

	public void setMovimento(boolean movimento) {
		this.movimento = movimento;
	}
	
	public void setPalla(double angolo, double v, int centroCanestroX1, int centroCanestroX2, int centroCanestroY) {
		this.angolo = angolo;
		this.v = v;
		
		this.centroCanestroX1 = centroCanestroX1;
		this.centroCanestroX2 = centroCanestroX2;
		this.centroCanestroY = centroCanestroY;
		System.out.println("Informazioni di lancio impostate");
	}
	
	 public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	private boolean controlloCanestro(int x, int y) {
		System.out.println("x: " + x + "\ny: " + y);
		System.out.println("can x: " + centroCanestroX1 + "can x: " + centroCanestroX2 + "\ny:" + centroCanestroY);
		
		if(centroCanestroY == y && centroCanestroX1 <= x && centroCanestroX2 >= x) {
			System.out.println("true");
			return true;
		} else 
			return false;
	}
	
	@Override
	public void run() {
		cT.setVal(angolo, v);
		setShowMessage(false);
		
		
		int g = cT.calcolaGittata();
		System.out.println(g);
		int x = 0, y;
		//for(int i = 0; i < g; i++) {
		do {
			cT.setX(x);
			y = (int) cT.calcolaY();
			
			if(y != -1) {
				setY(y);
				setX(x);
				
				if (controlloCanestro(x, y))
					setCanestro(true);
				
				try {
					Thread.sleep(10);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			else {
				System.err.println("y negativa");
				setMovimento(false);
				break;
			}
			
			x++;
		}while(y >= 0);
		
		setMovimento(false);
	}
}
