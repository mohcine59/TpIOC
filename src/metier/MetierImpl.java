package metier;

import dao.IDao;

public class MetierImpl implements IMetier{
	
	//couplage faible
	private IDao dao;
	
	public void setDao(IDao dao) {
		this.dao = dao;
	}

	@Override
	public double calcul() {
		double t = dao.getTemperature();
		return t;
	}

	
}
