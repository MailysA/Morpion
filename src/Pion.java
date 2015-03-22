
public class Pion {
	
	public Pion(){
		pionDuJoueur = '*';
	}
	
	public Pion(char pionDuJoueur){
		this.pionDuJoueur = pionDuJoueur;
	}
	
	public char getPionDuJoueur() {
		return pionDuJoueur;
	}

	public void setPionDuJoueur(char pionDuJoueur) {
		this.pionDuJoueur = pionDuJoueur;
	}


	private char pionDuJoueur;

}
