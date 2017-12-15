package chat.entites;

import java.io.Serializable;

public class Message implements Serializable{
	
	private Integer id;
	private String Content;
	private Utilisateur uSender;
	private Utilisateur uRecaver;
	private String dateSend;
	private String dateRec;
	
	public Message() {
		
	}

	public Message(Integer id, String content, Utilisateur uSender, Utilisateur uRecaver, String dateSend,
			String dateRec) {
		super();
		this.id = id;
		this.Content = content;
		this.uSender = uSender;
		this.uRecaver = uRecaver;
		this.dateSend = dateSend;
		this.dateRec = dateRec;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public Utilisateur getuSender() {
		return uSender;
	}

	public void setuSender(Utilisateur uSender) {
		this.uSender = uSender;
	}

	public Utilisateur getuRecaver() {
		return uRecaver;
	}

	public void setuRecaver(Utilisateur uRecaver) {
		this.uRecaver = uRecaver;
	}

	public String getDateSend() {
		return dateSend;
	}

	public void setDateSend(String dateSend) {
		this.dateSend = dateSend;
	}

	public String getDateRec() {
		return dateRec;
	}

	public void setDateRec(String dateRec) {
		this.dateRec = dateRec;
	}
	
	
}
