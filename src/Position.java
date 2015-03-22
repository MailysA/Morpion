
public class Position {

	private int x;
	private int y;
	private char symbole;
	
	public Position (){
	}
	
	public Position(int x, int y, char symbole){
		x = 0;
		y = 0;
		this.symbole = symbole;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public char getSymbole(){
		return symbole;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setSymbole(char symbole) {
		this.symbole = symbole;
	}
	
	
}
