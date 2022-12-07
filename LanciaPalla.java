
public class LanciaPalla implements Runnable{	
	private double angolo;
	private double v;
	
	private int x, y;
	
	private boolean movimento;
	private boolean canestro;
	private boolean showMessage;

	private int centroCanestroX1;
	private int centroCanestroX2;
	private int centroCanestroY;
	CalcoloTraiettoria cT = new CalcoloTraiettoria();

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
	
	//TODO: la verifica del canestro deve essere effettuata:
	/*
	 * yCanestro -> xPalla		data la y del canestro trovare la sua x
	 * se la x calcolata è tra il range allora è canestro
	 */
	private boolean controlloCanestro(double x, int y) {
		System.out.println("cx1: " + centroCanestroX1 + "\tcx1: " + centroCanestroX2 + "\ty:" + centroCanestroY);
		System.out.println("x: " + (x ) + "\t\ty: " + (y));
		
		if(centroCanestroY == y && centroCanestroX1 <= (int)x && centroCanestroX2 >= (int)x) {
			System.err.println("true");
			return true;
		} else 
			return false;
	}
	
	@Override
	public void run() {
		cT.setVal(angolo, v);
		setShowMessage(false);ì
		setCanestro(false);
		
		//TODO andre: canestro = cT.isCanestro();
		
		int g = cT.calcolaGittata();
		System.out.println(g);
		double x = 0;
		double y = 0;
		//for(int i = 0; i < g; i++) {
		do {
			if(isMovimento()) {
				cT.setX(x);
				y = cT.calcolaY();
				
				if(y != -1) {
					setY((int)y);
					setX((int)x);
					
					if (controlloCanestro(x, (int)y))
						setCanestro(true);
					
					try {
						Thread.sleep(5);
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				else {
					System.err.println("y negativa");
					setMovimento(false);
					break;
				}
				
				x+=0.3;
			}else {
				break;
			}
		}while(y >= 0);
		
		System.out.println("canestro: " + canestro);
		setMovimento(false);
	}
}
