package chat.metier;

import chat.entites.Utilisateur;

public interface IUser extends IMetier<Utilisateur> {
	
	public Utilisateur auth(String name , String pass);
}
