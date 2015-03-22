
public class Emplacement{
	
	public Emplacement(){
		this.contenu = '*';
	}
	
	public Emplacement(char contenu){
		this.contenu = contenu;
	}

	public char getContenu(){
		return contenu;
	}
	
	public void setContenu(char contenu){
		this.contenu = contenu;
	}
	
	public boolean estLibre(){
		return contenu == '*';
	}
	
	public void Afficher(){
		System.out.print(contenu);
	}
	
	private char contenu;
}
