package web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.app.dao.impl.DAOPresentation;
import ro.app.model.Presentation;

@RestController
public class SimpleRestController
{
	
	private DAOPresentation daoP = new DAOPresentation();
	public SimpleRestController(){
		System.out.println("***REST CONTROLLER 1***");
	}
	
    @RequestMapping(value = "/simplelist")
    public List<String> getAllEmployees()
    {
    	List<String> theList = new ArrayList<>();
    	theList.add("test1");
    	theList.add("test2");
    	theList.add("test3");
          
        return theList;
    }
      
    
    @RequestMapping(value = "/presentations")
    public List<Presentation> getAllPresentations()
    {
    	System.out.println("FINDING ALL PRESENTATIONS");
    	List<Presentation> presentations = daoP.findAll();
    	for(Presentation p : presentations){
    		System.out.println("***PRESENTATION***");
    		System.out.println(p.getTitle());
    	}
        return presentations;
    }
   
    public static void main(String[] args) {
    	SimpleRestController cont = new SimpleRestController();
    	List<Presentation> presentations = cont.daoP.findAll();
		System.out.println(presentations);
	}
}