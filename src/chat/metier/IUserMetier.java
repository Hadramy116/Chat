package chat.metier;

import java.util.List;

import chat.entites.Utilisateur;

public interface IUserMetier {
	
	public Utilisateur addUser(Utilisateur u);
	public Utilisateur updateUser(Utilisateur u);
	public List<Utilisateur> getUsers();
	public Utilisateur getUserById(int id);
	public boolean deleteUser(int id);

}
