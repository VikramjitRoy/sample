package com.mindtree.controller;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mindtree.entity.User;
@Controller
public class IndexController {
	
	@Autowired
	private SessionFactory sessionFactory;
	@RequestMapping(value="/register",method = RequestMethod.POST)
	public String printHi(ModelMap model,@RequestParam String email,@RequestParam String username,@RequestParam String password){
		Session session = sessionFactory.openSession();

		Transaction tx = null;
		//Integer constituencyId = null;
		try{
			tx = session.beginTransaction();
			User user= new User(email,username,password);
			session.save(user);
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		return "index";
	}
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String printWS(){
		System.out.println("hello,world");
		return "index";
	}
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String printHello(ModelMap model,@RequestParam String loginEmail,@RequestParam String loginPassword) {
		
		System.out.println("In Check login");
		
		Session session = sessionFactory.openSession();
				
		String SQL_QUERY =" from User where email='"+loginEmail+"'";
		System.out.println(SQL_QUERY);
		Query query = session.createQuery(SQL_QUERY);
		
		List<User> list = query.list();
		System.out.println(loginEmail+" "+loginPassword);
		for(User u : list){
			if(u.getPassowrd().equals(loginPassword)){
				System.out.println(u.getUsername()+" "+u.getPassowrd());
				return "home";
			}
			else{
				return "index";
			}
		}
		return "index";
	}
}
