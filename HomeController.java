package com.mindtree.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;  
import com.mindtree.entity.Task;
import com.mindtree.entity.User;
import com.mindtree.service.HomeService;
import com.mindtree.serviceimpl.HomeServiceImpl;


@Controller
public class HomeController {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private HomeServiceImpl homeService; 
	@RequestMapping(value="/addTask",method=RequestMethod.POST)
	public ModelAndView addTask(ModelMap model ,@RequestParam String content,@RequestParam String date,@RequestParam String project,@RequestParam String priority){

		Session session = sessionFactory.openSession();
		ModelAndView mav = new ModelAndView("home");
		Transaction tx = null;
		//Integer constituencyId = null;
		try{

			tx = session.beginTransaction();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
			Timestamp taskDate = null;
			System.out.println(date);

			String a  = date+" 00:00:00";
			System.out.println(a);

			taskDate = Timestamp.valueOf(a);

			System.out.println(taskDate);		        

			Task task= new Task(content,taskDate,priority,project);

			session.save(task);		
			tx.commit();


			tx = session.beginTransaction();
			String SQL_QUERY =" from Task";			
			Query query = session.createQuery(SQL_QUERY);
			List<Task> list = query.list();
//			for(Task t:list){
//				System.out.println(t.getContent());
//			}
			mav.addObject("list", list);
			tx.commit();

		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}
			//e.printStackTrace();
		}finally{
			session.close();
		}
		return mav;
	}
	@RequestMapping(value="/inbox",method=RequestMethod.GET)
	public ModelAndView inboxTask(ModelMap model){
		System.out.println("Inside addTask :"+sessionFactory);
		ModelAndView mav = new ModelAndView("home");
		List<Task> list = homeService.getTaskInbox("vikramjit.roy@mindtree.com",sessionFactory);
		mav.addObject("list", list);
		return mav;
	}
	@RequestMapping(value="/daily",method=RequestMethod.GET)
	public ModelAndView dailyTask(ModelMap model){
		System.out.println("Inside addTask :"+sessionFactory);
		ModelAndView mav = new ModelAndView("home");
		//homeService = new HomeServiceImpl(sessionFactory);
		List<Task> list = homeService.getTaskToday("vikramjit.roy@mindtree.com");
		mav.addObject("list", list);
		return mav;
	}
	@RequestMapping(value="/weekly",method=RequestMethod.GET)
	public ModelAndView weeklyTask(ModelMap model){
		System.out.println("Inside addTask :"+sessionFactory);
		ModelAndView mav = new ModelAndView("home");
		//homeService = new HomeServiceImpl(sessionFactory);
		List<Task> list = homeService.getTaskWeekly("vikramjit.roy@mindtree.com");
		mav.addObject("list", list);
		return mav;
	}
}
