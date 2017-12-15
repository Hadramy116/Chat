package chat.metier;

import java.util.List;
import java.util.Map;

import chat.entites.Utilisateur;

public interface IUserMetier {
	
	public boolean addUser(Utilisateur u);
	public boolean updateUser(Utilisateur u);
	public Map<Integer , Utilisateur> getUsers();
	public Utilisateur getUserById(int id);
	public boolean deleteUser(int id);

}
