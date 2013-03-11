package br.com.sos24horas.tcc.common.conexao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static final SessionFactory buildSessionFactory(){
		
		try{
			AnnotationConfiguration cfg = new AnnotationConfiguration();
			cfg.configure("hibernate.cfg.xml");
			return cfg.buildSessionFactory();
		}catch(Throwable e){
			System.out.println("Criação inicial da SessionFactory falhou erro: " + e);
			throw new ExceptionInInitializerError(e);
			
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	
}
