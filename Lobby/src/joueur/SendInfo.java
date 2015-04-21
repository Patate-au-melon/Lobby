package joueur;

import object.Joueur;

public class SendInfo {
	
	public SendInfo(String server, String label, String message){
		if(label.equalsIgnoreCase("requestJoueur")){
			String[] msg = message.split(" ");
			Joueur j = object.Joueur.getJoueur(msg[0]);
			if(object.Joueur.joueurList.contains(j)){
				String rep = j.getName() + " ";
				for(String m : msg){
					if(m.equalsIgnoreCase("grade"))
						rep = rep + j.getGrade() + " ";
					else if(m.equalsIgnoreCase("server"))
						rep = rep + j.getServer() + " ";
					else if(m.equalsIgnoreCase("moneyMiniGames"))
						rep = rep + j.getMoneyMiniGames() + " ";
					else if(m.equalsIgnoreCase("moneyVIP"))
						rep = rep + j.getMoneyVIP() + " ";
					else if(m.equalsIgnoreCase("multiplicateur"))
						rep = rep + j.getMultiplcateur() + " ";
				}
				new server.SendMessage(server, "reponseRequestJoueur", rep);
			}
		}
	}
	

}
