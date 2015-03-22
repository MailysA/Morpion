public class Morpion {

	public Morpion(String nom1, String nom2, char symbole0, char symbole1) {
		plateau = new Plateau(3, 3, '*');
		joueurs[0] = new Joueur(nom1);
		joueurs[1] = new Joueur(nom2);
		
		int cpt = 1;
		do{
			cpt++;
			if(cpt % 2 == 0){
				joueurPeutJouer(0, joueurs[0].choisirSymbole(symbole0,symbole1));
			}else{
				joueurPeutJouer(1, joueurs[1].recupererSymboleRestant(joueurs[0].choisirSymbole(symbole0,symbole1)));
			}
		}while(this.controlerEtatFin(laPosition));
	}
	
	public void joueurPeutJouer(int leJoueur, char symbole){
		
				joueurs[leJoueur].Afficher();
				laPosition = joueurs[leJoueur].saisieJoueur().getSaisiePosition();
				laPosition.setSymbole(joueurs[leJoueur].getMonPion().getPionDuJoueur());
		
				if (plateau.existe(laPosition) && plateau.joueurPeutJouer(laPosition)) {
					plateau.Afficher();
				}else{
					joueurPeutJouer(leJoueur, symbole);
				}
	}
	
	public boolean controlerEtatFin(Position position){
		return /*controlerPlateauRempli() || */ controlerEgaliteColonne(position) || controlerEgaliteLigne(position) || controlerEgaliteDiagonale(position);
	}
	
	public boolean controlerEgaliteLigne(Position position){
		if( plateau.getPlateau()[position.getX()][position.getY()].getContenu() == plateau.getPlateau()[position.getX() % 3][(position.getY() + 1) % 3].getContenu()
		&& plateau.getPlateau()[position.getX()][position.getY()].getContenu() == plateau.getPlateau()[position.getX() % 3][(position.getY() + 2) % 3].getContenu()){
			Utils.Log("un des joueurs a gagné en ligne");
			return true;
		}
		return false;
	}
	
	public boolean controlerEgaliteColonne(Position position){
	if(plateau.getPlateau()[position.getX()][position.getY()].getContenu() == plateau.getPlateau()[(position.getX() + 1)  % 3][position.getY() % 3].getContenu()
				&& plateau.getPlateau()[position.getX()][position.getY()].getContenu() == plateau.getPlateau()[(position.getX() + 2)% 3][position.getY()% 3].getContenu()){
		Utils.Log("un des joueurs a gagné en colonne");
		return true;
	}
	return false;
	}
	
	public boolean controlerEgaliteDiagonale(Position position){
		if(positionTableau(position,0,0)
			&& plateau.getPlateau()[position.getX()][position.getY()].getContenu() == modifierPositionSurPlateau(position,1,1).getContenu()
			&& plateau.getPlateau()[position.getX()][position.getY()].getContenu() == modifierPositionSurPlateau(position,2,2).getContenu()
		|| positionTableau(position,2,0)
			&& plateau.getPlateau()[position.getX()][position.getY()].getContenu() == modifierPositionSurPlateau(position,1,1).getContenu()
			&& plateau.getPlateau()[position.getX()][position.getY()].getContenu() == modifierPositionSurPlateau(position,2,2).getContenu()
		|| positionTableau(position,0,2)
			&& plateau.getPlateau()[position.getX()][position.getY()].getContenu() == modifierPositionSurPlateau(position,1,2).getContenu()
			&& plateau.getPlateau()[position.getX()][position.getY()].getContenu() == modifierPositionSurPlateau(position,2,1).getContenu()
		|| positionTableau(position,2,2)
			&& plateau.getPlateau()[position.getX()][position.getY()].getContenu() == modifierPositionSurPlateau(position,1,1).getContenu()
			&& plateau.getPlateau()[position.getX()][position.getY()].getContenu() == modifierPositionSurPlateau(position,2,2).getContenu()
		||positionTableau(position,1,1)
			&& plateau.getPlateau()[position.getX()][position.getY()].getContenu() == modifierPositionSurPlateau(position,1,1).getContenu()
			&& plateau.getPlateau()[position.getX()][position.getY()].getContenu() == modifierPositionSurPlateau(position,2,2).getContenu()
		|| positionTableau(position,1,1)
			&& plateau.getPlateau()[position.getX()][position.getY()].getContenu() == modifierPositionSurPlateau(position,1,2).getContenu()
			&& plateau.getPlateau()[position.getX()][position.getY()].getContenu() == modifierPositionSurPlateau(position,2,1).getContenu()){
			System.out.println("un des joueurs a gagné en diagonale");
			return true;
		}
		return false;
	}
	
	public Emplacement modifierPositionSurPlateau(Position position, int deplacementX, int deplacementY){
		return plateau.getPlateau()[(position.getX() + deplacementX)  % 3][(position.getY() + deplacementY) % 3];
	}
	
	public boolean positionTableau(Position position, int x, int y){
		return position.getX() == x && position.getY() == y;
	}
	
	private boolean controlerPlateauRempli() {
		boolean plateauPlein = true;
		
		for(int i = 0; i <= 2; i++){
			for (int j = 0; j <= 2; j++) {
				if(!plateau.getPlateau()[i][j].estLibre())
					plateauPlein = false;
			}
		}
		if(plateauPlein)
			Utils.Log("Fin de la partie!");

			return plateauPlein;
	}

	public void Afficher() {
		Utils.Log("Bienvenue "); joueurs[0].Afficher();
		Utils.Log(" et "); joueurs[1].Afficher();
		Utils.Log("");
	}
	
	private Plateau plateau;
	private Joueur[] joueurs = new Joueur[2];
	private Position laPosition;

}
