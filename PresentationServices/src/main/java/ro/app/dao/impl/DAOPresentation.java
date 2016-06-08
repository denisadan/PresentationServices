package ro.app.dao.impl;

import java.util.List;

import ro.app.dao.GenericDaoHibernateImpl;
import ro.app.model.Presentation;

public class DAOPresentation extends GenericDaoHibernateImpl<Presentation, Integer>{

	public DAOPresentation() {
		super(Presentation.class);
	}

	public static void main(String[] args) {
		DAOPresentation dao = new DAOPresentation();
		Presentation pres1 = dao.read(1);
		System.out.println("--------");
		List<Presentation> presentations = dao.findAll();
		for(Presentation p : presentations){
			System.out.println("PRESENTATION: " + p);
		}
		System.out.println(pres1);
	}
	
}
