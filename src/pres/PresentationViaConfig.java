package pres;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Scanner;

import dao.DaoImpl;
import dao.IDao;
import metier.IMetier;
import metier.MetierImpl;

public class PresentationViaConfig {

	public static void main(String[] args){
		try {
			
//			DaoImpl dao = new DaoImpl();
//			MetierImpl metier = new MetierImpl(); //la couche presentation est ouverte a la modification
//			metier.setDao(dao);
			
			
			Scanner scanner = new Scanner(new File("config.txt"));
			String daoClassName = scanner.next();
			String metierClassName = scanner.next();
			
			Class cDao = Class.forName(daoClassName); //On charge la classe Dao en memoire
			Class cMetier = Class.forName(metierClassName);
			
			IDao dao = (IDao) cDao.newInstance(); //on cree un objet dynamiquement
			IMetier metier = (IMetier) cMetier.newInstance();
			
			Method m = cMetier.getMethod("setDao", new Class[]{IDao.class}); //injection des dependances
			m.invoke(metier, new Object[]{dao});//metier.setDao
			
			System.out.println(metier.calcul());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
