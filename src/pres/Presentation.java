package pres;

import dao.DaoImpl;
import metier.MetierImpl;

public class Presentation {

	public static void main(String[] args){
		//Injection de dependance
		DaoImpl dao = new DaoImpl();
		MetierImpl metier = new MetierImpl(); //la couche presentation est ouverte a la modification
		metier.setDao(dao);
		System.out.println(metier.calcul());
	}
}
