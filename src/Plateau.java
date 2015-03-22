
public class Plateau{
	
	public Plateau(int ligne, int colonne, char valeurParDefaut){
		this.ligne = ligne;
		this.colonne = colonne;
		 plateau = new Emplacement[ligne][colonne];
		for (int i = 0; i < ligne; i++) {
			for (int j = 0; j < colonne; j++) {
				plateau[i][j] = new Emplacement(valeurParDefaut);
				plateau[i][j].getContenu();
			}
		}
	}
	
	public Emplacement[][] getPlateau(){
		return plateau;
	}
	
	public boolean joueurPeutJouer(Position position){
		boolean peutJouer;
			if(plateau[position.getX()][position.getY()].estLibre()){
				plateau[position.getX()][position.getY()].setContenu(position.getSymbole());
				peutJouer = true;
			}else{
				peutJouer= false;
				Utils.Log("l'emplacement est déjà pris, Veuillez jouer un autre emplacement");
			}
		return peutJouer;
	}
	
	public boolean existe(Position position) {
		boolean laPosition = true;
		if (position.getX() >= this.ligne || position.getY() >= this.ligne) {
			laPosition = false;
			Utils.Log("la position ne rentre pas sur le plateau");
		}
		return laPosition;
	}
	
	
	public void Afficher(){
		for (int i = 0; i < this.ligne; i++) {
			for (int j = 0; j < this.colonne; j++) {
				plateau[i][j].Afficher();
				System.out.print("  ");
			}
			System.out.println("");
		}
	}
	
	
	int ligne;
	int colonne;
	private Emplacement[][] plateau;
}
