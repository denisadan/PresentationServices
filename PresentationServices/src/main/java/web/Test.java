package web;

import java.util.List;

import ro.app.dao.impl.DAOPresentation;
import ro.app.model.Presentation;

public class Test {
	public static void main(String[] args) {
		DAOPresentation daoP = new DAOPresentation();
		// SimpleRestController cont = new SimpleRestController();
		List<Presentation> presentations = daoP.findAll();
		System.out.println(presentations);
	}
}
