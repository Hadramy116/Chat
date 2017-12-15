package chat.metier;

import java.util.HashMap;
import java.util.Map;

import chat.entites.History;
import chat.entites.Message;

public class HistoryCtrl implements IHistoryMetier	  {

	public Map<Integer ,History> hitorys = new HashMap<Integer ,History>();

	@Override
	public boolean addToHistory(Message msg) {
		
		return false;
	}
	
	@Override
	public Map<Integer, History> getUserHistoryS(int userId) {
		
		return null;
	}

	



}
