package server;

import java.util.ArrayList;

public class Transmition {
	
	//Recupération de tous les messages
	static void transmit(String server, ArrayList<String> message){
		signControl.Message.receive(server, message); //Vers la gestion des panneaux
	}

}
