package object;

import java.util.ArrayList;

public class Grade {
	
	/*
	 * 
	 * A lancer au onEnable()
	 * 		Creation de la liste gradeList
	 * 		recupGrade() (apres le lancement de la base de donnee)
	 * 
	 */
	
	private String name;
	private int power;
	private String prexife;
	private int multiplicateur;
	
	public static ArrayList<Grade> gradeList;
	
	
	public Grade(String name, int power, String prefixe, int multiplicateur){
		this.name = name;
		this.power = power;
		this.prexife = prefixe;
		this.multiplicateur = multiplicateur;
		gradeList.add(this);
	}
	
	public Grade getGrade(String name){
		for(Grade g : gradeList){
			if(g.name.equalsIgnoreCase(name))
					return g;
		}
		return null;
	}
	
	public String getName(){
		return name;
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
	
	public static void recupGrade(){
		ArrayList<ArrayList<String>> list = main.Api.BdDsendRequette("SELECT * FROM `listGrade`");
		for(ArrayList<String> l : list){
			String name = l.get(0);
			int power = Integer.parseInt(l.get(1));
			String prefixe = l.get(2);
			int multiplicateur = Integer.parseInt(l.get(3));
			new Grade(name, power, prefixe, multiplicateur);
		}
	}
	
	

}
