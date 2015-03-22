import java.util.Scanner;


public class ControllerJoueur {
	
	public ControllerJoueur(){
	}
	
	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	
	public Position getSaisiePosition(){
		saisieClavierX();
		saisieClavierY();
		laPosition = new Position();
		laPosition.setX(x);
		laPosition.setY(y);
		
		return laPosition;
	}
	
	public void saisieClavierX(){
		Scanner scanner = new Scanner(System.in);

        System.out.print("Entrer une valeur pour x: ");
        x = scanner.nextInt();
	}
	
	public void saisieClavierY(){
		Scanner scanner = new Scanner(System.in);

        System.out.print("Entrer une valeur pour y: ");
        y = scanner.nextInt();
	}
	
	private Position laPosition;
	private int x;
	private int y;

}
