package com.vrm.rs.dao;

import java.io.Serializable;
import java.util.Calendar;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class IDGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		
		
        String key="TW";
		
		Calendar cl=Calendar.getInstance();
		StringBuffer id= new StringBuffer();
		int year=cl.get(Calendar.YEAR);
		String y=year+"";
		id.append(y.substring(2,y.length())+"");
		
		
		
		
		
		id.insert(0, key);
		
	
		return id.toString();
		
		
	
	}

}
