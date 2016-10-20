package com.mindtree.client;


import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.*;
import org.hibernate.cfg.*;

import com.mindtree.entity.Candidates;
import com.mindtree.entity.Constituency;

public class MainApp {
	private static SessionFactory factory;
	private static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {

		factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			Set<Candidates> constituencyCandidates = new HashSet<Candidates>();
			constituencyCandidates.add(new Candidates("HariPrasad","Congress"));
			constituencyCandidates.add(new Candidates("AnanthKumar","BJP"));
			constituencyCandidates.add(new Candidates("ShivKumar","JDS"));

			Constituency constituency = new Constituency("Jayanagar", constituencyCandidates);
			session.save(constituency);

			Set<Candidates> constituencyCandidates1 = new HashSet<Candidates>();
			constituencyCandidates1.add(new Candidates("JSharif","Congress"));
			constituencyCandidates1.add(new Candidates("Adarsh","Congress"));

			constituency = new Constituency("VijayNagar", constituencyCandidates1);
			session.save(constituency);
			Set<Candidates> constituencyCandidates2 = new HashSet<Candidates>();
			constituencyCandidates2.add(new Candidates("Francis","Congress"));
			constituencyCandidates2.add(new Candidates("Ashok","BJP"));

			constituency = new Constituency("Basavanagudi", constituencyCandidates2);
			session.save(constituency);

			Set<Candidates> constituencyCandidates3 = new HashSet<Candidates>();
			constituencyCandidates3.add(new Candidates("RNaidu","TDP"));

			constituency = new Constituency("PadmanabaNagar", constituencyCandidates3);
			session.save(constituency);

			Set<Candidates> constituencyCandidates4 = new HashSet<Candidates>();
			constituencyCandidates4.add(new Candidates("RamaSwamy","CPM"));
			constituency = new Constituency("BTMLayout", constituencyCandidates4);
			session.save(constituency);
			Set<Candidates> constituencyCandidates5 = new HashSet<Candidates>();
			constituency = new Constituency("Ramnagar", constituencyCandidates5);
			session.save(constituency);
			transaction.commit();

			while (true) {
				int ch;
				do{
					System.out.println("\n1.Display candidate name,constituency and party for a constituency ID.\n2.Display candidate name and constituency name for a party.\n3.Set of candidates for a given constituency name.\n4. Candidate name for a given party and constituency name.\n5. Exit\nEnter your choice:");
					ch = scan.nextInt();
					scan.nextLine();
				}while(ch>5||ch<1);
				String hql = null;
				Query query = null;
				List<Constituency> results = null;
				switch (ch) {
				case 1:
					int cId;
					do{
						System.out.println("Enter the constituency ID:");
						cId = scan.nextInt();
					}while(ch>6||ch<1);
					hql = "FROM Constituency where constituencyId="+cId;
					System.out.println(hql);
					query = session.createQuery(hql);
					results = query.list();
					for(Constituency consti: results ){
						//System.out.println(consti.getContituencyCandidates());
						for(Candidates candidate:consti.getContituencyCandidates()){
							System.out.println(consti.getConstituencyName()+" "+candidate.getName()+" "+candidate.getParty());
						}
					}
					break;
				case 2:

					String partyName;
					System.out.println("Enter the party name:");
					partyName = scan.nextLine();
					hql = "FROM Constituency";

					query = session.createQuery(hql);
					results = query.list();
					for(Constituency consti: results ){
						//System.out.println(consti.getContituencyCandidates());
						for(Candidates candidate:consti.getContituencyCandidates()){
							if(candidate.getParty().equals(partyName)){
								System.out.println(consti.getConstituencyName()+" "+candidate.getName()+" "+candidate.getParty());
							}
						}
					}
					break;
				case 3:
					String constituencyName;
					System.out.println("Enter the constituency name:");
					constituencyName = scan.nextLine();
					hql = "FROM Constituency where constituencyName='"+constituencyName+"'";

					query = session.createQuery(hql);
					results = query.list();
					for(Constituency consti: results ){
						//System.out.println(consti.getContituencyCandidates());
						for(Candidates candidate:consti.getContituencyCandidates()){

							System.out.println(candidate.getId()+" "+candidate.getName()+" "+candidate.getParty());

						}
					}
					break;
				case 4:
					String constituency_Name,party_Name;
					System.out.println("Enter the constituency name:");
					constituency_Name = scan.nextLine();

					System.out.println("Enter the party name:");
					party_Name = scan.nextLine();
					hql = "FROM Constituency where constituencyName='"+constituency_Name+"'";

					query = session.createQuery(hql);
					results = query.list();
					for(Constituency consti: results ){
						//System.out.println(consti.getContituencyCandidates());
						for(Candidates candidate:consti.getContituencyCandidates()){
							if(candidate.getParty().equals(party_Name)){
								System.out.println(consti.getConstituencyName()+" "+candidate.getName()+" "+candidate.getParty());
							}
						}
					}
					break;
				case 5:
					System.exit(1);
					break;
				}
			}

		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
