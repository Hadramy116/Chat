package chat.entites;

import java.io.Serializable;
///Utilisateur java bean
public class Utilisateur implements Serializable{
	
	private Integer id;
	private String name;
	private String password;
	
	public Utilisateur() {
		
	}

	public Utilisateur(Integer id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
