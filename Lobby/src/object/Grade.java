package object;

import java.util.ArrayList;

public class Grade {
	
	private String name;
	private int power;
	private String prexife;
	private int multiplicateur;
	
	public static ArrayList<Grade> gradeList;
	
	
	public Grade(){
		
	}
	
	public Grade getGrade(String name){
		for(Grade g : gradeList){
			if(g.name.equalsIgnoreCase(name))
					return g;
		}
		return null;
	}

	public int getPower() {
		return power;
	}


	public void setPower(int power) {
		this.power = power;
	}


	public String getPrexife() {
		return prexife;
	}


	public void setPrexife(String prexife) {
		this.prexife = prexife;
	}


	public int getMultiplicateur() {
		return multiplicateur;
	}


	public void setMultiplicateur(int multiplicateur) {
		this.multiplicateur = multiplicateur;
	}
	
	

}
