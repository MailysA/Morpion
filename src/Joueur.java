
public class Joueur{
	
	public Joueur(String nom){
		this.nom = nom;
		saisieJoueur = new ControllerJoueur();
	}
	
	public char choisirSymbole(char symbole1, char symbole2){
		if(Math.random() == 0){
			monPion = new Pion(symbole1);
			return symbole1;
		}else{
			monPion = new Pion(symbole2);
			return symbole2;
		}
	}
	
	public char recupererSymboleRestant(char symbole){
		char symbolerestant = 0;
		if(symbole == 'O'){
			monPion = new Pion('X');
			symbolerestant = 'X';
		}else if(symbole == 'X'){
			monPion = new Pion('O');
			symbolerestant = 'O';
		}
		return symbolerestant;
	}
	
	public void Afficher(){
		System.out.println(this.nom + " joue:");
	}
	
	public ControllerJoueur saisieJoueur(){
		return saisieJoueur;
	}
	
	public Pion getMonPion(){
		return monPion;
	}
    	
	private String nom;
	private Pion monPion;
	private ControllerJoueur saisieJoueur;
}
