package ro.app.PresentationServices;

import org.hibernate.Session;

import ro.app.hibernate.HibernateUtil;
import ro.app.model.Presentation;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Session session = HibernateUtil.getSessionFactory().openSession();
        Presentation p1 = (Presentation)session.get(Presentation.class, 1);
        System.out.println("NUME PREZENTARE: " + p1.getTitle());
        session.close();
    }
}
