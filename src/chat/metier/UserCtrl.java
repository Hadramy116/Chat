package chat.metier;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import chat.entites.Utilisateur;

public class UserCtrl implements IUser,IMetier<Utilisateur>  {
	
	private static Map<Integer, Utilisateur> users = new HashMap<Integer,Utilisateur>();
	
	public String cryptWithMD5(String pass){
	    try {
	    	MessageDigest md = MessageDigest.getInstance("MD5");
	        byte[] passBytes = pass.getBytes();
	        md.reset();
	        byte[] digested = md.digest(passBytes);
	        StringBuffer sb = new StringBuffer();
	        for(int i=0;i<digested.length;i++){
	            sb.append(Integer.toHexString(0xff & digested[i]));
	        }
	        return sb.toString();
	    } catch (NoSuchAlgorithmException ex) {
	        //Logger.getLogger(CryptWithMD5.class.getName()).log(Level.SEVERE, null, ex);
	    	return pass;
	    }
	}
	
	
	@Override
	public boolean add(Utilisateur user) {
		if(user != null){
			user.setPassword(cryptWithMD5(user.getPassword()));
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
	
	@Override
	public Utilisateur auth(String name , String pass){
		
		pass = cryptWithMD5(pass);
		
		for(Utilisateur user :users.values() ) {
			
			if(user.getName().equals(name) && user.getPassword().equals(pass)) {
				return user;
			}
		}
		
		return null;
	}

}
