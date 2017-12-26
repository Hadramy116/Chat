package chat.metier;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import chat.entites.Utilisateur;

public class UserCtrl implements IMetier<Utilisateur>  {
	
	private static Map<Integer, Utilisateur> users = new HashMap<Integer,Utilisateur>();
	
	@Override
	public boolean add(Utilisateur user) {
		if(user != null){
			users.put(user.getId(),user);
			return true;
		}else{
			return false;
		}	
	}

	@Override
	public boolean update(Utilisateur user) {
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
	public Collection<Utilisateur> getItems() {
		return  users.values();
	}

	@Override
	public Utilisateur getItemById(Integer id) {
	
		return users.get(id);
	}

	@Override
	public boolean delete(Integer id) {
		if(users.remove(id) != null )
			return true;
		else 
			return false;
	}

}
