package pres;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import metier.IMetier;

public class PresentationViaSpring {

	public static void main(String[] args){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		
		IMetier metier = (IMetier) context.getBean("metier");
		System.out.println(metier.calcul());
	}
}
