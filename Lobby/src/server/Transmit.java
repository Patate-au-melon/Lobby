package server;

public class Transmit {
	
	public Transmit(String server, String label, String message){
		new signControl.Receive(server, label, message);
	}

}
