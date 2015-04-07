package server;

public class Transmit {
	
	public Transmit(String server, String label, String message){
		System.out.println(server + label + message);
		new signControl.Receive(server, label, message);
	}

}
