package connection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	/*
	private static ThreadLocal<Session> sessions = new ThreadLocal<Session>();
	private static SessionFactory factory;
	static {
		Configuration cfg = new Configuration().configure();
		cfg.buildSessionFactory();
	}

	public static Session openSession() {
		if (sessions.get() != null) {
			System.out.print("Ja existe uma sessao para esta thread!");
		}
		System.out.print("Abrindo uma nova sessao");
		sessions.set(factory.openSession());
		return sessions.get();
	}

	public static void closeCurrentSession() {
		System.out.print("Fechando sessao");
		sessions.get().close(); 	
		sessions.set(null);
	}

	public static Session currentSession() {
		return sessions.get();
	}
	*/
	
	public static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration cfg = new Configuration();
                sessionFactory = cfg.configure().buildSessionFactory();
            } catch (Throwable ex) {   
                System.out.println("Erro ao inicar o Hibernte " + ex);
                throw new ExceptionInInitializerError(ex);
            }
            return sessionFactory;
            
        } else {
            return sessionFactory;
        }

	 
    }
    

}
