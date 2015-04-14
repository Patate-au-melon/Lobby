package newSignControl;

import object.Panneau;

public class Receive {
	
	public Receive(String server, String label, String message){
		if(label.equalsIgnoreCase("sign")){
			Panneau p = object.Panneau.getPanneau(server);
		}
	}

}
