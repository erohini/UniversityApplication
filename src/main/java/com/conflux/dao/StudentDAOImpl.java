package com.conflux.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.conflux.entity.Student;

public class StudentDAOImpl implements StudentDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveStudent(Student studentBean) {
		Session session = sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		if(studentBean!=null){
			try{
			session.save(studentBean);
			tx.commit();
			session.close();
			}catch(Exception e){
				tx.rollback();
				session.close();
				e.printStackTrace();
			}
		}

	}

	@Override
	public Student loginStudent(Student student) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from com.conflux.entity.StudentBean as s where s.email=? and s.password=?";
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0, student.getUserName());
			query.setParameter(1, student.getPassword());
			student = (Student) query.uniqueResult();
			tx.commit();
			session.close();
		}catch(Exception e){
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return student;
	}

}
