package chat.entites;

import java.util.Collection;

public class Groupe {
	
	private Integer id;
	private Collection<Utilisateur> users;
	private Collection<Message> msgs;
	
	
	public Groupe() {
		super();
	}


	public Groupe(Collection<Utilisateur> users, Collection<Message> msgs) {
		super();
		this.users = users;
		this.msgs = msgs;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Collection<Utilisateur> getUsers() {
		return users;
	}


	public void setUsers(Collection<Utilisateur> users) {
		this.users = users;
	}


	public Collection<Message> getMsgs() {
		return msgs;
	}


	public void setMsgs(Collection<Message> msgs) {
		this.msgs = msgs;
	}


}
