package com.vims.generators;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class PolicyIdGenerator implements IdentifierGenerator{

	public static int i=1;
	public static String key;
	
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		
			FileReader fr=null;
			FileWriter fw=null;
			BufferedReader br=null;
			BufferedWriter bw=null;
			File f=new File("src/policyid.txt");
			try {
				 fr=new FileReader(f);
				 br=new BufferedReader(fr);
				 i=br.read();
				if(i==-1){
					i=1;
				}else{
					i++;
				}
			} catch (IOException e1) {
				System.out.println("file reader exception");
			}
			try {
				 fw=new FileWriter(f);
				 bw=new BufferedWriter(fw);
				 bw.write(i);
			} catch (IOException e) {
				System.out.println("file writer excpetion");
			}
			finally{try {
						br.close();bw.close();
					
				} catch (IOException e) {
					System.out.println("finally exception");
				}}
			
			
			
			
			Calendar cl=Calendar.getInstance();
			StringBuffer id= new StringBuffer();
			
			int year=cl.get(Calendar.YEAR);
			String y=Integer.toString(year);
			
			id.append(y.substring(2,y.length())+"");
			
			id.insert(0, key);
			
			
		
			String number= Integer.toString(i);
			
			if(number.length()==1){
				id.append("000");
				id.append(number);
			}
			else if (number.length()==2){
				id.append("00");
				id.append(number);
			}
			else if (number.length()==3){
				id.append("0");
				id.append(number);
			}
			else if (number.length()==4){
				
				id.append(number);
			}
			
		
			
			return id.toString();
			
		
		
		
		
		
		
		
		
	}

}
