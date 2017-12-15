package chat.metier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import chat.entites.Utilisateur;

public class UserCtrl implements IUserMetier {
	
	private Map<Integer, Utilisateur> users = new HashMap<Integer,Utilisateur>();
	
	@Override
	public boolean addUser(Utilisateur user) {
		if(user != null){
			users.put(user.getId(),user);
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public boolean updateUser(Utilisateur user) {
		Utilisateur u = users.get(user.getId());
		if(u != null){
			users.remove(u.getId());
			users.put(user.getId(), user);
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public Map<Integer,Utilisateur> getUsers() {
		
		return  users;
	}

	@Override
	public Utilisateur getUserById(int id) {
	
		return users.get(id);
	}

	@Override
	public boolean deleteUser(int id) {
		if(users.remove(id) != null )
			return true;
		else 
			return false;
	}

}
