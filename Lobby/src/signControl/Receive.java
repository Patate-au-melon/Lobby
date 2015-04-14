package signControl;

import object.Panneau;

public class Receive {
	
	public Receive(String server, String label, String message){
		if(label.equalsIgnoreCase("sign")){
			Panneau p = object.Panneau.getPanneau(server);
			String[] line = message.split(" ");
			for(int i = 0;i<4;i++){
				String l = line[i];
				String[] lm = l.split(":");
				line[i] = lm[0];
				for(int n = 1 ;n<lm.length; n++){
					line[i] = line[i] + " " + lm[n];
				}
			}
			String line1 = line[0];
			String line2 = line[1];
			String line3 = line[2];
			String line4 = line[3];
			p.setSign(line1, line2, line3, line4);
		}
	}

}
