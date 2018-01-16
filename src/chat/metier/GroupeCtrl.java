package chat.metier;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import chat.entites.Groupe;
import chat.entites.Message;
import chat.entites.Utilisateur;

public class GroupeCtrl implements IGroupe{
	
	private static Map<Integer, Groupe> grps = new HashMap<Integer,Groupe>();
	
	private IUser userCtrl = new UserCtrl();
	private IMessageMetier msgCtrl = new MessageCtrl();
	
	public boolean isExist(Integer id){
		
		if(grps.get(id) != null){
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public boolean add(Groupe item) {
		if(!isExist(item.getId())){
			grps.put(item.getId(), item);
			return true;
		}else
			return false;
	}

	@Override
	public boolean update(Groupe item) {
		if(isExist(item.getId())){
			grps.remove(item.getId());
			grps.put(item.getId(), item);
			return true;
		}else
			return false;
	}

	@Override
	public Collection<Groupe> getItems() {
	
		return grps.values();
	}

	@Override
	public Groupe getItemById(Integer id) {
		
		return grps.get(id);
	}

	@Override
	public boolean delete(Integer id) {
		if(isExist(id)){
			grps.remove(id);
			return true;
		}else
			return false;
	}

	@Override
	public boolean addToGroupe(Utilisateur user , Integer idGrp) {
		
		if(userCtrl.isExist(user.getId()) && isExist(idGrp)){
				grps.get(idGrp).getUsers().add(user);
				return true;
		}else{
			return false;
		}
		
	}

	@Override
	public boolean isInGroupe(Integer userId , Integer idGrp) {
	
		if(userCtrl.isExist(userId) && isExist(idGrp)){
			
				if (grps.get(idGrp).getUsers().contains(userCtrl.getItemById(userId))) {
					return true;
				}else{
					return false;
				}
				
		}else{
			return false;
		}
	}

	@Override
	public Message addMsgToGroupe(Message msg , Integer idGrp) {
		if(msgCtrl.isExist(msg.getId()) && isExist(idGrp)){
			grps.get(idGrp).getMsgs().add(msg);
			return msg;
		}else{
			return null;
		}

	}

	@Override
	public Collection<Message> getGrpMsg(Integer id) {
		
		return grps.get(id).getMsgs();
	}

	@Override
	public Collection<Utilisateur> getGrpUser(Integer id) {
		
		return grps.get(id).getUsers();
	}

}
