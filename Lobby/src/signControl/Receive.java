package signControl;

import object.Panneau;

public class Receive {
	
	public Receive(String server, String label, String message){
		if(label.equalsIgnoreCase("sign")){
			Panneau p = object.Panneau.getPanneau(server);
			String[] line = message.split(" ");
			String line1 = line[0];
			String line2 = line[1];
			String line3 = line[2];
			String line4 = line[3];
			p.setSign(line1, line2, line3, line4);
		}
	}

}
