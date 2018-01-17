package chat.metier;

import java.util.Collection;

import chat.entites.Groupe;
import chat.entites.Message;
import chat.entites.Utilisateur;

public interface IGroupe extends IMetier<Groupe>{
	
	public boolean addToGroupe(Utilisateur user , Integer idGrp);
	public boolean isInGroupe(Integer userId , Integer idGrp);
	public Message addMsgToGroupe(Message msg , Integer idGrp);
	public boolean isExist(Integer id);
	public boolean deleteUserFromGrp(Integer idUser , Integer idGrp);
	
	public Collection<Message> getGrpMsg(Integer idGrp);
	public Collection<Utilisateur> getGrpUser(Integer idGrp);
	
	
	

}
